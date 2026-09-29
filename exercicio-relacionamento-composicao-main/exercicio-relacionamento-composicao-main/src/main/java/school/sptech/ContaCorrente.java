package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
    private String titular;
    private String agencia;
    private String numero;
    private List<Operacao> operacoes = new ArrayList<>();

    public void adicionarOperacao(String categoria, String descricao, Double valor){
        if(categoria == null || descricao== null || valor == null){
            return;
        }
        if(valor <= 0 || descricao.isBlank()){
            return;
        }

        Operacao novaOperacao = new Operacao(categoria, descricao, valor);

        operacoes.add(novaOperacao);
    }

    public Double obterSaldo(){
        Double somaSaldo = 0.0;

        if(operacoes.size() == 0 || operacoes.size() == -1){
            return 0.0;
        }

        for (int i = 0; i < operacoes.size(); i++) {
            somaSaldo += operacoes.get(i).getValor();
        }

        return somaSaldo;


    }

    public List<Operacao> buscarOperacoesPorCategoria(String categoria){
        if(categoria == null){
            return new ArrayList<>();
        }
        String categoriaMinuscula = categoria.toLowerCase();
        List<Operacao> operacoesEncontradas = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            if(operacoes.get(i).getCategoria().toLowerCase().equals(categoriaMinuscula)){
                operacoesEncontradas.add(operacoes.get(i));
            }
        }
        return operacoesEncontradas;
    }
    public List<Operacao> buscarOperacoesPorValor(Double valor){
        if(valor == null){
            return new ArrayList<>();
        }

        List<Operacao> operacoesEncontradas = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            if(operacoes.get(i).getValor().equals(valor)){
                operacoesEncontradas.add(operacoes.get(i));
            }
        }
        return operacoesEncontradas;
    }

    public List<Operacao> buscarOperacoesSaida(){

        List<Operacao> operacoesEncontradas = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            if(operacoes.get(i).getValor() < 0){
                operacoesEncontradas.add(operacoes.get(i));
            }
        }
        return operacoesEncontradas;
    }

    public List<Operacao> buscarOperacoesPorDescricao(String descricao){
        if(descricao == null){
            return new ArrayList<>();
        }
        String descricaoMinuscula = descricao.toLowerCase();
        List<Operacao> operacoesEncontradas = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            if(operacoes.get(i).getDescricao().toLowerCase().contains(descricaoMinuscula)){
                operacoesEncontradas.add(operacoes.get(i));
            }
        }
        return operacoesEncontradas;
    }

    public Double buscarMenorValor(){
        if(operacoes.size() == 0 || operacoes.size() == -1){
            return 0.0;
        }
        Double menorValor = operacoes.get(0).getValor();

        for (int i = 1; i < operacoes.size(); i++) {
            if(operacoes.get(i).getValor() < menorValor){
                menorValor = operacoes.get(i).getValor();
            }
        }
        return menorValor;
    }

    public Double obterSaldoPorCategoria(String categoria) {
        if(categoria == null || categoria.isBlank()){
            return 0.0;
        }
        Double saldoCategoria = 0.0;
        String categoriaMinuscula = categoria.toLowerCase();

        for (int i = 0; i < operacoes.size(); i++) {
            if (operacoes.get(i).getCategoria().toLowerCase().equals(categoriaMinuscula)){
                saldoCategoria += operacoes.get(i).getValor();
            }
        }
        return saldoCategoria;
    }
    public String buscarCategoriaComMaiorGasto(){
        if (operacoes == null || operacoes.isEmpty()) {
            return null;
        }

        String categoriaMaiorGasto = null;
        List<String> categoria = new ArrayList<>();
        List<Double> saldoCategoria = new ArrayList<>();

        Integer indiceMaiorGasto = 0;

        for (int i = 0; i < operacoes.size(); i++) {
            String catAtual = operacoes.get(i).getCategoria();

            if (!categoria.contains(catAtual)) {
                categoria.add(catAtual);
                saldoCategoria.add(obterSaldoPorCategoria(catAtual));
            }
        }

        Double menorSaldo = saldoCategoria.get(0);
        for (int i = 1; i < categoria.size(); i++) {

            if(saldoCategoria.get(i) < menorSaldo){
                menorSaldo = saldoCategoria.get(i);
                indiceMaiorGasto = i;
            }
        }
        if (menorSaldo >= 0){
            return null;
        }

        categoriaMaiorGasto = categoria.get(indiceMaiorGasto);
        return categoriaMaiorGasto;
    }

    public List<Operacao> buscarOperacoesDuplicadas(){
        List<Operacao> operacoesDuplicadas = new ArrayList<>();

        for (int i = 0; i < operacoes.size(); i++){
            for (int j = 0; j < operacoes.size(); j++){
                if(operacoes.get(i).getCategoria().toLowerCase().equals(operacoes.get(j).getCategoria().toLowerCase()) &&
                operacoes.get(i).getDescricao().toLowerCase().equals(operacoes.get(j).getDescricao().toLowerCase())
                && operacoes.get(i).getValor().equals(operacoes.get(j).getValor()) ){
                 if(i != j){
                     operacoesDuplicadas.add(operacoes.get(i));
                     break;
                 }
                }
            }
        }
        return operacoesDuplicadas;
    }






    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }


}
