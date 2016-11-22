package br.com.fabricadeprogramador.fdpapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 08/11/16.
 */

public class ListaAgendaActivity extends AppCompatActivity {

    @Bind(R.id.lv_lista_agenda)
    ListView listaAgenda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_agenda_activity);
        ButterKnife.bind(this);

//        atualiza();

        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa pessoaSel = (Pessoa) adapterView.getItemAtPosition(i);
                Intent irParaCadastro = new Intent(ListaAgendaActivity.this, AgendaActivity.class);
                irParaCadastro.putExtra("pessoaSel", pessoaSel);
                startActivity(irParaCadastro);
            }
        });

        listaAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa pessoaSel = (Pessoa) adapterView.getItemAtPosition(i);
                BancoDeDados bancoDeDados = new BancoDeDados(ListaAgendaActivity.this);
                bancoDeDados.excluir(pessoaSel);
                atualiza();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        atualiza();
    }

    public void atualiza(){
        BancoDeDados banco = new BancoDeDados(this);
        PessoaListAdapter adapter = new PessoaListAdapter(this, banco.buscarTodos());
        listaAgenda.setAdapter(adapter);
    }

    @OnClick(R.id.bt_lista_novo)
    public void novo(){
        Intent irParaForm = new Intent(ListaAgendaActivity.this, AgendaActivity.class);
        startActivity(irParaForm);
    }

    @OnClick(R.id.bt_lista_fechar)
    public void fechar(){
        finish();
    }
}
