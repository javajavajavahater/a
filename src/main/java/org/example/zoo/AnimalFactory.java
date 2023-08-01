package org.example.zoo;

import org.example.Main;
import org.example.exeptions.AnimalException;
import org.example.exeptions.NotFoundAnimalNameException;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
    public Animal createAnimal(String animalName) throws AnimalException {
        try {
            return (Animal) Class.forName(Main.ANIMALS_CLASSES_PACKAGE + animalName).getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new AnimalException("something went wrong", e);
        } catch (ClassNotFoundException | NullPointerException e) {
            throw new NotFoundAnimalNameException(String.format("the animal: %s not exist", animalName), e);
        }
    }
}
