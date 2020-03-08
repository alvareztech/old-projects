/*
 *      @(#)Morph3App.java 1.0 1.1 00/09/22 14:37
 *
 * Copyright (c) 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame; 
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

import java.util.Enumeration;

//   Morph3App renders a single ColorCube
//   that rotates when any key is pressed.

public class Morph3App extends Applet {

    public class MorphTangoBehavior extends Behavior{

        private Morph targetMorph;
        private Alpha alpha;
        // the following two members are here for effciency (no memory burn)
        private double[] weights = {0, 0, 0, 0}; 
        private WakeupCondition trigger = new WakeupOnElapsedFrames(0);

        // create MorphTangoBehavior
        MorphTangoBehavior(Morph targetMorph, Alpha alpha){
            this.targetMorph = targetMorph;
            this.alpha = alpha;
        }

        public void initialize(){
            // set initial wakeup condition
            this.wakeupOn(trigger);
        }

        public void processStimulus(Enumeration criteria){
            // don't need to decode event since there is only one trigger

            // do what is necessary
            weights[0] = 0;
            weights[1] = 0;
            weights[2] = 0;
            weights[3] = 0;
            double alphaValue = (double) alpha.value();
            weights[0] = alphaValue;
            weights[2] = 1.0 - alphaValue;

            targetMorph.setWeights(weights);
            // set next wakeup condition
            this.wakeupOn(trigger);
        }

    } // end of class MorphTangoBehavior

    public class MorphBrokenBehavior extends Behavior{

        private Morph targetMorph;
        private Alpha alpha;
        // the following two members are here for effciency (no memory burn)
        private double[] weights = {0, 0, 0, 0}; 
        private WakeupCondition trigger = new WakeupOnElapsedFrames(0);

        // create MorphBrokenBehavior
        MorphBrokenBehavior(Morph targetMorph, Alpha alpha){
            this.targetMorph = targetMorph;
            this.alpha = alpha;
        }

        public void initialize(){
            // set initial wakeup condition
            this.wakeupOn(trigger);
        }

        public void processStimulus(Enumeration criteria){
            // don't need to decode event since there is only one trigger

            // do what is necessary
            weights[0] =  1;
            weights[1] = -1;
            weights[2] =  1;
            weights[3] = -1;
            float alphaValue = 4f * alpha.value() - 0.00001f;
            int alphaIndex = (int) alphaValue;
            weights[alphaIndex] = (double) alphaValue - (double)alphaIndex;
            if(alphaIndex < 3)
                weights[alphaIndex + 1] = 1.0 - weights[alphaIndex];
            else
                weights[0] = 1.0 - weights[alphaIndex];

            targetMorph.setWeights(weights);
            // set next wakeup condition
            this.wakeupOn(trigger);
        }

    } // end of class MorphBrokenBehavior

    public class MorphInPlaceBehavior extends Behavior{

        private Morph targetMorph;
        private Alpha alpha;
        // the following two members are here for effciency (no memory burn)
        private double[] weights = {0, 0, 0, 0}; 
        private WakeupCondition trigger = new WakeupOnElapsedFrames(0);

        // create MorphInPlaceBehavior
        MorphInPlaceBehavior(Morph targetMorph, Alpha alpha){
            this.targetMorph = targetMorph;
            this.alpha = alpha;
        }

        public void initialize(){
            // set initial wakeup condition
            this.wakeupOn(trigger);
        }

        public void processStimulus(Enumeration criteria){
            // don't need to decode event since there is only one trigger

            // do what is necessary
            weights[0] = 0;
            weights[1] = 0;
            weights[2] = 0;
            weights[3] = 0;
            float alphaValue = 4f * alpha.value() - 0.00001f;
            int alphaIndex = (int) alphaValue;
            weights[alphaIndex] = (double) alphaValue - (double)alphaIndex;
            if(alphaIndex < 2)
                weights[alphaIndex + 2] = 1.0 - weights[alphaIndex];
            else
                weights[alphaIndex - 2] = 1.0 - weights[alphaIndex];

            targetMorph.setWeights(weights);
            // set next wakeup condition
            this.wakeupOn(trigger);
        }

    } // end of class MorphInPlaceBehavior

    public GeometryArray createGeomArray0(){
         int[] counts = {7, 5, 2};
         LineStripArray geom = new LineStripArray(14, GeometryArray.COORDINATES | GeometryArray.COLOR_3, counts);
         float[] coordinates = {  0.00f, 0.05f, 0f, -0.01f, 0.15f, 0f,  0.05f, 0.25f, 0f, 
                                  0.00f, 0.60f, 0f,
                                  0.01f, 0.30f, 0f,  0.04f, 0.00f, 0f,  0.09f, 0.00f, 0f,
                                  0.15f, 0.71f, 0f, -0.01f, 0.69f, 0f,
                                  0.06f, 1.10f, 0f,
                                 -0.05f, 0.75f, 0f,  0.14f, 0.75f, 0f,
                                  0.06f, 1.10f, 0f,  0.00f, 0.60f, 0f};
         geom.setCoordinates(0, coordinates);

//         not setting the colors is the same as setting them to black
//         Color3f c = new Color3f(0f, 0f, 0f);
//         for (int i = 0; i < 14; i++) geom.setColor(i, c);

         return geom;
    }

    public GeometryArray createGeomArray1(){
         int[] counts = {7, 5, 2};
         LineStripArray geom = new LineStripArray(14, GeometryArray.COORDINATES | GeometryArray.COLOR_3, counts);
         float[] coordinates = { -0.10f, 0.00f, 0f, -0.15f, 0.08f, 0f, -0.05f, 0.30f, 0f, 
                                  0.00f, 0.60f, 0f,
                                  0.15f, 0.30f, 0f,  0.10f, 0.00f, 0f,  0.15f, 0.05f, 0f,
                                  0.05f, 0.70f, 0f, -0.05f, 0.80f, 0f,
                                  0.06f, 1.10f, 0f,
                                  0.05f, 0.70f, 0f,  0.20f, 0.80f, 0f,
                                  0.06f, 1.10f, 0f,  0.00f, 0.60f, 0f};
         geom.setCoordinates(0, coordinates);

//         not setting the colors is the same as setting them to black
//         Color3f c = new Color3f(0f, 0f, 0f);
//         for (int i = 0; i < 14; i++) geom.setColor(i, c);

         return geom;
    }

    public GeometryArray createGeomArray2(){
         int[] counts = {7, 5, 2};
         LineStripArray geom = new LineStripArray(14, GeometryArray.COORDINATES | GeometryArray.COLOR_3, counts);
         float[] coordinates = {  0.09f, 0.00f, 0f,  0.04f, 0.00f, 0f,  0.01f, 0.30f, 0f,
                                  0.00f, 0.60f, 0f,
                                  0.05f, 0.25f, 0f, -0.01f, 0.15f, 0f,  0.00f, 0.05f, 0f, 
                                  0.14f, 0.75f, 0f, -0.05f, 0.75f, 0f,  
                                  0.06f, 1.10f, 0f,
                                 -0.01f, 0.69f, 0f,  0.15f, 0.71f, 0f, 
                                  0.06f, 1.10f, 0f,  0.00f, 0.60f, 0f};
         geom.setCoordinates(0, coordinates);

//         not setting the colors is the same as setting them to black
//         Color3f c = new Color3f(0f, 0f, 0f);
//         for (int i = 0; i < 14; i++) geom.setColor(i, c);

         return geom;
    }

    public GeometryArray createGeomArray3(){
         int[] counts = {7, 5, 2};
         LineStripArray geom = new LineStripArray(14, GeometryArray.COORDINATES | GeometryArray.COLOR_3, counts);
         float[] coordinates = {  0.15f, 0.05f, 0f,  0.10f, 0.00f, 0f,  0.15f, 0.30f, 0f,  
                                  0.00f, 0.60f, 0f,
                                 -0.05f, 0.30f, 0f, -0.15f, 0.08f, 0f, -0.10f, 0.00f, 0f, 
                                  0.20f, 0.80f, 0f,  0.05f, 0.70f, 0f,  
                                  0.06f, 1.10f, 0f,
                                 -0.05f, 0.80f, 0f,  0.05f, 0.70f, 0f, 
                                  0.06f, 1.10f, 0f,  0.00f, 0.60f, 0f};
         geom.setCoordinates(0, coordinates);

//         not setting the colors is the same as setting them to black
//         Color3f c = new Color3f(0f, 0f, 0f);
//         for (int i = 0; i < 14; i++) geom.setColor(i, c);

         return geom;
    }

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();

        Transform3D t3d = new Transform3D();
        t3d.set(new Vector3f(-0.5f, -0.5f, 0f));
        TransformGroup translateT = new TransformGroup(t3d);
        t3d.set(new Vector3f(   0f, -0.5f, 0f));
        TransformGroup translateIP = new TransformGroup(t3d);
        t3d.set(new Vector3f( 0.5f, -0.5f, 0f));
        TransformGroup translateB = new TransformGroup(t3d);

        // create GeometryArray[] (array of GeometryArray objects)
        GeometryArray[] geomArray = new GeometryArray[4];
        geomArray[0] = createGeomArray0();
        geomArray[1] = createGeomArray1();
        geomArray[2] = createGeomArray2();
        geomArray[3] = createGeomArray3();

        // create morph objects
        Morph morphTObj = new Morph(geomArray);
        morphTObj.setCapability(Morph.ALLOW_WEIGHTS_WRITE);
        Morph morphIPObj = new Morph(geomArray);
        morphIPObj.setCapability(Morph.ALLOW_WEIGHTS_WRITE);
        Morph morphBObj = new Morph(geomArray);
        morphBObj.setCapability(Morph.ALLOW_WEIGHTS_WRITE);

        // create alpha object
        Alpha alpha = new Alpha(-1, 1, 0, 0, 2000, 100, 0, 0, 0, 0);

        // create morph driving behavior
        MorphTangoBehavior morphTBehav = new MorphTangoBehavior(morphTObj, alpha);
        morphTBehav.setSchedulingBounds(new BoundingSphere());
        MorphInPlaceBehavior morphIPBehav = new MorphInPlaceBehavior(morphIPObj, alpha);
        morphIPBehav.setSchedulingBounds(new BoundingSphere());
        MorphBrokenBehavior morphBBehav = new MorphBrokenBehavior(morphBObj, alpha);
        morphBBehav.setSchedulingBounds(new BoundingSphere());

        //assemble scene graph
        objRoot.addChild(translateT);
        translateT.addChild(morphTObj);
        objRoot.addChild(morphTBehav);
        objRoot.addChild(translateIP);
        translateIP.addChild(morphIPObj);
        objRoot.addChild(morphIPBehav);
        objRoot.addChild(translateB);
        translateB.addChild(morphBObj);
        objRoot.addChild(morphBBehav);

        Background background = new Background();
        background.setColor(1f, 1f, 1f);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.addChild(background);

	// Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

	return objRoot;
    } // end of CreateSceneGraph method of Morph3App

    // Create a simple scene and attach it to the virtual universe

    public Morph3App() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config =
           SimpleUniverse.getPreferredConfiguration();

        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);

        BranchGroup scene = createSceneGraph();

        // SimpleUniverse is a Convenience Utility class
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);

	// This will move the ViewPlatform back a bit so the
	// objects in the scene can be viewed.
        simpleU.getViewingPlatform().setNominalViewingTransform();

        simpleU.addBranchGraph(scene);
    } // end of Morph3App (constructor)
    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        System.out.print("Morph3App.java \n- a demonstration of various animations");
        System.out.println("possible using the same key frames and a variety of behaviors.\nNot all are good ;-)\n");
        System.out.println("This is a simple example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new Morph3App(), 256, 256);
    } // end of main (method of Morph3App)

} // end of class Morph3App
