/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.umk.mat.ksiegarnia.model.Admin;
import pl.umk.mat.ksiegarnia.model.Client;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;
import pl.umk.mat.ksiegarnia.model.UserServices;
import pl.umk.mat.ksiegarnia.model.book.BookAuthor;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookOrder;
import pl.umk.mat.ksiegarnia.model.book.BookPBH;
import pl.umk.mat.ksiegarnia.view.admin.AddNewBookView;
import pl.umk.mat.ksiegarnia.view.admin.AdminMainMenuView;
import pl.umk.mat.ksiegarnia.view.admin.DeleteBooksView;
import pl.umk.mat.ksiegarnia.view.admin.FinishedOrdersView;
import pl.umk.mat.ksiegarnia.view.admin.OrdersToDoView;
import pl.umk.mat.ksiegarnia.view.client.AvailableProductsView;
import pl.umk.mat.ksiegarnia.view.client.BasketView;
import pl.umk.mat.ksiegarnia.view.client.ChangeUserDataView;
import pl.umk.mat.ksiegarnia.view.client.ConfirmOrderView;
import pl.umk.mat.ksiegarnia.view.client.MainMenuView;
import pl.umk.mat.ksiegarnia.view.client.OrdersView;
import pl.umk.mat.ksiegarnia.view.services.CreateNewUserView;
import pl.umk.mat.ksiegarnia.view.services.LoginView;
import pl.umk.mat.ksiegarnia.view.services.ServicesView;

/**
 * The Class AdminController.
 *
 * @author Mariusz
 */
public class AdminController
{
    
    /** The admin model. */
    private Admin adminModel;
    
    /** The view admin main menu. */
    private AdminMainMenuView viewAdminMainMenu;
    
    /** The view add new book. */
    private AddNewBookView viewAddNewBook;
    
    /** The view delete books. */
    private DeleteBooksView viewDeleteBooks;
    
    /** The view orders to do. */
    private OrdersToDoView viewOrdersToDo;
    
    /** The view finished orders. */
    private FinishedOrdersView viewFinishedOrders;
    
    
    /**
     * Instantiates a new admin controller.
     *
     * @param a the admin
     */
    public AdminController(Admin a)
    {
    	this.adminModel=a;	
    }
    
