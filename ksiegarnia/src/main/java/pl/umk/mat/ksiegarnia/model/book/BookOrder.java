/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.model.book;

/**
 * The Class Order.
 *
 * @author Mariusz
 */
public class BookOrder {
        
    /** The id_zamowienia. */
    private int idOrder;
    
    /** The price. */
    private float price;
    
    /**
     * Instantiates a new order.
     */
    public BookOrder()
    {    
    }
    
    /**
     * Instantiates a new order.
     *
     * @param kl the kl
     * @param zam the zam
     * @param p the p
     */
    public BookOrder( int zam, float p)
    {
        idOrder = zam;
        price = p;
    }
    
    /**
     * Gets the i d_zamowienia.
     *
     * @return the i d_zamowienia
     */
    public int getOrderID()
    {
        return idOrder;
    }
    
    /**
     * Gets the price.
     *
     * @return the price
     */
    public float getPrice()
    {
        return price;
    }
}
