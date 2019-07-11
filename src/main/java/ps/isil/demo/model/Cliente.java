package ps.isil.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;



}
