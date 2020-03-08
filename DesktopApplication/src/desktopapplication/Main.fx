/*
 * Main.fx
 *
 * Created on 28-09-2010, 07:48:10 AM
 */

package desktopapplication;

/**
 * @author Daniel
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def circle: javafx.scene.shape.Circle = javafx.scene.shape.Circle {
        disable: false
        opacity: 0.47
        layoutX: 129.0
        layoutY: 20.0
        fill: javafx.scene.paint.Color.WHITE
        stroke: javafx.scene.paint.Color.BLACK
        radius: 25.0
    }
    
    public-read def polygon: javafx.scene.shape.Polygon = javafx.scene.shape.Polygon {
        layoutX: 208.0
        layoutY: 65.0
        points: [ 0.0, 0.0, 20.0, 10.0, 10.0, 20.0, ]
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 480.0
        height: 320.0
        content: getDesignRootNodes ()
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ circle, polygon, ]
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
