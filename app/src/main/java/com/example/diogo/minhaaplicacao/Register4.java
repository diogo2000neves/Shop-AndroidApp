package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register4 extends Activity {

    Intent clickedDay;

    public void nextRegister4()
    {
        clickedDay = new Intent(Register4.this, RegisterConclusao.class);
        startActivity(clickedDay);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void ClickBack4 (View v){
        if(v.getId() == R.id.back4){
            Intent i = new Intent(Register4.this, Register3.class);
            i = i.putExtra("newi1", Registo.userNome);
            i = i.putExtra("newi2", Registo.userApelido);
            i = i.putExtra("newi3", Registo.userEmail);
            i = i.putExtra("newi4", Registo2.userPass);
            i = i.putExtra("newi5", Register3.userTele);
            i = i.putExtra("newi6", Register3.userDia);
            i = i.putExtra("newi7", Register3.userMes);
            i = i.putExtra("newi8", Register3.userAno);
            i = i.putExtra("newi9", Register3.userNasc);
            i = i.putExtra("newi10", Register3.userMorada);
            i = i.putExtra("newi11", Register3.userCodigo);
            i = i.putExtra("newi12", Register3.userPostal);
            i = i.putExtra("newi13", Register3.userCP);
            i = i.putExtra("newi14", userEndereco);
            i = i.putExtra("newi15", userCidade);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar1 (View v){
        if(v.getId() == R.id.button15){
            Intent i = new Intent(Register4.this, Registo.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar2 (View v){
        if(v.getId() == R.id.button14){
            Intent i = new Intent(Register4.this, Registo2.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar3 (View v){
        if(v.getId() == R.id.button13){
            Intent i = new Intent(Register4.this, Register3.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private EditText endereco, cidade;

    private Button buttonToRegister4;

    Context context = this;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4);

        infoRetain();

        if ((retaini14 != null) && (retaini15 != null)) {
            ((EditText)findViewById(R.id.endereco)).setText(retaini14);
            ((EditText)findViewById(R.id.cidade)).setText(retaini15);
        } else{
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_LONG).show();
        }

        initializeWidgets();

        initializeListeners();

        buttonToRegister4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoSend(view);
                addInfo(view);
                signUp(view);
            }
        });
    }


    private void initializeListeners() {
    }

    private void initializeWidgets() {

        endereco = (EditText) findViewById(R.id.endereco);
        cidade = (EditText) findViewById(R.id.cidade);


        buttonToRegister4 = (Button) findViewById(R.id.buttonToRegister4);
    }

    public static String userEndereco, userCidade;

    public void infoSend (View view) {
        userEndereco = endereco.getText().toString();
        userCidade = cidade.getText().toString();
    }

    public void addInfo(View view) {
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        databaseHelper.addInformations(Registo.userNome, Registo.userApelido, Registo.userEmail, Registo2.userPass, Register3.userTele, Register3.userNasc,
                Register3.userMorada, Register3.userCP, userEndereco ,userCidade, sqLiteDatabase);
        databaseHelper.close();
    }


    public void signUp(View view) {
        boolean isValid = true;

        if (isValid) {
            nextRegister4();
        }
    }

    public static String retaini14, retaini15;

    public void infoRetain(){
        Intent intent = getIntent();
        retaini14 = intent.getStringExtra("newi14");
        retaini15 = intent.getStringExtra("newi15");
    }

}
