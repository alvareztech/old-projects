/*
 * Main.fx
 *
 * Created on 02-11-2010, 04:41:51 PM
 */

package ejemploanimacion;

/**
 * @author Daniel
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def button: javafx.scene.control.Button = javafx.scene.control.Button {
        layoutX: 405.0
        layoutY: 13.0
        text: "Button"
        action: buttonAction
    }
    
    public-read def color: javafx.scene.paint.Color = javafx.scene.paint.Color {
    }
    
    public-read def color2: javafx.scene.paint.Color = javafx.scene.paint.Color {
        green: 0.6
    }
    
    public-read def innerShadow: javafx.scene.effect.InnerShadow = javafx.scene.effect.InnerShadow {
        radius: 14.0
    }
    
    public-read def circle: javafx.scene.shape.Circle = javafx.scene.shape.Circle {
        layoutX: 51.0
        layoutY: 45.0
        effect: innerShadow
        fill: color2
        radius: 25.0
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 480.0
        height: 320.0
        content: getDesignRootNodes ()
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "estado1", "estado2", "estado3", "estado4", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            circle.layoutX = 51.0;
                            circle.layoutY = 45.0;
                            circle.translateX = 0.0;
                            circle.radius = 25.0;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            circle.layoutX => circle.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            circle.layoutY => circle.layoutY tween javafx.animation.Interpolator.DISCRETE,
                            circle.translateX => circle.translateX tween javafx.animation.Interpolator.DISCRETE,
                            circle.radius => circle.radius tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 500ms
                        values: [
                            circle.layoutX => 320.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.layoutY => 65.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.translateX => 0.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.radius => 40.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            circle.layoutX => circle.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            circle.layoutY => circle.layoutY tween javafx.animation.Interpolator.DISCRETE,
                            circle.translateX => circle.translateX tween javafx.animation.Interpolator.DISCRETE,
                            circle.radius => circle.radius tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 500ms
                        values: [
                            circle.layoutX => 110.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.layoutY => 234.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.translateX => 0.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.radius => 25.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            circle.layoutX => circle.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            circle.layoutY => circle.layoutY tween javafx.animation.Interpolator.DISCRETE,
                            circle.translateX => circle.translateX tween javafx.animation.Interpolator.DISCRETE,
                            circle.radius => circle.radius tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 500ms
                        values: [
                            circle.layoutX => 317.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.layoutY => 243.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.translateX => 0.0 tween javafx.animation.Interpolator.LINEAR,
                            circle.radius => 10.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
        ]
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ circle, button, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

    function buttonAction(): Void {
        currentState.nextWrapped();
         }

    function buttonActionAtestado1(): Void {
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
