package br.com.fabricadeprogramador.fdpapp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 08/11/16.
 */

public class GerenciadorAgenda {

    private static List<String> nomes = new ArrayList<>();

    public static void adicionar(String nome){
        nomes.add(nome);
    }

    public static List<String> getNomes() {
        return nomes;
    }

}
