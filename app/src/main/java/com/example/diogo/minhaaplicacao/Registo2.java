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

public class Registo2 extends Activity {

    Intent clickedDay;

    public void nextRegister2()
    {
        clickedDay = new Intent(Registo2.this, Register3.class);
        clickedDay.putExtra("i1", Registo.userNome);
        clickedDay.putExtra("i2", Registo.userApelido);
        clickedDay.putExtra("i3", Registo.userEmail);
        clickedDay.putExtra("i4", userPass);
        if (Register3.userTele != null){
            clickedDay.putExtra("newi5", Register3.userTele);
        }
        if (Register3.userDia != null){
            clickedDay.putExtra("newi6", Register3.userDia);
        }
        if (Register3.userMes != null){
            clickedDay.putExtra("newi7", Register3.userMes);
        }
        if (Register3.userAno != null){
            clickedDay.putExtra("newi8", Register3.userAno);
        }
        if (Register3.userNasc != null){
            clickedDay.putExtra("newi9", Register3.userNasc);
        }
        if (Register3.userMorada != null){
            clickedDay.putExtra("newi10", Register3.userMorada);
        }
        if (Register3.userCodigo != null){
            clickedDay.putExtra("newi11", Register3.userCodigo);
        }
        if (Register3.userPostal != null){
            clickedDay.putExtra("newi12", Register3.userPostal);
        }
        if (Register3.userCP != null){
            clickedDay.putExtra("newi13", Register3.userCP);
        }
        startActivity(clickedDay);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void ClickBack2 (View v){
        if(v.getId() == R.id.back2){
            Intent i = new Intent(Registo2.this, Registo.class);
            i = i.putExtra("newi1", Registo.userNome);
            i = i.putExtra("newi2", Registo.userApelido);
            i = i.putExtra("newi3", Registo.userEmail);
            i = i.putExtra("newi4", userPass);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void ClickVoltar1 (View v){
        if(v.getId() == R.id.button15){
            Intent i = new Intent(Registo2.this, Registo.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private EditText editText3, editText2;

    private Button buttonToRegister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo2);

        infoRetain();

        if (retaini4 != null){
            ((EditText)findViewById(R.id.editText3)).setText(retaini4);
            ((EditText)findViewById(R.id.editText2)).setText(retaini4);
        } else {
            Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_LONG).show();
        }

        initializeWidgets();

        initializeListeners();

        buttonToRegister2.setOnClickListener(new View.OnClickListener() {
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

        editText3 = (EditText) findViewById(R.id.editText3);
        editText2 = (EditText) findViewById(R.id.editText2);

        buttonToRegister2 = (Button) findViewById(R.id.buttonToRegister2);
    }

    public static String userPass;

    public void infoSend (View view) {
        userPass = editText2.getText().toString();
    }

    public void signUp(View view) {
        boolean isValid = true;
        String pw = editText3.getText().toString();
        String cp = editText2.getText().toString();

        if (pw.isEmpty()){
            editText3.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            editText2.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error2)).setText("");
            ((TextView)findViewById(R.id.error)).setText("Introduza uma palavra-passe");
            isValid = false;
        } else {
            editText3.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error)).setText("");
        }

        if (isValid && pw.length()<4 && pw.length()>0) {
            ((TextView)findViewById(R.id.error)).setText("A palavra-passe é demasiado pequena!");
            editText3.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            editText2.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error2)).setText("");
            isValid = false;
        } else if (isValid){
            editText3.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error)).setText("");
        }

        if (isValid && cp.isEmpty()){
            ((TextView)findViewById(R.id.error2)).setText("Confirme a palavra-passe!");
            editText2.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            isValid = false;
        } else if (isValid){
            editText2.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error2)).setText("");
        }

        if (isValid && !cp .equals(pw)) {
            ((TextView)findViewById(R.id.error2)).setText("As palavras-passe não são iguais!");
            editText2.getBackground().setColorFilter(Color.rgb(240, 128, 128), PorterDuff.Mode.SRC_ATOP);
            isValid = false;
        } else if (isValid){
            editText2.getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            ((TextView)findViewById(R.id.error2)).setText("");
        }

        if (isValid) {
            nextRegister2();
        }
    }

    public static String retaini4;

    public void infoRetain(){
        Intent intent = getIntent();
        retaini4 = intent.getStringExtra("newi4");
    }
}