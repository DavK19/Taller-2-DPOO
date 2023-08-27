package restaurante;

import java.io.BufferedReader;
import java.io.File;
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

	private ArrayList<ProductoMenu> listaProductos;
	private ArrayList<Ingrediente> listaIngredientes;
	private ArrayList<Combo> listaCombos;
	private Map<String, Pedido> pedidos = new HashMap<String, Pedido>();
	private File archivoProductos;
	private File archivoIngredientes;
	private File archivoCombos;

	public Restaurante() {
		this.archivoProductos = new File("/data/menu.txt");
		this.archivoIngredientes = new File("/data/ingredientes.txt");
		this.archivoCombos = new File("/data/combos.txt");
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
		BufferedReader in = new BufferedReader(new FileReader(archivoProductos));
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
		BufferedReader in = new BufferedReader(new FileReader(archivoIngredientes));
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
		BufferedReader in = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = in.readLine();

		while (linea != null) {
			String[] palabras = linea.split(";");
			Combo nuevoCombo = new Combo(palabras[0], Double.parseDouble(palabras[1].replace("%", "")));

			String[] productos = Arrays.copyOfRange(palabras, 2, palabras.length);

			for (String productoAgregar : productos) {
				ProductoMenu producto = encontrarProducto(productoAgregar);
				nuevoCombo.agregarItemCombo(producto);
			}

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
	}

	public void cerraryGuardarPedido() {

	}

	public void getPedidoEnCurso() {

	}

}
