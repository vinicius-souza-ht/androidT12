package br.com.fabricadeprogramador.fdpapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 08/11/16.
 */

public class AgendaActivity extends AppCompatActivity {

    @Bind(R.id.ed_agenda_id)
    EditText edId;

    @Bind(R.id.ed_agenda_nome)
    EditText edNome;

    @Bind(R.id.ed_agenda_telefone)
    EditText edTelefone;

    @Bind(R.id.ed_agenda_email)
    EditText edEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_agenda_salvar)
    public void salvar(){
        Intent intent = new Intent(AgendaActivity.this, ListaAgendaActivity.class);
        if(edId.getText().toString().isEmpty()){
            intent.putExtra("pessoa", new Pessoa(edNome.getText().toString(), edTelefone.getText().toString(), edEmail.getText().toString(),0));
        } else {
            intent.putExtra("pessoa", new Pessoa(new Long(edId.getText().toString()), edNome.getText().toString(), edTelefone.getText().toString(), edEmail.getText().toString(), 0));
        }
        startActivity(intent);
    }

    @OnClick(R.id.bt_agenda_fechar)
    public void fechar(){
        finish();
    }
}
