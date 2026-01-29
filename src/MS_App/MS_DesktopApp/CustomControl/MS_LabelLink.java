package MS_App.MS_DesktopApp.CustomControl;

import javax.swing.ImageIcon;

import MS_Infrastructure.MS_AppStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MS_LabelLink extends MS_Label implements MouseListener {

    MS_LabelLink(String text) {
        super(text);
        setPersonalizacion();
    }

    MS_LabelLink(String text, String iconPath) {
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }

    void setPersonalizacion() {
        addMouseListener(this);
        setOpaque(false);
        setForeground(MS_AppStyle.COLOR_FONT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // code
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(MS_AppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(MS_AppStyle.CURSOR_DEFAULT);
    }
}
