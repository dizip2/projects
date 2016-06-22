package pl.umk.mat.ksiegarnia.model;

import java.sql.SQLException;
import java.util.ArrayList;

import pl.umk.mat.ksiegarnia.model.book.BookAuthor;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookPBH;

public interface UserServices
{
	
	public String logIn(String name, String passwd) throws SQLException;

	
	public int createNewClient(String login, String passwd, String admin, String name, String surname,
			String address, String phone) throws SQLException;
	
	public ArrayList<BookPBH> loadAllPHBs() throws SQLException;
	
	public ArrayList<BookAuthor> loadAllAuthors() throws SQLException;
	
	public ArrayList<BookInformation> loadAvailableBooks() throws SQLException;
	
	public ArrayList<BookInformation> loadOrdersToDo() throws SQLException;
	
	public ArrayList<BookInformation> loadFinishedOrders() throws SQLException;
	
	public ArrayList<BookInformation> loadAllBooks() throws SQLException;
	
	public Boolean areNewOrders() throws SQLException;
}
