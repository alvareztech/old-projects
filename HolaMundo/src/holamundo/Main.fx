/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package holamundo;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author Daniel
 */

Stage {
    title: "SoloInformaticaYAlgoMas.blogspot.com"
    scene: Scene {
        width: 350
        height: 50
        content: [
            Text {
                font : Font {
                    size : 20
                }
                x: 10
                y: 30
                content: "Hola Mundo!"
            }
        ]
    }
}