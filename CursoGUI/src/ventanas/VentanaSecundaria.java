package ventanas;

import java.security.acl.Owner;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Clase VentanaSecundaria
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaSecundaria extends JDialog {
    
    private VentanaPrincipal nucleo;

    public VentanaSecundaria(VentanaPrincipal nucleo) {
        super(nucleo);
        this.nucleo = nucleo;
    }
    
    
    
}
