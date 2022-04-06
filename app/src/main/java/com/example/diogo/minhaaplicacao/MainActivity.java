package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etEmail, etPass;
    private Session session;

    DatabaseHelper myDb;

    public void ClickLogin (View view){
        if(view.getId() == R.id.loginButton){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    infoSend();
                    login();
                }
            }, 2550);

        }
    }

    public void ClickRegister (View v){
        if(v.getId() == R.id.registerBtn){
            Intent i = new Intent(MainActivity.this, Registo.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        etEmail = (EditText) findViewById(R.id.email);
        etPass = (EditText) findViewById(R.id.password);
        session = new Session(this);

        if (session.loggedin()){
            Intent i = new Intent(MainActivity.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            finish();
        }
    }

    public static String i1, i2, i3;

    public void infoSend() {
        String email = etEmail.getText().toString();

        i1 = etEmail.getText().toString();
        i2 = etPass.getText().toString();
        i3 = myDb.getName(email);
    }


    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String admEmail = "admin@gmail.com";
        String admPass = "admin";

        if(myDb.getUser(email,pass)){
            session.setLoggedin(true);
            Intent i = new Intent(MainActivity.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            finish();
        }else if(email.equals(admEmail) && pass.equals(admPass)){
            Intent i = new Intent(MainActivity.this, AdminArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Email ou password incorretos!", Toast.LENGTH_LONG).show();
        }
    }
}

