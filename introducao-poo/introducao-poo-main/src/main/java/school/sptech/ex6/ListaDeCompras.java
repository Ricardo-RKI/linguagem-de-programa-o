package school.sptech.ex6;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    String nomeLista;
    Integer capacidadeMaxima;
    List<String> itens = new ArrayList<>();

    void adicionarItem(String item) {
        if (itens.size() >= capacidadeMaxima) {
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            if(itens.get(i).equals(item)){
                return;
            }
        }

        itens.add(item);
    }
    Boolean removerItem(String item){
        for (int i  = 0; i < itens.size(); i++ ) {
            if(itens.get(i).equals(item)){
                itens.remove(item);
                return true;
            }
        }
        return false;
    }

    String obterItem(Integer posicao){
        if (posicao < 0 || posicao >= itens.size()){
            return null;
        }
        return itens.get(posicao);
    }
    Boolean substituirItem(Integer posicao, String novoItem){
        if (posicao < 0 || posicao >= itens.size()){
            return false;
        }
        for (int i  = 0; i < itens.size(); i++ ) {
            if(itens.get(i).equals(novoItem)){

                return false;
            }
        }
        itens.set(posicao, novoItem);
        return true;
    }
    Integer calcularVagasRestantes(){
        return capacidadeMaxima - itens.size();
    }
    String removerItemNaPosicao(Integer posicao) {
        if (posicao < 0 || posicao >= itens.size()) {
            return null;
        }

        String itemRemovido = itens.get(posicao);

        itens.remove((int) posicao);

        return itemRemovido;
    }

    Integer removerItensDuplicados(){
        Integer qtdRemovidos = 0;
        for (int i  = 0; i < itens.size(); i++) {
            for (int j = i + 1; j < itens.size(); j++) {
                if(itens.get(i).equals(itens.get(j))) {
                    itens.remove(j);
                    qtdRemovidos++;
                    j--;
                }

            }
        }
        return qtdRemovidos;
    }
}