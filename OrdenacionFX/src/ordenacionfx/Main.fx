package ordenacionfx;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.scene.shape.Line;
import javafx.scene.effect.Reflection;

/**
 * @author Daniel
 */
def circulo: Circle = Circle {
            centerX: 40
            centerY: 70
            radius: 25
            fill: Color.AQUAMARINE
        }
def linea1: Line = Line {
            startX: 50, startY: 50
            endX: 50, endY: 100
            strokeWidth: 10
            stroke: Color.BLACK
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea2: Line = Line {
            startX: 70, startY: 30
            endX: 70, endY: 100
            strokeWidth: 10
            stroke: Color.RED
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea3: Line = Line {
            startX: 90, startY: 40
            endX: 90, endY: 100
            strokeWidth: 10
            stroke: Color.YELLOW
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea4: Line = Line {
            startX: 110, startY: 70
            endX: 110, endY: 100
            strokeWidth: 10
            stroke: Color.GREEN
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea5: Line = Line {
            startX: 130, startY: 20
            endX: 130, endY: 100
            strokeWidth: 10
            stroke: Color.BLUE
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea6: Line = Line {
            startX: 150, startY: 60
            endX: 150, endY: 100
            strokeWidth: 10
            stroke: Color.BLUEVIOLET
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea7: Line = Line {
            startX: 170, startY: 10
            endX: 170, endY: 100
            strokeWidth: 10
            stroke: Color.ORANGE
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }
def linea8: Line = Line {
            startX: 190, startY: 100
            endX: 190, endY: 100
            strokeWidth: 10
            stroke: Color.GREENYELLOW
            effect: Reflection {
                fraction: 0.75
                topOpacity: 0.5
            }
        }

Timeline {
    keyFrames: [
        at (0s) {circulo.translateX => 0.0}
        at (5s) {circulo.translateX => 165.0 tween Interpolator.LINEAR}
    ]
}.play();

Stage {
    title: "OrdenacionFX"
    width: 300
    height: 200
    scene: Scene {
        content: [circulo, linea1, linea2, linea3, linea4, linea5, linea6, linea7, linea8]
    }
}
