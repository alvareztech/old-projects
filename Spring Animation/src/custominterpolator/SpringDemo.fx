/* 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms. 
 * 
 * This file is available and licensed under the following license:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 *
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *   * Neither the name of Sun Microsystems nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package custominterpolator;

import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.animation.*;
// create the spring interpolator
def spring = SpringInterpolator { bounce: false};
// create a spring interpolator with bounce turned on
def bounce = SpringInterpolator { bounce: true};
// width and height are updated when the screen is rotated
var width:Number = bind scene.width;
var height:Number = bind scene.height on replace {
    println("width = {width} {height}");
    createAnims();
}
// animate the y value using the spring interpolator
var springAnimY:Number;
var springAnim:Timeline;
var bounceAnimY:Number;
var bounceAnim:Timeline;

// bind the to the springAnimY variable which will animate it
var springImage = ImageView {
    translateX: bind width/2 - 95
    translateY: bind springAnimY;
    image:Image { url: "{__DIR__}image/ball.png" }
    onMousePressed:function(e:MouseEvent) {
        springAnim.time = 0s;
        springAnim.playFromStart();
    }
};
// bind the to the bounceAnimY variable which will animate it
var bounceImage = ImageView {
    translateX: bind width/2 + 5
    translateY: bind bounceAnimY;
    image:Image { url: "{__DIR__}image/ball.png" }
    onMousePressed:function(e:MouseEvent) {
        bounceAnim.time = 0s;
        bounceAnim.play();
    }
};


// this function is called to reinitialize the values when the height changes
function createAnims() {
    springAnimY = height - 100;
    springAnim = Timeline {
       keyFrames: [
           at(1s) { springAnimY => 50 },
           at(2.5s) { springAnimY => height-100.0 tween spring}
       ]
    };
    bounceAnimY = height-100;
    bounceAnim = Timeline {
        keyFrames: [
            at(1s) { bounceAnimY => 50 },
            at(2.5s) { bounceAnimY => height-100.0 tween bounce}
        ]
    };
}

createAnims();

var description:Text = Text {
    content: "Spring vs. Bounce Interpolator"
    //textAlignment: TextAlignment.CENTER
    font:Font {
        size: 12
    }
    fill: Color.WHITE
    y: 20
    //translateX: bind (width-description.boundsInParent.width)/2
    // josh: commented out until http://javafx-jira.kenai.com/browse/MOBL-138 is fixed
    translateX: bind (width-150)/2
}


class SButton extends Group {
    public-init var image:String;
    public var selected = false;

    var imageView = ImageView {
        translateX: 1
        translateY: 1
        image:Image { url: image }
    }

    override var content = bind [ imageView ]
};

var springButton:SButton = SButton {
    translateX: bind width/2 - 80
    translateY: bind height - 40
    image: "{__DIR__}image/springButton.png"
    onMousePressed:function(e:MouseEvent) {
        springAnim.time = 0s;
        springAnim.playFromStart();
    }
    onKeyPressed:function(e:KeyEvent):Void {
        if(e.code == KeyCode.VK_LEFT or e.code == KeyCode.VK_SOFTKEY_0) {
            springAnim.playFromStart();
        }
        if(e.code == KeyCode.VK_RIGHT or e.code == KeyCode.VK_SOFTKEY_1) {
            bounceAnim.playFromStart();
        }
    }
};

var bounceButton:SButton = SButton {
    translateX: bind width/2 + 20
    translateY: bind height - 40
    image: "{__DIR__}image/bounceButton.png"
    onMousePressed:function(e:MouseEvent) {
        bounceAnim.time = 0s;
        bounceAnim.playFromStart();
    }
}

var bounceDescription:Text = Text {
    content: "Bounce\nInterpolator"
    textAlignment: TextAlignment.CENTER
    font:Font {
        size: 16
    }
    fill: Color.WHITE
    x: 130
    y: 20
};

var scene:Scene = Scene {
    fill: Color.rgb(62, 0, 85)
    content: [
        description,
        springButton,
        bounceButton,
        springImage,
        bounceImage,
        Line {
            startX: 0 endX: bind width
            startY: bind height-50 endY: bind height-50
            stroke: Color.GRAY
        },
    ]
};


springButton.requestFocus();
// put everything together in a stage
Stage {
    title: "Spring Animation"
    visible: true
    width: 240
    height: 320
    scene: scene
}
