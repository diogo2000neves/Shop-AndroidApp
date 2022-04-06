package com.example.diogo.minhaaplicacao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class AdminLoja extends Activity {

    Intent clickedDay;

    public void ClickProduto1()
    {
        clickedDay = new Intent(AdminLoja.this, Produto1.class);
        startActivity(clickedDay);
    }

    public void ClickBack5 (View v){
        if(v.getId() == R.id.back5){
            Intent i = new Intent(AdminLoja.this, UserArea.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void SearchClick (View v){
        if(v.getId() == R.id.search){
            Intent i = new Intent(AdminLoja.this, SearchList.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
        }
    }

    ImageView imageView;
    Button menu;
    Button menu2;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_loja);

        menu = (Button) findViewById(R.id.menu);
        menu2= (Button) findViewById(R.id.button3);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu (AdminLoja.this,menu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        ClickProduto1();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu (AdminLoja.this,menu2);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu2, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        openGallery();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}


