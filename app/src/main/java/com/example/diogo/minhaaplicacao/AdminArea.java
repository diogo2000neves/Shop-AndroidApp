package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminArea extends Activity {

    public void ClickLoja (View v){
        if(v.getId() == R.id.Opcao1){
            Intent i = new Intent(AdminArea.this, AdminLoja.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickEncomendas (View v){
        if(v.getId() == R.id.Opcao2){
            Intent i = new Intent(AdminArea.this, Encomendas.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickContacto (View v){
        if(v.getId() == R.id.Opcao3){
            Intent i = new Intent(AdminArea.this, Contacto.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickConta (View v){
        if(v.getId() == R.id.Opcao4){
            Intent i = new Intent(AdminArea.this, Conta.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void ClickSair (View v){
        if(v.getId() == R.id.sair){
            Intent i = new Intent(AdminArea.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);
    }
}