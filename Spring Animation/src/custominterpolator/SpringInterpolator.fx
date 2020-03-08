/* 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms. 
 * 
 * This file is available and licensed under the following license:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 *
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *   * Neither the name of Sun Microsystems nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package custominterpolator;

import javafx.animation.SimpleInterpolator;
import java.lang.Math;


/* This is the actual interpolator class which implements
 * the standard spring equation.
 * It can be configured using the public-init vars
 * at the top, but reasonable defaults are provided.
 * */

public class SpringInterpolator extends SimpleInterpolator {
    // the amplitude of the wave
    // controls how far out the object can go from it's final stopping point.
    public-init var amplitude:Number = 1.0;
    // determines the weight of the object
    // makes the wave motion go longer and farther
    public-init var mass:Number = 0.058;
    // the stiffness of the wave motion / spring
    // makes the motion shorter and more snappy
    public-init var stiffness:Number = 12.0;
    // makes the wave motion be out of phase, so that the object
    // doesn't end up on the final resting spot.
    // this variable is usually never changed
    public-init var phase:Number = 0.0;

    // if this should do a normal spring or a bounce motion
    public-init var bounce:Boolean = false;


    // internal variables used for calcuations
    var pulsation:Number;

    init {
        this.pulsation = Math.sqrt(stiffness / mass);
    }


    // the actual spring equation
    override public function curve(t:Number):Number {
        var t2 = -Math.cos(pulsation*t+phase+Math.PI) * (1-t) * amplitude ;
        // use the absolute value of the distance if doing a bounces
        if(bounce) {
            return 1 - Math.abs(t2);
        } else {
            return 1 - t2;
        }
    }

}
