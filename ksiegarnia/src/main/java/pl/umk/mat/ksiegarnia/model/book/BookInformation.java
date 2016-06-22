/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model.book;

/**
 *
 * @author Mariusz
 */
public class BookInformation {
    private int id_book;
    private float price;
    private String title;
    private String author;
    private String publishingHouse;
    private String date;
    private String send;
    public BookInformation()
    {
    }

    /**
     *
     * @param id
     * @param t
     * @param a
     * @param p
     * @param pr
     * @param d
     * @param s
     */
    public BookInformation(int id, String t, String a, String p, float pr, String d )
    {
        id_book = id;
        title = t;
        author = a;
        publishingHouse = p;
        date = d;
        price = pr;
        send = "n";
    }
    public BookInformation(int id, String t, String a, String p, float pr, String d,String s  )
    {
        id_book = id;
        title = t;
        author = a;
        publishingHouse = p;
        date = d;
        price = pr;
        send=s;
    }
    
    public void setBookInfo(int id, String t, String a, String p, float pr, String d,String s)
    {
        id_book = id;
        title = t;
        author = a;
        publishingHouse = p;
        date = d;
        price = pr;
        send=s;
    }
    public int getID()
    {
        return id_book;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPH()
    {
        return publishingHouse;
    }
    public String getDate()
    {
        return date;
    }
    public float getPrice()
    {
        return price;
    }
    public Boolean getSend()
    {
        return send.equals("t");
    }
}
