package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Loja extends Activity {

    Intent clickedDay;

    public void ClickProduto1()
    {
        clickedDay = new Intent(Loja.this, Produto1.class);
        startActivity(clickedDay);
    }

    public void ClickBack5 (View v){
        if(v.getId() == R.id.back5){
            Intent i = new Intent(Loja.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void SearchClick (View v){
        if(v.getId() == R.id.search){
            Intent i = new Intent(Loja.this, SearchList.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
    }

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);

        menu = (Button) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu (Loja.this,menu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        if(item.getTitle()=="Categoria 1"){
                            Toast.makeText(Loja.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
    });
  }
}





























