package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Votacao {
    public static void main(String[] args) {
        Integer mussarela = 0;
        Integer calabresa = 0;
        Integer quatroQueijos = 0;
        String mensagemVencedor = "";

        for (int i = 1; i <= 10; i++) {
            Integer votoAleatorio = ThreadLocalRandom.current().nextInt(1,4);
            if (votoAleatorio.equals(1)) {
                mussarela++;
            } else if (votoAleatorio.equals(2)){
                calabresa++;
            } else {
                quatroQueijos++;
            }
        }
        if (calabresa >  mussarela && calabresa > quatroQueijos) {
            mensagemVencedor = "Calabresa foi o Sabor mais votado";
        } else if (mussarela > calabresa && mussarela > quatroQueijos) {
            mensagemVencedor = "Mussarela foi o sabor mais votado";
        } else {
            mensagemVencedor = "Quatro Queijos foi o Sabor mais Votado";
        }

    String mensagemQtdVotos = """ 
            Quantidade de Votos:
            Mussarela: %d
            Calabresa: %d
            Quatro Queijos: %d
            """.formatted(mussarela, calabresa, quatroQueijos);

    System.out.println(mensagemQtdVotos);
    System.out.println(mensagemVencedor);


    }
}
