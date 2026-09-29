package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class MusicaDao {

    private final JdbcTemplate jdbcTemplate;

    public MusicaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Musica> findAll() {
        return jdbcTemplate.query("SELECT * FROM musica", new BeanPropertyRowMapper<>(Musica.class));
    }

    public Musica findById(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM musica WHERE id = ?",
                    new BeanPropertyRowMapper<>(Musica.class),
                    id
            );
        } catch (Exception erro) {
            return null;
        }
    }

    public List<Musica> findByNomeLike(String nome) {
        if (nome == null || nome.isBlank()) {
            return new ArrayList<>();
        }
        try {
            String sql = "SELECT * FROM musica WHERE LOWER(nome) LIKE LOWER(?)";
            String buscaLike = "%" + nome + "%";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class), buscaLike);
        } catch (Exception erro) {
            return new ArrayList<>();
        }
    }

    public List<Musica> findByArtista(String artista) {
        if (artista == null || artista.isBlank()) {
            return new ArrayList<>();
        }
        try {
            String sql = "SELECT * FROM musica WHERE LOWER(artista) LIKE LOWER(?)";
            String buscaLike = "%" + artista + "%";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class), buscaLike);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Musica> findByAlbum(String album) {
        if (album == null || album.isBlank()) {
            return new ArrayList<>();
        }
        try {
            String sql = "SELECT * FROM musica WHERE LOWER(album) LIKE LOWER(?)";
            String buscaLike = "%" + album + "%";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class), buscaLike);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Musica> findByDuracaoGreaterThan(Integer duracao) {
        if (duracao == null) {
            return new ArrayList<>();
        }
        try {
            String sql = "SELECT * FROM musica WHERE duracao > ?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class), duracao);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Musica> findByAlbumAndNomeLike(String album, String nome) {
        if (album == null || album.isBlank() || nome == null || nome.isBlank()) {
            return new ArrayList<>();
        }
        try {
            String sql = "SELECT * FROM musica WHERE LOWER(nome) LIKE LOWER(?) AND LOWER(album) LIKE LOWER(?)";
            String nomeLike = "%" + nome + "%";
            String albumLike = "%" + album + "%";

            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class), nomeLike, albumLike);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void save(Musica musica) {
        if (musica == null) {
            return;
        }

        if (musica.getId() == null) {
            String sqlInsert = "INSERT INTO musica (nome, artista, album, duracao) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsert, musica.getNome(), musica.getArtista(), musica.getAlbum(), musica.getDuracao());
        } else {
            String sqlUpdate = "UPDATE musica SET nome = ?, artista = ?, album = ?, duracao = ? WHERE id = ?";
            jdbcTemplate.update(sqlUpdate, musica.getNome(), musica.getArtista(), musica.getAlbum(), musica.getDuracao(), musica.getId());
        }
    }

    public void deleteById(Integer id) {
        if (id == null) {
            return;
        }
        String sql = "DELETE FROM musica WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
