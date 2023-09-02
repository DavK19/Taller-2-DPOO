package restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import restaurante.ProductoAjustado;
import restaurante.ProductoMenu;
import restaurante.Ingrediente;
import restaurante.Combo;
import restaurante.Pedido;

public class Restaurante {

	private ArrayList<ProductoMenu> listaProductos = new ArrayList<ProductoMenu>();
	private ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
	private ArrayList<Combo> listaCombos = new ArrayList<Combo>();
	private Map<String, Pedido> pedidos = new HashMap<String, Pedido>();
	private File archivoProductos;
	private File archivoIngredientes;
	private File archivoCombos;
	private Pedido pedidoActual;

	public Restaurante() {
		this.archivoProductos = new File("data/menu.txt");
		this.archivoIngredientes = new File("data/ingredientes.txt");
		this.archivoCombos = new File("data/combos.txt");
		try {
			cargarInformacionRestaurante(this.archivoProductos, this.archivoIngredientes, this.archivoCombos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarInformacionRestaurante(File archivoProductos, File archivoIngredientes, File archivoCombos)
			throws Exception {
		cargarMenu(archivoProductos);
		cargarIngredientes(archivoIngredientes);
		cargarCombos(archivoCombos);
	}

	public void cargarMenu(File archivoProductos) throws Exception {
		FileReader fr = new FileReader(archivoProductos);
		BufferedReader in = new BufferedReader(fr);
		String linea = in.readLine();

		while (linea != null) {
			String[] palabras = linea.split(";");
			ProductoMenu nuevoProducto = new ProductoMenu(palabras[0], Integer.parseInt(palabras[1]));
			listaProductos.add(nuevoProducto);
			linea = in.readLine();
		}

		in.close();
	}

	public void cargarIngredientes(File archivoIngredientes) throws Exception {
		FileReader fr = new FileReader(archivoIngredientes);
		BufferedReader in = new BufferedReader(fr);
		String linea = in.readLine();

		while (linea != null) {
			String[] palabras = linea.split(";");
			Ingrediente nuevoIngrediente = new Ingrediente(palabras[0], Integer.parseInt(palabras[1]));
			listaIngredientes.add(nuevoIngrediente);
			linea = in.readLine();
		}

		in.close();
	}

	public void cargarCombos(File archivoCombos) throws Exception {
		FileReader fr = new FileReader(archivoCombos);
		BufferedReader in = new BufferedReader(fr);
		String linea = in.readLine();

		while (linea != null) {

			String[] palabras = linea.split(";");
			Combo nuevoCombo = new Combo(palabras[0], Double.parseDouble(palabras[1].replace("%", "")));

			for (int i = 2; i < palabras.length; i++) {
				String productoAgregar = palabras[i];
				ProductoMenu producto = encontrarProducto(productoAgregar);
				nuevoCombo.agregarItemCombo(producto);
			}
			listaCombos.add(nuevoCombo);

			linea = in.readLine();

		}

		in.close();
	}

	public ProductoMenu encontrarProducto(String nombreProducto) {

		for (ProductoMenu producto : listaProductos) {

			if (producto.getNombre().equals(nombreProducto)) {

				return producto;

			}

		}
		return null;
	}

	public Ingrediente encontrarIngrediente(String nombreIngrediente) {

		for (Ingrediente ingrediente : listaIngredientes) {
			if (ingrediente.getNombre().equals(nombreIngrediente)) {

				return ingrediente;

			}
		}

		return null;
	}

	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		pedidoActual = new Pedido(nombreCliente, direccionCliente);
	}

	public void agregarProducto(Producto producto) {
		pedidoActual.agregarProducto(producto);
	}

	public void cerraryGuardarPedido() {
		boolean verificacion = pedidos.containsKey(String.valueOf(pedidoActual.getIdPedido()));

		if (!verificacion) {
			pedidos.put(String.valueOf(pedidoActual.getIdPedido()), pedidoActual);
		} else {
			System.out.println("Ya existe un pedido con el mismo id");
		}
		pedidoActual = null;
	}

	public Pedido getPedidoEnCurso() {
		return pedidoActual;
	}

	public ArrayList<ProductoMenu> getListaProductos() {
		return listaProductos;
	}

	public ArrayList<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public ArrayList<Combo> getListaCombos() {
		return listaCombos;
	}

	public String getFactura() {
		return pedidoActual.generarFactura();
	}

	public int getIdPedidoActual() {
		return pedidoActual.getIdPedido();
	}

	public boolean cambiarPedido(int idPedido) {
		String llave = String.valueOf(idPedido);
		boolean existe = pedidos.containsKey(llave);

		if (existe) {
			pedidoActual = pedidos.get(llave);
			return existe;
		} else {
			return existe;
		}
	}
}
