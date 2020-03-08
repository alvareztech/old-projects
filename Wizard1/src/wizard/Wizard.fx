/*
 * Copyright (c) 2010, Oracle
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
 *  * Neither the name of Oracle nor the names of its 
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
 
package wizard;

public class Wizard {
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def sidebarButton: javafx.scene.control.Button = javafx.scene.control.Button {
        layoutX: 26.0
        layoutY: 362.0
        action: sidebarButtonAction
    }
    
    public-read def previousButton: javafx.scene.control.Button = javafx.scene.control.Button {
        disable: true
        text: "Previous"
        action: previousButtonAction
    }
    
    public-read def nextButton: javafx.scene.control.Button = javafx.scene.control.Button {
        disable: true
        text: "Next"
        action: nextButtonAction
    }
    
    public-read def finishButton: javafx.scene.control.Button = javafx.scene.control.Button {
        disable: true
        text: "Finish"
        action: finishButtonAction
    }
    
    public-read def controls: javafx.scene.layout.HBox = javafx.scene.layout.HBox {
        layoutX: 404.0
        layoutY: 365.0
        content: [ previousButton, nextButton, finishButton, ]
        spacing: 6.0
    }
    
    public-read def label: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "Welcome to JavaFX & NetBeans installer"
    }
    
    public-read def label2: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "You can visit our sites:"
    }
    
    public-read def hyperlink: javafx.scene.control.Hyperlink = javafx.scene.control.Hyperlink {
        text: "http://www.javafx.com"
    }
    
    public-read def hyperlink2: javafx.scene.control.Hyperlink = javafx.scene.control.Hyperlink {
        text: "http://www.netbeans.org"
    }
    
    public-read def vbox: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        layoutX: 30.0
        content: [ hyperlink, hyperlink2, ]
    }
    
    public-read def welcomePage: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        visible: false
        content: [ label, label2, vbox, ]
        spacing: 12.0
    }
    
    public-read def label3: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "This is a text of NetBeans and JavaFX license"
    }
    
    public-read def youHaveToAgreeLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        visible: false
        layoutX: 5.0
        layoutY: 275.0
        text: "You have to agree to the license terms to continue"
    }
    
    public-read def agreeCheckbox: javafx.scene.control.CheckBox = javafx.scene.control.CheckBox {
        layoutX: 3.0
        layoutY: 250.0
        text: "I agree to the license "
    }
    
    public-read def licensePage: javafx.scene.layout.Panel = javafx.scene.layout.Panel {
        visible: false
        content: [ label3, youHaveToAgreeLabel, agreeCheckbox, ]
    }
    
    public-read def label4: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "Choose features to install:"
    }
    
    public-read def javafxCheckbox: javafx.scene.control.CheckBox = javafx.scene.control.CheckBox {
        disable: true
        layoutX: 20.0
        text: "JavaFX SDK"
        selected: true
    }
    
    public-read def javafxDocCheckbox: javafx.scene.control.CheckBox = javafx.scene.control.CheckBox {
        text: "JavaFX SDK Documentation"
    }
    
    public-read def netbeansCheckbox: javafx.scene.control.CheckBox = javafx.scene.control.CheckBox {
        text: "NetBeans IDE for JavaFX"
    }
    
    public-read def choosePage: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        visible: false
        content: [ label4, javafxCheckbox, javafxDocCheckbox, netbeansCheckbox, ]
        spacing: 6.0
    }
    
    public-read def label5: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "You have choosen these features:"
    }
    
    public-read def featuresLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        layoutX: 30.0
        text: ""
    }
    
    public-read def summaryPage: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        visible: false
        content: [ label5, featuresLabel, ]
        spacing: 6.0
    }
    
    public-read def pages: javafx.scene.layout.Panel = javafx.scene.layout.Panel {
        layoutX: 250.0
        layoutY: 34.0
        content: [ welcomePage, licensePage, choosePage, summaryPage, ]
    }
    
    public-read def image: javafx.scene.image.Image = javafx.scene.image.Image {
        url: "{__DIR__}resources/logo.png"
    }
    
    public-read def logo: javafx.scene.image.ImageView = javafx.scene.image.ImageView {
        image: image
    }
    
    public-read def sidebar: javafx.scene.layout.Panel = javafx.scene.layout.Panel {
        layoutX: 15.0
        layoutY: 34.0
        content: [ logo, ]
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 600.0
        height: 400.0
        content: getDesignRootNodes ()
    }
    
    public-read def wizardPage: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "Welcome", "License", "Choose", "Summary", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            previousButton.disable = true;
                            nextButton.disable = false;
                            nextButton.action = nextButtonAction;
                            finishButton.disable = true;
                            welcomePage.visible = true;
                            licensePage.visible = false;
                            choosePage.visible = false;
                            summaryPage.visible = false;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            previousButton.disable = false;
                            nextButton.disable = false;
                            nextButton.action = nextButtonActionAtLicense;
                            finishButton.disable = true;
                            welcomePage.visible = false;
                            licensePage.visible = true;
                            choosePage.visible = false;
                            summaryPage.visible = false;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            previousButton.disable = false;
                            nextButton.disable = false;
                            nextButton.action = nextButtonActionAtChoose;
                            finishButton.disable = true;
                            welcomePage.visible = false;
                            licensePage.visible = false;
                            choosePage.visible = true;
                            summaryPage.visible = false;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            previousButton.disable = false;
                            nextButton.disable = true;
                            nextButton.action = nextButtonAction;
                            finishButton.disable = false;
                            welcomePage.visible = false;
                            licensePage.visible = false;
                            choosePage.visible = false;
                            summaryPage.visible = true;
                        }
                    }
                ]
            }
        ]
    }
    
    public-read def sidebarState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "Shown", "Hidden", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            sidebar.opacity => sidebar.opacity tween javafx.animation.Interpolator.DISCRETE,
                            sidebar.layoutX => sidebar.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            pages.layoutX => pages.layoutX tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            sidebarButton.text = "Hide Sidebar";
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 1000ms
                        values: [
                            sidebar.opacity => 1.0 tween javafx.animation.Interpolator.EASEIN,
                            sidebar.layoutX => 15.0 tween javafx.animation.Interpolator.EASEIN,
                            pages.layoutX => 250.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            sidebar.opacity => sidebar.opacity tween javafx.animation.Interpolator.DISCRETE,
                            sidebar.layoutX => sidebar.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            pages.layoutX => pages.layoutX tween javafx.animation.Interpolator.DISCRETE,
                        ]
                        action: function() {
                            sidebarButton.text = "Show Sidebar";
                        }
                    }
                    javafx.animation.KeyFrame {
                        time: 1000ms
                        values: [
                            sidebar.opacity => 0.0 tween javafx.animation.Interpolator.EASEOUT,
                            sidebar.layoutX => -250.0 tween javafx.animation.Interpolator.EASEOUT,
                            pages.layoutX => 30.0 tween javafx.animation.Interpolator.LINEAR,
                        ]
                    }
                ]
            }
        ]
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ sidebarButton, sidebar, controls, pages, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

    function sidebarButtonAction(): Void {
        sidebarState.nextWrapped ();
    }

    function previousButtonAction (): Void {
        wizardPage.previous();
    }

    function nextButtonAction (): Void {
        wizardPage.next();
    }

    function nextButtonActionAtChoose (): Void {
        var text = "JavaFX SDK";
        if (javafxDocCheckbox.selected) {
            text = "{text}, Documentation";
        }
        if (netbeansCheckbox.selected) {
            text = "{text}, NetBeans IDE";
        }
        featuresLabel.text = text;
        wizardPage.next();
    }

    function nextButtonActionAtLicense (): Void {
        if (agreeCheckbox.selected) {
            wizardPage.next();
        } else {
            youHaveToAgreeLabel.visible = true;
        }
    }

    function finishButtonAction (): Void {
        javafx.stage.Alert.inform ("Installation completed.");
        javafx.lang.FX.exit ();
    }

}

function run (): Void {
    var design = Wizard {};

    javafx.stage.Stage {
        title: "Software Installation Wizard"
        scene: design.getDesignScene ()
    }
}
