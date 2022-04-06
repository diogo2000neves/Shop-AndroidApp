package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register3 extends Activity {

    Intent clickedDay;

    public void nextRegister3()
    {
        clickedDay = new Intent(Register3.this, Register4.class);
        clickedDay.putExtra("i1", Registo.userNome);
        clickedDay.putExtra("i2", Registo.userApelido);
        clickedDay.putExtra("i3", Registo.userEmail);
        clickedDay.putExtra("i4", Registo2.userPass);
        clickedDay.putExtra("i5", userTele);
        clickedDay.putExtra("i6", userDia);
        clickedDay.putExtra("i7", userMes);
        clickedDay.putExtra("i8", userAno);
        clickedDay.putExtra("i9", userNasc);
        clickedDay.putExtra("i10", userMorada);
        clickedDay.putExtra("i11", userCodigo);
        clickedDay.putExtra("i12", userPostal);
        clickedDay.putExtra("i13", userCP);
        if (Register4.userEndereco != null) {
            clickedDay.putExtra("newi14", Register4.userEndereco);
            Toast.makeText(getApplicationContext(), "Endereco recebido", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Endereco nao recebido", Toast.LENGTH_LONG).show();
        }
        if (Register4.userCidade != null) {
            clickedDay.putExtra("newi15", Register4.userCidade);
            Toast.makeText(getApplicationContext(), "Cidade recebida", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Cidade n recebida", Toast.LENGTH_LONG).show();
        }
        startActivity(clickedDay);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void ClickBack3 (View v){
        if(v.getId() == R.id.back3){
            Intent i = new Intent(Register3.this, Registo2.class);
            i = i.putExtra("newi1", Registo.userNome);
            i = i.putExtra("newi2", Registo.userApelido);
            i = i.putExtra("newi3", Registo.userEmail);
            i = i.putExtra("newi4", Registo2.userPass);
            i = i.putExtra("newi5", userTele);
            i = i.putExtra("newi6", userDia);
            i = i.putExtra("newi7", userMes);
            i = i.putExtra("newi8", userAno);
            i = i.putExtra("newi9", userNasc);
            i = i.putExtra("newi10", userMorada);
            i = i.putExtra("newi11", userCodigo);
            i = i.putExtra("newi12", userPostal);
            i = i.putExtra("newi13", userCP);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar1 (View v){
        if(v.getId() == R.id.button15){
            Intent i = new Intent(Register3.this, Registo.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar2 (View v){
        if(v.getId() == R.id.button14){
            Intent i = new Intent(Register3.this, Registo2.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private EditText telemovel, dia, mes, ano, morada, codigo, postal;

    private Button buttonToRegister3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        infoRetain();

        if ((retaini5 != null) && (retaini6 != null) && (retaini7 != null) && (retaini8 != null)) {
            ((EditText)findViewById(R.id.telemovel)).setText(retaini5);
            ((EditText)findViewById(R.id.dia)).setText(retaini6);
            ((EditText)findViewById(R.id.mes)).setText(retaini7);
            ((EditText)findViewById(R.id.ano)).setText(retaini8);
            ((EditText)findViewById(R.id.morada)).setText(retaini10);
            ((EditText)findViewById(R.id.codigo)).setText(retaini11);
            ((EditText)findViewById(R.id.postal)).setText(retaini12);
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_LONG).show();
        }

        initializeWidgets();

        initializeListeners();

        buttonToRegister3.setOnClickListener(new View.OnClickListener() {
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

        telemovel = (EditText) findViewById(R.id.telemovel);
        dia = (EditText) findViewById(R.id.dia);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);
        morada = (EditText) findViewById(R.id.morada);
        codigo = (EditText) findViewById(R.id.codigo);
        postal = (EditText) findViewById(R.id.postal);

        buttonToRegister3 = (Button) findViewById(R.id.buttonToRegister3);
    }

    public static String userTele, userDia, userMes, userAno, userNasc, userMorada, userCodigo, userPostal, userCP;

    public void infoSend (View view) {
        userTele = telemovel.getText().toString();
        userDia = dia.getText().toString();
        userMes = mes.getText().toString();
        userAno = ano.getText().toString();
        userNasc = userDia+"-"+userMes+"-"+userAno;
        userMorada = morada.getText().toString();
        userCodigo = codigo.getText().toString();
        userPostal = postal.getText().toString();
        userCP = userCodigo+"-"+userPostal;
    }

    public void signUp(View view) {
        boolean isValid = true;
        String telemovelInt = telemovel.getText().toString();
        String mesInt = mes.getText().toString();
        String anoInt = ano.getText().toString();
        String moradaStr = morada.getText().toString();
        String codigoInt = codigo.getText().toString();
        String postalInt = postal.getText().toString();


        if (telemovel.getText().toString().isEmpty()){
            telemovel.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.telemovelText)).setText("Introduza um número!");
            isValid = false;
        } else if (isValid){
            telemovel.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.telemovelText)).setText("");
        }

        if (telemovelInt.length()<9 && telemovelInt.length()>0){
            telemovel.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.telemovelText)).setText("Introduza um número válido!");
            isValid = false;
        } else if (isValid){
            telemovel.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.telemovelText)).setText("");
        }

        if (dia.getText().toString().isEmpty()){
            dia.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.diaText)).setText("Em falta!");
            isValid = false;
        } else if (isValid){
            dia.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.diaText)).setText("");
        }

        if (mesInt.isEmpty()){
            mes.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.mesText)).setText("Em falta!");
            isValid = false;
        } else if (isValid){
            mes.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.mesText)).setText("");
        }

        if (anoInt.isEmpty()){
            ano.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.anoText)).setText("Em falta!");
            isValid = false;
        } else if (isValid){
            ano.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.anoText)).setText("");
        }

        if (moradaStr.isEmpty()){
            morada.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.moradaText)).setText("Introduza uma morada!");
            isValid = false;
        } else if (isValid){
            morada.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.moradaText)).setText("");
        }

        if (codigoInt.isEmpty()){
            codigo.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.codigoText)).setText("Em falta!");
            isValid = false;
        } else if (isValid){
            codigo.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.codigoText)).setText("");
        }

        if (postalInt.isEmpty()){
            postal.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.postalText)).setText("Em falta!");
            isValid = false;
        } else if (isValid){
            codigo.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.codigoText)).setText("");
        }


        if (isValid) {
            nextRegister3();
        }
    }

    public static String retaini5, retaini6, retaini7, retaini8, retaini9, retaini10, retaini11, retaini12, retaini13;

    public void infoRetain(){
        Intent intent = getIntent();
        retaini5 = intent.getStringExtra("newi5");
        retaini6 = intent.getStringExtra("newi6");
        retaini7 = intent.getStringExtra("newi7");
        retaini8 = intent.getStringExtra("newi8");
        retaini9 = intent.getStringExtra("newi9");
        retaini10 = intent.getStringExtra("newi10");
        retaini11 = intent.getStringExtra("newi11");
        retaini12 = intent.getStringExtra("newi12");
        retaini13 = intent.getStringExtra("newi13");
    }

}