package ps.isil.demo.repository;


import org.springframework.stereotype.Repository;
import ps.isil.demo.model.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Integer> {

}
