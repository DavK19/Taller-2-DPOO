package restaurante;

import restaurante.ProductoMenu;
import restaurante.Ingrediente;

import java.util.ArrayList;

public class ProductoAjustado {
	private ProductoMenu base;
	private String nombre;
	private int precio;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado (ProductoMenu productoBase) {
		this.base = productoBase;
		this.nombre = productoBase.getNombre();
		this.precio = productoBase.getPrecio();
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public String generarTextoFactura() {
		return "Factura";
	}
	
	public void agregarIngrediente (Ingrediente agregado) {
		this.agregados.add(agregado);
		precio = precio + agregado.getCosto();
	}
	
	public void eliminarIngredientes(Ingrediente eliminar) {
		
		precio = precio - eliminar.getCosto();
		
		if (agregados.contains(eliminar)) {
			agregados.remove(eliminar);
		}else {
			this.eliminados.add(eliminar);
		}
		
	}
}
