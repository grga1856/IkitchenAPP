package com.example.borna2.ikitchenapp;

import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.TextView;

        import com.example.borna2.ikitchenapp.Model.Order;
        import com.mikepenz.fastadapter.items.AbstractItem;

        import java.util.List;

public class MyItem extends AbstractItem<MyItem, MyItem.ViewHolder> {
    public Order order;
    String key;

    public String getKey() {
        return key;
    }

    public MyItem(Order order, String key) {
        this.order = order;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MyItem myItem = (MyItem) o;

        return order.equals(myItem.order);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + order.hashCode();
        return result;
    }

    public Order getOrder() {
        return order;

    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.uniq_id;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.item;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //bind our data
        //set the text for the name
        viewHolder.name.setText(order.getTableName());

    }

    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);

    }

    //Init the viewHolder for this Item
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;

        public ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.tableIdent);

        }
    }
}