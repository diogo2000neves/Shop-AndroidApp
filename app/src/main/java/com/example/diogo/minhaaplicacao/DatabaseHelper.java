package com.example.diogo.minhaaplicacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.diogo.minhaaplicacao.UserAcc.NewUserInfo.TABLE_NAME;
import static com.example.diogo.minhaaplicacao.UserAcc.NewUserInfo.USER_APELIDO;
import static com.example.diogo.minhaaplicacao.UserAcc.NewUserInfo.USER_EMAIL;
import static com.example.diogo.minhaaplicacao.UserAcc.NewUserInfo.USER_NAME;
import static com.example.diogo.minhaaplicacao.UserAcc.NewUserInfo.USER_PASS;

/**
 * Created by diogo on 13/04/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINF.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME+"("+ UserAcc.NewUserInfo.USER_NAME+" TEXT, "+
            UserAcc.NewUserInfo.USER_APELIDO+" TEXT, "+ UserAcc.NewUserInfo.USER_EMAIL+" TEXT, "+ UserAcc.NewUserInfo.USER_PASS+" TEXT, "+
            UserAcc.NewUserInfo.USER_TELE+" TEXT, "+ UserAcc.NewUserInfo.USER_NASC+" TEXT, "+ UserAcc.NewUserInfo.USER_MORADA+" TEXT, "+
            UserAcc.NewUserInfo.USER_CP+" TEXT, "+ UserAcc.NewUserInfo.USER_ENDERECO+" TEXT, "+ UserAcc.NewUserInfo.USER_CIDADE+");";
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
            Log.e("DATABASE OPERATIONS","Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created...");
    }

    public void addInformations(String nome, String apelido, String email, String pass, String telemovel, String nascimento, String morada, String cp,
                        String endereco, String cidade, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserAcc.NewUserInfo.USER_NAME,nome);
        contentValues.put(UserAcc.NewUserInfo.USER_APELIDO,apelido);
        contentValues.put(UserAcc.NewUserInfo.USER_EMAIL,email);
        contentValues.put(UserAcc.NewUserInfo.USER_PASS,pass);
        contentValues.put(UserAcc.NewUserInfo.USER_TELE,telemovel);
        contentValues.put(UserAcc.NewUserInfo.USER_NASC,nascimento);
        contentValues.put(UserAcc.NewUserInfo.USER_MORADA,morada);
        contentValues.put(UserAcc.NewUserInfo.USER_CP,cp);
        contentValues.put(UserAcc.NewUserInfo.USER_ENDERECO,endereco);
        contentValues.put(UserAcc.NewUserInfo.USER_CIDADE,cidade);
        db.insert(TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean getUser(String email, String pass){
        String selectQuery = "select * from " + TABLE_NAME + " where " +
                USER_EMAIL + " = "+ "'"+email+"'" + " and " + USER_PASS + " = " + "'"+pass+"'";

                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(selectQuery, null);
                //Mover para a primeira linha
                cursor.moveToFirst();
                if (cursor.getCount() > 0) {  //select name, apelido from
                    return true;
                }
                cursor.close();
                db.close();

                return false;
    }

    public String getName(String email){
        String selectQuery = "select " + USER_NAME + ", " + USER_APELIDO + " from " + TABLE_NAME + " where " + USER_EMAIL + " = "+ "'"+email+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        String currentUsername = cursor.getString(0);
        String currentUserapelido = cursor.getString(1);
        String currentName = currentUsername+"" + " "+currentUserapelido;
        cursor.close();
        db.close();
        return currentName;
    }
}
