package school.sptech;

public class calculoRenda {

  public static void main(String[] args) {
  Integer filhos0a3Anos = 2;
  Integer filhos4a16Anos = 4;
  Integer filhos17a18Anos = 1;

  Double totalBolsa = ((filhos0a3Anos * 25.12) + (filhos4a16Anos * 15.88) + (filhos17a18Anos * 12.44));
  Integer totalFilhos = (filhos0a3Anos + filhos4a16Anos + filhos17a18Anos);

  String mensagem = (" Você tem um total de %d filhos e " +
          "vai receber %.2f de valor de bolsa").formatted(totalFilhos, totalBolsa);
    System.out.println(mensagem);
  }
}