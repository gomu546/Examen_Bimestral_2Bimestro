package MS_App.MS_DesktopApp.CustomControl;

import javax.swing.*;

import MS_Infrastructure.MS_AppStyle;

import java.awt.*;

public class MS_LabelText extends JPanel {
    private MS_Label lblEtiqueta = new MS_Label();
    private MS_TextBox txtContenido = new MS_TextBox();

    public MS_LabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(etiqueta,
                MS_AppStyle.FONT_SMALL,
                MS_AppStyle.COLOR_FONT_LIGHT,
                MS_AppStyle.ALIGNMENT_LEFT);
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }

    public String getText() {
        return txtContenido.getText();
    }
}
