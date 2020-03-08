/*
 * Copyright (c) 2009, Sun Microsystems, Inc.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in 
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Sun Microsystems, Inc. nor the names of its 
 *    contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
 
package hello;
 
public class Hello {
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def label: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "Hello"
    }
    
    public-read def label2: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "World"
    }
    
    public-read def label3: javafx.scene.control.Label = javafx.scene.control.Label {
        opacity: 0.0
        text: "Hello"
    }
    
    public-read def hbox: javafx.scene.layout.HBox = javafx.scene.layout.HBox {
        layoutX: 27.0
        layoutY: 21.0
        onMouseEntered: hboxOnMouseEntered
        onMouseExited: hboxOnMouseExited
        translateY: -50.0
        pickOnBounds: true
        content: [ label, label2, label3, ]
        spacing: 6.0
    }
    
    public-read def button: javafx.scene.control.Button = javafx.scene.control.Button {
        text: "Back"
        action: buttonAction
    }
    
    public-read def button2: javafx.scene.control.Button = javafx.scene.control.Button {
        text: "Rotate"
        action: button2Action
    }
    
    public-read def hbox2: javafx.scene.layout.HBox = javafx.scene.layout.HBox {
        layoutX: 27.0
        layoutY: 163.0
        content: [ button, button2, ]
        spacing: 6.0
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 173.0
        height: 220.0
        content: getDesignRootNodes ()
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "Init", "Show", "Rotate", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            label.opacity => label.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label.rotate => label.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label2.rotate => label2.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label3.opacity => label3.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label3.rotate => label3.rotate tween javafx.animation.Interpolator.DISCRETE,
                            hbox.translateY => hbox.translateY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            button.disable = true;
                            button2.text = "Show";
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 800ms
                        values: [
                            label.opacity => 1.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label2.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.opacity => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            hbox.translateY => -50.0 tween javafx.animation.Interpolator.EASEBOTH,
                        ]
                        action: function() {
                            button2.disable = false;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            label.opacity => label.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label.rotate => label.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label2.rotate => label2.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label3.opacity => label3.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label3.rotate => label3.rotate tween javafx.animation.Interpolator.DISCRETE,
                            hbox.translateY => hbox.translateY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 800ms
                        values: [
                            label.opacity => 1.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label2.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.opacity => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.rotate => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            hbox.translateY => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                        ]
                        action: function() {
                            button.disable = false;
                            button2.disable = false;
                            button2.text = "Rotate";
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            label.opacity => label.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label.rotate => label.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label2.rotate => label2.rotate tween javafx.animation.Interpolator.DISCRETE,
                            label3.opacity => label3.opacity tween javafx.animation.Interpolator.DISCRETE,
                            label3.rotate => label3.rotate tween javafx.animation.Interpolator.DISCRETE,
                            hbox.translateY => hbox.translateY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            button2.disable = true;
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 800ms
                        values: [
                            label.opacity => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label.rotate => 180.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label2.rotate => 180.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.opacity => 1.0 tween javafx.animation.Interpolator.EASEBOTH,
                            label3.rotate => 180.0 tween javafx.animation.Interpolator.EASEBOTH,
                            hbox.translateY => 0.0 tween javafx.animation.Interpolator.EASEBOTH,
                        ]
                        action: function() {
                            button.disable = false;
                            button2.text = "Rotate";
                        }
                    }
                ]
            }
        ]
    }
    
    public-read def zoomState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "Regular", "Zoomed", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            hbox.scaleX => hbox.scaleX tween javafx.animation.Interpolator.DISCRETE,
                            hbox.scaleY => hbox.scaleY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 100ms
                        values: [
                            hbox.scaleX => 1.0 tween javafx.animation.Interpolator.LINEAR,
                            hbox.scaleY => 1.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            hbox.scaleX => hbox.scaleX tween javafx.animation.Interpolator.DISCRETE,
                            hbox.scaleY => hbox.scaleY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 100ms
                        values: [
                            hbox.scaleX => 1.5 tween javafx.animation.Interpolator.LINEAR,
                            hbox.scaleY => 1.5 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
        ]
    }
    
    init {
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ hbox, hbox2, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

    function buttonAction (): Void {
        currentState.previous();
    }

    function button2Action (): Void {
        currentState.next();
    }

    function hboxOnMouseEntered(event: javafx.scene.input.MouseEvent): Void {
        zoomState.actual = 1;
    }

    function hboxOnMouseExited(event: javafx.scene.input.MouseEvent): Void {
        zoomState.actual = 0;
    }

}

function run (): Void {
    var design = Hello {};

    javafx.stage.Stage {
        title: "Hello"
        scene: design.getDesignScene()
    }
}
