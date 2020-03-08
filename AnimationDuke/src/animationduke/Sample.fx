/*
 * Sample.fx
 *
 * Created on 23 Apr, 2009, 12:42:06 PM
 */

package animationduke;import javafx.scene.Node;

/**
 * @author Rakesh Menon
 */

public abstract class Sample {
    public var node : Node;
    public abstract function play() : Void;
}