    /**
     * Admin main menu control.
     */
    public void adminMainMenuControl()
	{
    	viewAdminMainMenu = new AdminMainMenuView();
    	viewAdminMainMenu.showMe();
    	
    	Thread thread = new newOrderIconThread();
    	thread.start();
    	
    	viewAdminMainMenu.setAddBookActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			AdminController con = new AdminController(adminModel);
				con.addBooksControl();
				viewAdminMainMenu.closeFrame();	
      		
      		}
    	});
    	viewAdminMainMenu.setDeleteBookActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			AdminController con = new AdminController(adminModel);
				con.deleteBooksControl();
				viewAdminMainMenu.closeFrame();	
      		
      		}
    	});
    	viewAdminMainMenu.setLogOutActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			UserServices user = new SQLUserServices();
      			ServicesController con = new ServicesController(user);
				con.loginControl();
				viewAdminMainMenu.closeFrame();	
      		
      		}
    	});
    	viewAdminMainMenu.setOrdersDoneActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			AdminController con = new AdminController(adminModel);
				con.ordersFinishedControl();
				viewAdminMainMenu.closeFrame();	
      		
      		}
    	});
    	viewAdminMainMenu.setOrdersToDoActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			AdminController con = new AdminController(adminModel);
				con.ordersToDoControl();
				viewAdminMainMenu.closeFrame();	
      		
      		}
    	});
    	
    		
	}
    
	/**
	 * Add books control.
	 */
	public void addBooksControl()
	{
		viewAddNewBook = new AddNewBookView();
		try
		{
			ArrayList<BookPBH> allPBHs = adminModel.loadAllPHBs();
		    ArrayList<BookAuthor> allAuthors =  adminModel.loadAllAuthors();
		    viewAddNewBook.fillPBHComboBox(allPBHs);
		    viewAddNewBook.fillAuthorComboBox(allAuthors);
		    viewAddNewBook.showMe();
		}
		catch(NullPointerException e)
		{
			viewAddNewBook.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewAddNewBook.showMessage("Blad polaczenia z baza : "+ e);
		}
	   
	    
		viewAddNewBook.setAdminMenuActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminController con = new AdminController(adminModel);
				con.adminMainMenuControl();
				viewAddNewBook.closeFrame();	

			}
		});
		viewAddNewBook.setAddNewBookActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					ArrayList<BookPBH> allPBHs = adminModel.loadAllPHBs();
				    ArrayList<BookAuthor> allAuthors =  adminModel.loadAllAuthors();
					int idAuthor = 0;
			    	int idPBH = 0;
	
	
			    	if(!viewAddNewBook.isAuthorSelected())
			    	{
			    		String ourAuthor = viewAddNewBook.getSelectedAuthor();
			    		for (BookAuthor curAuthor : allAuthors) {
			    			if( ourAuthor.equals(curAuthor.getName() + " " + curAuthor.getSurname()))
			    				idAuthor = curAuthor.getID();
			    		}         
			    	}
			    	else
			    	{     
			    		String name = viewAddNewBook.getAuthorName();
			    		String surname = viewAddNewBook.getAuthorSurname();
			    		String mail = viewAddNewBook.getAuthorMail();
			    		
			    		idAuthor = adminModel.addNewAuthor(name,surname,mail); 
			    	}
	
			    	if(!viewAddNewBook.isAddNewSelected())
			    	{
			    		String ourPbh = viewAddNewBook.getSelectedPBH();
			    		for (BookPBH curPBH : allPBHs) {
			    			if( ourPbh.equals(curPBH.getName()))
			    				idPBH = curPBH.getID();
			    		}
			    	}
			    	else
			    	{
			    		String name = viewAddNewBook.getPBHName();
			    		String phone = viewAddNewBook.getPBHPhone();
			    		String mail = viewAddNewBook.getPBHMail();
			    		idPBH = adminModel.addNewPBH(name, Integer.parseInt(phone), mail );  
			    	}
	
	
			    	adminModel.addNewBook(viewAddNewBook.getBookTitle(), idAuthor, idPBH, viewAddNewBook.getPriceBook(),viewAddNewBook.getBookDate());
				}
				catch(NullPointerException e)
				{
					viewAddNewBook.showMessage("Blad polaczenia z baza : "+ e);
				}
				catch(SQLException e)
				{
					viewAddNewBook.showMessage("Blad polaczenia z baza : "+ e);
				}
				catch(ParseException e)
				{
					viewAddNewBook.showMessage(e+"");
				}
				viewAddNewBook.showMessage("Pomyslnie dodano pozycje!");	
				AdminController con = new AdminController(adminModel);
				con.adminMainMenuControl();
				viewAddNewBook.closeFrame();	
					
			}
		});
	}
	
	/**
	 * Delete books control.
	 */
	public void deleteBooksControl()
	{
		viewDeleteBooks = new DeleteBooksView();
		try
		{
			ArrayList<BookInformation> allBooks = adminModel.loadAllBooks();
			viewDeleteBooks.showTable(allBooks);
		}
		catch(NullPointerException e)
		{
			viewDeleteBooks.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewDeleteBooks.showMessage("Blad polaczenia z baza : "+ e);
		}
		
	    viewDeleteBooks.showMe();
	    
	    viewDeleteBooks.setMainMenuActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminController con = new AdminController(adminModel);
				con.adminMainMenuControl();
				viewDeleteBooks.closeFrame();	

			}
		});
	    
	    viewDeleteBooks.setDeleteSelectedActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					ArrayList<Integer> booksToDelete = viewDeleteBooks.getBooksToDelete();
					for(Integer id : booksToDelete)
					{
						adminModel.deleteBook(id);
					}
				}
				catch(NullPointerException e)
				{
					viewDeleteBooks.showMessage("Blad polaczenia z baza : "+ e);
				}
				catch(SQLException e)
				{
					viewDeleteBooks.showMessage("Blad polaczenia z baza : "+ e);
				}
			}
		});
	}
	
	/**
	 * Orders to do control.
	 */
	public void ordersToDoControl()
	{
		viewOrdersToDo = new OrdersToDoView();
		try
		{
			ArrayList<BookInformation> allBooks = adminModel.loadOrdersToDo();
			viewOrdersToDo.showTable(allBooks);
		}
		catch(NullPointerException e)
		{
			viewOrdersToDo.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewOrdersToDo.showMessage("Blad polaczenia z baza : "+ e);
		}
		viewOrdersToDo.showMe();
	    
		viewOrdersToDo.setMainMenuActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminController con = new AdminController(adminModel);
				con.adminMainMenuControl();
				viewOrdersToDo.closeFrame();	

			}
		});
		viewOrdersToDo.setMakeOrderActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					ArrayList<Integer> ordersToDo = viewOrdersToDo.getSelectedOrders();
					for(Integer id : ordersToDo)
					{
						adminModel.confirmOrder(id);
					}	
				}
				catch(NullPointerException e)
				{
					viewOrdersToDo.showMessage("Blad polaczenia z baza : "+ e);
				}
				catch(SQLException e)
				{
					viewOrdersToDo.showMessage("Blad polaczenia z baza : "+ e);
				}
			}
		});
		
	}
	
	/**
	 * Orders finished control
	 */
	public void ordersFinishedControl()
	{
		viewFinishedOrders = new FinishedOrdersView();
		try
		{
			ArrayList<BookInformation> allBooks = adminModel.loadFinishedOrders();
			viewFinishedOrders.showTable(allBooks);
		}
		catch(NullPointerException e)
		{
			viewFinishedOrders.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewFinishedOrders.showMessage("Blad polaczenia z baza : "+ e);
		}
		viewFinishedOrders.showMe();
		
		viewFinishedOrders.setMainMenuActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AdminController con = new AdminController(adminModel);
				con.adminMainMenuControl();
				viewFinishedOrders.closeFrame();	
			}
		});
		
	}
	
	/**
	 * shows empty or full basket in admin menu
	 */
	public class newOrderIconThread extends Thread 
    {
        
        @Override
        public void run(){  
            try {     
                while(true)
                {
                    
                	newOrderIconThread.sleep(15000);
                    
                    try
                    {
	                    if(adminModel.areNewOrders())
	                    {
	                    	viewAdminMainMenu.setNewOrderIcon(true);
	                    }
	                    else
	                    {
	                    	viewAdminMainMenu.setNewOrderIcon(false);
	                    }
                    }
                    catch(NullPointerException e)
            		{
                    	viewAdminMainMenu.showMessage("Blad polaczenia z baza : "+ e);
            		}
            		catch(SQLException e)
            		{
            			viewAdminMainMenu.showMessage("Blad polaczenia z baza : "+ e);
            		}

                }  
            }catch (InterruptedException ex) {
                Logger.getLogger(AdminMainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    	
    	
    
}
