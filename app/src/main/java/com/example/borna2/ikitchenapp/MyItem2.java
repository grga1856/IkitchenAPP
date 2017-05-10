package com.example.borna2.ikitchenapp;

/**
 * Created by Borna2 on 08-May-17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.borna2.ikitchenapp.Model.ProductPair;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class MyItem2 extends AbstractItem<MyItem2, MyItem2.ViewHolder> {
    public ProductPair product;

    public MyItem2(ProductPair product) {

        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MyItem2 myItem = (MyItem2) o;

        return product.equals(myItem.product);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }

    public ProductPair getProduct() {
        return product;

    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.uniq_id;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.item2;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //bind our data
        //set the text for the name
        viewHolder.name.setText(product.getProduct().getName());
        viewHolder.quantity.setText(String.valueOf(product.getCount()));

    }

    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);
        holder.quantity.setText(null);

    }

    //Init the viewHolder for this Item
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView quantity;

        public ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.name);
            this.quantity = (TextView) view.findViewById(R.id.quantity);
        }
    }
}