package school.sptech.ex01;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Carrinho {
    private String cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Integer getQuantidade() {
        return produtos.size();
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public Boolean existsPorNome(String nome) {
        if (nome == null) {
            return false;
        }
        nome = nome.toLowerCase();
        for (int i = 0; i < produtos.size(); i++) {
            String nomeMinusculo = produtos.get(i).getNome().toLowerCase();
            if (nome.equals(nomeMinusculo)) {
                return true;
            }

        }
        return false;
    }

    public Integer getQuantidadePorCategoria(String nome) {
        Integer contador = 0;
        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).getCategoria().equals(nome)) {
                contador++;
            }
        }
        return contador;
    }

    public void limpar() {
        produtos.removeAll(produtos);
    }

    public void removerPorNome(String nome) {
        if (nome == null) {
            return;
        }
        nome = nome.toLowerCase();
        for (int i = 0; i < produtos.size(); i++) {
            String nomeMinusculo = produtos.get(i).getNome().toLowerCase();
            if (nome.equals(nomeMinusculo)) {
                produtos.remove(i);
            }

        }
    }

    public Produto getPorNome(String nome) {
        if (nome == null) {
            return null;
        }
        nome = nome.toLowerCase();
        for (int i = 0; i < produtos.size(); i++) {
            String nomeMinusculo = produtos.get(i).getNome().toLowerCase();
            if (nome.equals(nomeMinusculo)) {
                return produtos.get(i);
            }

        }
        return null;

    }

    public Double getValorTotal(){
        Double soma = 0.0;
        for (int i = 0; i < produtos.size(); i++) {
            soma += produtos.get(i).getPreco();

        }
        return soma;
    }



}


