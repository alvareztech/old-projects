package org.yourorghere;

// ICGFrame.java
// Frame used for ICG examples.

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;

class ICGFrame extends Frame {
	public ICGFrame(String title) {
		init(title, null);
	}

	public ICGFrame(String title, GLCanvas canvas) {
		init(title, canvas);
	}

	private void init(String title, GLCanvas canvas) {
		setTitle(title);
		setSize(512, 512);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		if (canvas != null) {
			add(canvas);
		}
	}

	// Mandatory definition to avoid a compiler warning.
	private static final long serialVersionUID = 1L;
}
