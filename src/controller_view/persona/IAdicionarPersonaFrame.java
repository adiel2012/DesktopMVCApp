/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller_view.persona;

import javax.swing.JButton;

/**
 *
 * @author Adiel
 */
public interface IAdicionarPersonaFrame {

    /**
     * @return the BtnAdicionar
     */
    JButton getBtnAdicionar();

    String getEdad();

    String getNombre();

    void mostrar();
    
}
