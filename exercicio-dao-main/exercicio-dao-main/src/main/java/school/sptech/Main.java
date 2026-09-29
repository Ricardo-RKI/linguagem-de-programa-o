package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

  public static void main(String[] args) {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate template  = new JdbcTemplate(conexao.getBasicDataSource());
  }
}