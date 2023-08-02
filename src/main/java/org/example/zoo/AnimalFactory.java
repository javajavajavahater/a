package org.example.zoo;

import org.example.exeptions.AnimalException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.NotFoundAnimalNameException;
import org.example.exeptions.PropertiesException;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class AnimalFactory {
    private static final String ANIMALS_CLASSES_PACKAGE = "org.example.zoo.";

    private final Properties ANIMALS_PROPERTIES;

    public AnimalFactory(Properties animalsProperties) {
        this.ANIMALS_PROPERTIES = animalsProperties;
    }

    public Animal createAnimal(String animalName) throws AnimalException {
        try {
            return (Animal) Class.forName(getAnimalClassName(animalName)).getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new AnimalException("something went wrong", e);
        } catch (ClassNotFoundException | NullPointerException e) {
            throw new NotFoundAnimalNameException(String.format("the animal: %s not exist", animalName), e);
        }
    }

    private String getAnimalClassName(String animalName) {
        return this.ANIMALS_CLASSES_PACKAGE + this.ANIMALS_PROPERTIES.getProperty(animalName, animalName);
    }
}
