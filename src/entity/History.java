/*JKTV21 Bondarenko*/
package entity;

import java.util.Date;

public class History {
    private Customer customer;
    private Product product;
    private Date takeOnProduct;
    private Date returnProduct;

    public History() {
    }

    public History(Customer customer, Product product, Date takeOnProduct, Date returnProduct) {
        this.customer = customer;
        this.product = product;
        this.takeOnProduct = takeOnProduct;
        this.returnProduct = returnProduct;
    }

    public Date getReturnProduct() {
        return returnProduct;
    }

    public void setReturnProduct(Date returnProduct) {
        this.returnProduct = returnProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTakeOnProduct() {
        return takeOnProduct;
    }

    public void setTakeOnProduct(Date takeOnProduct) {
        this.takeOnProduct = takeOnProduct;
    }

    @Override
    public String toString() {
        return "History{"
                + "customer=" + customer 
                + ", product=" + product 
                + ", takeOnProduct=" + takeOnProduct 
                + ", returnProduct=" + returnProduct + '}';
    }    
}