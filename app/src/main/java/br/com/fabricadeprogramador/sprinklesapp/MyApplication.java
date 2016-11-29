package br.com.fabricadeprogramador.sprinklesapp;

import android.app.Application;

import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by viniciuspodi on 29/11/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());
        runMigrations(sprinkles);
    }

    private void runMigrations(Sprinkles sprinkles) {
        sprinkles.addMigration(new CreateUserMigration());
    }
}