package br.com.fabricadeprogramador.fdpapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuspodi on 03/11/16.
 */

public class ResultadoConversaoActivity extends Activity {

    @Bind(R.id.tv_conv_metros)
    TextView tvConvMetros;

    @Bind(R.id.tv_conv_resultado)
    TextView tvConvertido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_conversao_activity);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double valorMetro = bundle.getDouble("valorMetro");
        Double valorConv = bundle.getDouble("valorConvertido");

        tvConvMetros.setText(valorMetro.toString());
        tvConvertido.setText(valorConv.toString());

    }
}
