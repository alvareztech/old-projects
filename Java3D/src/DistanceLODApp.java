/*
 *      @(#)DistanceLODApp.java 1.1 00/09/22 14:37
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
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

//   DistanceLODApp renders a simple landscape

public class DistanceLODApp extends Applet {


    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere();

        // create target TransformGroup with Capabilities
        TransformGroup objMove = new TransformGroup();
        objMove.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        // create Alpha 
        Alpha alpha = new Alpha (-1,
                         Alpha.INCREASING_ENABLE + Alpha.DECREASING_ENABLE,
                         0, 0, 5000, 1000, 1000, 5000, 1000, 1000);

        // specify the axis of translation
        AxisAngle4f axisOfTra = new AxisAngle4f(0.0f,1.0f,0.0f,(float)Math.PI/-2.0f);
        Transform3D axisT3D = new Transform3D();
        axisT3D.set(axisOfTra);

        // create position interpolator
        PositionInterpolator posInt
           = new PositionInterpolator (alpha, objMove, axisT3D, 0.0f, -35.0f);
        posInt.setSchedulingBounds(bounds);

        // create DistanceLOD target object
        Switch targetSwitch = new Switch();
        targetSwitch.setCapability(Switch.ALLOW_SWITCH_WRITE);

        // add visual objects of various levels of detail to the target switch
        Appearance sphereAppearA = new Appearance();
        ColoringAttributes sphereCAa = new ColoringAttributes();
        sphereCAa.setColor(0.1f, 0.8f, 0.1f);
        sphereAppearA.setColoringAttributes(sphereCAa);

        Appearance sphereAppearB = new Appearance();
        ColoringAttributes sphereCAb = new ColoringAttributes();
        sphereCAb.setColor(0.8f, 0.1f, 0.1f);
        sphereAppearB.setColoringAttributes(sphereCAb);

        targetSwitch.addChild(new Sphere(.40f, 0, 25, sphereAppearA));
        targetSwitch.addChild(new Sphere(.40f, 0, 15, sphereAppearB));
        targetSwitch.addChild(new Sphere(.40f, 0, 10, sphereAppearA));
        targetSwitch.addChild(new Sphere(.40f, 0,  4, sphereAppearB));

        // create DistanceLOD object
        float[] distances = { 5.0f, 10.0f, 20.0f};
        DistanceLOD dLOD = new DistanceLOD(distances, new Point3f());
        dLOD.addSwitch(targetSwitch);
        dLOD.setSchedulingBounds(bounds);

        if((targetSwitch.numChildren()-1) != dLOD.numDistances()){
                System.out.println("DistanceLOD not initialized properly");
                System.out.println(targetSwitch.numChildren());
                System.out.println(dLOD.numDistances());
        }

        // assemble scene graph

        objRoot.addChild(objMove);     // target TG of position interp to move vo
        objRoot.addChild(posInt);      // add position interpolator
        objMove.addChild(dLOD);        // make the bounds move with visual object
        objMove.addChild(targetSwitch);// must add target switch to scene graph too


        // show a level 3 object up close for comparison
        Transform3D t3d = new Transform3D();
        t3d.set(new Vector3f(0.6f, 0.0f, 0.0f));
        TransformGroup tga = new TransformGroup(t3d);
        objRoot.addChild(tga);
        tga.addChild(new Sphere(.40f, 0,  4, sphereAppearB));

        // show a level 0 object at a distance for comparison
        t3d.set(new Vector3f(-5.0f, 0.0f, -35.0f));
        TransformGroup tgb = new TransformGroup(t3d);
        objRoot.addChild(tgb);
        tgb.addChild(new Sphere(.40f, 0,  25, sphereAppearA));

        // a white background is better for printing images in tutorial
        Background background = new Background();
        background.setColor(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.addChild(background);

	// Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

        return objRoot;
    } // end of CreateSceneGraph method of DistanceLODApp

    public DistanceLODApp() {
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
    } // end of DistanceLODApp (constructor)


    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        System.out.print("DistanceLODApp.java\n- a demonstration of using the DistanceLOD ");
        System.out.println("class to provide variable \n  level of detail (LOD) for a visual object in a Java 3D scene.");
        System.out.println("The sphere is represented by one of four different spheres \ndepending on the viewing distance.");
        System.out.println("In this example the different spheres are colored differently to \nillustrate swithcing.");
        System.out.println("In practice the spheres would all be colored alike.");
        System.out.println("The large static sphere is a duplicate of the sphere with the least detail.");
        System.out.println("The small static sphere is a duplicate of the sphere with the most detail.\n");
        System.out.println("This is an example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new DistanceLODApp(), 256, 256);
    } // end of main (method of DistanceLODApp)

} // end of class DistanceLODApp
