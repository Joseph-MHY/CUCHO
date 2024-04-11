package JOSEPH.VO;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaVO {
    
    private Integer venta_id;
    private ClienteVO cliente;
    private EmpleadoVO empleado;
    private Date fecha_venta;
    private BigDecimal total;
}
