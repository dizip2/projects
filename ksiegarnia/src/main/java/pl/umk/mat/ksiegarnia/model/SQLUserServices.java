/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pl.umk.mat.ksiegarnia.model.book.BookAuthor;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookPBH;
import pl.umk.mat.ksiegarnia.view.admin.AdminMainMenuView;
import pl.umk.mat.ksiegarnia.view.client.MainMenuView;

/**
 * The Class User.
 *
 * @author Mariusz
 */
public class SQLUserServices implements UserServices{


	
    /**
     * Log in.
     *
     * @param name the name
     * @param passwd the password
     * @return "t" if admin, "n" if client, "x" if unknown
     */
    public String logIn(String name, String passwd) throws SQLException
    {
    	ArrayList<String> columns = new ArrayList<String>() {
    		{
    			add("login");
    			add("Haslo");
    		}
    	};
    	ArrayList<Object> values = new ArrayList<Object>() {
    		{
    			add(name);
    			add(passwd);
    		}
    	};
    	ResultSet result = DatabaseConnection.select(null, "Klient", null, columns, values);

    	if (result.next()) {
    		return result.getString("czy_admin");
    	}
    	else 
    	{
    		return "x";
    	} 
    	
    }


	/**
	 * Creates the new client.
	 *
	 * @param login the login
	 * @param passwd the passwd
	 * @param admin the admin
	 * @param name the name
	 * @param surname the surname
	 * @param address the address
	 * @param phone the phone
	 * @return 0 if successful, -1 if error
	 */
	public int createNewClient(String login, String passwd, String admin, String name, String surname,
			String address, String phone) throws SQLException
	{
            ArrayList<Object> values = new ArrayList<Object>() {{
                add(null);  add(login);   
                add(passwd);    add(admin);
                add(name);    add(surname);
                add(address); add(phone);       
            }};
            int id = DatabaseConnection.insert("KLIENT", values, null);
            
       if(id==0) return 0;
       return -1;	
	}
    
    /**
     * Load all publishing houses.
     *
     * @return the array list of class BookPBH
     */
    public ArrayList<BookPBH> loadAllPHBs() throws SQLException
	{

    	ArrayList<BookPBH> allPBHs = new ArrayList<>();
    	ResultSet result = DatabaseConnection.select(null, "Wydawnictwa", null, null, null);
    	while (result.next())
    	{
    		allPBHs.add(new BookPBH(result.getInt("id_wydawnictwa"), result.getString("nazwa"),
    				result.getInt("telefon"), result.getString("mail")));
    	}
    	return allPBHs;
	}

	/**
	 * Load all authors.
	 *
	 * @return the array list of class BookAuthor
	 */
	public ArrayList<BookAuthor> loadAllAuthors() throws SQLException
	{
		ArrayList<BookAuthor> allAuthors = new ArrayList<>();
		ResultSet result = DatabaseConnection.select(null, "Autorzy", null, null, null);
		while (result.next())
		{
			allAuthors.add(new BookAuthor(result.getInt("id_autora"), result.getString("imie"),
					result.getString("nazwisko"), result.getString("mail")));
		}
		return allAuthors;
	}
	
	/**
	 * Load available books.
	 *
	 * @return the array list of class BookInformation
	 */
	public ArrayList<BookInformation> loadAvailableBooks() throws SQLException
	{
		ArrayList<BookInformation> allBooks = new ArrayList<>();
		ArrayList<String> records = new ArrayList<String>() {{
			add("K.id_ksiazki");add("K.tytul"); add("A.imie");
			add("A.nazwisko"); add("W.nazwa"); add("K.cena");
			add("K.data_wydania");    
		}};
		ResultSet result = DatabaseConnection.select(
				records,
				"Ksiazki K, autorzy A, Wydawnictwa W",
				"K.id_autora = A.id_autora AND K.id_wydawnictwa = W.id_wydawnictwa",
				null,null
				);
		while (result.next()) {
			String author = result.getString("imie") + " " + result.getString("nazwisko");
			allBooks.add(new BookInformation(
					result.getInt("id_ksiazki"),
					result.getString("tytul"),
					author,
					result.getString("nazwa"),
					result.getFloat("cena"),
					result.getString("data_wydania")
					));
		}
		return allBooks;
    }
	
