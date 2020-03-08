/*
 *      @(#)RotPosPathApp.java 1.1 00/09/22 14:37
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



public class RotPosPathApp extends Applet {

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();

        Alpha alpha = new Alpha(-1, 10000);
        TransformGroup target = new TransformGroup();
        Transform3D axisOfRotPos = new Transform3D();
        float[] knots = {0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.6f, 0.8f, 0.9f, 1.0f};
        Quat4f[] quats = new Quat4f[9];
        Point3f[] positions = new Point3f[9];

        target.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        AxisAngle4f axis = new AxisAngle4f(1.0f,0.0f,0.0f,0.0f);
        axisOfRotPos.set(axis);

        quats[0] = new Quat4f(0.0f, 1.0f, 1.0f, 0.0f);
        quats[1] = new Quat4f(1.0f, 0.0f, 0.0f, 0.0f);
        quats[2] = new Quat4f(0.0f, 1.0f, 0.0f, 0.0f);
        quats[3] = new Quat4f(0.0f, 1.0f, 1.0f, 0.0f);
        quats[4] = new Quat4f(0.0f, 0.0f, 1.0f, 0.0f);
        quats[5] = new Quat4f(0.0f, 1.0f, 1.0f, 0.0f);
        quats[6] = new Quat4f(1.0f, 1.0f, 0.0f, 0.0f);
        quats[7] = new Quat4f(1.0f, 0.0f, 0.0f, 0.0f);
        quats[8] = quats[0];

        positions[0]= new Point3f(  0.0f,  0.0f, -1.0f);
        positions[1]= new Point3f(  1.0f, -1.0f, -2.0f);
        positions[2]= new Point3f( -1.0f,  1.0f, -3.0f);
        positions[3]= new Point3f(  2.0f,  0.0f, -4.0f);
        positions[4]= new Point3f( -2.0f, -1.0f, -5.0f);
        positions[5]= new Point3f(  3.0f,  1.0f, -6.0f);
        positions[6]= new Point3f( -3.0f,  0.0f, -7.0f);
        positions[7]= new Point3f(  2.0f, -1.0f, -4.0f);
        positions[8]= positions[0];


        RotPosPathInterpolator rotPosPath = new RotPosPathInterpolator(
                alpha, target, axisOfRotPos, knots, quats, positions);
        rotPosPath.setSchedulingBounds(new BoundingSphere());


        objRoot.addChild(target);
        objRoot.addChild(rotPosPath);
        target.addChild(new ColorCube(0.4));

        Background background = new Background();
        background.setColor(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.addChild(background);

        PointArray point_geom = new PointArray(9, GeometryArray.COORDINATES);
        point_geom.setCoordinates(0, positions);
        Appearance points_appear = new Appearance();
        ColoringAttributes points_coloring = new ColoringAttributes();
        points_coloring.setColor(1.0f, 0.0f, 0.0f);
        points_appear.setColoringAttributes(points_coloring);
        PointAttributes points_points = new PointAttributes(4.0f, true);
        points_appear.setPointAttributes(points_points);
        Shape3D points = new Shape3D(point_geom, points_appear);
        objRoot.addChild(points);

        objRoot.compile();

        return objRoot;
    } // end of CreateSceneGraph method of RotPosPathApp

    // Create a simple scene and attach it to the virtual universe

    public RotPosPathApp() {
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
    } // end of RotPosPathApp (constructor)

    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        System.out.print("RotPosPathApp.java \n- a demonstration of using the RotPosPathInterpolator ");
        System.out.println("and Alpha classes to provide animation in a Java 3D scene.");
        System.out.println("The RotPosPathInterpolator changes the target TransformGroup");
        System.out.println("to change the POSition and ROTation along a PATH.  The positions");
        System.out.println("are marked by the red dots in the scene.");
        System.out.println("This is a simple example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new RotPosPathApp(), 256, 256);
    } // end of main (method of RotPosPathApp)

} // end of class RotPosPathApp
