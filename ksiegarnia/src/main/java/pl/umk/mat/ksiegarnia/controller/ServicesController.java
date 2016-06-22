package pl.umk.mat.ksiegarnia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import pl.umk.mat.ksiegarnia.model.Admin;
import pl.umk.mat.ksiegarnia.model.Client;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;
import pl.umk.mat.ksiegarnia.model.UserServices;
import pl.umk.mat.ksiegarnia.view.services.CreateNewUserView;
import pl.umk.mat.ksiegarnia.view.services.LoginView;

/**
 * The Class ServicesController.
 */
public class ServicesController
{
	
	/** The user service. */
	private UserServices userService;
    
	/** The view login. */
	private LoginView viewLogin;
	
	/** The view new user. */
	private CreateNewUserView viewNewUser;

	/**
	 * Instantiates a new services controller.
	 *
	 * @param userService the user service
	 */
	public ServicesController(UserServices userService)
    {
    	this.userService = userService;
    }
	
	/**
	 * Login control.
	 */
	public void loginControl() 
    {
    	viewLogin = new LoginView();
    	viewLogin.showMe();
    	viewLogin.setLogButtonActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent arg0)
      		{
      			if( viewLogin.getLoginInput().equals(""))
      				viewLogin.showMessage("Wypelnij pole!");
      			else 
      			{
      				try
      				{
      					
	      				String role = userService.logIn(viewLogin.getLoginInput(),viewLogin.getPassInput());
	      				if(role.equals("t"))
	      				{
	      					Admin adminModel = new Admin();
	      					adminModel = adminModel.loadAdminData(viewLogin.getLoginInput(), viewLogin.getPassInput());
	      					AdminController con = new AdminController(adminModel);
	      					con.adminMainMenuControl();
	      					viewLogin.closeFrame();
	      				
	      				}
	      				else if(role.equals("n"))
	      				{
	      					Client clientModel = new Client();
	      					clientModel = clientModel.loadClientData(viewLogin.getLoginInput(), viewLogin.getPassInput());
	      					ClientController con = new ClientController(clientModel);
	      					con.mainMenuControl();
	      					viewLogin.closeFrame();
	      				}
	      				else
	      				{
	      					viewLogin.showMessage("Nie znany uzytkownik!");
	      				}
      				}
      				catch(NullPointerException e)
      				{
      					viewLogin.showMessage("Blad polaczenia z baza : "+ e);
      				}
      				catch(SQLException e)
      				{
      					viewLogin.showMessage("Blad polaczenia z baza : "+ e);
      				}
      				
      			}	
      		}
      	});
    	viewLogin.setClearInputnActionListener(new ActionListener(){

      		@Override
      		public void actionPerformed(ActionEvent e)
      		{
      			viewLogin.clearAllInput();
      		}	
      	});
    	viewLogin.setNewUserActionListener(new MouseAdapter() {

    		@Override
      		public void mouseClicked(MouseEvent arg0)
      		{
    			UserServices user = new SQLUserServices();
    			ServicesController con = new ServicesController(user);
				con.newUserControl();
				viewLogin.closeFrame();
      		}
      	});
	
    }
	
	/**
	 * New user control.
	 */
	public void newUserControl()
    {
    	viewNewUser = new CreateNewUserView();
    	
    	viewNewUser.showMe();

    	viewNewUser.setCancelRegisterrActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			UserServices user = new SQLUserServices();
    	        ServicesController con = new ServicesController(user);
    			con.loginControl();		
    			viewNewUser.closeFrame();	
    		}
    	});
    	viewNewUser.setRegisterUserActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent arg)
    		{
    			String login = viewNewUser.getLogin();
    			String password = viewNewUser.getPassword();
    			String name = viewNewUser.getName();
    			String surname = viewNewUser.getSurname();
    			String address = viewNewUser.getAddress();
    			String phone = viewNewUser.getPhone();
    			
    			if(login.equals("") || password.equals("") || name.equals("")|| surname.equals("")|| address.equals("")) 
    	        {
    				viewNewUser.showMessage( "Wypelnij obowiazkowe pola!"); 
    	        }
    	        else if( login.length() >= 30)
    	        {
    	        	viewNewUser.showMessage( "Login za dlugi!"); 
    	        }
    	        else if( password.length() >= 30)
    	        {
    	        	viewNewUser.showMessage( "Haslo za dlugie!"); 
    	        }
    	        else if( !isNumeric(phone))
    	        {
    	        	viewNewUser.showMessage( "Telefon musi skladac sie z liczb!"); 
    	        }
    	        else if(name.length() >= 30  )
    	        {
    	        	viewNewUser.showMessage( "Imie moze skladac sie maksymalnie z 30 znakow!"); 
    	        }
    	        else if( surname.length() >= 30 )
    	        {
    	        	viewNewUser.showMessage( "Nazwisko  moze skladac sie maksymalnie z 30 znakow!"); 
    	        }
    	        else if( address.length() >= 30 )
    	        {
    	        	viewNewUser.showMessage( "Adres  moze skladac sie maksymalnie z 30 znakow!"); 
    	        }
    	        else if( phone.length() != 9 )
    	        {
    	        	viewNewUser.showMessage( "Komorka to ma 9 cyfr!"); 
    	        }
    	        else
    	        {
    	        	try
    	        	{
    	        		userService.createNewClient(login, password ,"n",name, surname , address ,phone);
    	        		UserServices user = new SQLUserServices();
        	        	ServicesController con = new ServicesController(user);
            			con.loginControl();		
            			viewNewUser.closeFrame();
    	        	}
    	        	catch(NullPointerException e)
            		{
    	        		viewNewUser.showMessage("Blad polaczenia z baza : "+ e);
            		}
            		catch(SQLException e)
            		{
            			viewNewUser.showMessage("Blad polaczenia z baza : "+ e);
            		}	
    	        		
    	        }		
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
