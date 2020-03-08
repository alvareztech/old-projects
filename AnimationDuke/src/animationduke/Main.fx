
/*
 * Main.fx
 *
 * Created on 23 Apr, 2009, 12:07:35 PM
 */

package animationduke;

import animationduke.FadeSample;
import animationduke.RotateSample;
import animationduke.ScaleSample;
import animationduke.TranslateSample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Rakesh Menon
 */

var node : Node;
var sample : Sample[] = [
    FadeSample { },
    RotateSample { },
    ScaleSample { },
    TranslateSample { }
];
var index = 0;

var timeline = Timeline {
    
    repeatCount: Timeline.INDEFINITE

    keyFrames: [
        KeyFrame {
            time: 4s
            action: function() {
                node = sample[index].node;
                sample[index].play();
                index++;
                if(index >= (sizeof sample)) {
                    index = 0;
                }
            }
        }
    ]
};

Stage {
    title: "Animation"
    scene: Scene {
        width: 200
        height: 200
        content: bind node
    }
    resizable: true
}

timeline.play();