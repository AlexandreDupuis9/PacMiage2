package pacmiage.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.newdawn.slick.SlickException;
import pacmiage.utiles.Configuration;
import pacmiage.vue.menu.FenetrePrincipale;

/**
 *
 * @author Maëlle Cloitre / Dupuis Alexandre / Axel Nini / Raphaël Senand
 */
public class SelectionNiveauListener implements ActionListener {

    private final FenetrePrincipale fenetre;

    /**
     *
     * @param fenetre
     */
    public SelectionNiveauListener(FenetrePrincipale fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            JButton tp = (JButton) e.getSource();

            switch (tp.getText()) {
                case "1":
                    fenetre.executerPartie(1, Configuration.getInstance().recupererValeur("carte1"));
                    break;
                case "2":
                    fenetre.executerPartie(2, Configuration.getInstance().recupererValeur("carte2"));
                    break;
                case "3":
                    fenetre.executerPartie(3, Configuration.getInstance().recupererValeur("carte3"));
                    break;
                case "4":
                    fenetre.executerPartie(4, Configuration.getInstance().recupererValeur("carte4"));
                    break;
                case "5":
                    fenetre.executerPartie(5, Configuration.getInstance().recupererValeur("carte5"));
                    break;
                default:
                    break;
            }
        } catch (SlickException ex) {
            Logger.getLogger(SelectionNiveauListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
