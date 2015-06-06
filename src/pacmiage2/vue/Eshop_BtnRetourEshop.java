/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmiage2.vue;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import pacmiage2.utiles.Session;

/**
 * Bouton pour annuler un achat et revenir à l'eshop
 *
 * @author Maëlle
 */
public class Eshop_BtnRetourEshop extends JButton {

    public Eshop_BtnRetourEshop(JFrame f) {
        
        this.setText(Session.getInstance().recupererValeur("non"));
        this.setFont(new Font(null, 30, 30 ));
        this.setBorderPainted(false);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
    }

}