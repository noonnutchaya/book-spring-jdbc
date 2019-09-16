package th.ku.bookstore;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImp implements BookDao {
    private JdbcTemplate jdbcTemplate;

    public BookDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book) {
        String query = "INSERT INTO book (id, name, price) VALUES (?, ?, ?);";
        Object[] data = new Object[]
                {book.getId(), book.getName(), book.getPrice()};
        jdbcTemplate.update(query, data);
    }

    public void update(int id, Book book) {
        String query = "UPDATE book SET name = ?, price = ? WHERE id = ?;";
        jdbcTemplate.update(query, new Object[]{book.getName(), book.getPrice(), id});
    }

    public void deleteById(int id) {
        String query = "DELETE FROM book WHERE id = " + id;
        jdbcTemplate.update(query);
    }

    public Book findById(int id) {
        String query = "SELECT * FROM book WHERE id = " + id;
        Book book = jdbcTemplate.queryForObject(query, new BookRowMapper());
        return book;
    }

    public List<Book> findAll() {
        String query = "SELECT * FROM book";
        List<Book> books = jdbcTemplate.query(query, new BookRowMapper());
        return books;

    }

    class BookRowMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book(rs.getString("name"), rs.getInt("price"), rs.getInt("id"));
            return book;
        }
    }


}
