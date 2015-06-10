package pacmiage2.utiles.objetBonus;

import pacmiage2.controleur.partie.PartieController;
import pacmiage2.modele.Bonus;
import pacmiage2.utiles.Configuration;

/**
 *
 * @author Maëlle
 */
public class ObjetGreen implements Bonus {
    
    public ObjetGreen() {
        
    }
    
    @Override
    public void executerBonus(PartieController partie) {
        partie.getPlayer().setImagePac(Configuration.getInstance().recupererValeur("pacVert"));
    }
    
}