package restaurante;

import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;

import java.util.ArrayList;

import restaurante.Combo;

public class Pedido {
	private static int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private int precioTotal = 0;
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = numeroPedidos;
		Pedido.numeroPedidos++;
	}

	public void agregarProducto(Producto producto) {
		listaProductos.add(producto);
		precioTotal = precioTotal + producto.getPrecio();
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public int getNumeroPedidos() {
		return Pedido.numeroPedidos;
	}

	public String generarFactura() {
		String facturaFinal;
		String id = "Id de la factura: " + String.valueOf(idPedido) + "\n";
		String encabezado = String.format("%" + "s" + 10 + "s" + "\n", nombreCliente, direccionCliente);
		String contenido = "";

		for (Producto producto : listaProductos) {
			contenido = contenido + producto.getFactura();
		}

		facturaFinal = id + encabezado + contenido;

		return facturaFinal;
	}

}
