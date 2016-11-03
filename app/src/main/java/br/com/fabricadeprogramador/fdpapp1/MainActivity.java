package br.com.fabricadeprogramador.fdpapp1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{

    private static final String TAG = "MainActivity";

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
        Log.i(TAG,"CHAMOU ON CREATE");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.bt_soma);
        Button bt2 = (Button) findViewById(R.id.bt_sub);
        Button bt3 = (Button) findViewById(R.id.bt_mul);
        Button bt4 = (Button) findViewById(R.id.bt_div);

        final EditText ed1 = (EditText) findViewById(R.id.ed1);
        final EditText ed2 = (EditText) findViewById(R.id.ed2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double soma = n1 + n2;

                Intent irParaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado", soma);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double sub = n1 - n2;

                Intent irParaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado", sub);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double mul = n1 * n2;

                Intent irParaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado", mul);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double n1 = Double.parseDouble(ed1.getText().toString());
                Double n2 = Double.parseDouble(ed2.getText().toString());

                Double div = n1 / n2;

                Intent irParaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("resultado", div);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);

            }
        });
    }
}