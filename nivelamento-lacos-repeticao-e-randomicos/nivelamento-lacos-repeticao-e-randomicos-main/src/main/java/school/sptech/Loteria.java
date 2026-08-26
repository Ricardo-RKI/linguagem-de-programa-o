package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Loteria {

  public static void main(String[] args) {
    Integer numero = 7;
    Integer qtdVezesNumeroSorte = 0;

    for (int i = 0; i < 10; i++) {
      Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0,11);
      System.out.println("Número Sorteado: " + numeroAleatorio);
      qtdVezesNumeroSorte++;

      if (numero.equals(numeroAleatorio)) {
        break;
      } else {
        i--;
      }

    }

    if (qtdVezesNumeroSorte <= 3) {
      System.out.println("Você é MUITO sortudo");
    } else if (qtdVezesNumeroSorte <= 10) {
      System.out.println("Você é Sortudo");
    } else {
      System.out.println("É melhor Você parar de apostar e ir trabalhar");
    }



  }
}