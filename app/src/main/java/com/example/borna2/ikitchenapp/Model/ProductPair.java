package com.example.borna2.ikitchenapp.Model;



import java.io.Serializable;

public class ProductPair implements Serializable {
    private Product product;
    private int count;

    public ProductPair() {
    }

    public ProductPair(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getPairTotal() {
        return
                (this.getProduct().getActionflag() ? this.getProduct().getActionprice() : this.getProduct().getPrice()) * this.getCount();

    }
}