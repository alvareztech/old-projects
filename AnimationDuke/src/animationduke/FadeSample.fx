
package animationduke;

import javafx.animation.transition.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FadeSample extends Sample {

    public override var node = ImageView {
        translateX: 50
        translateY: 50
        image: Image {
            url: "{__DIR__}images/duke.jpg"
        }
    }

    var fadeTransition = FadeTransition {
        duration: 2s
        node: node
        fromValue: 1.0
        toValue: 0.1
        repeatCount: 2
        autoReverse: true
    }
    
    public override function play() : Void {
        fadeTransition.play();
    }
}