package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
        Integer soma = 0;

        for (int i = 0; i < 10; i++) {
            Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(11);
            System.out.println("O Número Aleatório é: " + numeroAleatorio);
            if (numeroAleatorio.equals(0)) {
                break;
            } else {
                soma+=numeroAleatorio;
                i--;
            }
        }
        System.out.printf("A Soma dos Números é %d".formatted(soma));
    }
}
