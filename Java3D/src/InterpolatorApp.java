/*
 *      @(#)InterpolatorApp.java 1.1 00/09/22 14:37
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
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.*;
import javax.vecmath.*;


//   InterpolatorApp renders an 

public class InterpolatorApp extends Applet {

    Shape3D createCar(float xScale, float yScale, boolean createNormals,
                        boolean assignColoring) {
        Shape3D car = new Shape3D();
        QuadArray carGeom = null;

        if (createNormals)
            carGeom = new QuadArray(16, GeometryArray.COORDINATES
                                        | GeometryArray.NORMALS);
        else
            carGeom = new QuadArray(16, GeometryArray.COORDINATES);

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

        if (createNormals){
            int i;
            Vector3f normal = new Vector3f(0.6f, 0.6f, 0.8f);
            for(i = 0; i < 8; i++)
                carGeom.setNormal(i, normal);
            normal.set(new Vector3f(0.5f, 0.5f, 0.5f));
            for(i = 8; i <16; i++)
                carGeom.setNormal(i, normal);
        }

        if (assignColoring){
            ColoringAttributes colorAttrib =
                  new ColoringAttributes(0.0f, 0.0f, 1.0f, ColoringAttributes.NICEST);
            Appearance carAppear = new Appearance();
            carAppear.setColoringAttributes(colorAttrib);
            car.setAppearance(carAppear);
        }

        car.setGeometry(carGeom);
        return car;
    }

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();
        Transform3D t3d = new Transform3D();
        BoundingSphere bounds = new BoundingSphere();

        // create target TransformGroup with Capabilities
        TransformGroup objMove = new TransformGroup();
        objMove.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        // create target TransformGroup with Capabilities
        TransformGroup objRotate = new TransformGroup();
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        // create target TransformGroup with Capabilities
        TransformGroup objScale = new TransformGroup();
        objScale.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        // create target Material with Capabilities
        Material objColor = new Material();
        objColor.setCapability(Material.ALLOW_COMPONENT_WRITE);

        // create target Transparency with Capabilities
        TransparencyAttributes objTransp = new TransparencyAttributes();
        objTransp.setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);
        objTransp.setTransparencyMode(TransparencyAttributes.BLENDED);

        // create target Switch with Capabilities
        Switch objSwitch = new Switch();
        objSwitch.setCapability(Switch.ALLOW_SWITCH_WRITE);

        // create Alpha 
        Alpha alpha = new Alpha (-1,
                                 Alpha.INCREASING_ENABLE + Alpha.DECREASING_ENABLE,
                                 0, 0, 2000, 0, 1000, 2000, 0, 1000);

        // create position interpolator
        PositionInterpolator posInt = new PositionInterpolator (alpha, objMove);
        posInt.setSchedulingBounds(bounds);
        posInt.setStartPosition(-1.0f);

        // create rotation interpolator
        RotationInterpolator rotInt = new RotationInterpolator (alpha, objRotate);
        rotInt.setSchedulingBounds(bounds);

        // create scale interpolator
        ScaleInterpolator scaInt = new ScaleInterpolator (alpha, objScale);
        scaInt.setSchedulingBounds(bounds);

        // create color interpolator
        ColorInterpolator colInt = new ColorInterpolator (alpha, objColor);
        colInt.setStartColor(new Color3f(1.0f, 0.0f, 0.0f));
        colInt.setEndColor(new Color3f(0.0f, 0.0f, 1.0f));
        colInt.setSchedulingBounds(bounds);

        // create transparency interpolator
        TransparencyInterpolator traInt = new TransparencyInterpolator (alpha, objTransp);
        traInt.setSchedulingBounds(bounds);

        // create switch value interpolator
        SwitchValueInterpolator swiInt = new SwitchValueInterpolator (alpha, objSwitch);
        swiInt.setSchedulingBounds(bounds);

        t3d.setTranslation(new Vector3f(0.0f, 0.8f, 0.0f));
        TransformGroup objMovePos = new TransformGroup(t3d);
        objRoot.addChild(objMovePos);
        objMovePos.addChild(objMove);
        objMove.addChild(createCar(0.4f, 0.4f, false, true));
        objRoot.addChild(posInt);

        t3d.setTranslation(new Vector3f(0.0f, 0.5f, 0.0f));
        TransformGroup objRotPos = new TransformGroup(t3d);
        objRoot.addChild(objRotPos);
        objRotPos.addChild(objRotate);
        objRotate.addChild(createCar(0.4f, 0.4f, false, true));
        objRoot.addChild(rotInt);

        t3d.setTranslation(new Vector3f(0.0f, 0.2f, 0.0f));
        TransformGroup objScalePos = new TransformGroup(t3d);
        objRoot.addChild(objScalePos);
        objScalePos.addChild(objScale);
        objScale.addChild(createCar(0.4f, 0.4f, false, true));
        objRoot.addChild(scaInt);

        t3d.setTranslation(new Vector3f(0.0f, -0.2f, 0.0f));
        TransformGroup objColorPos = new TransformGroup(t3d);
        objRoot.addChild(objColorPos);
        Shape3D colorCar = createCar(0.4f, 0.4f, true, false);
        Appearance materialAppear = new Appearance();
        materialAppear.setMaterial(objColor);
        colorCar.setAppearance(materialAppear);
        objColorPos.addChild(colorCar);
        objRoot.addChild(colInt);

        t3d.setTranslation(new Vector3f(0.0f, -0.5f, 0.0f));
        TransformGroup objTranspPos = new TransformGroup(t3d);
        objRoot.addChild(objTranspPos);
        Shape3D transpCar = createCar(0.4f, 0.4f, false, true);
        Appearance transpAppear = transpCar.getAppearance();
        transpAppear.setTransparencyAttributes(objTransp);
        objTranspPos.addChild(transpCar);
        objRoot.addChild(traInt);

        t3d.setTranslation(new Vector3f(0.0f, -0.8f, 0.0f));
        TransformGroup objSwitchPos = new TransformGroup(t3d);
        objRoot.addChild(objSwitchPos);
        objSwitch.addChild(createCar(0.4f, 0.4f, false, true));;
        objSwitch.addChild(new ColorCube(0.1f));
        objSwitchPos.addChild(objSwitch);
        objRoot.addChild(swiInt);
        swiInt.setLastChildIndex(2);// since switch made after interpolator

        DirectionalLight lightD1 = new DirectionalLight();
	// lightD1.setDirection(new Vector3f(-0.7f,-0.7f,0.0f));
        lightD1.setInfluencingBounds(bounds);
        objRoot.addChild(lightD1);

        Background background = new Background();
        background.setColor(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.addChild(background);

	// Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

	return objRoot;
    } // end of CreateSceneGraph method of InterpolatorApp

    // Create a simple scene and attach it to the virtual universe

    public InterpolatorApp() {
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
    } // end of InterpolatorApp (constructor)

    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        System.out.print("InterpolatorApp.java \n- a demonstration of using Interpolator ");
        System.out.println("objects to provide animation in a Java 3D scene.");
        System.out.println("This is a simple example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new InterpolatorApp(), 256, 256);
    } // end of main (method of InterpolatorApp)

} // end of class InterpolatorApp
