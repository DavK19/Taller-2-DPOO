package consola;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	Restaurante restaurante;
	ArrayList <ProductoMenu> listaProductos;
	ArrayList <Ingrediente> listaIngredientes;
	
	
	public void main(String[] args) {
		
		boolean working = true;
		int opcion;
		
		
		while (working) {
			mostrarMenu();
			opcion = Integer.parseInt(input("Ingrese la opcion a elegir: "));
			switch (opcion) {
			case 1:
				
			}
		}
	}

	public void mostrarMenu() {
		System.out.println("Bienvenido al asistente para tomar pedidos del restaurante ¿Que desea hacer?");
		System.out.println("1.Tomar un nuevo pedido");
		System.out.println("2.Agregar un nuevo elemento al pedido");
		System.out.println("3.Cerrar y guardar el pedido");
		System.out.println("4.Consultar un pedido dado su Id");
		System.out.println("Salir del programa");

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
	
	public void 
}
