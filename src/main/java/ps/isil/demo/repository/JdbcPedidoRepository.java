package ps.isil.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Pedido;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcPedidoRepository implements PedidoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Pedido pedido) {
        final String sql = "insert into pedido(codigoPedido, fecha, estado, nombrePedido) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pedido.getCodigoPedido(), pedido.getFecha(), pedido.getEstado(), pedido.getNombrePedido());


    }

    @Override
    public void update(Pedido pedido) {
        final String sql = "update pedido set fecha = ?, estado = ?, nombrePedido = ? where codigoPedido = ?";
        jdbcTemplate.update(sql, pedido.getCodigoPedido(), pedido.getFecha(), pedido.getEstado(), pedido.getNombrePedido());

    }

    @Override
    public void delete(String codigoPedido) {
        final String sql = "delete product where codigoPedido = ?";
        jdbcTemplate.update(sql, codigoPedido);

    }

    @Override
    public List<Pedido> findAll() {
        final String sql= "select * from pedido";
        return jdbcTemplate.query(sql, JdbcPedidoRepository::PedidoRowMapper);
    }

    @Override
    public Pedido findById(String codigoPedido) {
        final String sql ="select * from pedido where codigoPedido = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{codigoPedido}, JdbcPedidoRepository::PedidoRowMapper);
    }
    private static Pedido PedidoRowMapper(ResultSet resultSet, int i) throws SQLException{
        String  rsCodigoPedido = resultSet.getString("codigoPedido");
        Date    feha =resultSet.getDate("fecha");
        String  estado=resultSet.getString("estado");
        String  nombrePedido=resultSet.getString("nombrePedido");
        return new Pedido(rsCodigoPedido,feha,estado,nombrePedido);
    }
}
