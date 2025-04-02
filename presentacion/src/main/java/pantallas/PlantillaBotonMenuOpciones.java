package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class PlantillaBotonMenuOpciones extends JButton {

    private final Dimension DIMENSION_BOTONES = new Dimension(140, 250);
    private final Font FONT_TEXTO_BOTON = new Font("Segoe UI", Font.BOLD, 18);

    public PlantillaBotonMenuOpciones(String texto, String colorHexcode) {
        super("<html><center>" + texto + "</center></html>");
        
        this.setFont(FONT_TEXTO_BOTON);

        this.setPreferredSize(DIMENSION_BOTONES);
        this.setMinimumSize(DIMENSION_BOTONES);
        this.setMaximumSize(DIMENSION_BOTONES);
        
        try {
            this.setBackground(Color.decode(colorHexcode));
        } catch (NumberFormatException e) {
            this.setBackground(Color.GRAY);
        }
    }

}
