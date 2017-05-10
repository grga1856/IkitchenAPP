package com.example.borna2.ikitchenapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shimu on 16.3.2017..
 */

public class Order implements Serializable {

    List<ProductPair> listOfOrderedProducts = new ArrayList<>();
    private String tableName;
    private String userID;
    private String waiterID;
    private Boolean paid = Boolean.FALSE;
    private Boolean served = Boolean.FALSE;
    private long timeStamp;
    private Double total;
    private Boolean ordered;
    private Boolean forkitchen;
    private Boolean done = Boolean.FALSE;


    public Order() {
    }

    public Boolean getForkitchen() {
        return forkitchen;
    }

    public void setForkitchen(Boolean forkitchen) {
        this.forkitchen = forkitchen;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<ProductPair> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }

    public void setListOfOrderedProducts(List<ProductPair> listOfOrderedProducts) {
        this.listOfOrderedProducts = listOfOrderedProducts;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getWaiterID() {
        return waiterID;
    }

    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getServed() {
        return served;
    }

    public void setServed(Boolean served) {
        this.served = served;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getTotal() {
        double total = 0.;
        for (ProductPair product : listOfOrderedProducts) {
            total += (product.getProduct().getActionflag() ? product.getProduct().getActionprice() : product.getProduct().getPrice()) * product.getCount();
        }
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public Double sum() {
        double total = 0.;
        for (ProductPair product : listOfOrderedProducts) {
            total += (product.getProduct().getActionflag() ? product.getProduct().getActionprice() : product.getProduct().getPrice()) * product.getCount();
        }
        return total;
    }
}