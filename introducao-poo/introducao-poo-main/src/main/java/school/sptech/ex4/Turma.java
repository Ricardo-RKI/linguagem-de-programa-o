package school.sptech.ex4;



public class Turma {
    String turma; //(Texto) (ex: "Turma A")
    Integer capacidadeMaxima;// (Número inteiro) (ex: 30)
    Integer quantidadeAlunosMatriculados; //(Número inteiro) (ex: 20)

  void matricularAluno(Integer qtdAlunos) {
      if(qtdAlunos < 0) {

      } else {
          Integer qtdNovosAlunos = quantidadeAlunosMatriculados + qtdAlunos;

          if(qtdNovosAlunos > capacidadeMaxima) {

          } else {
              quantidadeAlunosMatriculados += qtdAlunos;
          }
      }

    }

    Double encontrarMaiorNota (Double[] notas) {
      Double maior = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if(notas[i] > maior) {
                maior = notas[i];
            }
        }
        return maior;
    }
    Double calcularMediaTurma(Double[] notas) {
      Double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma / notas.length;
    }
    Integer contarAprovados(Double[] notas) {
      Integer qtdAprovados = 0;

      for (int i  =0 ; i < notas.length; i++) {
          if(notas[i] >= 6.0){
              qtdAprovados++;
          }
      }

      return qtdAprovados;

    }

    Boolean validarQuantidadeNotas(Double[] notas){
      if(notas.length == quantidadeAlunosMatriculados) {
          return true;
      }
      return false;
    }

    Double encontrarNotaMaisProximaDaMedia(Double[] notas){

        Double media = calcularMediaTurma(notas);
        Double notaMaisProxima = notas[0];
        Double diferencaInicial = media - notas[0];
        Double menorDiferenca = diferencaInicial < 0 ? diferencaInicial * (-1) : diferencaInicial;


     for (int i = 1; i < notas.length; i++) {
        Double diferencaDaVez = media - notas[i];

        diferencaDaVez = diferencaDaVez < 0 ? diferencaDaVez * (-1) : diferencaDaVez;

        if (diferencaDaVez < menorDiferenca){
            menorDiferenca = diferencaDaVez;
            notaMaisProxima = notas[i];
        }

      }

     return notaMaisProxima;

    }
}
