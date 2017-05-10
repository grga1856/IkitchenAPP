package com.example.borna2.ikitchenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.borna2.ikitchenapp.Decoration.SimpleDividerItemDecoration;
import com.example.borna2.ikitchenapp.Model.Order;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MyItem> orders;
    private FastItemAdapter<MyItem> fastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fastAdapter = new FastItemAdapter<>();
        orders = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fastAdapter.set(orders);
        // specify an adapter (see also next example)
        mRecyclerView.setAdapter(fastAdapter);
        FirebaseDatabase.getInstance().getReference("kitchen").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final String orderKey = dataSnapshot.getValue(String.class);
                FirebaseDatabase.getInstance().getReference("orders").child(orderKey).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        orders.add(new MyItem(dataSnapshot.getValue(Order.class),orderKey));
                        Log.e("qwertz",dataSnapshot.getValue(Order.class).getTableName());
                        Log.e("qwertz",orders.toString());
                        fastAdapter.set(orders);
                        fastAdapter.notifyAdapterDataSetChanged();
                        fastAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String key=(String) dataSnapshot.getValue();
                ArrayList<MyItem> tempOrder = new ArrayList<MyItem>();
                Log.e("KEY", key);
                for (MyItem order : orders) {
                    if(!order.key.equals(key))
                        tempOrder.add(order);
                }
                orders.clear();
                orders.addAll(tempOrder);
                fastAdapter.set(orders);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        fastAdapter.withSelectable(true);
        fastAdapter.withOnClickListener(new FastAdapter.OnClickListener<MyItem>() {
            @Override
            public boolean onClick(View v, IAdapter<MyItem> adapter, MyItem item, int position) {
                Order o = item.getOrder();
                Intent secondActivity = new Intent(MainActivity.this, Detail.class);
                final int result = 1;
                secondActivity.putExtra("glavniAcc", o);
                secondActivity.putExtra("kljuc", item.getKey());
                startActivity(secondActivity);
                //dodaj intent za novu aktivnost i ušpricaj joj order ( o )
                //u novoj aktivnosti izšpricaj
                return true;
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

}
