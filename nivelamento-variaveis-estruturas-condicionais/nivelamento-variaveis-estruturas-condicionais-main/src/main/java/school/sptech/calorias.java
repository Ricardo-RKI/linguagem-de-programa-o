package school.sptech;

public class calorias {
    public static void main(String[] args) {
        Integer tempoAquecendo = 15;
        Integer tempoAerobicos = 20;
        Integer tempoMusculacao = 25;

        Integer perdaCalorias = ((tempoAquecendo * 12) + (tempoAerobicos * 20) + (tempoMusculacao * 25));
        Integer minutosExercicios = (tempoAquecendo + tempoAerobicos + tempoMusculacao);

        String mensagemCalorias = ("Olá Jorge. Você fez um total %d minutos de exercícios e perdeu cerca de %d calorias").formatted(minutosExercicios, perdaCalorias);
        System.out.println(mensagemCalorias);
    }

}
