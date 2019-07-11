package ps.isil.demo.repository;

import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Pedido;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, String> {
}
