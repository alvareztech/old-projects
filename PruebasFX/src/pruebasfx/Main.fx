package pruebasfx;

import javafx.stage.*;
import javafx.scene.*;
import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

var radio = 0;
var radio2 = 0;
var opacidad = 0;

Stage {
    style: StageStyle.TRANSPARENT
    scene: Scene {
        fill: null
        width: 400
        height: 400
        content: [
            Circle {
                centerX: 200
                centerY: 200
                radius: bind radio
                fill: Color.GREEN
            }
            Circle {
                centerX: 200
                centerY: 200
                radius: bind radio2
                fill: Color.YELLOWGREEN
            }
            Text {
                x: 40
                y: 200
                content: "SoloInformaticaYAlgoMas.blogspot.com"
                opacity: bind opacidad
                font: Font {
                    size: 20
                }
            }
        ]
    }
}
var animacion = Timeline {
            keyFrames: [
                KeyFrame { time: 1s values: radio => 150 tween Interpolator.EASEBOTH },
                KeyFrame { time: 2s values: radio2 => 200 tween Interpolator.EASEBOTH },
                KeyFrame { time: 2s values: opacidad => 1 },
            ]
            autoReverse: true
            repeatCount: Timeline.INDEFINITE
        };

animacion.play()
