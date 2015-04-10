/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.entities.repositories;

import models.entities.PersonaModel;

/**
 *
 * @author Adiel
 */
public interface IPersonaRepository {

    int AdicionarPersona(PersonaModel p);

    int EditarPersona(int aid, PersonaModel p);

    int EliminarPersonaPorId(int aid);

    PersonaModel[] getListadoPersona();

    PersonaModel getPersonaPorId(int aid);
    
}
