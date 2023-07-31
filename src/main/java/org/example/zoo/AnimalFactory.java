package org.example.zoo;

import org.example.exeptions.AnimalExeption;
import org.example.exeptions.NotFoundAnimalNameException;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
    private static final String ANIMALS_CLASSES_PACKAGE = "org.example.zoo.";

    public Animal createAnimal(String animalName) throws NotFoundAnimalNameException, AnimalExeption {
        try {
            return (Animal) Class.forName(ANIMALS_CLASSES_PACKAGE + animalName).getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException |  IllegalAccessException |NoSuchMethodException e) {
            throw new AnimalExeption("something went wrong", e);
        } catch (ClassNotFoundException e) {
            throw new NotFoundAnimalNameException("the class: " + animalName + " not exist", e);
        }
    }
}
