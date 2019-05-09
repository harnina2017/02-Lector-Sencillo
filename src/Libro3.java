import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Libro3 {
	private FileReader libro = null;
	private String ruta = "juegotronos.txt";

	// Quien controla que el archivo exista
	public Libro3() {
		super();
		if (validarLibro(ruta)) {
			libro = abrirLibro(new File(ruta));
		}
	}

	private boolean validarLibro(String ruta2) {
		File file=new File(ruta2);
		//Aqui haces programcion defensiva
		//Porque la clase libro debe tomar una decison sobre los errores
		return file.exists()&&file.canRead();
	}

	private FileReader abrirLibro(File ruta2) {
		assert ruta2.exists() && ruta2.canRead();
		try {
			return new FileReader(ruta2);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	static class Test {

		@org.junit.jupiter.api.Test
		public void testAbrirLibro() {
			Libro3 libro = new Libro3();
			File li2 = new File("juegotronos.txt");
			assertNotNull(libro.abrirLibro(li2));
		}
		
		@org.junit.jupiter.api.Test
		public void testValidarRuta() {
			Libro3 libro = new Libro3();
			assertFalse(libro.validarLibro("no existe"));
			assertTrue(libro.validarLibro("juegotronos.txt"));
		}
	}
}
