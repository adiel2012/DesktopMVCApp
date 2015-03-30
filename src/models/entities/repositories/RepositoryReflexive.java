/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entities.repositories;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.entities.PersonaModel;

/**
 *
 * @author acastano
 */
public class RepositoryReflexive<T> {

    ArrayList<T> data = new ArrayList<T>();

    Random rnd = new Random();

    public int AdicionarPersona(T p) {
        try {
            System.out.println("Adicionando persona: " + p);

            //p.setId(rnd.nextInt());
            Field field = p.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(p, rnd.nextInt());
            field.setAccessible(false);

            data.add(p);
            return 1;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RepositoryReflexive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RepositoryReflexive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(RepositoryReflexive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(RepositoryReflexive.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public T[] getListadoPersona() {
        System.out.println("Obteniendo Listado");

        T[] toR = (T[]) java.lang.reflect.Array.newInstance(data.get(0)
                .getClass(), data.size());
        for (int i = 0; i < data.size(); i++) {
            toR[i] = data.get(i);
        }

        return toR;
    }

    public T getPersonaPorId(int aid) {
//        System.out.println("Obteniendo persona" + aid);
//        for (T personaModel : data) {
//            if (personaModel.getId() == aid) {
//                return personaModel;
//            }
//        }
        return null;
    }

    public int EditarPersona(int aid, T p) {
//        System.out.println("Adicionando persona: " + p);
//        int indice = 0;
//        for (T personaModel : data) {
//            if (personaModel.getId() == aid) {
//                data.set(indice, p);
//                return 1;
//            }
//            indice++;
//        }
        return -1;
    }

    public int EliminarPersonaPorId(int aid) {
        System.out.println("Obteniendo persona" + aid);

//        int pos = 0;
//        while (pos < data.size() && data.get(pos++).getId() != aid);
//        if (pos < data.size()) {
//            data.remove(pos);
//            return 1;
//        }
        return -1;
    }

}
