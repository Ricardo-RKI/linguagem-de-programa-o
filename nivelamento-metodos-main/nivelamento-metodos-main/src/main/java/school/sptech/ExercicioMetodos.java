package school.sptech;

import java.util.Locale;

public class ExercicioMetodos {
    Boolean verificarMaioridade(Integer idade) {
        if(idade >= 18){
            return true;
        }
        return false;
    }
    Double calcularMedia(Double valor1, Double valor2, Double valor3){
        Double soma = valor1 + valor2 + valor3;
        Double media = soma / 3;

        return media;
    }

    Integer maiorNumero(Integer valor1, Integer valor2, Integer valor3) {
        if (valor1 >= valor2 && valor1 >= valor3) {
            return valor1;
        }
        if (valor2 >= valor1 && valor2 >= valor3) {
            return valor2;
        }
        return valor3;
    }

    Integer calcularFatorial(Integer valor) {
        Integer resultadofatorial = valor;
        if (valor.equals(0)) {
            return resultadofatorial = 1;
        }

        for ( int i = valor - 1; i >= 1; i--) {
            resultadofatorial *= i;
        }
        return resultadofatorial;
    }

    Boolean verificarPrimo(Integer valor){
        Integer quantidadeDeDivisores = 0;

        for (int i = 1; i <= valor; i++) {
            if (valor % i == 0){
                quantidadeDeDivisores++;
            }
        }
        if (quantidadeDeDivisores.equals(2)){
            return true;
        }
        return false;
    }
    Integer calcularPotencia(Integer base, Integer expoente){
        Integer resultado = 1;
        if(expoente.equals(0)) {
            return resultado;
        }

        for( int i = 0; i < expoente; i++) {
            resultado = resultado * base;
        }

        return resultado;

    }
    Integer calcularTrocoEmBalas(Double valorCompra, Double valorRecebido){
        if (valorRecebido < valorCompra) {
            return 0;
        }

        Double troco = valorRecebido - valorCompra;

        Integer qtdbalas = 0;

        if (troco < 0.25) {
            return 0;
        }
        for(Double i = 0.0; i < troco; i+=0.25) {
            qtdbalas++;
        }
        return qtdbalas;

    }

    Boolean verificarPalindromo(String palavra) {
       if (palavra == null) {
           return false;
       }
       String palavrasemespaco = palavra.replaceAll(" ", "");
       int esquerda = 0;
       int direita = palavrasemespaco.length() - 1;

       while(esquerda < direita) {
           if (Character.toLowerCase(palavrasemespaco.charAt(esquerda)) != Character.toLowerCase(palavrasemespaco.charAt(direita))) {
               return false;
           }
           esquerda++;
           direita--;
       }
       return true;

    }
}
