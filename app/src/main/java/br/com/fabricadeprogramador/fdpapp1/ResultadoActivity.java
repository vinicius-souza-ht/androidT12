package br.com.fabricadeprogramador.fdpapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by viniciuspodi on 01/11/16.
 */

public class ResultadoActivity extends Activity {

    private static final String TAG = "ResultadoActivity";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "CHAMOU ON CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Button btFechar = (Button) findViewById(R.id.bt_fechar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double resultado = bundle.getDouble("resultado");

        TextView tvResultado = (TextView) findViewById(R.id.tv_resultado);
        tvResultado.setText(resultado.toString());

        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
