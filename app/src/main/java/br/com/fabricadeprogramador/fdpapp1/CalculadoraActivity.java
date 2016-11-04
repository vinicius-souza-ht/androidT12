package br.com.fabricadeprogramador.fdpapp1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculadoraActivity extends Activity{

    private static final String TAG = "CalculadoraActivity";

    @Bind(R.id.ed1)
    EditText ed1;

    @Bind(R.id.ed2)
    EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"CHAMOU ON CREATE");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calculadora_activity);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_soma)
    public void somar(){

                Log.i(TAG,"SOMA");
                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double soma = n1 + n2;

                Intent irParaResultado = new Intent(CalculadoraActivity.this, ResultadoCalculadoraActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado_calculadora_activity", soma);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

    }

    @OnClick(R.id.bt_sub)
    public void subtrair(){


                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double sub = n1 - n2;

                Intent irParaResultado = new Intent(CalculadoraActivity.this, ResultadoCalculadoraActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado_calculadora_activity", sub);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

    }

    @OnClick(R.id.bt_mul)
    public void multiplicar(){


                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double mul = n1 * n2;

                Intent irParaResultado = new Intent(CalculadoraActivity.this, ResultadoCalculadoraActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado_calculadora_activity", mul);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

    }

    @OnClick(R.id.bt_div)
    public void dividir(){


                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double div = n1 / n2;

                Intent irParaResultado = new Intent(CalculadoraActivity.this, ResultadoCalculadoraActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado_calculadora_activity", div);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

    }

    @Override
    protected void onStart() {
        Log.i(TAG,"CHAMOU ON START");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"CHAMOU ON RESUME");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"CHAMOU ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"CHAMOU ON STOP");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG,"CHAMOU ON RESTART");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"CHAMOU ON DESTROY");
        super.onDestroy();
    }
}