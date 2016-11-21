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

        Intent intent = getIntent();
        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");
        pessoa.setImagem(R.drawable.imagem1);
//        GerenciadorAgenda.adicionar(pessoa);

        BancoDeDados banco = new BancoDeDados(this);
        banco.salvar(pessoa);

        PessoaListAdapter adapter = new PessoaListAdapter(this, banco.buscarTodos());

        //ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, GerenciadorAgenda.getPessoasList());

        listaAgenda.setAdapter(adapter);

    }

    @OnClick(R.id.bt_lista_fechar)
    public void fechar(){
        finish();
    }
}
