package JOSEPH.CLASES;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private int cliente_id;
    private int empleado_id;
    private List<DetalleVenta> DetalleVenta;
}
