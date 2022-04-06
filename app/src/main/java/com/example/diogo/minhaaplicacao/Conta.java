package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Conta extends Activity {

    DatabaseHelper myDb;

    public void DefUm (View v){
        if(v.getId() == R.id.primeiraDef){
            Intent i = new Intent(Conta.this, DefUm.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickConta (View v){
        if(v.getId() == R.id.backConta){
            Intent i = new Intent(Conta.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        myDb = new DatabaseHelper(this);
        Toast.makeText(getApplicationContext(), ""+MainActivity.i3+"", Toast.LENGTH_LONG).show();
        ((TextView)findViewById(R.id.textView74)).setText(MainActivity.i3);
    }

}
