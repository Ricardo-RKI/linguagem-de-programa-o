package school.sptech;

public class calculoMedia {
    public static void main(String[] args) {
        String nome = "Ricardo";
        Double nota1 = 9.5;
        Double nota2 = 9.0;

        Double media = ((nota1 + nota2)/ 2);

        String mensagemMedia = "Olá %s. Sua media é %.2f".formatted(nome, media);
        System.out.println(mensagemMedia);
    }
}
