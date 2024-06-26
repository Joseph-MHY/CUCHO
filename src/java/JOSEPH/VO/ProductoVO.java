package JOSEPH.VO;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoVO {
    
    private Integer producto_id;
    private String nombre;
    private CategoriaVO categoria; 
    private BigDecimal precio;
    private Integer stock;
}
