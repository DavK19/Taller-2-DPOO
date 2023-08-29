package restaurante;


import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;
import restaurante.Combo;



public class Pedido {
	private static int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private Producto productos;
	
	public Pedido (String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = numeroPedidos;
		Pedido.numeroPedidos ++;
		productos = new Producto();
	}
	
	
	public void agregarProducto(ProductoMenu producto) {
		productos.agregarProductoMenu(producto);
	}
	
	public void agregarProductoAjustado (ProductoAjustado producto) {
		productos.agregarProductoAjustado(producto);
	}
	
	public void agregarCombo (Combo combo) {
		productos.agregarCombo(combo);
	}
	
	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public int getNumeroPedidos() {
		return Pedido.numeroPedidos;
	}
	
	public String generarFactura() {
		return productos.generarTextoFactura();
	}
	
	
}
