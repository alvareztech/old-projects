/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication4;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author Daniel
 */

Stage {
    title: "Mi primera aplicación JavaFX"
    scene: Scene {
        width: 280
        height: 50
        content: [
            Text {
                x: 100
                y: 30
                content: "Hola Mundo!"
            }
        ]
    }
}