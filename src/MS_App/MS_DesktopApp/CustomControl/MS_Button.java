package MS_App.MS_DesktopApp.CustomControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import MS_Infrastructure.MS_AppStyle;

import javax.swing.ImageIcon;

public class MS_Button extends JButton implements MouseListener {
    public MS_Button(String text) {
        customizeComponent(text);
    }

    public MS_Button(String text, String iconPath) {
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath) {
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20);
        setIcon(new ImageIcon(iconPath));
        setFont(MS_AppStyle.FONT);
    }

    public void customizeComponent(String text) {
        setText(text);
        addMouseListener(this);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(MS_AppStyle.COLOR_FONT);
        setHorizontalAlignment(MS_AppStyle.ALIGNMENT_LEFT);
        setFont(MS_AppStyle.FONT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(MS_AppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(MS_AppStyle.CURSOR_DEFAULT);
    }
}
