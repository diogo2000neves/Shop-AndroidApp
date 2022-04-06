package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class Registo extends Activity {

    Intent clickedDay;

    public void nextRegister() {
        clickedDay = new Intent(Registo.this, Registo2.class);
        clickedDay.putExtra("i1", userNome);
        clickedDay.putExtra("i2", userApelido);
        clickedDay.putExtra("i3", userEmail);
        if(Registo2.userPass != null){
            clickedDay.putExtra("newi4", Registo2.userPass);
        }
        startActivity(clickedDay);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    public void ClickBack1 (View v){
        if(v.getId() == R.id.back1){
            Intent i = new Intent(Registo.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private EditText nome, apelido, email;

    private Button buttonToRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);

        infoRetain();

        if ((retaini1 != null) && (retaini2 != null) && (retaini3 != null)){
            ((EditText)findViewById(R.id.nome)).setText(retaini1);
            ((EditText)findViewById(R.id.apelido)).setText(retaini2);
            ((EditText)findViewById(R.id.email)).setText(retaini3);
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_LONG).show();
        }

        initializeWidgets();

        initializeListeners();

        buttonToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoSend(view);
                signUp(view);
            }
        });
    }

    private void initializeListeners() {
    }
    private void initializeWidgets() {

        nome = (EditText) findViewById(R.id.nome);
        apelido = (EditText) findViewById(R.id.apelido);
        email = (EditText) findViewById(R.id.email);
        buttonToRegister = (Button) findViewById(R.id.buttonToRegister);

    }

    public static String userNome, userApelido, userEmail;

    public void infoSend (View view) {
         userNome = nome.getText().toString();
         userApelido = apelido.getText().toString();
         userEmail = email.getText().toString();
    }

    //Tentar meter o username dentro de um método igual ao do addInfo

    //NOTA: FIZ A BASE DE DADOS QUASE TODA SEM VER NA NET!


    private boolean isValidEmaillId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    public void signUp(View view) {
        boolean isValid = true;
        boolean isValid2 = true;
        boolean isValid3 = true;

            if (isValid && nome.getText().toString().isEmpty()) {
                ((TextView)findViewById(R.id.nomeText)).setText("Introduza o seu nome!");
                nome.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid = false;
            } else if (isValid){
                nome.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                ((TextView)findViewById(R.id.nomeText)).setText("");
            }

            if (isValid && nome.length() < 3 && nome.length() > 0) {
                ((TextView)findViewById(R.id.nomeText)).setText("Nome demasiado pequeno!");
                nome.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid = false;
            } else if (isValid){
                nome.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                ((TextView)findViewById(R.id.nomeText)).setText("");
            }

            if (isValid2 && apelido.getText().toString().isEmpty()) {
                ((TextView)findViewById(R.id.apelidoText)).setText("Introduza o seu apelido!");
                apelido.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid2 = false;
            } else if (isValid2){
                apelido.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                ((TextView)findViewById(R.id.apelidoText)).setText("");
            }

            if (isValid2 && apelido.length() < 3 && apelido.length() > 0) {
                ((TextView)findViewById(R.id.apelidoText)).setText("Apelido demasiado pequeno!");
                apelido.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid2 = false;
            } else if (isValid2){
                apelido.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                ((TextView)findViewById(R.id.apelidoText)).setText("");
            }

            if (isValid3 && email.getText().toString().isEmpty()) {
                ((TextView)findViewById(R.id.emailText)).setText("Introduza o seu email!");
                email.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid3 = false;
            } else if (isValid){
                email.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                ((TextView)findViewById(R.id.emailText)).setText("");
            }

            if (isValid3 && isValidEmaillId(email.getText().toString().trim())) {
                email.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            } else if (isValid3){
                ((TextView)findViewById(R.id.emailText)).setText("Introduza um email válido!");
                email.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
                isValid3 = false;
            }

            if (isValid && isValid2 && isValid3) {
                nextRegister();
            }
        }

    String retaini1, retaini2, retaini3;

    public void infoRetain(){
        Intent intent = getIntent();
        retaini1 = intent.getStringExtra("newi1");
        retaini2 = intent.getStringExtra("newi2");
        retaini3 = intent.getStringExtra("newi3");
    }
    }

