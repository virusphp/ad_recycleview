package com.example.setsuga.recycleku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Hokage> list;

    // untuk membuat view pertama oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(HokageData.getListData());

        showRecyclerList();
        setActionBarTitle("Mode List");
    }

    // Show ListView
    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListHokageAdapter listHokageAdapter = new ListHokageAdapter(this);
        listHokageAdapter.setListHokage(list);
        rvCategory.setAdapter(listHokageAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHokage(list.get(position));
            }
        });
    }

    // Show Grid View
    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridHokageAdapter gridHokageAdapter = new GridHokageAdapter(this);
        gridHokageAdapter.setListHokage(list);
        rvCategory.setAdapter(gridHokageAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHokage(list.get(position));
            }
        });
    }

    // Show Card View
    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewHokageAdapter cardViewHokageAdapter = new CardViewHokageAdapter(this);
        cardViewHokageAdapter.setListHokage(list);
        rvCategory.setAdapter(cardViewHokageAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHokage(list.get(position));
            }
        });
    }

    public void showSelectedHokage(Hokage hokage) {
        Toast.makeText(this, "Kamu Memilih "+hokage.getNama(), Toast.LENGTH_LONG).show();
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    // create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // aksi ketika selected item menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()) {
            case R.id.action_list :
                showRecyclerList();
                title = "Mode List";
                break;
            case R.id.action_grid :
                showRecyclerGrid();
                title = "Mode Grid";
                break;
            case R.id.action_cardview :
                showRecyclerCardView();
                title = "Mode Card";
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }
}
