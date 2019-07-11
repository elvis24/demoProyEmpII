package ps.isil.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    private Integer idProducto;
    private String descripcion;
    private String precio;
    private Integer stock;
    private String categoria;

}
