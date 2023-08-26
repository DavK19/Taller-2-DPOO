package restaurante;

import restaurante.Combo;
import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;


public class Producto {
	
	Object base;
	String nombre;
	int precioProducto;
	
	
	public Producto (int tipoProducto) {
		switch (tipoProducto) {
		case 1:
			base = ProductoMenu.class.cast(base);
		case 2:
			base = ProductoAjustado.class.cast(base);
		case 3:
			base = Combo.class.cast(base);
		}	
	}
	
	public int getPrecio() {
		return this.precioProducto;
	}
	
}
