package restaurante;

import restaurante.ProductoMenu;
import restaurante.Ingrediente;

import java.util.ArrayList;

public class ProductoAjustado {
	private ProductoMenu base;
	private String nombre;
	private int precioBase;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado (ProductoMenu productoBase) {
		this.base = productoBase;
		this.nombre = productoBase.getNombre();
		this.precioBase = productoBase.getPrecio();
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getPrecio() {
		return this.precioBase;
	}
	
	public String generarTextoFactura() {
		return "Factura";
	}
	
	public void agregarIngrediente (Ingrediente agregado) {
		this.agregados.add(agregado);
	}
	
	public void eliminarIngredientes(Ingrediente eliminar) {
		this.eliminados.add(eliminar);
	}
}
