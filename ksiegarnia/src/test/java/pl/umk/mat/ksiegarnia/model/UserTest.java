package pl.umk.mat.ksiegarnia.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import pl.umk.mat.ksiegarnia.controller.AdminController;
import pl.umk.mat.ksiegarnia.model.book.BookAuthor;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookPBH;

public class UserTest
{
	// testy sa bardziej integracyjny niz jednostkowe, ale jeszcze mockowania nie zdazylem sie nauczyc


	@Test
	public void testCreateNewClient()
	{
		try
		{
			UserServices user = new SQLUserServices();
			int idCli=0;
			int res = user.createNewClient("user","password","n","name","surname","address", "123456789");
			ArrayList<String> records = new ArrayList<String>();
			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>() ;

			records.add("id_klienta");
			columns.add("imie");
			columns.add("nazwisko"); 
			values.clear();
			values.add("name");
			values.add("surname"); 

			ResultSet result =  DatabaseConnection.select(records,"Klient", null, columns,values);
			if(result.next())
				idCli = result.getInt("id_klienta");

			DatabaseConnection.delete("Klient","Id_klienta", idCli);
			assertEquals(0,res);
		}
		catch(Exception e)
		{
			fail();
		}	
	}

	@Test
	public void testLoadAllPHBs()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookPBH> allPBHs = user.loadAllPHBs();
			assertNotNull(allPBHs);
		}
		catch(SQLException e)
		{
			fail();
		}
	}

	@Test
	public void testLoadAllAuthors()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookAuthor> allAuthors = user.loadAllAuthors();	
			assertNotNull(allAuthors);
		}
		catch(SQLException e)
		{
			fail();
		}
	}

	@Test
	public void testLoadAvailableBooks()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookInformation> allBooks = user.loadAvailableBooks();	
			assertNotNull(allBooks);
		}
		catch(SQLException e)
		{
			fail();
		}
	}

	@Test
	public void testLoadOrdersToDo()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookInformation> allBooks = user.loadOrdersToDo();
			assertNotNull(allBooks);
		}
		catch(SQLException e)
		{
			fail();
		}
	}

	@Test
	public void testLoadFinishedOrders()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookInformation> allBooks = user.loadFinishedOrders();
			assertNotNull(allBooks);
		}
		catch(SQLException e)
		{
			fail();
		}
	}

	@Test
	public void testLoadAllBooks()
	{
		try
		{
			UserServices user = new SQLUserServices();
			ArrayList<BookInformation> allBooks = user.loadAllBooks();
			assertNotNull(allBooks);
		}
		catch(SQLException e)
		{
			fail();
		}
	}


}
