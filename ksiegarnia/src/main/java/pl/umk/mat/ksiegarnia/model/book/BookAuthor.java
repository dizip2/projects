/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model.book;

/**
 * The Class BookAuthor.
 *
 * @author Mariusz
 */
public class BookAuthor {
    
    /** The author name. */
    private String name;
    
    /** The author surname. */
    private String surname;
    
    /** The author email. */
    private String email;
    
    /** The author id. */
    private int idAuthor;
    
    /**
     * Instantiates a new book author.
     */
    public BookAuthor(){}
    
    /**
     * Instantiates a new book author.
     *
     * @param i the id author
     * @param n the author name
     * @param s the author surname
     * @param e the author email
     */
    public BookAuthor(int i, String n, String s, String e)
    {
         name = n;
         idAuthor = i;
         surname = s;
         email = e;
    }
     
    /**
     * Sets the author info.
     *
     * @param i the id author
     * @param n the author name
     * @param s the author surname
     * @param e the author email
     */
    public void setAuthorInfo(int i, String n, String s, String e)
    {
        name = n;
        idAuthor = i;
        surname = s;
        email = e;
    }
    
    /**
     * Gets the name.
     *
     * @return the author name
     */
    public String getName() { return name; }
    
    /**
     * Gets the surname.
     *
     * @return the author surname
     */
    public String getSurname() { return surname; }
    
    /**
     * Gets the mail.
     *
     * @return the author mail
     */
    public String getMail() { return email; }
    
    /**
     * Gets the id.
     *
     * @return the author id
     */
    public int getID() { return idAuthor; }
      
}
