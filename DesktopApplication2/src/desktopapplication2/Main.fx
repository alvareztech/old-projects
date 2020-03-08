/*
 * Main.fx
 *
 * Created on 29-10-2010, 08:16:10 PM
 */

package desktopapplication2;

/**
 * @author Daniel
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def button: javafx.scene.control.Button = javafx.scene.control.Button {
        layoutX: 148.0
        layoutY: 39.0
        text: "Button"
    }
    
    public-read def choiceBox: javafx.scene.control.ChoiceBox = javafx.scene.control.ChoiceBox {
        layoutX: 307.0
        layoutY: 47.0
        items: [ "La Paz", "Oruro", "Potosi", "Santa Cruz", "Cochabamba", ]
    }
    
    public-read def progressIndicator: javafx.scene.control.ProgressIndicator = javafx.scene.control.ProgressIndicator {
        layoutX: 293.0
        layoutY: 99.0
    }
    
    public-read def textBox: javafx.scene.control.TextBox = javafx.scene.control.TextBox {
        layoutX: 46.0
        layoutY: 32.0
    }
    
    public-read def button2: javafx.scene.control.Button = javafx.scene.control.Button {
        text: "Button"
    }
    
    def __layoutInfo_toolBar: javafx.scene.layout.LayoutInfo = javafx.scene.layout.LayoutInfo {
        width: 337.0
        height: 20.0
    }
    public-read def toolBar: com.javafx.preview.control.ToolBar = com.javafx.preview.control.ToolBar {
        layoutX: 0.0
        layoutY: 0.0
        layoutInfo: __layoutInfo_toolBar
        items: [ button2, ]
    }
    
    public-read def toggleButton: javafx.scene.control.ToggleButton = javafx.scene.control.ToggleButton {
        layoutX: 116.0
        layoutY: 106.0
        text: "Toggle Button"
    }
    
    public-read def listView: javafx.scene.control.ListView = javafx.scene.control.ListView {
        layoutX: 201.0
        layoutY: 159.0
        items: [ "Item 1", "Item 2", "Item 3", ]
    }
    
    public-read def listCell: javafx.scene.control.ListCell = javafx.scene.control.ListCell {
        layoutX: 55.0
        layoutY: 170.0
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 480.0
        height: 320.0
        content: getDesignRootNodes ()
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "New State 1", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        values: [
                            button.layoutX => button.layoutX tween javafx.animation.Interpolator.DISCRETE,
                            button.layoutY => button.layoutY tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                    javafx.animation.KeyFrame {
                        time: 1000ms
                        values: [
                            button.layoutX => 34.0 tween javafx.animation.Interpolator.DISCRETE,
                            button.layoutY => 53.0 tween javafx.animation.Interpolator.DISCRETE,
                        ]
                    }
                ]
            }
        ]
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ button, choiceBox, progressIndicator, textBox, toolBar, toggleButton, listView, listCell, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

}

function run (): Void {
    var design = Main {};

    javafx.stage.Stage {
        title: "Main"
        scene: design.getDesignScene ()
    }
}
