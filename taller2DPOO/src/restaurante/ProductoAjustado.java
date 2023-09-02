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
		this.nombre = productoBase.getNombre();
		this.precio = productoBase.getPrecio();
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public String getFactura() {
		
		String nombreFinal = getNombre();
		
		if (agregados.size() > 0) {
			nombreFinal = nombreFinal + "con adicion de" + "               " + String.valueOf(precio);
			for (Ingrediente agregado: agregados) {
				nombreFinal = nombreFinal + "\t" + agregado.getNombre() + "\n";
			}
		}
		
		if (eliminados.size() > 0) {
			nombreFinal = nombreFinal + "sin \n";
			
			for (Ingrediente eliminado: eliminados) {
				nombreFinal = nombreFinal + "\t" + eliminado.getNombre() + "\n"; 
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
