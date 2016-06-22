/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Mariusz
 */
public class DatabaseConnection {
	/**
	 * Method connect to database
	 * @return connection
	 */
    public static Connection connectDb()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORA2015","GR3_rozanski","0BA381ea123");
            return con;
        }
        catch(Exception e)
        {
        	return null;
        }     
    }
    /**
     * 
     * @param Object
     * @return 1 if string, 2 if integer, 3 if null, 4 if Date, 0 if unknown
     */
    public static int checkMyType(Object input)
    {
        if(input instanceof String) return 1;
        if(input instanceof Integer) return 2;
        if(input == null) return 3;
        if(input instanceof Date) return 4;     
        return 0;
    }
    /**
     * method insert records to database
     * @param table table where we insert data
     * @param values values to insert
     * @param returnColumn column to return unique id which we inserted, null if we dont want to get id
     * @return id of inserted record or 0 if returnColumn was null
     * @throws SQLException 
     */
    public static int insert(String table, ArrayList<Object> values, String returnColumn ) throws SQLException,NullPointerException
    {
        Connection conn = DatabaseConnection.connectDb();
        OraclePreparedStatement pst = null;    
        StringBuilder Query = new StringBuilder("INSERT INTO " + table + " VALUES ( ");

        for (int i = 0; i < values.size(); i++)
        {
            Query.append("? ");
            if (i + 1 != values.size())
                Query.append(", ");
        }
        if(returnColumn!=null) Query.append(") RETURNING " + returnColumn + " INTO ?");
        else Query.append(")");
        pst = (OraclePreparedStatement) conn.prepareStatement(Query.toString());
        
        for (int i = 0; i < values.size(); i++)
        {
                switch(checkMyType(values.get(i)))
                {
                    case 1:
                    {
                        pst.setString(i + 1, (String) values.get(i));
                        break;
                    }
                    case 2: {
                        pst.setInt(i + 1, (Integer) values.get(i));
                        break;
                    }
                    case 3: {
                        pst.setNull(i + 1, Types.BIGINT);
                        break;
                    }
                    case 4:
                    {
                        Date utilDate = (Date) values.get(i);
                        java.sql.Date date = new java.sql.Date(utilDate.getTime());
                        pst.setDate(i + 1, date);
                        break;
                    }
                    default:
                    {
                    	throw new SQLException("Unknown type of values");
                    }
                }       
        }  
        if(returnColumn!=null) pst.registerReturnParameter(values.size() + 1, OracleTypes.INTEGER); 
        pst.executeUpdate();
        
        if(returnColumn!=null) {
            OracleResultSet rset = (OracleResultSet) pst.getReturnResultSet();       
            rset.next();
            return rset.getInt(1);
         } 
        return 0;
    }
    /**
     * static method receive data from database
     * @param records names of columns which we want,  null = "select *"
     * @param table name of table
     * @param dependencies constant dependencies between tables like  "book.id = ordered.id"
     * @param columns conditions clause where like "id_client = ?", '=?' is adding automatically 
     * @param values values filling all " ? "
     * @return object ResultSet
     * @throws SQLException 
     */
    public static ResultSet select( ArrayList<String> records,String table , String dependencies, ArrayList<String> columns, ArrayList<Object> values) throws SQLException,NullPointerException
    {
        ResultSet Result=null;
        Connection conn = DatabaseConnection.connectDb();
        OraclePreparedStatement pst = null;  
        
        if(columns!=null || dependencies!=null)
        {
            StringBuilder Query = new StringBuilder("SELECT ");
            
            if(records!=null)
            {
                for (int i = 0; i < records.size(); i++)
                {
                    Query.append(records.get(i));
                    if (i + 1 != records.size())
                        Query.append(", ");
                }
            }
            else Query.append(" * ");
            
            if(dependencies !=null) Query.append(" FROM "+ table +" WHERE " +dependencies + " ");
            else Query.append(" FROM "+ table +" WHERE " );
            
            if(columns!=null)
                for (int i = 0; i < columns.size(); i++)
                {
                    Query.append(columns.get(i) + " = ?");
                    if (i + 1 != columns.size())
                        Query.append(" AND ");
                }
            pst = (OraclePreparedStatement) conn.prepareStatement(Query.toString());
            if(values!=null)
                for (int i = 0; i < values.size(); i++)
                {
                    switch(checkMyType(values.get(i)))
                    {
                        case 1:
                        {
                            pst.setString(i + 1, (String) values.get(i));
                            break;
                        }
                        case 2: {
                            pst.setInt(i + 1, (Integer) values.get(i));
                            break;
                        }
                        case 3: {
                            pst.setNull(i + 1, Types.BIGINT);
                            break;
                        }
                        default:
                        {
                        	throw new SQLException("Unknown type of values");
                        }
                    }
                }
            Result= pst.executeQuery();
        }
        else{
            pst = (OraclePreparedStatement) conn.prepareStatement("SELECT * FROM " + table);
            Result= pst.executeQuery();
        }     
        return Result;
    }
    /**
     * static method override records in database
     * @param table table which we override
     * @param records SET names what we change
     * @param columns dependencies WHERE
     * @param values values to override records SET and dependencies WHERE 
     * @throws SQLException 
     */
    public static void update(String table, ArrayList<String> records , ArrayList<String> columns, ArrayList<Object> values) throws SQLException,NullPointerException
    {
        Connection conn = DatabaseConnection.connectDb();
        OraclePreparedStatement pst = null;  
        
        StringBuilder Query = new StringBuilder("UPDATE " + table + " SET ");

        if (records != null) {
            for (int i = 0; i < records.size(); i++) {
                Query.append(records.get(i) + " = ?");
                if (i + 1 != records.size()) {
                    Query.append(", ");
                }
            }
        }

        Query.append(" WHERE ");

        for (int i = 0; i < columns.size(); i++) {
            Query.append(columns.get(i) + " = ?");
            if (i + 1 != columns.size()) {
                Query.append(" AND ");
            }
        }
        pst = (OraclePreparedStatement) conn.prepareStatement(Query.toString());
        for (int i = 0; i < values.size(); i++) {
            switch (checkMyType(values.get(i))) {
                case 1: {
                    pst.setString(i + 1, (String) values.get(i));
                    break;
                }
                case 2: {
                    pst.setInt(i + 1, (Integer) values.get(i));
                    break;
                }
                case 3: {
                    pst.setNull(i + 1, Types.BIGINT);
                    break;
                }
                default:
                {
                	throw new SQLException("Unknown type of values");
                }
            }
        }
        pst.executeQuery();

    }
    /**
     * static method to delete records from database
     * @param table table where we delete 
     * @param columnID column name to clause WHERE
     * @param index id which we delete
     * @throws SQLException 
     */
    public static int delete(String table, String columnID, int index) throws SQLException,NullPointerException
    {
        Connection conn = DatabaseConnection.connectDb();
        OraclePreparedStatement pst = null; 
        
        StringBuilder Query = new StringBuilder("DELETE FROM " + table + " WHERE " + columnID + " = ? ");

        pst = (OraclePreparedStatement) conn.prepareStatement(Query.toString());

        pst.setInt(1, index);

        pst.executeUpdate();
        
        return 0;
    }
    
    
    
    
        
    
    


    
}

