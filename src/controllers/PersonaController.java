/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DependecyInjection.DependencyResolver;
import DependecyInjection.MyAfterInject;
import DependecyInjection.MyInject;
import controller_view.persona.IAdicionarPersonaFrame;
import controller_view.persona.IPrincipalViewPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.entities.PersonaModel;

import models.entities.repositories.IPersonaRepository;

/**
 *
 * @author Adiel
 */
public class PersonaController {

//<<<<<<< HEAD
    @MyInject
    IPersonaRepository repo = null;
    @MyInject
    IPrincipalViewPersona mainframe = null;
    @MyInject
    IAdicionarPersonaFrame forma = null;
    

    public PersonaController() {
        //DependencyResolver.getInstance().InyectDependencies(this);
        //mediate();
    }

    public void MostrarCRUD() {
        mainframe.mostrar();
    }

    public void MostrarFormularioInsercion() {
       forma.mostrar();
    }

    public void iniciarFormularioEdicion(int aid) {

    }

    private int Editar(int aid, PersonaModel p) {
        return repo.EditarPersona(aid, p);
    }

    private int Adicionar(PersonaModel p) {
        return repo.AdicionarPersona(p);
    }

    @MyAfterInject
    private void mediate() {

        
        final PersonaController controller = this;

        //adicionando mediación a la adición
        forma.getBtnAdicionar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(forma.getNombre().equals("")){
                    JOptionPane.showMessageDialog(null, "Falta el nombre", "Incorrecto", 0);
                    return;
                }
                
                int edad = 0;
                try {
                    edad = Integer.parseInt(forma.getEdad());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Edad no válida", "Error", 0);
                    return;
                }
                if (Adicionar(new PersonaModel(forma.getNombre(), edad)) == 1) {
                    JOptionPane.showMessageDialog(null, "Persona Adicionada Correctamente", "Correcto", 1);
                    mainframe.getTabla().setModel(CrearModelo());
                }
            }

        });
        mainframe.getBtnAdicionar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               controller.MostrarFormularioInsercion();
            }
        });

        
        //adicionando medición a la edición
        
        
        //adicionando mediación a la eliminación
        
        
        
    }

    //crea el modelo para la tabla
    private TableModel CrearModelo() {
        PersonaModel[] listado = repo.getListadoPersona();
        Object[][] data = new Object[listado.length][2];
        for (int i = 0; i < listado.length; i++) {
            data[i][0]= listado[i].getNombre();
            data[i][1]= listado[i].getEdad();
        }
        
        DefaultTableModel res = new DefaultTableModel(data, new Object[]{"Nombre", "Edad"});

        return res;
    }
}
