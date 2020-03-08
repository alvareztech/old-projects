package org.yourorghere;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Raton extends JApplet implements MouseListener,
		MouseMotionListener {
	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	JTextField text5;
	JLabel label;
	private int xPos, yPos;

	public void init() {
		text1 = new JTextField(35);
		text2 = new JTextField(35);
		text3 = new JTextField(35);
		text4 = new JTextField(35);
		text5 = new JTextField(35);
		label = new JLabel("pasame por encima.");
		JPanel miPanel = new JPanel();
		miPanel.add(text1);
		miPanel.add(text2);
		miPanel.add(text3);
		miPanel.add(text4);
		miPanel.add(text5);
		miPanel.add(label);
		add(miPanel);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// dibujar objeto String en la ubicación donde se hizo clic con el ratón
	public void paint(Graphics g) {
		// llamar al método paint de la superclase
		super.paint(g);

		g.drawString("Se hizo clic en: [" + xPos + ", " + yPos + "]", xPos,
				yPos);
	}

	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
			text1.setText("Botón izquierdo del ratón apretado en " + e.getX()
					+ "," + e.getY());
		} else if ((e.getModifiers() & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK) {
			text1.setText("Botón central del ratón apretado en " + e.getX()
					+ "," + e.getY());
		} else {
			text1.setText("Botón derecho del ratón apretado en " + e.getX()
					+ "," + e.getY());
		}
	}

	public void mouseClicked(MouseEvent e) {
		xPos = e.getX();
		yPos = e.getY();
		String texto = "Se hizo clic " + e.getClickCount() + " Veces";
		if (e.isMetaDown()) // botón derecho del ratón
			texto += " con el botón derecho del ratón";
		else if (e.isAltDown()) // botón de en medio del ratón
			texto += " con el botón central del ratón";
		else
			// botón izquierdo del ratón
			texto += " con el botón izquierdo del ratón";
		text2.setText(texto);
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		text3.setText("Se soltó el botón del ratón.");
	}

	public void mouseEntered(MouseEvent e) {
		label.setText("estás encima de mí");
	}

	public void mouseExited(MouseEvent e) {
		label.setText("estás fuera de mí");
	}

	public void mouseDragged(MouseEvent e) {
		text4.setText("Se arrastó el ratón.");
	}

	public void mouseMoved(MouseEvent e) {
		text5.setText("Se movió el ratón.");
	}
}
