package pacmiage.utiles.objetbonus;

import pacmiage.controleur.partie.PartieController;
import pacmiage.modele.Bonus;
import pacmiage.utiles.Configuration;

/**
 *
 * @author Maëlle
 */
public class ObjetRed implements Bonus {

    /**
     *
     */
    public ObjetRed() {
        
    }

    /**
     *
     * @param partie
     */
    @Override
    public void executerBonus(PartieController partie) {
partie.getPlayer().setImagePac(Configuration.getInstance().recupererValeur("pacRouge"));
    }
    
    
}
