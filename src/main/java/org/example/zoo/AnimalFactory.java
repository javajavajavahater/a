package org.example.zoo;

import org.example.exeptions.CustomExeption;
import org.example.exeptions.NotFoundAnimalNameException;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
    private final String PACKAGE_OF_ANIMALS_CLASSES = "org.example.zoo.";

    public Animal createAnimal(String className) throws NotFoundAnimalNameException, CustomExeption {
        try {
            Class<?> animalSubClass = Class.forName(PACKAGE_OF_ANIMALS_CLASSES + className);
            return ((Animal) animalSubClass.getDeclaredConstructor().newInstance());

        } catch (InvocationTargetException e) {
            throw new CustomExeption("failure in calling the Constructor method through the reflection", e);
        } catch (InstantiationException e) {
            throw new CustomExeption("The class" + className + " object represents an abstract class, interface, array class, primitive or void.\n" +
                    "The class has no nullary constructor. Such a constructor is required when a parameterized constructor is defined for the class.", e);
        } catch (IllegalAccessException e) {
            throw new CustomExeption("Application tries to reflectively create an instance (other than an array)\n, set or get a field, or invoke a method" +
                    ", but the currently executing method does not have access to the definition of the specified class,\n field, method or constructor.", e);
        } catch (NoSuchMethodException e) {
            throw new CustomExeption("create Animal method Failed", e);
        } catch (ClassNotFoundException e) {
            throw new NotFoundAnimalNameException("the class: " + className + " not exist", e.getCause());
        }
    }
}
