/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model.book;

/**
 * The Class BookPBH.
 *
 * @author Mariusz
 */
public class BookPBH {
    
    /** The publishing house name. */
    private String name;
    
    /** The publishing house  phone. */
    private int phone;
    
    /** The publishing house  email. */
    private String email;
    
    /** The publishing house id. */
    private int idPBH;
    
    /**
     * Instantiates a new book publishing house.
     */
    public BookPBH(){}
    
    /**
     * Instantiates a new book publishing house.
     *
     * @param i the publishing house id
     * @param n the publishing house name
     * @param p the publishing house phone
     * @param e the publishing house email
     */
    public BookPBH(int i, String n, int p, String e)
    {
         name = n;
         idPBH = i;
         phone = p;
         email = e;
    }
     
    /**
     * Sets the publishing house info.
     *
     * @param i the publishing house id
     * @param n the publishing house name
     * @param p the publishing house phone
     * @param e the publishing house email
     */
    public void setPBHInfo(int i, String n, int p, String e)
    {
        name = n;
        idPBH = i;
        phone = p;
        email = e;
    }
    
    /**
     * Gets the publishing house name.
     *
     * @return name
     */
    public String getName() { return name; }
    
    /**
     * Gets the publishing house phone.
     *
     * @return phone
     */
    public int getPhone() { return phone; }
    
    /**
     * Gets the publishing house mail.
     *
     * @return mail
     */
    public String getMail() { return email; }
    
    /**
     * Gets the publishing house id.
     *
     * @return id
     */
    public int getID() { return idPBH; }
}
