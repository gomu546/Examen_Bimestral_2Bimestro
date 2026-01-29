package MS_App.MS_DesktopApp.CustomControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import MS_Infrastructure.MS_AppStyle;

public class MS_TextBox extends JTextField {

    public MS_TextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setBorderDownLine();
        setFont(MS_AppStyle.FONT);
        setForeground(MS_AppStyle.COLOR_FONT_LIGHT);
        setCaretColor(MS_AppStyle.COLOR_CURSOR); // Color del cursor
        setMargin(new Insets(4, 4, 4, 4)); // Ajusta los márgenes
        setOpaque(false); // Fondo transparente
        // setUI(new BasicTextFieldUI()); // Para deshabilitar el subrayado por defecto
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(MS_AppStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(4, 4, 4, 4); // Márgenes internos
        setBorder(new CompoundBorder(lineBorder, emptyBorder));
    }

    private void setBorderDownLine() {
        int thickness = 1;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                BorderFactory.createMatteBorder(0, 0, thickness, 0, MS_AppStyle.COLOR_BORDER)));
    }
}
