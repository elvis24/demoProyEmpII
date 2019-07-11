package ps.isil.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductoRepository implements ProductoRepository {


    @Autowired
     JdbcTemplate jdbcTemplate;

    @Override
    public void create(Producto producto) {
        final String sql="insert into producto(idProducto,descripcion,precio,stock,categoria) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getIdProducto(),producto.getDescripcion(), producto.getPrecio(), producto.getStock(), producto.getCategoria());

    }

    @Override
    public void update(Producto producto) {
        final String sql="update producto set descripcion = ?, precio=?, stock=?, categoria=? where idProducto =?";
        jdbcTemplate.update(sql, producto.getIdProducto(),producto.getDescripcion(), producto.getPrecio(), producto.getStock(), producto.getCategoria());


    }

    @Override
    public void delete(Integer idProducto) {
        final String sql = "delete producto where idProducto =?";
        jdbcTemplate.update(sql, idProducto);

    }

    @Override
    public List<Producto> findAll() {
        final String sql = "select * from producto";
        return jdbcTemplate.query(sql, JdbcProductoRepository::ProductoRowMapper);
    }

    @Override
    public Producto findById(Integer idProducto) {
        final String sql="select * from producto where idProducto=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idProducto}, JdbcProductoRepository::ProductoRowMapper);
    }

    private static Producto ProductoRowMapper(ResultSet resultSet, int i) throws SQLException{
        Integer rsIdProducto = resultSet.getInt("idProducto");
        String descripcion = resultSet.getString("descripcion");
        String precio = resultSet.getString("precio");
        Integer stock = resultSet.getInt("stock");
        String categoria = resultSet.getString("categoria");
        return new Producto(rsIdProducto,descripcion,precio,stock,categoria);
    }
}
