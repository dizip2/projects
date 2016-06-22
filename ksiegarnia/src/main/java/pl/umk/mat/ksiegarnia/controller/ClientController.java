package pl.umk.mat.ksiegarnia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.umk.mat.ksiegarnia.model.Client;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;
import pl.umk.mat.ksiegarnia.model.UserServices;
import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.model.book.BookOrder;
import pl.umk.mat.ksiegarnia.view.client.AvailableProductsView;
import pl.umk.mat.ksiegarnia.view.client.BasketView;
import pl.umk.mat.ksiegarnia.view.client.ChangeUserDataView;
import pl.umk.mat.ksiegarnia.view.client.ConfirmOrderView;
import pl.umk.mat.ksiegarnia.view.client.MainMenuView;
import pl.umk.mat.ksiegarnia.view.client.OrdersView;

/**
 * The Class ClientController.
 */
public class ClientController
{
	
	/** The client model. */
	private Client clientModel;
	
    /** The view main menu. */
    private MainMenuView viewMainMenu;
    
    /** The view available products. */
    private AvailableProductsView viewAP;
    
    /** The view basket. */
    private BasketView viewBasket;
    
    /** The view orders. */
    private OrdersView viewOrders;
    
    /** The view change user data view. */
    private ChangeUserDataView viewChangeUserData;
    
    /** The view confirm order. */
    private ConfirmOrderView viewConfirmOrder;

    /**
     * Instantiates a new client controller.
     *
     * @param c the client
     */
    public ClientController(Client c)
    {
    	this.clientModel=c;
    }



