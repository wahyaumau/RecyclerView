package com.example.recyclerviewsubmissionmadp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Hardware> listHardware;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        listHardware = new ArrayList<>();
        showRecyclerView();

        if (savedInstanceState == null) {
            setActionBarTitle("Card View");
            listHardware.addAll(HardwareData.getListData());
            showRecyclerCardView();
            mode = R.id.action_cardview;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hardware> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            listHardware.addAll(stateList);
            setMode(stateMode);
        }

    }

    private void showRecyclerView(){
        // pengggunaan getApplicationContext untuk menghindari memory leak pattern
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ListHardwareAdapter listHardwareAdapter = new ListHardwareAdapter(getApplicationContext());
        listHardwareAdapter.setListHardware(listHardware);
        recyclerView.setAdapter(listHardwareAdapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHardware(listHardware.get(position));
            }
        });

    }

    private void showRecyclerCardView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewHardwareAdapter cardViewPresidentAdapter = new CardViewHardwareAdapter(this);
        cardViewPresidentAdapter.setListHardware(listHardware);
        recyclerView.setAdapter(cardViewPresidentAdapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHardware(listHardware.get(position));
            }
        });
    }

    private void showSelectedHardware(Hardware hardware){
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME, hardware.getName());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_DESCRIPTION, hardware.getDescription());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, hardware.getPhoto());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TYPE, hardware.getType());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PRICE, hardware.getPrice());
        startActivity(moveWithDataIntent);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "ListView";
                showRecyclerView();
                break;
            case R.id.action_cardview:
                title = "CardView";
                showRecyclerCardView();
                break;
        }
        this.mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, listHardware);
        outState.putInt(STATE_MODE, mode);
    }
}
