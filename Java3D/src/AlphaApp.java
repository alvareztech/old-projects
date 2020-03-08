/*
 *      @(#)AlphaApp.java 1.1 00/09/22 14:37
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


//   AlphaApp renders an 

public class AlphaApp extends Applet {

    Shape3D createCar(float xScale, float yScale) {
        Shape3D car = new Shape3D();

        QuadArray carGeom = new QuadArray(16, GeometryArray.COORDINATES);

        carGeom.setCoordinate( 0, new Point3f(xScale*-0.25f, yScale*0.22f, 0.0f));
        carGeom.setCoordinate( 1, new Point3f(xScale* 0.20f, yScale*0.22f, 0.0f));
        carGeom.setCoordinate( 2, new Point3f(xScale* 0.10f, yScale*0.35f, 0.0f));
        carGeom.setCoordinate( 3, new Point3f(xScale*-0.20f, yScale*0.35f, 0.0f));
        carGeom.setCoordinate( 4, new Point3f(xScale*-0.50f, yScale*0.10f, 0.0f));
        carGeom.setCoordinate( 5, new Point3f(xScale* 0.50f, yScale*0.10f, 0.0f));
        carGeom.setCoordinate( 6, new Point3f(xScale* 0.45f, yScale*0.20f, 0.0f));
        carGeom.setCoordinate( 7, new Point3f(xScale*-0.48f, yScale*0.20f, 0.0f));
        carGeom.setCoordinate( 8, new Point3f(xScale*-0.26f, yScale*0.00f, 0.0f));
        carGeom.setCoordinate( 9, new Point3f(xScale*-0.18f, yScale*0.00f, 0.0f));
        carGeom.setCoordinate(10, new Point3f(xScale*-0.16f, yScale*0.12f, 0.0f));
        carGeom.setCoordinate(11, new Point3f(xScale*-0.28f, yScale*0.12f, 0.0f));
        carGeom.setCoordinate(12, new Point3f(xScale* 0.25f, yScale*0.00f, 0.0f));
        carGeom.setCoordinate(13, new Point3f(xScale* 0.33f, yScale*0.00f, 0.0f));
        carGeom.setCoordinate(14, new Point3f(xScale* 0.35f, yScale*0.12f, 0.0f));
        carGeom.setCoordinate(15, new Point3f(xScale* 0.23f, yScale*0.12f, 0.0f));

        car.setGeometry(carGeom);

        ColoringAttributes colorAttrib =
              new ColoringAttributes(0.0f, 0.0f, 1.0f, ColoringAttributes.NICEST);
        Appearance carAppear = new Appearance();
        carAppear.setColoringAttributes(colorAttrib);
        car.setAppearance(carAppear);

        return car;
    }

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();

        // create target TransformGroup with Capabilities
        TransformGroup objMove1 = new TransformGroup();
        objMove1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3f(0.0f, 0.8f, 0.0f));
        TransformGroup objPos1 = new TransformGroup(t3d);

        // create Alpha that continuously cycles with a period of 1 sec
        Alpha alpha1 = new Alpha();

        alpha1.setIncreasingAlphaDuration(2000);
        alpha1.setAlphaAtOneDuration(1000);
        alpha1.setDecreasingAlphaDuration(2000);
        alpha1.setAlphaAtZeroDuration(1000);

        // create position interpolator
        PositionInterpolator posInt1 = new PositionInterpolator (alpha1, objMove1);
        posInt1.setSchedulingBounds(new BoundingSphere());

        posInt1.setStartPosition(-1.0f);

        objRoot.addChild(objPos1);
        objPos1.addChild(objMove1);
        objMove1.addChild(createCar(0.4f, 0.4f));
        objRoot.addChild(posInt1);

        // create target TransformGroup with Capabilities
        TransformGroup objMove2 = new TransformGroup();
        objMove2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3d.setTranslation(new Vector3f(0.0f, 0.3f, 0.0f));
        TransformGroup objPos2 = new TransformGroup(t3d);

        Alpha alpha2 = new Alpha();

        alpha2.setIncreasingAlphaDuration(2000);
        alpha2.setAlphaAtOneDuration(1000);
        alpha2.setIncreasingAlphaRampDuration(500);

        // create position interpolator
        PositionInterpolator posInt2 = new PositionInterpolator (alpha2, objMove2);
        posInt2.setSchedulingBounds(new BoundingSphere());

        posInt2.setStartPosition(-1.0f);

        objRoot.addChild(objPos2);
        objPos2.addChild(objMove2);
        objMove2.addChild(createCar(0.4f, 0.4f));
        objRoot.addChild(posInt2);

        // create target TransformGroup with Capabilities
        TransformGroup objMove3 = new TransformGroup();
        objMove3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        t3d.setTranslation(new Vector3f(0.0f, -0.3f, 0.0f));
        TransformGroup objPos3 = new TransformGroup(t3d);

        Alpha alpha3 = new Alpha();

        alpha3.setIncreasingAlphaDuration(2000);
        alpha3.setAlphaAtOneDuration(1000);
        alpha3.setIncreasingAlphaRampDuration(1000);

        // create position interpolator
        PositionInterpolator posInt3 = new PositionInterpolator (alpha3, objMove3);
        posInt3.setSchedulingBounds(new BoundingSphere());

        posInt3.setStartPosition(-1.0f);

        objRoot.addChild(objPos3);
        objPos3.addChild(objMove3);
        objMove3.addChild(createCar(0.4f, 0.4f));
        objRoot.addChild(posInt3);

        Background background = new Background();
        background.setColor(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.addChild(background);

	// Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

	return objRoot;
    } // end of CreateSceneGraph method of alpha1App

    // Create a simple scene and attach it to the virtual universe

    public AlphaApp() {
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
    } // end of AlphaApp (constructor)

    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        System.out.print("AlphaApp.java \n- a demonstration of using alpha to control ");
        System.out.println("Interpolators to provide animation in a Java 3D scene.");
        System.out.println("This is a simple example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new AlphaApp(), 256, 256);
    } // end of main (method of AlphaApp)

} // end of class AlphaApp
