package pl.umk.mat.ksiegarnia.model;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import pl.umk.mat.ksiegarnia.model.Client;
import pl.umk.mat.ksiegarnia.model.DatabaseConnection;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;

public class ConnectionTest
{

	private Connection con;
	private int idClient;


	@Before
	public void setUp() throws Exception
	{
		idClient=0;
		con=null;
	}
	@Test
	public void setConnectionToDatabase()
	{

		con = DatabaseConnection.connectDb();

		assertNotNull(con);
				
	}
	// testy sa bardziej integracyjny niz jednostkowe, ale jeszcze mockowania nie zdazylem sie nauczyc
	@Test 
	public void insertSelectUpdateDeleteTest()
	{
		try
		{
			ArrayList<String> records = new ArrayList<String>();
			ArrayList<String> columns = new ArrayList<String>();
            ArrayList<Object> values = new ArrayList<Object>() ;

            values.add(null);  values.add("Krzyn");   
            values.add("haslo");    values.add("n");
            values.add("Jan");    values.add("Krzynowek");
            values.add("nieznany"); values.add("123456789");       
            DatabaseConnection.insert("KLIENT", values, null);
				
			records.add("id_klienta");
			columns.add("imie");
			columns.add("nazwisko"); 
			values.clear();
			values.add("Jan");
			values.add("Kowalski"); 
			
			ResultSet result =  DatabaseConnection.select(records,"Klient", null, columns,values);
			if(result.next())
				idClient =  result.getInt("id_klienta");
			
			records.clear();
			records.add("imie");
			records.add("nazwisko");
			records.add("adres");
			records.add("telefon");
			
			columns.clear();
			columns.add("id_klienta");
			
			values.clear();
			values.add("Roman");
			values.add("Nowak"); 
			values.add("znany");
			values.add(987654321);
			values.add(idClient); 
			DatabaseConnection.update("Klient", records, columns ,values);
			
			
			int res = DatabaseConnection.delete("Klient","Id_klienta",idClient);
			assertEquals(0, res);	
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			fail();
		}
		
	}
	
	
	
	

}
