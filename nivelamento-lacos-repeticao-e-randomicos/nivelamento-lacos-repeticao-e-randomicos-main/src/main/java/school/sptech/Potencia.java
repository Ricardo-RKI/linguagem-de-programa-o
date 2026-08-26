package school.sptech;

public class Potencia {
    public static void main(String[] args) {
        Integer base = 5;
        Integer expoente = 3;
        Integer resultado = 1;

        if (expoente.equals(0)) {
            System.out.printf("%d elevado a %d é igual a %d".formatted(base, expoente, resultado));
        } else if (expoente.equals(1)) {
            resultado = base;
            System.out.printf("%d elevado a %d é igual a %d".formatted(base, expoente, resultado));
        } else {

            for (int i = 0; i < expoente; i++) {
                resultado = resultado * base;

            }

            System.out.printf("%d elevado a %d é igual a %d".formatted(base, expoente, resultado));

        }
    }
}
