package a3d;

import javax.swing.JLabel;

public class Animacion extends Thread {

    JLabel imagenAnimacion;
    String color;

    public Animacion(String str, JLabel imagenAnimacion) {
        color = str;
        this.imagenAnimacion = imagenAnimacion;

    }

    public void run() {
        int c = 1;
        while (true) {
            try {
                if (c == 1) {
                    if (color.equals("rojo")) {
                        imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/rojo1.png"))); // NOI18N        
                    }
                    if (color.equals("amarillo")) {
                        imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/amarillo1.png"))); // NOI18N        
                    }
                    if (color.equals("verde")) {
                        imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/verde1.png"))); // NOI18N        
                    }
                    c = 2;
                } else {
                    if (c == 2) {
                        if (color.equals("rojo")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/rojo2.png"))); // NOI18N        
                        }
                        if (color.equals("amarillo")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/amarillo2.png"))); // NOI18N        
                        }
                        if (color.equals("verde")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/verde2.png"))); // NOI18N        
                        }
                        c = 3;
                    } else {
                        if (color.equals("rojo")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/rojo3.png"))); // NOI18N        
                        }
                        if (color.equals("amarillo")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/amarillo3.png"))); // NOI18N        
                        }
                        if (color.equals("verde")) {
                            imagenAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a3d/verde3.png"))); // NOI18N        
                        }
                        c = 1;
                    }
                }

                sleep(300);




            } catch (InterruptedException e) {
            }
        }

    }
}