package com.example.borna2.ikitchenapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.borna2.ikitchenapp.Decoration.SimpleDividerItemDecoration;
import com.example.borna2.ikitchenapp.Model.Order;
import com.example.borna2.ikitchenapp.Model.ProductPair;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borna2 on 08-May-17.
 */

public class Detail extends AppCompatActivity {
    private List<ProductPair> products;
    private List<MyItem2> items;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FastItemAdapter<MyItem2> fastAdapter;

    private FloatingActionButton button;
    private Order order;
    private String key = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        button = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        button.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        fastAdapter = new FastItemAdapter<>();
        products = new ArrayList<>();
        items = new ArrayList<>();
        fastAdapter.set(items);
        Intent getOrder = getIntent();
        order = (Order) getOrder.getSerializableExtra("glavniAcc");
        key = getOrder.getStringExtra("kljuc");
        products.addAll(order.getListOfOrderedProducts());
        for (ProductPair product : products) {
            if(product.getProduct().getForkitchen()) {
                items.add(new MyItem2(product));
            }
        }
        fastAdapter.clear();
        fastAdapter.setNewList(items);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // specify an adapter (see also next example)
        mRecyclerView.setAdapter(fastAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.setDone(true);
                FirebaseDatabase.getInstance().getReference("orders").child(key).setValue(order);
                final DatabaseReference kitchen =  FirebaseDatabase.getInstance().getReference("kitchen");
                Query upit = kitchen.orderByValue().equalTo(key);
                upit.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String keyy =dataSnapshot.getValue().toString().split("=")[0].substring(1);
                        Log.e("Values", keyy);
                        kitchen.child(keyy).setValue(null);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                Intent goingBack = new Intent();
                setResult(RESULT_OK, goingBack);
                finish();
            }
        });
    }
}
