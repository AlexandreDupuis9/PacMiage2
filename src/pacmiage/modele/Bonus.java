package pacmiage.modele;

import java.io.Serializable;
import pacmiage.controleur.partie.PartieController;

/**
 *
 * @author Maëlle Cloitre / Dupuis Alexandre / Axel Nini / Raphaël Senand
 */
public interface Bonus extends Serializable{
    
    /**
     *
     * @param partie
     */
    void executerBonus(PartieController partie);
}
