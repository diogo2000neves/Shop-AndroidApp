package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserArea extends Activity {
    public void ClickLoja (View v){
        if(v.getId() == R.id.Opcao1){
            Intent i = new Intent(UserArea.this, Loja.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickEncomendas (View v){
        if(v.getId() == R.id.Opcao2){
            Intent i = new Intent(UserArea.this, Encomendas.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickContacto (View v){
        if(v.getId() == R.id.Opcao3){
            Intent i = new Intent(UserArea.this, Contacto.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickConta (View v){
        if(v.getId() == R.id.Opcao4){
            Intent i = new Intent(UserArea.this, Conta.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickSair (View v){
        if(v.getId() == R.id.sairBtn){
            Intent i = new Intent(UserArea.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private Button btnLogout;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        Toast.makeText(getApplicationContext(), ""+MainActivity.i3+"", Toast.LENGTH_LONG).show();

        session = new Session(this);
        if (!session.loggedin()){
            logout();
        }
        btnLogout = (Button) findViewById(R.id.sairBtn);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }


    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(UserArea.this,MainActivity.class));
    }
}