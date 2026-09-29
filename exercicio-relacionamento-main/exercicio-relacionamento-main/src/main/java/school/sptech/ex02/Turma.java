package school.sptech.ex02;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String nome;

    private List<Aluno> alunos = new ArrayList<>();

    public void matricular(Aluno aluno) {

        if (aluno == null ||
                aluno.getNome() == null ||
                aluno.getNome().isBlank() ||
                aluno.getIdade() == null ||
                aluno.getNotaProva() == null ||
                aluno.getNotaAtividade() == null) {
            return;
        }

        if (aluno.getIdade() < 0) {
            return;
        }

        if (aluno.getNotaProva() < 0.0 || aluno.getNotaProva() > 10.0) {
            return;
        }

        if (aluno.getNotaAtividade() < 0.0 || aluno.getNotaAtividade() > 10.0) {
            return;
        }

        alunos.add(aluno);
    }

    public List<Aluno> buscarPorParteDoNome(String nome) {

        List<Aluno> alunosComParteNoNome = new ArrayList<>();

        if (nome == null) {
            return alunosComParteNoNome;
        }

        nome = nome.toLowerCase();

        for (int i = 0; i < alunos.size(); i++) {

            String nomeAluno = alunos.get(i).getNome().toLowerCase();

            if (nomeAluno.contains(nome)) {
                alunosComParteNoNome.add(alunos.get(i));
            }
        }

        return alunosComParteNoNome;
    }

    public List<Aluno> buscarAprovados(Double notaMinima) {

        List<Aluno> aprovados = new ArrayList<>();

        if (notaMinima == null) {
            return aprovados;
        }

        for (int i = 0; i < alunos.size(); i++) {

            Aluno aluno = alunos.get(i);

            if (aluno.calcularNotaFinal() >= notaMinima) {
                aprovados.add(aluno);
            }
        }

        return aprovados;
    }

    public Double calcularMediaTurma() {

        if (alunos.isEmpty()) {
            return 0.0;
        }

        Double soma = 0.0;

        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).calcularNotaFinal();
        }

        return soma / alunos.size();
    }

    public List<Aluno> buscarAcimaDaMedia() {

        List<Aluno> alunosAcimaDaMedia = new ArrayList<>();

        Double media = calcularMediaTurma();

        for (int i = 0; i < alunos.size(); i++) {

            Aluno aluno = alunos.get(i);

            if (aluno.calcularNotaFinal() > media) {
                alunosAcimaDaMedia.add(aluno);
            }
        }

        return alunosAcimaDaMedia;
    }

    public Aluno buscarMenorNota() {

        if (alunos.isEmpty()) {
            return null;
        }

        Aluno menor = alunos.get(0);

        for (int i = 1; i < alunos.size(); i++) {

            Aluno aluno = alunos.get(i);

            if (aluno.calcularNotaFinal() < menor.calcularNotaFinal()) {
                menor = aluno;
            }
        }

        return menor;
    }

    public Double calcularIdadeMedia() {

        if (alunos.isEmpty()) {
            return 0.0;
        }

        Double soma = 0.0;

        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).getIdade();
        }

        return soma / alunos.size();
    }

    public Double calcularAmplitudeNotas() {

        if (alunos.isEmpty()) {
            return 0.0;
        }

        Double maior = alunos.get(0).calcularNotaFinal();
        Double menor = alunos.get(0).calcularNotaFinal();

        for (int i = 1; i < alunos.size(); i++) {

            Double nota = alunos.get(i).calcularNotaFinal();

            if (nota > maior) {
                maior = nota;
            }

            if (nota < menor) {
                menor = nota;
            }
        }

        return maior - menor;
    }

    public List<Aluno> encontrarAlunosComMesmaNota() {

        List<Aluno> alunosComMesmaNota = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {

            for (int j = i + 1; j < alunos.size(); j++) {

                Double nota1 = alunos.get(i).calcularNotaFinal();
                Double nota2 = alunos.get(j).calcularNotaFinal();

                if (nota1.equals(nota2)) {

                    if (!alunosComMesmaNota.contains(alunos.get(i))) {
                        alunosComMesmaNota.add(alunos.get(i));
                    }

                    if (!alunosComMesmaNota.contains(alunos.get(j))) {
                        alunosComMesmaNota.add(alunos.get(j));
                    }
                }
            }
        }

        return alunosComMesmaNota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}