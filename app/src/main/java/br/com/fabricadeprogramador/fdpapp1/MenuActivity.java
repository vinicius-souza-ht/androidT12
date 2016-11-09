package br.com.fabricadeprogramador.fdpapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 03/11/16.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_menu_calculadora)
    public void irCalculadora(){
        Intent irParaCalculadora = new Intent(MenuActivity.this, CalculadoraActivity.class);
        startActivity(irParaCalculadora);

    }

    @OnClick(R.id.bt_menu_conversor)
    public void irConversor(){
        Intent irParaConversor = new Intent(MenuActivity.this, ConversorActivity.class);
        startActivity(irParaConversor);
    }

    @OnClick(R.id.bt_menu_agenda)
    public void irAgenda(){
        Intent irParaAgenda = new Intent(MenuActivity.this, AgendaActivity.class);
        startActivity(irParaAgenda);
    }
}
