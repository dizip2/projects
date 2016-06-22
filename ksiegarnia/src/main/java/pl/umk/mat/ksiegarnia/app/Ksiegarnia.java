/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.app;

import pl.umk.mat.ksiegarnia.controller.ServicesController;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;
import pl.umk.mat.ksiegarnia.model.UserServices;


/**
 *
 * @author Mariusz
 */
public class Ksiegarnia {

    /** 
     * executable class
     */
    public static void main(String[] args) {
    	UserServices user = new SQLUserServices();
    	ServicesController con = new ServicesController(user);
        con.loginControl();      
    }

    
}
