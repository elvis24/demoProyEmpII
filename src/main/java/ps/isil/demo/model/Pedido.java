package ps.isil.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
    private String  codigoPedido;
    private Date    fecha;
    private String  estado;
    private String  nombrePedido;
}
