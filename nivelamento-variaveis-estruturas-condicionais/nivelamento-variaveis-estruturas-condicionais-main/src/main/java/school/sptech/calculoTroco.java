package school.sptech;

public class calculoTroco {
    public static void main(String[] args) {
        Double valorProduto = 20.00;
        Integer qtdVendida = 3;
        Double valorPago = 80.00;

        Double troco = (valorPago - (valorProduto * qtdVendida));

        String mensagemTroco = "Seu troco será de R$ %.2f, onde %.2f é o valor a ser devolvido ao cliente".formatted(troco, troco);
        System.out.println(mensagemTroco);
    }
}
