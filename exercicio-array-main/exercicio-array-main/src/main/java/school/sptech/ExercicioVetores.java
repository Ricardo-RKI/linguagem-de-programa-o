package school.sptech;

public class ExercicioVetores {
    Integer somar(Integer[] vetor) {
        Integer soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }
    Double calcularMedia(Double[] notas){
        Double soma = 0.0;
        if (notas == null) {
            return 0.0;
        }
        for(int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        Double media = soma / notas.length;

        return media;
    }

    Integer buscarMaiorNumero(Integer[] vetor) {
        Integer maior = vetor[0];
        for(int i = 0; i < vetor.length; i++) {
            if (vetor[i] > vetor[0] ) {
                maior = vetor[i];
            }
        }
        return maior;
    }
    Integer calcularDecimal(Integer[] binario){
        Integer expoente = binario.length - 1;
        Integer resultado = 0;

        for (int i = 0; i < binario.length; i++) {
            if (binario[i] == 1) {
                resultado += ((int)Math.pow(2.0, expoente));
               expoente--;
            } else {
                expoente--;
            }
        }
        return resultado;
    }

    Character[] inverter(Character[] vetor){

        if (vetor == null) {
            return null;
        }

        Character[] vetorInvertido = new Character[vetor.length];

        for(int i = 0;  i < vetor.length; i++) {

                vetorInvertido[i] = vetor[vetor.length - 1 - i];

        }
        return vetorInvertido;
    }

    Integer[] mesclar(Integer[] vetor1, Integer[] vetor2){
        Integer[] vetormesclado = new Integer[vetor1.length + vetor2.length];
        int i = 0;
        int j = 0;

        for(int k = 0; k < vetormesclado.length; k++) {
        if(i >= vetor1.length){
            vetormesclado[k] = vetor2[j++];
        }
        else if (j >= vetor2.length){
            vetormesclado[k] = vetor1[i++];
        }

        else if (vetor1[i] != null && (vetor2[j] == null || vetor1[i] <= vetor2[j])) {
            vetormesclado[k] = vetor1[i++];
        } else {
            vetormesclado[k] = vetor2[j++];
        }

        }

        return vetormesclado;
    }

Integer[] somarDois(Integer[] vetor, Integer alvo) {
    for (int i = 0; i < vetor.length; i++) {
        for (int j = i + 1; j < vetor.length; j++) {
            if (vetor[i] + vetor[j] == alvo) {
                return new Integer[]{i, j};
            }
        }
    }
    return null;
}
}