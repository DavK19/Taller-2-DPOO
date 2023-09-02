package restaurante;

import java.util.ArrayList;

import restaurante.Combo;
import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;

public interface Producto {

	public abstract int getPrecio();

	public abstract String getNombre();

	public abstract String getFactura();
}
