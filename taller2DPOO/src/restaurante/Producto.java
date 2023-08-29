package restaurante;

import java.util.ArrayList;


import restaurante.Combo;
import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;


public class Producto {
	
	private ArrayList<Combo> combos = new ArrayList<Combo>();
	private ArrayList<ProductoMenu> productosBase = new ArrayList<ProductoMenu>();
	private ArrayList <ProductoAjustado> productosAjustados = new ArrayList <ProductoAjustado>();
	private int precio = 0;
	
	public void agregarProductoMenu (ProductoMenu producto) {
		productosBase.add(producto);
		precio = precio + producto.getPrecio();
	}
	
	public void agregarProductoAjustado (ProductoAjustado producto) {
		productosAjustados.add(producto);
		precio = precio + producto.getPrecio();
	}
	
	public void agregarCombo (Combo producto) {
		combos.add(producto);
		precio = precio + producto.getPrecio();
	}
	
	public int getPrecio() {
		int total = 0;
		
		if (combos.size() > 0) {
			for (Combo combo: combos) {
				total = total + combo.getPrecio();
			}
		}
		
		if (productosBase.size() > 0) {
			for (ProductoMenu producto: productosBase) {
				total = total + producto.getPrecio();
			}
		}
		
		if (productosAjustados.size() > 0) {
			for (ProductoAjustado producto: productosAjustados) {
				total = total + producto.getPrecio();
			}
		}
		
		return total;
	}
	
	public String generarTextoFactura() {
		return "Factura";
	}
	
}
