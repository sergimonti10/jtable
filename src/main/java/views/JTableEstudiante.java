package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import centroeducativo2JPA.Estudiante;
import centroeducativo2JPA.Materia;
import centroeducativo2JPA.Nota;
import centroeducativo2JPA.Profesor;
import centroeducativo2JPA.Tipologiasexo;
import centroeducativo2JPA.Valoracionmateria;
import controller.ControladorEstudiante;
import controller.ControladorProfesor;
import controller.ControladorTipologiaSexo;
import controller.ControladorValoracionMateria;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class JTableEstudiante extends JFrame {
	MiTableModel tableModel = null;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfAp1;
	private JTextField jtfAp2;
	private JTextField jtfTel;
	private JTextField jtfDir;
	private JTextField jtfDni;
	private JTextField jtfEmail;
	JButton jbtnTodosIzq;
	JButton jbtnIzq;
	JButton jbtnTodosDer;
	JButton jbtnDer;
	JComboBox<Tipologiasexo> jcbSexo;
	JTable jTable;
	
	public JTableEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{249, 0};
		gbl_panel.rowHeights = new int[]{161, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		panel.add(splitPane, gbc_splitPane);
		
		tableModel = new MiTableModel();
		jTable = new JTable(tableModel);
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		JScrollPane scrollPane = new JScrollPane(jTable);


		splitPane.setTopComponent(scrollPane);
		splitPane.setResizeWeight(1.0);
		splitPane.setPreferredSize(new Dimension(1200, 400));
		
		MiTableHeaderCellRenderer tableHeaderCellRenderer = new MiTableHeaderCellRenderer();
		for (int i = 0; i < jTable.getColumnCount(); i++) {
			jTable.getColumnModel().getColumn(i).setHeaderRenderer(tableHeaderCellRenderer);
		}
		
		jTable.setDefaultEditor(Tipologiasexo.class, new MiSexoTableCellEditor());
		
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				seleccionarDatosDeLaTabla();
			}
		});
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 8;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		panel_1.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 8;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel_1.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfAp1 = new JTextField();
		GridBagConstraints gbc_jtfAp1 = new GridBagConstraints();
		gbc_jtfAp1.gridwidth = 8;
		gbc_jtfAp1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAp1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAp1.gridx = 1;
		gbc_jtfAp1.gridy = 2;
		panel_1.add(jtfAp1, gbc_jtfAp1);
		jtfAp1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfAp2 = new JTextField();
		GridBagConstraints gbc_jtfAp2 = new GridBagConstraints();
		gbc_jtfAp2.gridwidth = 8;
		gbc_jtfAp2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAp2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAp2.gridx = 1;
		gbc_jtfAp2.gridy = 3;
		panel_1.add(jtfAp2, gbc_jtfAp2);
		jtfAp2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfTel = new JTextField();
		GridBagConstraints gbc_jtfTel = new GridBagConstraints();
		gbc_jtfTel.gridwidth = 8;
		gbc_jtfTel.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTel.gridx = 1;
		gbc_jtfTel.gridy = 4;
		panel_1.add(jtfTel, gbc_jtfTel);
		jtfTel.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDir = new JTextField();
		GridBagConstraints gbc_jtfDir = new GridBagConstraints();
		gbc_jtfDir.gridwidth = 8;
		gbc_jtfDir.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDir.gridx = 1;
		gbc_jtfDir.gridy = 5;
		panel_1.add(jtfDir, gbc_jtfDir);
		jtfDir.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.gridwidth = 8;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		panel_1.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.gridwidth = 8;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		panel_1.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbSexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.gridwidth = 8;
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 8;
		panel_1.add(jcbSexo, gbc_jcbSexo);
		
		jbtnTodosIzq = new JButton("<<");
		jbtnTodosIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante estudiante = ControladorEstudiante.findFirst();
		        cargarEnPantalla(estudiante);
			}
		});
		GridBagConstraints gbc_jbtnTodosIzq = new GridBagConstraints();
		gbc_jbtnTodosIzq.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnTodosIzq.gridx = 1;
		gbc_jbtnTodosIzq.gridy = 9;
		panel_1.add(jbtnTodosIzq, gbc_jbtnTodosIzq);
		
		jbtnIzq = new JButton("<");
		jbtnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante estudiante = ControladorEstudiante.findPrevious(ControladorEstudiante.getEstudianteById(Integer.parseInt(jtfId.getText())));
		        cargarEnPantalla(estudiante);
			}
		});
		GridBagConstraints gbc_jbtnIzq = new GridBagConstraints();
		gbc_jbtnIzq.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnIzq.gridx = 2;
		gbc_jbtnIzq.gridy = 9;
		panel_1.add(jbtnIzq, gbc_jbtnIzq);
		
		jbtnDer = new JButton(">");
		jbtnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante estudiante = ControladorEstudiante.findNext(ControladorEstudiante.getEstudianteById(Integer.parseInt(jtfId.getText())));
		        cargarEnPantalla(estudiante);
			}
		});
		GridBagConstraints gbc_jbtnDer = new GridBagConstraints();
		gbc_jbtnDer.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnDer.gridx = 3;
		gbc_jbtnDer.gridy = 9;
		panel_1.add(jbtnDer, gbc_jbtnDer);
		
		jbtnTodosDer = new JButton(">>");
		jbtnTodosDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante estudiante = ControladorEstudiante.findLast();
		        cargarEnPantalla(estudiante);
			}
		});
		GridBagConstraints gbc_jbtnTodosDer = new GridBagConstraints();
		gbc_jbtnTodosDer.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnTodosDer.gridx = 4;
		gbc_jbtnTodosDer.gridy = 9;
		panel_1.add(jbtnTodosDer, gbc_jbtnTodosDer);
		
		JButton jbtnGuardar = new JButton("Guardar");
		jbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_jbtnGuardar = new GridBagConstraints();
		gbc_jbtnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnGuardar.gridx = 5;
		gbc_jbtnGuardar.gridy = 9;
		panel_1.add(jbtnGuardar, gbc_jbtnGuardar);
		
		JButton jbtnNuevo = new JButton("Nuevo");
		jbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		GridBagConstraints gbc_jbtnNuevo = new GridBagConstraints();
		gbc_jbtnNuevo.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnNuevo.gridx = 6;
		gbc_jbtnNuevo.gridy = 9;
		panel_1.add(jbtnNuevo, gbc_jbtnNuevo);
		
		JButton jbtnEliminar = new JButton("Eliminar");
		jbtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		GridBagConstraints gbc_jbtnEliminar = new GridBagConstraints();
		gbc_jbtnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnEliminar.gridx = 7;
		gbc_jbtnEliminar.gridy = 9;
		panel_1.add(jbtnEliminar, gbc_jbtnEliminar);
		
		cargarComboSexo();
	}
	
	/**
	 * 
	 */
	public void seleccionarDatosDeLaTabla() {
		int selectedRow = jTable.getSelectedRow();
		jtfId.setText(Integer.toString(((Integer) tableModel.getValueAt(selectedRow, 0)).intValue()));
		jtfNombre.setText((String) tableModel.getValueAt(selectedRow, 1));
		jtfAp1.setText((String) tableModel.getValueAt(selectedRow, 2));
		jtfAp2.setText((String) tableModel.getValueAt(selectedRow, 3));
		jtfTel.setText((String) tableModel.getValueAt(selectedRow, 4));
		jtfDir.setText((String) tableModel.getValueAt(selectedRow, 5));
		jtfDni.setText((String) tableModel.getValueAt(selectedRow, 6));
		jtfEmail.setText((String) tableModel.getValueAt(selectedRow, 7));
		Tipologiasexo sexo = (Tipologiasexo) tableModel.getValueAt(selectedRow, 8);
	    jcbSexo.setSelectedItem(sexo);
	}

	/**
	 * 
	 * @param c
	 */
	private void cargarEnPantalla(Estudiante c) {

		 Estudiante estudianteActual = ControladorEstudiante.getEstudianteById(c.getId());

	    if (ControladorEstudiante.findPrevious(estudianteActual) == null) {
	        jbtnTodosIzq.setEnabled(false);
	        jbtnIzq.setEnabled(false);
	    } else {
	        jbtnTodosIzq.setEnabled(true);
	        jbtnIzq.setEnabled(true);
	    }

	    if (ControladorEstudiante.findNext(estudianteActual) == null) {
	        jbtnTodosDer.setEnabled(false);
	        jbtnDer.setEnabled(false);
	    } else {
	        jbtnTodosDer.setEnabled(true);
	        jbtnDer.setEnabled(true);
	    }
	    
	    jtfId.setText(Integer.toString(c.getId()));
	    jtfNombre.setText(c.getNombre());
	    jtfAp1.setText(c.getApellido1());
	    jtfAp2.setText(c.getApellido2());
	    jtfTel.setText(c.getTelefono());
	    jtfDir.setText(c.getDireccion());
	    jtfDni.setText(c.getDni());
	    jtfEmail.setText(c.getEmail());
	    jcbSexo.setSelectedItem(c.getTipologiasexo());

	}

	 /**
	    * 
	    */
	   private void cargarComboSexo() {

		   jcbSexo.removeAllItems();

	       List<Tipologiasexo> lista = ControladorTipologiaSexo.findAll();

	       if (lista != null) {
	           for (Tipologiasexo t : lista) {
	               jcbSexo.addItem(t);
	           }
	       }
	   }
	   
	   /**
	    * 
	    */
	   private void nuevo() {
		   
		   jtfId.setText("0");
		   jtfNombre.setText("");
		   jtfAp1.setText("");
		   jtfAp2.setText("");
		   jtfTel.setText("");
		   jtfDir.setText("");
		   jtfDni.setText("");
		   jtfEmail.setText("");
		   jcbSexo.setSelectedIndex(0);
	   }
	   
	   /**
	    * 
	    */
	   public void eliminar() {
		   
		   int id = Integer.parseInt(jtfId.getText());
		   Estudiante estudianteAEliminar = ControladorEstudiante.getEstudianteById(id);
		   ControladorEstudiante.eliminar(estudianteAEliminar);
		   ControladorEstudiante.actualizarTabla((MiTableModel) jTable.getModel());

	   }
	   
	   /**
	    * 
	    */
	   private void guardar() {
		   
		    int id = Integer.parseInt(jtfId.getText());
		    Tipologiasexo s = (Tipologiasexo) jcbSexo.getSelectedItem();
		    Estudiante e = ControladorEstudiante.getEstudianteById(id);
		    if (e == null) {
		        e = new Estudiante();
		    }
		    e.setNombre(jtfNombre.getText());
		    e.setApellido1(jtfAp1.getText());
		    e.setApellido2(jtfAp2.getText());
		    e.setTelefono(jtfTel.getText());
		    e.setDireccion(jtfDir.getText());
		    e.setDni(jtfDni.getText());
		    e.setEmail(jtfEmail.getText());
		    e.setTipologiasexo(s);
		    ControladorEstudiante.guardar(e);
		    
		    ControladorEstudiante.actualizarTabla((MiTableModel) jTable.getModel());

		}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableEstudiante frame = new JTableEstudiante();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
