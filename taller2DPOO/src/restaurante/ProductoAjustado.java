package restaurante;

import restaurante.ProductoMenu;
import restaurante.Ingrediente;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ProductoMenu base;
	private String nombre;
	private int precio;
	private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();

	public ProductoAjustado(ProductoMenu productoBase) {
		this.base = productoBase;
		this.nombre = base.getNombre();
		this.precio = base.getPrecio();
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public String getFactura() {
		int L;
		String precioString = String.valueOf(getPrecio());
		
		L = 60 - (getNombre().length() + precioString.length());
		

		String nombreFinal = getNombre() + ".".repeat(L) + precioString + "\n";

		if (agregados.size() > 0) {
			nombreFinal = nombreFinal + "\t"+ "con adicion de" + "\n";
			for (Ingrediente agregado : agregados) {
				nombreFinal = nombreFinal + "\t\t-" + agregado.getNombre() + "\n";
			}
		}

		if (eliminados.size() > 0) {
			nombreFinal = nombreFinal + "\t" + "sin \n";

			for (Ingrediente eliminado : eliminados) {
				nombreFinal = nombreFinal + "\t\t-" + eliminado.getNombre() + "\n";
			}
		}

		return nombreFinal;
	}

	public void agregarIngrediente(Ingrediente agregado) {
		this.agregados.add(agregado);
		precio = precio + agregado.getCosto();
	}

	public void eliminarIngredientes(Ingrediente eliminar) {

		precio = precio - eliminar.getCosto();

		if (agregados.contains(eliminar)) {
			agregados.remove(eliminar);
		} else {
			this.eliminados.add(eliminar);
		}

	}
}
