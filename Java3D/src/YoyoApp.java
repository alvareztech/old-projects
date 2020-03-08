/*
 *      @(#)YoyoApp.java 1.1 00/09/22 15:57
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


/*
 * Getting Started with the Java 3D API
 * written in Java 3D
 */

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame; 
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class YoyoApp extends Applet {

    /////////////////////////////////////////////////
    //
    // create scene graph branch group
    //
    public class Yoyo extends Shape3D{

	////////////////////////////////////////////
	//
	// create Shape3D with geometry and appearance
        // the geometry is created in method yoyoGeometry
        // the appearance is created in method yoyoAppearance
	//
	public Yoyo() {

                this.setGeometry(yoyoGeometry());

	} // end of Yoyo constructor

	////////////////////////////////////////////
	//
	// create yoyo geometry
        // four triangle fans represent the yoyo
        // strip   indicies_______________
        //   0     0N+0 to 1N+0 ( 0 to N )
        //   1     1N+1 to 2N+1
        //   2     2N+2 to 3N+2
        //   3     3N+4 to 4N+3
	//
	private Geometry yoyoGeometry() {

                TriangleFanArray tfa;
                int     N = 17;
                int     totalN = 4*(N+1);
                Point3f coords[] = new Point3f[totalN];
                int     stripCounts[] = {N+1, N+1, N+1, N+1};
                float   r = 0.6f;
                float   w = 0.4f;
                int     n;
                double  a;
                float   x, y;

                // set the central points for four triangle fan strips
                coords[0*(N+1)] = new Point3f(0.0f, 0.0f, w);
                coords[1*(N+1)] = new Point3f(0.0f, 0.0f, 0.0f);
                coords[2*(N+1)] = new Point3f(0.0f, 0.0f, 0.0f);
                coords[3*(N+1)] = new Point3f(0.0f, 0.0f, -w);

                for(a = 0,n = 0; n < N; a = 2.0*Math.PI/(N-1) * ++n){
                        x = (float) (r * Math.cos(a));
                        y = (float) (r * Math.sin(a));
                        coords[0*(N+1)+n+1] = new Point3f(x, y, w);
                        coords[1*(N+1)+N-n] = new Point3f(x, y, w);
                        coords[2*(N+1)+n+1] = new Point3f(x, y, -w);
                        coords[3*(N+1)+N-n] = new Point3f(x, y, -w);
                }

		tfa = new TriangleFanArray (totalN, 
					TriangleFanArray.COORDINATES,
					stripCounts);
		
                tfa.setCoordinates(0, coords);

                return tfa;

	} // end of method yoyoGeometry in class Yoyo


    } // end of class Yoyo

    /////////////////////////////////////////////////
    //
    // create scene graph branch group
    //
    public BranchGroup createSceneGraph() {

	BranchGroup objRoot = new BranchGroup();

      // Create the transform group node and initialize it to the
      // identity.  Enable the TRANSFORM_WRITE capability so that
      // our behavior code can modify it at runtime.  Add it to the
      // root of the subgraph.
      TransformGroup objSpin = new TransformGroup();
      objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

      objRoot.addChild(objSpin);
 
        objSpin.addChild(new Yoyo());

      // Create a new Behavior object that will perform the desired
      // operation on the specified transform object and add it into
      // the scene graph.
      Transform3D yAxis = new Transform3D();
      Alpha rotationAlpha = new Alpha(-1, 4000);

      RotationInterpolator rotator =
          new RotationInterpolator(rotationAlpha, objSpin);
      BoundingSphere bounds =
          new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
      rotator.setSchedulingBounds(bounds);
      objSpin.addChild(rotator);

	// Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

	return objRoot;
    } // end of CreateSceneGraph method of YoyoApp

    // Create a simple scene and attach it to the virtual universe

    public YoyoApp() {
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
    } // end of YoyoApp constructor

    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        Frame frame = new MainFrame(new YoyoApp(), 256, 256);
    } // end of main method of YoyoApp

} // end of class YoyoApp
