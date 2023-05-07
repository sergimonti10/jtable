package views;

import java.util.List;

import centroeducativo2JPA.Estudiante;
import controller.ControladorEstudiante;

public class DatosDeTabla {
	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "Apellido 1", "Apellido 2", "Teléfono", "Dirección", "DNI", "Email", "Sexo"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> estudiantes = ControladorEstudiante.findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][9];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			datos[i][0] = estudiante.getId();
			datos[i][1] = estudiante.getNombre();
			datos[i][2] = estudiante.getApellido1();
			datos[i][3] = estudiante.getApellido2();
			datos[i][4] = estudiante.getTelefono();
			datos[i][5] = estudiante.getDireccion();
			datos[i][6] = estudiante.getDni();
			datos[i][7] = estudiante.getEmail();
			datos[i][8] = estudiante.getTipologiasexo();
		}
		
		return datos;
	}
	
	
}
