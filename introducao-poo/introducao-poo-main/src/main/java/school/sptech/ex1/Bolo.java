package school.sptech.ex1;

public class Bolo {
    String sabor;
    Double valor;
    Integer quantidadeVendida;
    Integer quantidadeEmEstoque;

    void venderBolo(Integer boloVendido) {
        if (boloVendido > quantidadeEmEstoque){
            System.out.println("Bolo vendido ultrapassa a quantiade de estoque");
            return;
        }
        if (boloVendido < 0) {
            System.out.println("Quantidade Inválida de Bolos");
            return;
        }

        quantidadeEmEstoque -= boloVendido;
        quantidadeVendida += boloVendido;
        System.out.println("Bolos Vendidos com Sucesso");
        return;
    }

    Boolean aumentarEstoque (Integer boloRestoque){
       if(boloRestoque < 0) {
           System.out.println("Quantidade Invalida");
           return  false;
       }
       quantidadeEmEstoque += boloRestoque;
       return true;
    }
    Integer quantidadeDisponivel(){

        return quantidadeEmEstoque;
    }
    Double totalVendido() {

        return quantidadeVendida * valor;
    }
}
