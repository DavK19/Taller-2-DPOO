package restaurante;

import java.util.ArrayList;

import restaurante.Combo;
import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;


public class Producto {
	
	private ArrayList<Object> listaProductos;
	private int precio = 0;
	
	public void agregarProductoMenu (Object producto) {
		
		if (producto instanceof ProductoMenu){
			listaProductos.add(producto);
		}
	}
	
}
