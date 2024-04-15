package JOSEPH.VO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaVO {
    private int cliente_id;
    private int empleado_id;
    private List<DetallesVentaVO> DetalleVenta;
}