    /**
     * Main menu control.
     */
    public void mainMenuControl()
    {
    	viewMainMenu = new MainMenuView();
    	viewMainMenu.showMe();
    	viewMainMenu.setBuyBooksActionListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.availableProductsControl();
    			viewMainMenu.closeFrame();	
    		}	
    	});
    	viewMainMenu.setLogOutActionListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e)
    		{
    			UserServices user = new SQLUserServices();
    			ServicesController con = new ServicesController(user);
    			con.loginControl();
    			viewMainMenu.closeFrame();
    		}	
    	});
    	viewMainMenu.setMyOrdersBooksActionListener(new MouseAdapter() {

    		@Override
    		public void mouseClicked(MouseEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.myOrdersControl();
    			viewMainMenu.closeFrame();	
    		}	
    	});
    	viewMainMenu.setEditInfoBooksActionListener(new MouseAdapter() {

    		@Override
    		public void mouseClicked(MouseEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.editUserDataControl();
    			viewMainMenu.closeFrame();	
    		}	
    	});
    	viewMainMenu.setMyBacketBooksActionListener(new MouseAdapter() {

    		@Override
    		public void mouseClicked(MouseEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.myBasketControl();
    			viewMainMenu.closeFrame();
    		}	
    	});
    }
    
    /**
     * Available products control.
     */
    public void availableProductsControl()
    {
    	viewAP = new AvailableProductsView();
    	try
    	{
    		ArrayList<BookInformation> allBooks = clientModel.loadAvailableBooks();
    		viewAP.showTable(allBooks);
    	}
    	catch(NullPointerException e)
		{
    		viewAP.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewAP.showMessage("Blad polaczenia z baza : "+ e);
		}

    	viewAP.showMe();
    	viewAP.setAddToBasketActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent arg)
    		{
    			try
    			{
    				ArrayList<Integer> allTheBooks = new ArrayList<Integer>();
    				allTheBooks = viewAP.getSelectedBooks();
    				for(int bookId : allTheBooks )
    					clientModel.addToBasket(bookId);
    				
    				viewAP.showMessage("Dodano do koszyka!");
    			}
    			catch(NullPointerException e)
    			{
    	    		viewAP.showMessage("Blad polaczenia z baza : "+ e);
    			}
    			catch(SQLException e)
    			{
    				viewAP.showMessage("Blad polaczenia z baza : "+ e);
    			}

    			

    		}	
    	});
    	viewAP.setMainMenuActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.mainMenuControl();		
    			viewAP.closeFrame();	
    		}	
    	});

    }
    
    /**
     * Basket control.
     */
    public void myBasketControl()
    {
    	viewBasket = new BasketView();

    	try
    	{
    		ArrayList<BookInformation> loadBasket = new ArrayList<>();
    		loadBasket = clientModel.loadMyBasket();
    		viewBasket.showTable(loadBasket);
    	}
    	catch(SQLException e)
    	{
    		viewBasket.showMessage(e+"");
    	}
    	viewBasket.showMe();

    	viewBasket.setDeleteSelectedActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent arg)
    		{
    			try
    			{
    				ArrayList<Integer> booksToDelete = new ArrayList<Integer>();
    				booksToDelete = viewBasket.getBooksToDelete();
    				for(int bookId : booksToDelete )
    					clientModel.deleteOrdersFromBasket(bookId);  
    			}
    			catch(NullPointerException e)
    			{
    				viewBasket.showMessage("Blad polaczenia z baza : "+ e);
    			}
    			catch(SQLException e)
    			{
    				viewBasket.showMessage("Blad polaczenia z baza : "+ e);
    			}
    		}

    	});
    	viewBasket.setMainMenuActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.mainMenuControl();		
    			viewBasket.closeFrame();	
    		}

    	});
    	viewBasket.setMakeOrderActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ArrayList<BookOrder> orderedBooks = viewBasket.getOrderedBooks();
    			ClientController con = new ClientController(clientModel);
    			con.makeOrderControl(orderedBooks);		
    			viewBasket.closeFrame();
    		}

    	});

    }
    
    /**
     * Confirm order control.
     *
     * @param orderedBooks the ordered books
     */
    public void makeOrderControl(ArrayList<BookOrder> orderedBooks)
    {
    	viewConfirmOrder = new ConfirmOrderView();

    	float price= 0.0F;

    	for (BookOrder curBook : orderedBooks)
    		price+=curBook.getPrice();

    	viewConfirmOrder.setUserInfoFields(clientModel.getName(), clientModel.getSurname(), clientModel.getAddress(), String.valueOf(clientModel.getPhone()), String.valueOf(price));

    	viewConfirmOrder.showMe();

    	viewConfirmOrder.setSubmitOrderActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent arg)
    		{
    			try
    			{
    				clientModel.confirmOrders(orderedBooks);
    				viewConfirmOrder.showMessage("Transakcja przebiegła pomyślnie!");
    				ClientController con = new ClientController(clientModel);
    				con.mainMenuControl();	
    			}
    			catch(NullPointerException e)
    			{
    				viewConfirmOrder.showMessage("Blad polaczenia z baza : "+ e);
    			}
    			catch(SQLException e)
    			{
    				viewConfirmOrder.showMessage("Blad polaczenia z baza : "+ e);
    			}
    			viewConfirmOrder.closeFrame();
    		}
    	});

    	viewConfirmOrder.setCancelTransactionActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.mainMenuControl();		
    			viewConfirmOrder.closeFrame();	
    		}
    	});

    }
    
    /**
     * Edits user data control.
     */
    public void editUserDataControl()
    {
    	viewChangeUserData = new ChangeUserDataView();
    	viewChangeUserData.showMe();

    	viewChangeUserData.setCancelRegisterActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.mainMenuControl();		
    			viewChangeUserData.closeFrame();	
    		}
    	});


    	viewChangeUserData.setRegisterUserActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent arg)
    		{
    			String name = viewChangeUserData.getName();
    			String surname = viewChangeUserData.getSurname();
    			String address = viewChangeUserData.getAdrdress();
    			String phone = viewChangeUserData.getPhone();
    			if(name.equals("")|| surname.equals("")|| address.equals("")) 
    			{
    				viewChangeUserData.showMessage("Wypelnij obowiazkowe pola!"); 
    			}
    			else if( !isNumeric(phone))
    			{
    				viewChangeUserData.showMessage( "Telefon musi skladac sie z liczb!"); 
    			}
    			else if(name.length() >= 30  )
    			{
    				viewChangeUserData.showMessage( "Imie moze skladac sie maksymalnie z 30 znakow!"); 
    			}
    			else if( surname.length() >= 30 )
    			{
    				viewChangeUserData.showMessage( "Nazwisko  moze skladac sie maksymalnie z 30 znakow!"); 
    			}
    			else if( address.length() >= 30 )
    			{
    				viewChangeUserData.showMessage( "Adres  moze skladac sie maksymalnie z 30 znakow!"); 
    			}
    			else if( phone.length() != 9 )
    			{
    				viewChangeUserData.showMessage( "Komorka to ma 9 cyfr!"); 
    			}
    			else
    			{
    				try
    				{
    					clientModel.editYourData(name, surname, address, Integer.parseInt(phone)); 
    					ClientController con = new ClientController(clientModel);
    					con.mainMenuControl();		
    				}
    				catch(NullPointerException e)
        			{
    					viewChangeUserData.showMessage("Blad polaczenia z baza : "+ e);
        			}
        			catch(SQLException e)
        			{
        				viewChangeUserData.showMessage("Blad polaczenia z baza : "+ e);
        			}
    				viewChangeUserData.closeFrame();	
    			}
    		}

    	});
    }
    
    /**
     * Orders control.
     */
    public void myOrdersControl()
    {
    	viewOrders = new OrdersView();
    	try
    	{
    		ArrayList<BookInformation> allBooks = clientModel.loadMyOrders();
    		viewOrders.showTable(allBooks);
    	}
    	catch(NullPointerException e)
		{
    		viewOrders.showMessage("Blad polaczenia z baza : "+ e);
		}
		catch(SQLException e)
		{
			viewOrders.showMessage("Blad polaczenia z baza : "+ e);
		}
    	viewOrders.showMe();

    	viewOrders.setMainMenuActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			ClientController con = new ClientController(clientModel);
    			con.mainMenuControl();		
    			viewOrders.closeFrame();	
    		}
    	});
    }

    /**
     * Checks if is numeric.
     *
     * @param string
     * @return true, if is numeric
     */
    public static boolean isNumeric(String str)  
    {  
    	try  
    	{  
    		int d = Integer.parseInt(str);  
    	}  
    	catch(NumberFormatException nfe)  
    	{  
    		return false;  
    	}  
    	return true;  
    }
}
