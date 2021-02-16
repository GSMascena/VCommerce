/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.control.components;

import java.util.ArrayList;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class Request {
    private int idRequest;
    private Client client;
    private ArrayList<Product> productList;
    
    //Construtor
    public Request(int idRequest, Client client) {
        this.idRequest = idRequest;
        this.client = client;
        this.productList = new ArrayList<>();
    }
    //Construtor FIM
    
    //Métodos
    public void addProduct(Product product){
        this.productList.add(product);
    }
    
    public Product[] giveProductList(){
        Product[] productArray = new Product[productList.size()];
        int counter = 0;
        for(Product product : productList){
            productArray[counter] = product;
            counter++;
        }
        return productArray;
    }
    //Métodos FIM
    
    //Getters e Setters
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    //Getters e Setters FIM
    
}
