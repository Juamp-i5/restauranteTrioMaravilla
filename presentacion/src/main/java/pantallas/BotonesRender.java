package pantallas;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author pablo
 */
public class BotonesRender extends JButton implements TableCellRenderer {
    public BotonesRender() {
        setText("Agregar"); 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }   
}
