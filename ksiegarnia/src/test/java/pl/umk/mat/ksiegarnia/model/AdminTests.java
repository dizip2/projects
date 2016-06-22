package pl.umk.mat.ksiegarnia.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Test;

public class AdminTests
{
	Admin admin = new Admin();
	// testy sa bardziej integracyjny niz jednostkowe, ale jeszcze mockowania nie zdazylem sie nauczyc
	@Test
	public void testAddNewAuthor()
	{
		try
		{
			int idAuthor = admin.addNewAuthor("Jacek","Krzynówek","JK@gmail.com" ); 
			DatabaseConnection.delete("Autorzy","Id_Autora", idAuthor); //czyscimy po sobie
			assertNotEquals(-1, idAuthor);
		}
		catch(Exception e)
		{
			fail();
		}
		
	}

	@Test
	public void testAddNewPBH()
	{
		 
		try
		{
			int idPBH = admin.addNewPBH("OnLew", 0000000000 ,"helion@gmail.com" ); 	
			DatabaseConnection.delete("Wydawnictwa","Id_Wydawnictwa", idPBH); //czyscimy po sobie
			assertNotEquals(-1, idPBH);
		}
		catch(Exception e)
		{
			fail();
		}
		
	}

	@Test
	public void testAddDeleteBook()
	{	
		try
		{
			admin.addNewBook("Myslenie w Dzawie", 1, 1, "9999" ,"01-01-1970"); //zakladamy, ze isnieje jakis autor i wydawnictwo o kluczu 1 
			ArrayList<String> records = new ArrayList<String>();
			ArrayList<String> columns = new ArrayList<String>();
            ArrayList<Object> values = new ArrayList<Object>() ;
            int idBook=0;
            
			records.add("Id_Ksiazki");
			columns.add("tytul");
			values.add("Myslenie w Dzawie");
			
			ResultSet result =  DatabaseConnection.select(records,"Ksiazki", null, columns,values);
			if(result.next())
				idBook = result.getInt("Id_Ksiazki");
			
			int res =admin.deleteBook(idBook); //czyscimy po sobie
			
			assertEquals(0, res);
		}
		catch(Exception e)
		{
			fail();
		}	
	}


}
