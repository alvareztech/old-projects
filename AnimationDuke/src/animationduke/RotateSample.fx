
package animationduke;

import javafx.animation.transition.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RotateSample extends Sample {

    public override var node = ImageView {
        translateX: 50
        translateY: 50
        image: Image {
            url: "{__DIR__}images/duke.jpg"
        }
    };

    var rotateTransition = RotateTransition {
        duration: 2s
        node: node
        fromAngle: 0
        toAngle: 360
        repeatCount: 2
        autoReverse: true
    };
    
    public override function play() : Void {
        rotateTransition.play();
    }
}