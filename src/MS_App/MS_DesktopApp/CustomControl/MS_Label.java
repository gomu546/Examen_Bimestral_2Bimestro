package MS_App.MS_DesktopApp.CustomControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import MS_Infrastructure.MS_AppStyle;

public class MS_Label extends JLabel {
    public MS_Label() {
        customizeComponent();
    }

    public MS_Label(String text) {
        setText(text);
        customizeComponent();
    }

    private void customizeComponent() {
        setCustomizeComponent(getText(), MS_AppStyle.FONT, MS_AppStyle.COLOR_FONT_LIGHT, MS_AppStyle.ALIGNMENT_LEFT);
    }

    public void setCustomizeComponent(String text, Font font, Color color_font, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color_font);
        setHorizontalAlignment(alignment);
        // setIcon(new ImageIcon(iconPath));
    }
}