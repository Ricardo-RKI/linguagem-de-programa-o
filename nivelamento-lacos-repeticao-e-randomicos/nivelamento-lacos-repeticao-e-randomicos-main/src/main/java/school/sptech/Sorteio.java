package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Sorteio {
    public static void main(String[] args) {
        Integer numeroeEscolhido = 55;
        Integer numerosPares = 0;
        Integer numerosImpares = 0;

        for(int i = 0; i <= 200; i++){
            Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(1,100);
            
            if (numeroAleatorio.equals(numeroeEscolhido)) {
                System.out.printf("Seu número foi sorteado. A Posição do Sorteio é: %d\n".formatted(i));
                System.out.printf("Foram Sorteados %d Números Pares\n".formatted(numerosPares));
                System.out.printf("Foram Sorteados %d Números Impares\n".formatted(numerosImpares));
                break;
            }

            if (i % 2 == 0) {
                numerosPares++;
            } else {
                numerosImpares++;
            }



        }
    }
}
