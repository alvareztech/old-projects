
package animationduke;

import javafx.animation.transition.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TranslateSample extends Sample {

    public override var node = ImageView {
        translateX: 50
        translateY: 50
        image: Image {
            url: "{__DIR__}images/duke.jpg"
        }
    };

    var translateTransition = TranslateTransition {
        duration: 2s
        node: node
        fromX: 0
        toX: 100
        repeatCount: 2
        autoReverse: true
    };

    public override function play() : Void {
        translateTransition.play();
    }
}