package com.example.borna2.ikitchenapp.Model;

import java.io.Serializable;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable{
    private String name;
    private String key;
    private List<Product> productList = new ArrayList<>();

    public Category() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return name.equals(category.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}