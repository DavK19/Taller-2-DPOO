package restaurante;

import java.util.ArrayList;

import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;
import restaurante.Combo;

public class Pedido {
	private static int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Object> listaProductos;
	private Producto productos;
	
	public Pedido (String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = numeroPedidos;
		Pedido.numeroPedidos ++;
	}
	
	
	public void agregarProducto(ProductoMenu producto) {
		
	}
	
	public void agregarProductoAjustado (ProductoAjustado producto) {
		
	}
	
	public void agregarCombo (Combo combo) {
		
	}
	
	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public int getNumeroPedidos() {
		return Pedido.numeroPedidos;
	}
	
	
}
