package views;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import centroeducativo2JPA.Tipologiasexo;
import controller.ControladorTipologiaSexo;

public class MiSexoTableCellEditor extends DefaultCellEditor {

	// Utilizaremos este puntero para hacer referencia al control mostrado en la tabla
	private JComboBox<Tipologiasexo> jcbSexo = null;
	
	/**
	 * 
	 */
	public MiSexoTableCellEditor() {
		super(new JComboBox<Tipologiasexo>());
		
		// La celda se comenzar� a editar tras 2 clics
		setClickCountToStart(2);
		// Inicializaci�n del componente
		jcbSexo = (JComboBox<Tipologiasexo>) getComponent();
	}

	/**
	 * En este m�todo construimos el componente que el usuario ver� cuando haga clic sobre la celda en concreto
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JComboBox<Tipologiasexo> jcbSexo = (JComboBox<Tipologiasexo>) super.getTableCellEditorComponent(table, value, isSelected, row, column);

		// Si los hubiera, elimino los items actuales.
		jcbSexo.removeAllItems();
		
		// Inicializo los elementos del combobox a todas las provincias disponibles y selecciono la correcta
		List<Tipologiasexo> sexos = ControladorTipologiaSexo.findAll();
		for (Tipologiasexo sexo : sexos) {
			jcbSexo.addItem(sexo);
			if (value != null && value instanceof Tipologiasexo) {
				Tipologiasexo provinciaValue = (Tipologiasexo) value;
				if (provinciaValue.getId() == sexo.getId()) {
					jcbSexo.setSelectedItem(sexo);
				}
			}
		}
		
		return jcbSexo;
	}

	/**
	 * Devuelvo el objeto de tipo Provincia seleccionado por el usuario
	 */
	public Object getCellEditorValue() {
		return (Tipologiasexo) jcbSexo.getSelectedItem();
	}

}
