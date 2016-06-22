/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import pl.umk.mat.ksiegarnia.view.client.MainMenuView;
import pl.umk.mat.ksiegarnia.view.services.ServicesView;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookOrder;

/**
 * The Class Client.
 *
 * @author Mariusz
 */
public class Client extends SQLUserServices
{

	/** The id client. */
	private int idClient;
	
	/** The login. */
	private String login; 
	
	/** The name. */
	private String name;
	
	/** The surname. */
	private String surname;
	
	/** The address. */
	private String address;
	
	/** The phone. */
	private int phone;
    
    /**
     * Instantiates a new client.
     */
    public Client()
    {
    	
    }
    
    /**
     * Instantiates a new client.
     *
     * @param testId only to junit test
     */
    public Client(int testId)
    {
    	idClient=testId;
    }

    /**
     * Instantiates a new client.
     *
     * @param id the id of client
     * @param l the login
     * @param n the name
     * @param s the surname
     * @param a the address
     * @param p the phoneNumber
     */
    public Client(int id, String l, String n, String s, String a, int p)
    {
    	idClient = id;
        login = l;
        name = n;
        surname = s;
        address = a;
        phone = p;
    }
    
    /**
     * Sets the information.
     *
     * @param id the id of client
     * @param l the login
     * @param n the name
     * @param s the surname
     * @param a the address
     * @param p the phoneNumber
     */
    public void setInformation(int id, String l, String n, String s, String a, int p)
    {
    	idClient = id;
        login = l;
        name = n;
        surname = s;
        address = a;
        phone = p;
    }
    
    /**
     * Gets the idClient.
     *
     * @return the id
     */
    public int getID()
    {
        return idClient;
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
     * Gets the name.
     *
     * @return the client name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the surname.
     *
     * @return the client surname
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * Gets the address.
     *
     * @return the client address
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Gets the phone.
     *
     * @return the client phone
     */
    public int getPhone()
    {
        return phone;
    }
    
    /**
     * Checks if is admin.
     *
     * @return the boolean
     */
    public Boolean isAdmin()
    {
        return false;
    }
    
    /**
     * Load client data.
     *
     * @param login the login
     * @param passwd the password
     * @return the client with set all information about him
     */
    public Client loadClientData(String login, String passwd) throws SQLException
    {
    	Client client = new Client();
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

    	if (result.next()) {

    		client.setInformation(result.getInt("id_klienta"), result.getString("login"), result.getString("imie"),
    				result.getString("nazwisko"), result.getString("adres"), result.getInt("telefon"));	

    	}
    	return client;
    }
	
	/**
	 * Adds the to basket.
	 *
	 * @param idBook the id book to add
	 */
	public void addToBasket(int idBook) throws SQLException
	{
		ArrayList<Object> values = new ArrayList<>();
		values.add(null);
		values.add(new Date()); values.add("n");values.add("n");
		values.add(idClient);
		int ID = DatabaseConnection.insert("Zamowienia", values, "ID_Zamowienia");

		values.clear();
		values.add(idBook);
		values.add(ID); 
		DatabaseConnection.insert("ZLOZ_ZAMOWIENIE", values, null); 
	}

	/**
	 * Edits the your data.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @param address the address
	 * @param phone the phone
	 */
	public void editYourData(String name, String surname, String address, int phone) throws SQLException
	{
		ArrayList<String> records = new ArrayList<String>() {{
			add("imie");
			add("nazwisko");
			add("adres");
			add("telefon");
		}};
		ArrayList<String> columns = new ArrayList<String>() {{
			add("id_klienta");
		}};
		ArrayList<Object> values = new ArrayList<Object>() {{
			add(name);
			add(surname);
			add(address);
			add(phone);
			add(idClient);        
		}};

		DatabaseConnection.update("KLIENT", records, columns, values);

		setInformation(this.idClient, this.login, name, surname, address, phone);        
	}

	/**
	 * Confirm orders.
	 *
	 * @param orders arraylist with the orders
	 */
	public void confirmOrders(ArrayList<BookOrder> orders) throws SQLException
	{
		for (BookOrder curBook : orders) {
			ArrayList<String> records = new ArrayList<String>();
			records.add("CZY_ZREALIZOWANE");

			ArrayList<String> columns = new ArrayList<String>() {{
				add("ID_zamowienia");
			}};
			ArrayList<Object> values = new ArrayList<Object>() {{
				add("y");
				add(curBook.getOrderID());
			}};
			DatabaseConnection.update("zamowienia", records, columns, values); 
		}         
	}

	/**
	 * Delete orders from basket.
	 *
	 * @param id the id of book to delete
	 */
	public void deleteOrdersFromBasket(int id) throws SQLException
	{
		DatabaseConnection.delete("zloz_zamowienie","id_zamowienia", id);
		DatabaseConnection.delete("zamowienia","id_zamowienia", id);
	}
	
	/**
	 * Load my basket.
	 *
	 * @return the array list with BookInformation, null if error
	 */
	public ArrayList<BookInformation> loadMyBasket() throws SQLException
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
			add("Z.id_zamowienia");    
		}};
		ArrayList<String> columns = new ArrayList<String>() {{
			add("czy_zrealizowane");
			add("Z.id_klienta");               
		}};
		ArrayList<Object> values = new ArrayList<Object>() {{
			add("n");
			add(idClient);
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
	 * Load my orders.
	 *
	 * @return the array list of BookInformations
	 */
	public ArrayList<BookInformation> loadMyOrders() throws SQLException
	{
		ArrayList<BookInformation> allBooks = new ArrayList<>();
		ArrayList<String> records = new ArrayList<String>() {{
			add("K.id_ksiazki"); add("tytul");
			add("imie");
			add("nazwisko");
			add("nazwa");
			add("cena");
			add("data_wydania");
			add("czy_wyslano");    
		}};
		ArrayList<String> columns = new ArrayList<String>() {{
			add("czy_zrealizowane");
			add("Z.id_klienta");               
		}};
		ArrayList<Object> values = new ArrayList<Object>() {{
			add("y");
			add(idClient);
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
					result.getString("data_wydania"),
					result.getString("czy_wyslano")
					));
		}
		return allBooks;
    }


}
