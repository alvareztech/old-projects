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

	// dibujar objeto String en la ubicaci�n donde se hizo clic con el rat�n
	public void paint(Graphics g) {
		// llamar al m�todo paint de la superclase
		super.paint(g);

		g.drawString("Se hizo clic en: [" + xPos + ", " + yPos + "]", xPos,
				yPos);
	}

	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
			text1.setText("Bot�n izquierdo del rat�n apretado en " + e.getX()
					+ "," + e.getY());
		} else if ((e.getModifiers() & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK) {
			text1.setText("Bot�n central del rat�n apretado en " + e.getX()
					+ "," + e.getY());
		} else {
			text1.setText("Bot�n derecho del rat�n apretado en " + e.getX()
					+ "," + e.getY());
		}
	}

	public void mouseClicked(MouseEvent e) {
		xPos = e.getX();
		yPos = e.getY();
		String texto = "Se hizo clic " + e.getClickCount() + " Veces";
		if (e.isMetaDown()) // bot�n derecho del rat�n
			texto += " con el bot�n derecho del rat�n";
		else if (e.isAltDown()) // bot�n de en medio del rat�n
			texto += " con el bot�n central del rat�n";
		else
			// bot�n izquierdo del rat�n
			texto += " con el bot�n izquierdo del rat�n";
		text2.setText(texto);
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		text3.setText("Se solt� el bot�n del rat�n.");
	}

	public void mouseEntered(MouseEvent e) {
		label.setText("est�s encima de m�");
	}

	public void mouseExited(MouseEvent e) {
		label.setText("est�s fuera de m�");
	}

	public void mouseDragged(MouseEvent e) {
		text4.setText("Se arrast� el rat�n.");
	}

	public void mouseMoved(MouseEvent e) {
		text5.setText("Se movi� el rat�n.");
	}
}
