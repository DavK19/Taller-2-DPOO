package test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.exceptions.HamburguesaException;
import src.restaurante.Restaurante;

public class TestCargaDatos{
	
	private File menuOriginal = new File("data/menu.txt");
	private File menuIntercambio = new File("data/menuGuardar.txt");
	private Restaurante restaurante;
	
	public TestCargaDatos() {
		
	}
	
	@BeforeEach
	public void setUp(){
		menuOriginal.renameTo(menuIntercambio);
		
		File newMenu = new File("data/menu.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(newMenu));
			bw.write("piña;2000");
			bw.write("piña;2000");
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterEach
	public void reemplazarArchivo() {
		File newMenu = new File("data/menu.txt");
		newMenu.delete();
		menuOriginal.renameTo(new File("data/menu.txt"));
	}
	
	@Test
	public void testCargarDatosPiña() {
		assertThrows(HamburguesaException.class, ()->{
			restaurante.cargarMenu(new File("data/menu.txt"));
		}
		);
	}
}