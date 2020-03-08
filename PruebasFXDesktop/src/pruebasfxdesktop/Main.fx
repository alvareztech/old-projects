/*
 * Main.fx
 *
 * Created on 29-10-2010, 10:41:26 PM
 */

package pruebasfxdesktop;

/**
 * @author Daniel
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def label: javafx.scene.control.Label = javafx.scene.control.Label {
        layoutX: 97.0
        layoutY: 49.0
        text: "Master Estado"
    }
    
    public-read def button: javafx.scene.control.Button = javafx.scene.control.Button {
        layoutX: 193.0
        layoutY: 115.0
        text: "Siguiente Estado"
        action: buttonAction
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 600.0
        height: 400.0
        content: getDesignRootNodes ()
        camera: null
        cursor: javafx.scene.Cursor.HAND
        fill: null
    }
    
    public-read def color: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 1.0
    }
    
    public-read def color2: javafx.scene.paint.Color = javafx.scene.paint.Color {
        blue: 1.0
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "Red", "Blue", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            label.scaleX => label.scaleX tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            label.text = "Estado Red";
                            label.textFill = color;
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 500ms
                        values: [
                            label.scaleX => 1.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            label.scaleX => label.scaleX tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            label.text = "Estado Azul";
                            label.textFill = color2;
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 500ms
                        values: [
                            label.scaleX => 1.5 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
        ]
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ label, button, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

    function buttonAction(): Void {
        currentState.nextWrapped();
         }

    function buttonActionAtEmpezar(): Void {
        currentState.nextWrapped();
         }

    function buttonActionAtEstado1(): Void {
        currentState.nextWrapped();
         }

}

function run (): Void {
    var design = Main {};

    javafx.stage.Stage {
        title: "Main"
        scene: design.getDesignScene ()
    }
}
