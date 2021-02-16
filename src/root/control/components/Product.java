/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.control.components;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class Product {
    private int idProduct;
    private String name;
    private double price;
    
    //Construtor
    public Product(int idProduct, String name, double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }
    //Construtor FIM
    
    
    //Getters e Setters
    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //Getters e Setters FIM
    
}
