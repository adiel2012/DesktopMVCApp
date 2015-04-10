/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller_view.persona;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Adiel
 */
public interface IPrincipalViewPersona {

    /**
     * @return the BtnAdicionar
     */
    JButton getBtnAdicionar();

    /**
     * @return the BtnEditar
     */
    JButton getBtnEditar();

    /**
     * @return the BtnEliminar
     */
    JButton getBtnEliminar();

    /**
     * @return the Tabla
     */
    JTable getTabla();

    void mostrar();
    
}
