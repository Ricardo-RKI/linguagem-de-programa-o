package school.sptech.ex2;

public class Encomenda {
    String tamanho;// (Texto) (ex: "P", "M", "G")
    String enderecoRemetente; // (Texto) (Ex: Rua Santos da Glória, 18)
    String enderecoDestinatario; //(Texto) (Ex: Av Dr. Pedro, 255)
    Double distancia; //(Número real)// (ex: 42.2)
    Double valorProduto; //(Número real)// (ex: 87.50)

    Double calcularFrete() {
        Double freteTamanho = 0.0;
        Double freteDistancia = 0.0;

        if (tamanho.equals("P")) {
            freteTamanho = valorProduto * 0.01;
        }
        if (tamanho.equals("M")) {
            freteTamanho = valorProduto * 0.03;
        }
        if (tamanho.equals("G")) {
            freteTamanho = valorProduto * 0.05;
        }

        if (distancia > 200) {
            freteDistancia = 7.0;
        } else if (distancia > 50) {
            freteDistancia = 5.0;
        } else {
            freteDistancia = 3.0;
        }

        return  freteTamanho + freteDistancia;
    }

    void aplicarCupomDeDesconto(Integer porcentagem) {
        valorProduto = valorProduto * (1 - (porcentagem/100.0));

    }
    Double valorTotalDaEncomenda(){
        Double frete = calcularFrete();
        return valorProduto + frete;
    }
}
