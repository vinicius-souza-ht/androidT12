package br.com.fabricadeprogramador.sprinklesapp;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by viniciuspodi on 29/11/16.
 */

public class CreateUserMigration extends Migration {


    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT)");
    }
}
