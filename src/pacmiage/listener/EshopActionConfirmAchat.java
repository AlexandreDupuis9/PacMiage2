/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmiage.listener;

import pacmiage.modele.JoueurInfo;
import pacmiage.modele.Objet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Achat d'un objet
 *
 * @author Maëlle Cloitre / Dupuis Alexandre / Axel Nini / Raphaël Senand
 */
public class EshopActionConfirmAchat extends AbstractAction {

    JoueurInfo j;
    Objet it;
    String message;

    /**
     *
     * @param j
     * @param it
     */
    public EshopActionConfirmAchat(JoueurInfo j, Objet it) {
        this.j = j;
        this.it = it;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (j.getGraines() < it.getPrix()) {
            message = "Vous n'avez pas assez de graines";
        } else {
            j.retirerGraines(it.getPrix());
            j.ajouterObjet(it);
            message = "Cet objet a été ajouté à votre liste";
        }
        JDialog f = new JDialog();

        JPanel p = new JPanel();
        p.setBackground(Color.black);
        ImageIcon icon = new ImageIcon("./src/ressources/image/eshop/ghost.png");
        JLabel image = new JLabel(icon);
        JLabel texte = new JLabel();
        texte.setText(message);
        texte.setForeground(Color.white);
        texte.setFont(new Font(null, 30 , 30));

        p.setLayout(new BorderLayout());
        p.add(texte, BorderLayout.NORTH);
        p.add(image);
        f.add(p);
        f.setVisible(true);
    }

}