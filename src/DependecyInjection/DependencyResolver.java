/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DependecyInjection;

import controller_view.persona.IAdicionarPersonaFrame;
import controller_view.persona.IPrincipalViewPersona;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.entities.repositories.IPersonaRepository;
import models.entities.repositories.PersonaRepository;
import views.PersonaAdicionarFrame;
import views.PersonaCRUDFrame;

/**
 *
 * @author Adiel
 */
public class DependencyResolver {

    private static DependencyResolver instance = null;

    public static DependencyResolver getInstance() {
        if (instance == null) {
            instance = new DependencyResolver();
        }

        return instance;
    }

    Map<Class, Class> mapa = new HashMap<Class, Class>();
    Map<Class, Class> mapasingleton = new HashMap<Class, Class>();

    private DependencyResolver() {

        mapasingleton.put(IPrincipalViewPersona.class, PersonaCRUDFrame.class);
        mapasingleton.put(IAdicionarPersonaFrame.class, PersonaAdicionarFrame.class);

        mapa.put(IPersonaRepository.class, PersonaRepository.class);
    }

    public Object provide(Class c) {
        // para los singletons

        if (mapasingleton.containsKey(c)) {
            Method method;
            try {

               // PersonaAdicionarFrame.class.getMethod("getInstance");
                method = mapasingleton.get(c).getMethod("getInstance");
                return method.invoke(null);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        

        try {
            if (mapa.containsKey(c)) {
                return mapa.get(c).newInstance();
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DependencyResolver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
