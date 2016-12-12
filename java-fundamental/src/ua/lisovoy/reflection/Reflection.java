package ua.lisovoy.reflection;

import java.lang.reflect.*;

/**
 * Created by vladimir on 01.12.16.
 */
public class Reflection {

    //Method accepts Class and return created object of this class
    public Object getClass(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    //Method accepts Object and call all it methods without parameters
    public void invokeAllMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                method.invoke(object);
            }
        }
    }

    //Method accepts Object and print all signature of methods which have final
    public void printFinalSignatureMethods(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            for (Parameter parameter : method.getParameters()) {
                int modifiers = parameter.getModifiers();
                Modifier.fieldModifiers();
                System.out.println(method.getParameterTypes()[0]);
                boolean finalField = Modifier.isFinal(modifiers);
                if (finalField) {

                }
            }
        }
    }

    //Method accepts Class and print all non public methods within Class
    public void printNonPublicMethods(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method.getName());
            }
        }
    }

    //Method accepts Class and print all Class ancestors and all interfaces which implemented
    public void printAllAncestors(Class clazz) {
        for (Class bClass : clazz.getInterfaces()) {
            Class cClass = bClass;
            if (cClass != null) {
                System.out.println(bClass.getName());
                printAllAncestors(cClass);
            }
        }
        Class aClass = clazz.getSuperclass();
        if (aClass != null) {
            System.out.println(aClass);
            printAllAncestors(aClass);
        }
    }

    //Method accepts Object and set 0 to all private field (null, 0, false etc)
    public void setDefaultPrivateValue(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            boolean privateField = Modifier.isPrivate(modifiers);
            if (privateField) {
                field.setAccessible(true);
                if (field.getType().equals(String.class)){
                    String newMess = "opa";
                    field.set(field.getChar(object), newMess.toCharArray());
                } /*else if (field.getType().equals(String.class)){
                    field.set(field.getName(), null);
                } else if (field.getType().equals(boolean.class)){
                    field.set(field.getName(), false);
                }*/
                field.setAccessible(false);
                System.out.println(field.getType());
            }
        }
        System.out.println(object);
    }

    //Method accepts Object and call all it methods without parameters
    public void runAnnotatedMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            Run annotRun = method.getAnnotation(Run.class);
                if (annotRun != null) {
                    method.invoke(object);
                }
        }
    }

}
