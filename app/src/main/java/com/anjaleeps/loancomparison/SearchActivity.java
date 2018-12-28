package com.anjaleeps.loancomparison;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity{

    private TextView textview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);
        handleIntent(getIntent());
        textview=findViewById(R.id.search_result);
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    //public void onListItemClick(ListView l,
                               // View v, int position, long id) {
        // call detail activity for clicked entry
    //}

    private void handleIntent(@NonNull Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
    }

    public void doSearch(String query) {
        String result ="You have searched for "+query;
        //textview.setText(result);
    }
}