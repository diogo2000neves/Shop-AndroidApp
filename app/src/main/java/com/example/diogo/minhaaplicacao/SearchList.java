package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchList extends Activity {

    public void ClickBack (View v){
        if(v.getId() == R.id.back){
            Intent i = new Intent(SearchList.this, Loja.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        }
    }

    private static final String TAG = "SearchList";
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ListView list = (ListView) findViewById(R.id.ListProducts);
        EditText search = (EditText) findViewById(R.id.search);
        Log.d(TAG, "onCreate: Started");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.array_produtos)));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchList.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent myItent = new Intent(view.getContext(), Produto1.class);
                    startActivityForResult(myItent,0);
                }

                if (position==1){
                    Intent myIntent = new Intent(view.getContext(), Loja.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

}