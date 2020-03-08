/*
 * Main.fx
 *
 * Created on 02-11-2010, 07:27:40 PM
 */

package ordenacionburbujafx;

/**
 * @author Daniel
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def rectangle: javafx.scene.shape.Rectangle = javafx.scene.shape.Rectangle {
        layoutX: 56.0
        layoutY: 166.0
        width: 10.0
        height: 100.0
    }
    
    public-read def color: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 1.0
    }
    
    public-read def rectangle2: javafx.scene.shape.Rectangle = javafx.scene.shape.Rectangle {
        layoutX: 72.0
        layoutY: 175.0
        fill: color
        width: 10.0
        height: 90.0
    }
    
    public-read def color2: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 1.0
        green: 0.4
    }
    
    public-read def rectangle3: javafx.scene.shape.Rectangle = javafx.scene.shape.Rectangle {
        layoutX: 88.0
        layoutY: 185.0
        fill: color2
        width: 10.0
        height: 80.0
    }
    
    public-read def color3: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 1.0
        green: 1.0
    }
    
    public-read def rectangle4: javafx.scene.shape.Rectangle = javafx.scene.shape.Rectangle {
        layoutX: 103.0
        layoutY: 197.0
        fill: color3
        width: 10.0
        height: 70.0
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 480.0
        height: 320.0
        content: getDesignRootNodes ()
    }
    
    public-read def linearGradient: javafx.scene.paint.LinearGradient = javafx.scene.paint.LinearGradient {
        stops: [ javafx.scene.paint.Stop { offset: 0.0, color: javafx.scene.paint.Color.web ("#FFFFFF") }, javafx.scene.paint.Stop { offset: 1.0, color: javafx.scene.paint.Color.web ("#000000") }, ]
    }
    
    public-read def bloom: javafx.scene.effect.Bloom = javafx.scene.effect.Bloom {
    }
    
    public-read def dropShadow: javafx.scene.effect.DropShadow = javafx.scene.effect.DropShadow {
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ rectangle, rectangle2, rectangle3, rectangle4, ]
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
