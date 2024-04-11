package JOSEPH.VO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteVO {
    
    private Integer cliente_id;
    private String nombre;
    private String direccion;
    private String telefono;
}
