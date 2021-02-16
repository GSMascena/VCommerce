
package root.control.log;

import java.util.ArrayList;
import root.control.components.Product;

/**
 *
 * @authors Gabriel Mascena, Arthur Rocha
 */
public class ProductLog {
    private ArrayList<Product> productLog;
    
    //Construtor
    public ProductLog() {
        this.productLog = new ArrayList<>();
    }
    //Construtor FIM
    
    //Métodos
    public boolean addProduct(Product product){
        if(product.getIdProduct() <= 0)
            return false;
        if(product.getName().equals(""))
            return false;
        if(product.getPrice() <= 0)
            return false;
        
        this.productLog.add(product);
        return true;
    }
    
    public boolean deleteProduct(int id){
        for(Product product : this.productLog){
            if(product.getIdProduct() == id){
                this.productLog.remove(product);
                return true;
            }
        }
        return false;
    }
    
    public int size(){
        return this.productLog.size();
    }
    
    public int generateId(){
        int id = 0;
        for(Product product : this.productLog){
            if(product.getIdProduct() > id){
                id = product.getIdProduct();
            }
        }
        return id+1;
    }
    
    public Product[] toArray(){
        Product[] productArray = new Product[productLog.size()];
        int counter = 0;
        for(Product product : productLog){
            productArray[counter] = product;
            counter++;
        }
        return productArray;
    }
    //Métodos FIM
    
    //Getters e Setters 
    public ArrayList<Product> getProductLog() {
        return productLog;
    }

    public void setProductLog(ArrayList<Product> productLog) {
        this.productLog = productLog;
    }
    //Getters e Setters FIM
    
}
