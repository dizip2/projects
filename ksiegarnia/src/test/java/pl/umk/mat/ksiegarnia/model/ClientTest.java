package pl.umk.mat.ksiegarnia.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pl.umk.mat.ksiegarnia.model.book.BookInformation;

public class ClientTest
{
	// testy sa bardziej integracyjny niz jednostkowe, ale jeszcze mockowania nie zdazylem sie nauczyc
	Client client = new Client(2);
	@Test
	public void testAddDeleteBookFromBasket()
	{
		try
		{
			client.addToBasket(1);
			client.deleteOrdersFromBasket(1);
		}
		catch(Exception e)
		{
			fail();
		}
		assertTrue(true);
	}
	@Test
	public void testEditYourData()
	{
		try
		{
			client.editYourData("Jerzy","Dudek","unknown",123456789);
		}
		catch(Exception e)
		{
			fail();
		}
		assertTrue(true);
	}
	
	@Test
	public void testLoadMyBasket()
	{
		try
		{
			ArrayList<BookInformation> allBooks = client.loadMyBasket();
			assertNotNull(allBooks);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	@Test
	public void testLoadMyOrders()
	{
		try
		{
			ArrayList<BookInformation> allOrders = client.loadMyOrders();
			assertNotNull(allOrders);
		}
		catch(Exception e)
		{
			fail();
		}
	}

	
	
	
	
	
	

}
