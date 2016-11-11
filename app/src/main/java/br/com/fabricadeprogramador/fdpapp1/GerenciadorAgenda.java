package br.com.fabricadeprogramador.fdpapp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 08/11/16.
 */

public class GerenciadorAgenda {

    private static List<Pessoa> pessoasList = new ArrayList<>();

    public static void adicionar(Pessoa pessoa){
        pessoasList.add(pessoa);
    }

    public static List<Pessoa> getPessoasList() {
        return pessoasList;
    }
}
