/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


/**
 * The Class Admin.
 *
 * @author Mariusz
 */
public class Admin extends SQLUserServices
{

	/** The admin id. */
	protected int idAdmin;
    
    /** The login. */
    protected String login; 
    
    /** The isAdmin. */
    protected String admin ="t";
    
    /**
     * Instantiates a new admin.
     */
    public Admin (){}
    
    /**
     * Instantiates a new admin.
     *
     * @param the idAdmin
     * @param the login
     */
    public Admin(int id, String l)
    {
    	idAdmin = id;
        login = l;
    }
    
    /**
     * Sets the information.
     *
     * @param id the id
     * @param l the login
     */
    public void setInformation(int id, String l)
    {
    	idAdmin = id;
        login = l;
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getID()
    {
        return idAdmin;
    }
    
    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin()
    {
        return login;
    }
    
    /**
     * Checks if is admin.
     *
     * @return the boolean
     */
    public Boolean isAdmin()
    {
        return admin.equals("t");
    }
    
    /**
     * Load admin data.
     *
     * @param login the admin login
     * @param passwd the admin passwd
     * @return the admin with set all information
     */
    public Admin loadAdminData(String login, String passwd) throws SQLException
    {
    	ArrayList<String> columns = new ArrayList<String>() {
    		{
    			add("login");
    			add("Haslo");
    		}
    	};
    	ArrayList<Object> values = new ArrayList<Object>() {
    		{
    			add(login);
    			add(passwd);
    		}
    	};
    	ResultSet result = DatabaseConnection.select(null, "Klient", null, columns, values);

    	if (result.next())
    	{
    		this.setInformation(result.getInt("id_klienta"), result.getString("login"));
    		return this;
    	}
		return null;
    }
    
    /**
     * Adds the new author.
     *
     * @param name the author name
     * @param surname the author surname
     * @param mail the author mail
     * @return the id of new author, -1 if error
     */
    public int addNewAuthor(String name, String surname, String mail) throws SQLException
    {

    	ArrayList<Object> values = new ArrayList<Object>() {{
    		add(null);add(name);add(surname);add(mail); 
    	}};
    	int id = DatabaseConnection.insert("Autorzy", values, "id_autora");
    	if(id!=0) return id;
    	
    	return -1;
    }

    /**
     * Adds the new publishingHouse.
     *
     * @param name the pbh name
     * @param phone the pbh phone
     * @param mail the pbh mail
     * @return the id of new publishingHouse
     */
    public int addNewPBH(String name, int phone, String mail) throws SQLException
    {

    	ArrayList<Object> values = new ArrayList<Object>() {{
    		add(null);add(name);add(phone);add(mail); 
    	}};       
    	return DatabaseConnection.insert("Wydawnictwa", values, "id_wydawnictwa");
    }

	/**
	 * Adds the new book.
	 *
	 * @param bookTitle the book title
	 * @param idAuthor the id author
	 * @param idPBH the id publishing house
	 * @param price the price
	 * @param dateS the date
	 * @throws SQLException, ParseException 
	 */
	public void addNewBook(String bookTitle, int idAuthor, int idPBH, String price, String dateS) throws SQLException, ParseException
	{

		ArrayList<Object> values = new ArrayList<>();
		values.add(null); values.add(bookTitle); values.add(idAuthor);
		values.add(idPBH); values.add(price);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = format.parse(dateS);
		values.add(date);

		DatabaseConnection.insert("Ksiazki", values, null);
	}

	/**
	 * Confirm order.
	 *
	 * @param id the id book to confirm
	 */
	public void confirmOrder(int id) throws SQLException
	{
		ArrayList<String> records = new ArrayList<String>() {{
			add("CZY_Wyslano");
		}};
		ArrayList<String> columns = new ArrayList<String>() {{
			add("ID_zamowienia");
		}};

		ArrayList<Object> values = new ArrayList<Object>() {{
			add("t");
			add(id);        
		}};
		DatabaseConnection.update("zamowienia", records, columns, values);                     
	}

	/**
	 * Delete book.
	 *
	 * @param id the id of book to delete
	 * @return 0 when succesfull 
	 */
	public int deleteBook(int id) throws SQLException
	{
		DatabaseConnection.delete("ksiazki","id_ksiazki", id);
		return 0;	
	}
    

    
}
