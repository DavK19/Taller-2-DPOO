package restaurante;

import restaurante.ProductoMenu;
import java.util.ArrayList;

public class Combo implements Producto {

	private String nombreCombo;
	private double descuento;
	private int precioBase;
	private Double precioFinal;
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();

	public Combo(String nombre, double descuento) {
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}

	public void agregarItemCombo(ProductoMenu producto) {
		this.itemsCombo.add(producto);
		precioBase = precioBase + producto.getPrecio();
		precioFinal = precioBase * descuento;

	}

	public String getNombre() {
		return this.nombreCombo;
	}

	public int getPrecio() {
		int retorno = this.precioFinal.intValue();
		return retorno;
	}

	public String getFactura() {
		String factura = String.format("%" + "s" + 10 + "d" + "\n", getNombre(), getPrecio());

		return factura;
	}
}
