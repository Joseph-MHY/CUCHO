package JOSEPH.VO;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoVO {
    
    private Integer empleado_id;
    private String nombre;
    private String cargo;
    private String telefono;
    private BigDecimal salario;
}
