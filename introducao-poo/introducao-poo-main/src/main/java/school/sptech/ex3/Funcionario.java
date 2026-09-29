package school.sptech.ex3;

public class Funcionario {
    String nome; // (Texto) (ex: William)
    String cargo; //(Texto) //(Ex: Analista Desenvolvedor)
    Double salario; //(Número real) (Ex: 8000.0)

    void reajustarSalario(Integer valorReajuste){

        salario =  salario * (1 +(valorReajuste / 100.0));
    }
    Double calcularValorHora(){
        Double valorHora = salario / 220;
        return valorHora;
    }
    Double calcularHoraExtra(Integer qtdHoras, Integer valorAdicional){
        Double valorHora = calcularValorHora();
        Double valorHoraExtra = valorHora * (1 +(valorAdicional / 100.0));
        return valorHoraExtra * qtdHoras;
    }
    Double calcularBonificacaoAnual(){
        if (salario > 6000.0) {
            return salario * 0.05;
        } else if (salario > 2500.0) {
            return salario * 0.1 ;
        } else {
            return salario * 0.15;
        }
    }
}
