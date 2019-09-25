package com.example.times;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "times";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Times ( id_time INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome_time TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Jogadores ( id_jogador INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "id_time_FK INTEGER, nome_jogador TEXT, numero_camiseta INTEGER, FOREIGN KEY(id_time_FK) references Times(id_time) )");
//

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
