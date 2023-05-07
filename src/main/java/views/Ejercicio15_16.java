package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import centroeducativo2JPA.Estudiante;
import centroeducativo2JPA.Materia;
import centroeducativo2JPA.Nota;
import centroeducativo2JPA.Profesor;
import centroeducativo2JPA.Valoracionmateria;
import controller.ControladorEstudiante;
import controller.ControladorMateria;
import controller.ControladorNota;
import controller.ControladorProfesor;
import controller.ControladorValoracionMateria;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio15_16 extends JFrame {
	private final JButton btnActualizar = new JButton("Botón actualizar alumnado");
	private JList jlistNoSelect;
	private JList jlistSelect;
	private DefaultListModel<Estudiante> listModelEstudianteSelect = null;
	private DefaultListModel<Estudiante> listModelEstudianteNoSelect = null;
	private List<Estudiante> estudiantes = ControladorEstudiante.findAll();
	private int indiceProximoEstudianteParaAgregar = 0;
	JComboBox<Materia> jcmbMateria;
	JComboBox<Profesor> jcmbProfesor;
	private static JComboBox jcmbNota;
	
	public Ejercicio15_16() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 202, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 128, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jcmbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcmbMateria = new GridBagConstraints();
		gbc_jcmbMateria.gridwidth = 4;
		gbc_jcmbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbMateria.gridx = 1;
		gbc_jcmbMateria.gridy = 0;
		getContentPane().add(jcmbMateria, gbc_jcmbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		getContentPane().add(lblProfesor, gbc_lblProfesor);
		
		jcmbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcmbProfesor = new GridBagConstraints();
		gbc_jcmbProfesor.gridwidth = 4;
		gbc_jcmbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbProfesor.gridx = 1;
		gbc_jcmbProfesor.gridy = 1;
		getContentPane().add(jcmbProfesor, gbc_jcmbProfesor);
		
		JLabel lblNewLabel_1 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcmbNota = new JComboBox<Nota>();
		GridBagConstraints gbc_jcmbNota = new GridBagConstraints();
		gbc_jcmbNota.gridwidth = 4;
		gbc_jcmbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbNota.gridx = 1;
		gbc_jcmbNota.gridy = 2;
		getContentPane().add(jcmbNota, gbc_jcmbNota);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.gridwidth = 2;
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.gridx = 3;
		gbc_btnActualizar.gridy = 3;
		getContentPane().add(btnActualizar, gbc_btnActualizar);
		
		JLabel lblNewLabel_2 = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{79, 0, 69, 0};
		gbl_panel.rowHeights = new int[]{128, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		jlistNoSelect = new JList(getDefaultListModelNoSelect());
		scrollPane.setViewportView(jlistNoSelect);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnTodoIzq = new JButton("<<");
		btnTodoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosANoSeleccionados();
			}
		});
		btnTodoIzq.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createVerticalStrut(4));
		panel_1.add(btnTodoIzq);
		
		JButton btnIzq = new JButton("<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarANoSeleccionados();
			}
		});
		btnIzq.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createVerticalStrut(4));
		panel_1.add(btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarASeleccionados();
			}
		});
		btnDer.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createVerticalStrut(4));
		panel_1.add(btnDer);
		
		JButton btnTodoDer = new JButton(">>");
		btnTodoDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosASeleccionados();
			}
		});
		btnTodoDer.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(Box.createVerticalStrut(4));
		panel_1.add(btnTodoDer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		jlistSelect = new JList(getDefaultListModelSelect());
		scrollPane_1.setViewportView(jlistSelect);
		
		JButton btnGuardar = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar2();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 6;
		getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		agregarEstudiantes();
		cargarCombos();
	}
	
	/**
	 * 
	 * @return
	 */
   private DefaultListModel getDefaultListModelSelect () {
       this.listModelEstudianteSelect = new DefaultListModel<Estudiante>();
       return this.listModelEstudianteSelect;
   }

   /**
    * 
    * @return
    */
   private DefaultListModel getDefaultListModelNoSelect () {
       this.listModelEstudianteNoSelect = new DefaultListModel<Estudiante>();
       return this.listModelEstudianteNoSelect;
   }
   
   /**
    * 
    */
   private void agregarEstudiantes() {
       if (estudiantes != null) {
           for (Estudiante e : estudiantes) {
               this.listModelEstudianteNoSelect.add(indiceProximoEstudianteParaAgregar, e);
               indiceProximoEstudianteParaAgregar++;
           }
       }
   }
   
   /**
    * 
    */
   private void pasarASeleccionados() {
       for (int i = this.jlistNoSelect.getSelectedIndices().length - 1; i >= 0; i--) {
           this.listModelEstudianteSelect.addElement(this.listModelEstudianteNoSelect.get(this.jlistNoSelect.getSelectedIndices()[i]));
           this.listModelEstudianteNoSelect.removeElementAt(this.jlistNoSelect.getSelectedIndices()[i]);
       }
   }
   
   /**
    * 
    */
   private void pasarANoSeleccionados() {
       for (int i = this.jlistSelect.getSelectedIndices().length - 1; i >= 0; i--) {
           this.listModelEstudianteNoSelect.addElement(this.listModelEstudianteSelect.get(this.jlistSelect.getSelectedIndices()[i]));
           this.listModelEstudianteSelect.removeElementAt(this.jlistSelect.getSelectedIndices()[i]);
       }
   }
   
   /**
    * 
    */
   private void pasarTodosASeleccionados() {
       listModelEstudianteNoSelect.removeAllElements();
       listModelEstudianteSelect.removeAllElements();
       listModelEstudianteSelect.addAll(estudiantes);
   }

   /**
    * 
    */
   private void pasarTodosANoSeleccionados() {
       listModelEstudianteSelect.removeAllElements();
       listModelEstudianteNoSelect.removeAllElements();
       listModelEstudianteNoSelect.addAll(estudiantes);
   }

   /**
    * 
    */
   private void cargarCombos() {
       cargarComboMateria();
       cargarComboProfesor();
       cargarComboNota();
   }

   /**
    * 
    */
   private void cargarComboMateria() {

       List<Materia> lista = ControladorMateria.findAll();

       if (lista != null) {
           for (Materia m : lista) {
               this.jcmbMateria.addItem(m);
           }
       }
   }

   /**
    * 
    */
   private void cargarComboProfesor() {

       List<Profesor> lista = ControladorProfesor.findAll();

       if (lista != null) {
           for (Profesor p : lista) {
               this.jcmbProfesor.addItem(p);
           }
       }
   }

   /**
    * 
    */
   private void cargarComboNota() {

//       List<Nota> lista = ControladorNota.findAll();
//
//       if (lista != null) {
//           for (Nota n : lista) {
//               this.jcmbNota.addItem(n);
//           }
//       }
	   for(float i = 0; i <= 10; i++) {
		   jcmbNota.addItem(i);
	   }
   }
   
   /**
    * 
    */
   private void guardar () {

       Materia m = (Materia) jcmbMateria.getSelectedItem();
       Profesor p = (Profesor) jcmbProfesor.getSelectedItem();
       Nota n = (Nota) jcmbNota.getSelectedItem();
       List<Estudiante> listaParaGuardar = new ArrayList<Estudiante>();

       for (int i = listModelEstudianteSelect.getSize() -1; i >= 0  ; i--) {
           listaParaGuardar.add( (Estudiante) listModelEstudianteSelect.getElementAt(i));
       }

       for (Estudiante e : listaParaGuardar) {
    	    Valoracionmateria v = ControladorValoracionMateria.notaEstudianteMateriaProfesor(e, p, m);
    	    if (v == null) {
    	        v = new Valoracionmateria();
    	        v.setEstudiante(e);
    	        v.setMateria(m);
    	        v.setProfesor(p);
    	    }
    	    v.setValoracion(n.getNota());
    	    ControladorValoracionMateria.guardar1(v);
    	}

   }
   
   /**
    * 
    */
   private void guardar1() {
	    estudiantes.removeAll(estudiantes);
	    for (int i = 0; i < listModelEstudianteSelect.size(); i++) {
	    	estudiantes.add(listModelEstudianteSelect.getElementAt(i));
	    }
	    for (Estudiante estudiante : estudiantes) {
	        Valoracionmateria v = ControladorValoracionMateria.notaEstudianteMateriaProfesor(estudiante,
	                (Profesor) jcmbProfesor.getSelectedItem(), (Materia) jcmbMateria.getSelectedItem());
	        if (v != null) {
	            v.setValoracion((float) jcmbNota.getSelectedItem());
	            ControladorValoracionMateria.modificar(v);
	        } else {
	            v = new Valoracionmateria();
	            v.setEstudiante(estudiante);
	            v.setMateria((Materia) jcmbMateria.getSelectedItem());
	            v.setProfesor((Profesor) jcmbProfesor.getSelectedItem());
	            v.setValoracion((float) jcmbNota.getSelectedItem());
	            ControladorValoracionMateria.insertar(v);
	        }
	    }
	}
   
   /**
    * 
    */
   private void guardar2() {
       List<Estudiante> listaParaGuardar = new ArrayList<Estudiante>();
       listaParaGuardar.removeAll(listaParaGuardar);

       for (int i = 0; i < listModelEstudianteSelect.size(); i++) {
           listaParaGuardar.add(listModelEstudianteSelect.getElementAt(i));
       }
       for (Estudiante estudiantes : listaParaGuardar) {
           Valoracionmateria v = ControladorValoracionMateria.notaEstudianteMateriaProfesor(estudiantes,
                   (Profesor) jcmbProfesor.getSelectedItem(), (Materia) jcmbMateria.getSelectedItem());
           if (v != null) {
               v.setValoracion((float) jcmbNota.getSelectedItem());
               ControladorValoracionMateria.modificar(v);
           } else {
               v = new Valoracionmateria();
               v.setEstudiante(estudiantes);
               v.setMateria((Materia) jcmbMateria.getSelectedItem());
               v.setProfesor((Profesor) jcmbProfesor.getSelectedItem());
               v.setValoracion((float) jcmbNota.getSelectedItem());
               ControladorValoracionMateria.insertar(v);
           }
       }
   }
   
   /**
    * 
    * @param args
    */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio15_16 frame = new Ejercicio15_16();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
