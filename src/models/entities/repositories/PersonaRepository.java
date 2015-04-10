/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.entities.repositories;

import java.util.ArrayList;
import java.util.Random;
import models.entities.PersonaModel;

/**
 *
 * @author Adiel
 */
public class PersonaRepository implements IPersonaRepository {
    
    ArrayList<PersonaModel> data = new ArrayList<PersonaModel>();
    
    Random rnd = new Random();
    
    @Override
    public int AdicionarPersona(PersonaModel p){
        System.out.println("Adicionando persona: "+p);
        p.setId(rnd.nextInt());
        data.add(p);
        return 1;
    }
    
    @Override
    public PersonaModel[] getListadoPersona(){
        System.out.println("Obteniendo Listado");
        return data.toArray(new PersonaModel[]{});
    }
    
    @Override
    public PersonaModel getPersonaPorId(int aid){
        System.out.println("Obteniendo persona"+aid);
        for (PersonaModel personaModel : data) {
            if(personaModel.getId()== aid)
                return personaModel;
        }
        return null;
    }
    
    @Override
    public int EditarPersona(int aid,PersonaModel p){
        System.out.println("Adicionando persona: "+p);
        int indice=0;
        for (PersonaModel personaModel : data) {
            if(personaModel.getId()== aid)
            {
                 data.set(indice, p);
                 return 1;
            }
            indice++;
        }
        return -1;
    }
    
    @Override
    public int EliminarPersonaPorId(int aid){
        System.out.println("Obteniendo persona"+aid);
        
        int pos=0;
        while(pos<data.size() && data.get(pos++).getId()!=aid);
        if(pos<data.size()){
            data.remove(pos);
            return 1;
        }
        return -1;
    }
    
}
