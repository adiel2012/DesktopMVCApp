/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflectionsample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import models.entities.PersonaModel;
import models.entities.Products;

/**
 *
 * @author Adiel
 */
public class sample {

    public static void main(String[] args) {

        Class tipo = PersonaModel.class; // Products.class;
        System.out.println("Anotaciones de la clase " + tipo.getName());
        Annotation[] anotaciones = tipo.getAnnotations();
        for (Annotation annotation : anotaciones) {
            System.out.println("    " + annotation.annotationType().getName());
        }

        System.out.println("Metodos de la clase " + tipo.getName());
        Method[] metodos = tipo.getDeclaredMethods();
        for (Method method : metodos) {
            System.out.println("    " + method.getName());
        }

        System.out.println("Campos de la clase " + tipo.getName());
        Field[] fields = tipo.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("    " + field.getName());
            anotaciones = field.getAnnotations();
            for (Annotation annotation : anotaciones) {
                System.out.println("        " + annotation.annotationType().getName());
                if(annotation.annotationType().equals(javax.persistence.Id.class)){
                    System.out.println("               Es llave");
                }else if(annotation.annotationType().equals(javax.persistence.Column.class)){
                    System.out.println("               Es una columna");
                }else if(annotation.annotationType().equals(javax.persistence.Basic.class)){
                    System.out.println("               opcional "+((javax.persistence.Basic)annotation).optional());
                }
            }
        }

    }
}
