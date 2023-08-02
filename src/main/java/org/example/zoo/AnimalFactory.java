package org.example.zoo;

import org.example.Main;
import org.example.exeptions.AnimalException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.NotFoundAnimalNameException;
import org.example.exeptions.PropertiesException;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class AnimalFactory {
    private Properties animalProperties;

    public AnimalFactory(String propertiesFileName) throws IncorrectFileNameException, PropertiesException {
        this.animalProperties = PropertiesFileMethods.returnProperties(FileMethods.getResourceFileAsInputStream(propertiesFileName));
    }

    private static String getAnimalClassName(Properties animalProperties, String animalName) {
        return Main.ANIMALS_CLASSES_PACKAGE + animalProperties.getProperty(animalName, animalName);
    }

    public Animal createAnimal(String animalName) throws AnimalException {
        try {
            return (Animal) Class.forName(getAnimalClassName(this.animalProperties, animalName)).getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new AnimalException("something went wrong", e);
        } catch (ClassNotFoundException | NullPointerException e) {
            throw new NotFoundAnimalNameException(String.format("the animal: %s not exist", animalName), e);
        }
    }
}
