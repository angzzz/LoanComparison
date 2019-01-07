package com.anjaleeps.loancomparison;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SearchAdapter adapter;
    private ListView listView;
    private DBBackend db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        db = new DBBackend(MainActivity.this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        listView.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        setContentView(R.layout.layout_main);
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {

        getMenuInflater().inflate( R.menu.search_menu, menu );

        // Add SearchWidget.
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem( R.id.search_box ).getActionView();


        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.VISIBLE);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                listView.setAdapter(null);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                if (!("".equals(query))) {
                    List<Entry> dbObject = db.searchDatabase(query);
                    adapter = new SearchAdapter(MainActivity.this, dbObject);
                    listView.setAdapter(adapter);
                }else{
                    listView.setAdapter(null);
                }
                return true;
            }
        });

        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );

        return super.onCreateOptionsMenu( menu );
    }

}
