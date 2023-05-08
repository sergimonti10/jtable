package views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import centroeducativo2JPA.Estudiante;



public class MiTableModel  extends AbstractTableModel {
	Object datos[][] = null;
	String titulos[] = null;
	List<Object[]> datos1 = new ArrayList<Object[]>();


	/**
	 * 
	 */
	public MiTableModel() {
		// Datos a presentar en la tabla
		datos = DatosDeTabla.getDatosDeTabla();
		titulos = DatosDeTabla.getTitulosColumnas();
	}
	
	// Los tres siguientes m�todos son los m�nimos necesarios para representar la tabla
	/**
	 * Permite que la tabla sepa cu�ntas columnas debe mostrar
	 */
	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	/**
	 * Permite que la tabla sepa cu�ntas filas debe mostrar
	 */
	@Override
	public int getRowCount() {
		return datos.length;
	}

	/**
	 * Se conocer� el dato en cada celda, es uno de los m�todos fundamentales del abstractTableModel
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos[rowIndex][columnIndex];
	}

	/**
	 * Podemos indicar si la tabla ser� o no editable en cada una de sus celdas, incluso por separado
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex != 0);
	}

	/**
	 * Este m�todo da nombre a las columnas de la tabla
	 */
	@Override
	public String getColumnName(int column) {
		return this.titulos[column];
	}

	/**
	 * Permite que la tabla sepa que tipo de dato est� mostrando en cada columna
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (this.datos.length > 0) {
			return this.datos[0][columnIndex].getClass();
		}
		return String.class;
	}

	/**
	 * Este m�todo s�lo debe implementarse si la tabla es editable y los datos pueden cambiar
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.datos[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}	
	
	/**
	 * 
	 * @param estudiantes
	 */
	public void setDatos(Object[][] datos) {
	    this.datos = datos;
	    fireTableDataChanged();
	}


}
