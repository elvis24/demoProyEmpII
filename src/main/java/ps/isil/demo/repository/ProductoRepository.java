package ps.isil.demo.repository;

import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Producto;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Integer>{
}
