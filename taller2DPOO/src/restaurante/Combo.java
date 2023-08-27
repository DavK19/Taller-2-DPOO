package restaurante;

import restaurante.ProductoMenu;
import java.util.ArrayList;

public class Combo {
	
	private String nombreCombo;
	private double descuento;
	private int precioBase;
	private double precioFinal;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo (String nombre, double descuento) {
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}
	
	public void agregarItemCombo (ProductoMenu producto) {
		this.itemsCombo.add(producto);
		precioBase = precioBase + producto.getPrecio();
		precioFinal = precioBase*descuento;
		
	}
	
	public String getNombre() {
		return this.nombreCombo;
	}
	
	public double getPrecio() {
		return this.precioFinal;
	}
	
	public String generarTextoFactura() {
		return "Factura";
	}
}
