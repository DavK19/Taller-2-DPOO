package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import restaurante.ProductoMenu;
import restaurante.ProductoAjustado;
import restaurante.Producto;
import restaurante.Combo;
import restaurante.Ingrediente;
import restaurante.Pedido;
import restaurante.Restaurante;

public class Aplicacion {

	private Restaurante restaurante;
	private ArrayList<ProductoMenu> listaProductos;
	private ArrayList<Ingrediente> listaIngredientes;
	private ArrayList<Combo> listaCombos;

	public void ejecutarAplicacion() {

		boolean working = true;
		int opcion;
		restaurante = new Restaurante();
		listaProductos = restaurante.getListaProductos();
		listaIngredientes = restaurante.getListaIngredientes();
		listaCombos = restaurante.getListaCombos();

		try {
			while (working) {
				mostrarMenu();
				opcion = Integer.parseInt(input("Ingrese la opcion a elegir"));
				if (opcion == 1) {
					String nombreCliente = input("Ingrese el nombre del cliente");
					String direccionCliente = input("Ingrese la direccion del cliente");

					restaurante.iniciarPedido(nombreCliente, direccionCliente);
				} else if (opcion == 2) {
					agregarProducto();

				} else if (opcion == 3) {
					cerrarPedido();

				} else if (opcion == 4) {
					buscarPedido();
				} else if (opcion == 5) {
					working = false;
					System.out.println("Gracias por utilizar el asistente del restaurante");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void buscarPedido() {
		System.out.println("Estas seguro de buscar otro pedido? El pedido actual se borrará");
		System.out.println("1. Si");
		System.out.println("2. No");
		int numero = Integer.parseInt(input("Ingrese la opcion que desea elegir"));
		if (numero == 1) {
			int idPedido = Integer.parseInt(input("Ingrese el id del pedido a buscar"));
			boolean existe = restaurante.cambiarPedido(idPedido);

			if (existe) {
				System.out.println(String.format("El pedido %d ha sido cargado", idPedido));
			} else {
				System.out.println("El pedido no esta registrado en la base de datos");
			}

		} else if (numero == 2) {
			System.out.println("Solicitud cancelada");
		} else {
			System.out.println("No ha ingresado una opcion adecuada");
		}
	}

	private void cerrarPedido() {
		System.out.println("Esta seguro de que desea cerrar el pedido");
		System.out.println("1. Si");
		System.out.println("2. No");

		int opcionElegida = Integer.parseInt(input("Ingrese la opcion que desea elegir"));

		if (opcionElegida == 1) {
			
			Path path = Paths.get(String.format("/facturas/%d.txt", String.valueOf(restaurante.getIdPedidoActual())));
			String factura = restaurante.getFactura();
			try {
				Files.writeString(path, factura, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("El pedido guardado es el siguiente:");
			System.out.println(factura);
			restaurante.cerraryGuardarPedido();
		}
	}

	private void agregarProducto() {
		System.out.println("Que tipo de producto desea agregar: ");
		System.out.println("1. Producto del menu");
		System.out.println("2. Combo");

		int opcion = Integer.parseInt(input("Ingrese la opcion a elegir"));

		if (opcion == 1) {
			mostrarProductos();
			int productoElegido = Integer.parseInt(input("Ingrese el producto que desea elegir"));

			if (productoElegido >= 0 && productoElegido < listaProductos.size()) {
				ProductoMenu productoBase = listaProductos.get(productoElegido);
				System.out.println("Desea modificar el producto: ");
				System.out.println("1.Si");
				System.out.println("2.No");

				opcion = Integer.parseInt(input("Ingrese la opcion a elegir"));

				if (opcion == 1) {
					ProductoAjustado productoFinal = new ProductoAjustado(productoBase);
					boolean modificar = true;

					while (modificar) {

						System.out.println("Desea agregar o eliminar un ingrediente?");
						System.out.println("1.Agregar");
						System.out.println("2.Eliminar");

						int opcionIngrediente = Integer.parseInt(input("Ingrese la opcion a elegir que desea elegir"));

						if (opcionIngrediente == 1) {
							mostrarIngredientes();

							int numeroIngrediente = Integer.parseInt(input("Ingrese el ingrediente que desea elegir"));

							Ingrediente agregar = listaIngredientes.get(numeroIngrediente);

							productoFinal.agregarIngrediente(agregar);

						} else if (opcionIngrediente == 2) {
							mostrarIngredientes();

							int numeroIngrediente1 = Integer.parseInt(input("Ingrese el ingrediente que desea elegir"));

							Ingrediente quitar = listaIngredientes.get(numeroIngrediente1);

							productoFinal.eliminarIngredientes(quitar);

						} else {
							System.out.println("No ingreso una opcion valida");
						}
						System.out.println("Desea seguir modificando el producto?");
						System.out.println("1.Si");
						System.out.println("2.No");

						int continuar = Integer.parseInt(input("Ingrese la opcion a elegir"));

						if (continuar == 2) {
							modificar = false;
							restaurante.agregarProducto(productoFinal);

						} else {
							System.out.println("No ingreso una opcion valida");
						}
					}

				} else if (opcion == 2) {
					restaurante.agregarProducto(productoBase);

				} else {
					System.out.println("Ingrese una opcion valida");
				}

			} else {
				System.out.println("No es un producto valido");
			}
		} else if (opcion == 2) {
			mostrarCombos();
			int comboElegido = Integer.parseInt(input("Ingrese el producto que desea elegir"));

			if (comboElegido >= 0 && comboElegido < listaCombos.size()) {
				Combo comboAgregar = listaCombos.get(comboElegido);
				restaurante.agregarProducto(comboAgregar);
			}
		} else {
			System.out.println("No has ingresado una opcion valida");
		}

	}

	public void mostrarMenu() {
		System.out.println("Bienvenido al asistente para tomar pedidos del restaurante ¿Que desea hacer?");
		System.out.println("1.Tomar un nuevo pedido");
		System.out.println("2.Agregar un nuevo elemento al pedido");
		System.out.println("3.Cerrar y guardar el pedido");
		System.out.println("4.Consultar un pedido dado su Id");
		System.out.println("5.Salir del programa");

	}

	public void mostrarProductos() {
		for (int i = 0; i < listaProductos.size(); i++) {
			String nombre = listaProductos.get(i).getNombre();
			System.out.println(String.format("%d. %s", i, nombre));
		}
	}

	public void mostrarIngredientes() {
		for (int i = 0; i < listaIngredientes.size(); i++) {
			String nombre = listaIngredientes.get(i).getNombre();
			System.out.println(String.format("%d. %s", i, nombre));
		}
	}

	public void mostrarCombos() {
		for (int i = 0; i < listaCombos.size(); i++) {
			String nombre = listaCombos.get(i).getNombre();
			System.out.println(String.format("%d. %s", i, nombre));
		}
	}

	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion();

	}
}
