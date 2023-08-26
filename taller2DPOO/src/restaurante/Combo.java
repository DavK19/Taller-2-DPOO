package restaurante;

import restaurante.ProductoMenu;
import java.util.ArrayList;

public class Combo {
	
	private String nombreCombo;
	private double descuento;
	private int precio;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo (String nombre, double descuento) {
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}
	
	public void agregarItemCombo (ProductoMenu producto) {
		this.itemsCombo.add(producto);
	}
	
	public String getNombre() {
		return this.nombreCombo;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public String generarTextoFactura() {
		return "Factura";
	}
}
