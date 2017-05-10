package com.example.borna2.ikitchenapp.Model;

 import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private Double price;
    private String size;
    private Double actionprice;
    private Boolean actionflag;
    private String category;
    private Boolean forkitchen;
    private String key;
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_PRICE = "PRICE";
    public static final String COLUMN_SIZE = "SIZE";
    public static final String COLUMN_ACTIONPRICE = "ACTION_PRICE";
    public static final String COLUMN_ACTIONPRICE_FLAG = "ACTION_FLAG";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public Product()  {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Boolean getForkitchen() {
        return forkitchen;
    }

    public void setForkitchen(Boolean forkitchen) {
        this.forkitchen = forkitchen;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getActionprice() {
        return actionprice;
    }

    public void setActionprice(Double actionprice) {
        this.actionprice = actionprice;
    }

    public Boolean getActionflag() {
        return actionflag;
    }

    public void setActionflag(Boolean actionflag) {
        this.actionflag = actionflag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (actionprice != null ? !actionprice.equals(product.actionprice) : product.actionprice != null)
            return false;
        if (actionflag != null ? !actionflag.equals(product.actionflag) : product.actionflag != null)
            return false;
        if (category != null ? !category.equals(product.category) : product.category != null)
            return false;
        if (forkitchen != null ? !forkitchen.equals(product.forkitchen) : product.forkitchen != null)
            return false;
        return key != null ? key.equals(product.key) : product.key == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (actionprice != null ? actionprice.hashCode() : 0);
        result = 31 * result + (actionflag != null ? actionflag.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (forkitchen != null ? forkitchen.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        return result;
    }
}