package JOSEPH.VO;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallesVentaVO {
    
    private Integer detalle_id;
    private VentaVO venta;
    private ProductoVO producto;
    private Integer cantidad;
    private BigDecimal subtotal;
}
