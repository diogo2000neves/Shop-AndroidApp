package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Produto1 extends Activity {

    public void ClickBack6 (View v){
        if(v.getId() == R.id.back6){
            Intent i = new Intent(Produto1.this, Loja.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto1);
    }
}
