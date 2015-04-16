/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopmvcapp;

import DependecyInjection.DependencyResolver;
import controllers.PersonaController;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adiel
 */
public class DesktopMVCApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            PersonaController personaController = new PersonaController();
            DependencyResolver.getInstance().InyectDependencies(personaController);
            personaController.MostrarCRUD();
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(DesktopMVCApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
