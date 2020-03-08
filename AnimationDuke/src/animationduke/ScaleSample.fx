
package animationduke;

import javafx.animation.transition.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ScaleSample extends Sample {

    public override var node = ImageView {
        translateX: 50
        translateY: 50
        image: Image {
            url: "{__DIR__}images/duke.jpg"
        }
    };

    var scaleTransition = ScaleTransition {
        duration: 2s
        node: node
        fromX: 1.0
        toX: 0.5
        fromY: 1.0
        toY: 0.5
        repeatCount: 2
        autoReverse: true
    };

    public override function play() : Void {
        scaleTransition.play();
    }
}