	/**
	 * Load orders to do.
	 *
	 * @return the array list of class BookInformation
	 */
	public ArrayList<BookInformation> loadOrdersToDo() throws SQLException
	{
        ArrayList<BookInformation> allBooks = new ArrayList<>();
        ArrayList<String> records = new ArrayList<String>() {{
        	add("Z.id_zamowienia");
        	add("K.id_ksiazki");
        	add("tytul");
        	add("imie");
        	add("nazwisko");
        	add("nazwa");
        	add("cena");
        	add("data_wydania");  
        }};
        ArrayList<String> columns = new ArrayList<String>() {{
        	add("czy_zrealizowane");
        	add("czy_Wyslano");               
        }};
        ArrayList<Object> values = new ArrayList<Object>() {{
        	add("y");
        	add("n");
        }};
        ResultSet result = DatabaseConnection.select(
        		records,
        		"Autorzy A, Wydawnictwa W, Ksiazki K, Zamowienia Z, Zloz_zamowienie X",
        		"K.ID_KSIAZKI=X.ID_KSIAZKI AND K.id_autora = A.id_autora AND K.id_wydawnictwa = W.id_wydawnictwa AND Z.id_zamowienia = X.id_zamowienia AND ",
        		columns, 
        		values
        		);
        while (result.next()) {
        	String author = result.getString("imie") + " " + result.getString("nazwisko");
        	allBooks.add(new BookInformation(
        			result.getInt("id_zamowienia"),
        			result.getString("tytul"),
        			author,
        			result.getString("nazwa"),
        			result.getFloat("cena"),
        			result.getString("data_wydania")
        			));
        }
        return allBooks;
	}
    /**
     * Load finished orders.
     *
     * @return the array list of class BookInformation
     */
    public ArrayList<BookInformation> loadFinishedOrders() throws SQLException
    {
    	ArrayList<BookInformation> allBooks = new ArrayList<>();
    	ArrayList<String> records = new ArrayList<String>() {{
    		add("K.id_ksiazki");
    		add("tytul");
    		add("imie");
    		add("nazwisko");
    		add("nazwa");
    		add("cena");
    		add("data_wydania");  
    	}};
    	ArrayList<String> columns = new ArrayList<String>() {{
    		add("czy_zrealizowane");
    		add("czy_Wyslano");               
    	}};
    	ArrayList<Object> values = new ArrayList<Object>() {{
    		add("y");
    		add("t");
    	}};
    	ResultSet result = DatabaseConnection.select(
    			records,
    			"Autorzy A, Wydawnictwa W, Ksiazki K, Zamowienia Z, Zloz_zamowienie X",
    			"K.ID_KSIAZKI=X.ID_KSIAZKI AND K.id_autora = A.id_autora AND K.id_wydawnictwa = W.id_wydawnictwa AND Z.id_zamowienia = X.id_zamowienia AND ",
    			columns, 
    			values
    			);

    	while (result.next()) {
    		String author = result.getString("imie") + " " + result.getString("nazwisko");
    		allBooks.add(new BookInformation(
    				result.getInt("id_ksiazki"),
    				result.getString("tytul"),
    				author,
    				result.getString("nazwa"),
    				result.getFloat("cena"),
    				result.getString("data_wydania")
    				));
    	}
    	return allBooks;
    }
    
    /**
     * Load all books.
     *
     * @return the array list of class BookInformation
     */
    public ArrayList<BookInformation> loadAllBooks() throws SQLException
    {
        ArrayList<BookInformation> allBooks = new ArrayList<>();
        ResultSet result = DatabaseConnection.select(
        		null,
        		"Ksiazki K, autorzy A, Wydawnictwa W",
        		"K.id_autora = A.id_autora AND K.id_wydawnictwa = W.id_wydawnictwa",
        		null, 
        		null
        		);
        while (result.next()) {
        	String author = result.getString("imie") + " " + result.getString("nazwisko");
        	allBooks.add(new BookInformation(
        			result.getInt("id_ksiazki"),
        			result.getString("tytul"),
        			author,
        			result.getString("nazwa"),
        			result.getFloat("cena"),
        			result.getString("data_wydania")
        			));
        }
        return allBooks;
    }
    
    /**
     * Check if new order exists
     *
     * @return the boolean
     */
    public Boolean areNewOrders() throws SQLException
    {
    	ArrayList<String> records = new ArrayList<String>() {{
    		add("Z.id_zamowienia");add("K.id_ksiazki"); add("tytul");
    		add("imie"); add("nazwisko"); add("nazwa");
    		add("cena"); add("data_wydania");   
    	}};
    	ArrayList<String> columns = new ArrayList<String>() {{
    		add("czy_zrealizowane");add("czy_Wyslano");  
    	}};
    	ArrayList<Object> values = new ArrayList<Object>() {{
    		add("y");
    		add("n");  
    	}};
    	ResultSet result = DatabaseConnection.select(
    			records,
    			"Autorzy A, Wydawnictwa W, Ksiazki K, Zamowienia Z, Zloz_zamowienie X",
    			"K.ID_KSIAZKI=X.ID_KSIAZKI AND K.id_autora = A.id_autora AND K.id_wydawnictwa = W.id_wydawnictwa AND Z.id_zamowienia = X.id_zamowienia AND",
    			columns,
    			values
    			);

    	return result.next();
    }

    
}
