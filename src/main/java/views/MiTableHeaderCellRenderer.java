package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiTableHeaderCellRenderer extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JLabel jlabel = (JLabel) c;
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        c.setBackground(Color.decode("#1f4684"));
        c.setForeground(Color.WHITE);
        return c;
	}


}
