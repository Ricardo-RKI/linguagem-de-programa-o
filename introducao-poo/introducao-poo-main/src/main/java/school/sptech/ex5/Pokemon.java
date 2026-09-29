package school.sptech.ex5;

public class Pokemon {
    String nome; // (Texto) (ex: "Pikachu")
    String tipo; // (Texto) (ex: "Fogo", "Água", "Planta"...)
    Integer vida; // (Número inteiro) (ex: 100)
    Integer ataque; //(Número inteiro) (ex: 50)
    Integer experiencia; //(Número inteiro) (ex: 0)

    void receberAtaque(Integer qtdDano){

        if (qtdDano< 0) {
           return;
        }

        vida -= qtdDano;

        if(vida < 0){
            vida = 0;
        }
    }

    void recuperarVida(Integer qtdVidaRecuperada){
        if(qtdVidaRecuperada < 0) {
            return;
        }

        vida += qtdVidaRecuperada;

        if (vida > 100) {
            vida = 100;
        }

    }

    void ganharExperiencia(Integer qtdExp){
        if(qtdExp < 0) {

        } else {
            experiencia += qtdExp;
        }
    }

    Integer calcularNivel() {
        Integer nivel = 0;
        while (experiencia >= 100) {
            experiencia -=100;
            nivel++;
        }
        return nivel;

    }

    Integer calcularPoderDeCombate() {
        Integer nivel = calcularNivel();
        return ataque + (nivel * 10) + vida;
    }

    void batalhar(Integer[] ataques, Integer curas[]) {
        Integer curaRodadas = 0;

        for (int i = 0; i < ataques.length; i++) {

            if(vida > 0){
                receberAtaque(ataques[i]);
                recuperarVida(curas[curaRodadas]);
                curaRodadas++;
            } else {
                return;
            }

        }

    }
}
