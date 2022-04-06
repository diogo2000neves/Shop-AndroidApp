package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Encomendas extends Activity {

    public void ClickBack8 (View v){
        if(v.getId() == R.id.back8){
            Intent i = new Intent(Encomendas.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encomendas);
    }
}
