package ps.isil.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcClienteRepository implements ClienteRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Cliente cliente) {
        final String sql ="insert into cliente(idCliente, nombre, apellido, direccion, telefono) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(),cliente.getTelefono());

    }

    @Override
    public void update(Cliente cliente) {
        final String sql ="update cliente set nombre =?, apellido= ?, direccion=?, telefono=? where idCliente= ?";
        jdbcTemplate.update(sql, cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(),cliente.getTelefono());

    }

    @Override
    public void delete(Integer idCliente) {
        final String sql="delete cliente where idCliente=?";
        jdbcTemplate.update(sql, idCliente);

    }

    @Override
    public List<Cliente> findAll() {
        final String sql="select * from cliente";
        return jdbcTemplate.query(sql, JdbcClienteRepository::ProductRowMapper);
    }

    @Override
    public Cliente findById(Integer idCliente) {
        final String sql ="select * from cliente where idCliente= ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idCliente}, JdbcClienteRepository::ProductRowMapper);
    }

    private static Cliente ProductRowMapper(ResultSet resultSet, int i) throws SQLException {
        Integer  rsIdCLiente = resultSet.getInt("idCliente");
        String  nombre   = resultSet.getString("nombre");
        String apellido  = resultSet.getString("apellido");
        String  direccion  = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");
        return new Cliente(rsIdCLiente,nombre,apellido,direccion, telefono);

    }
}
