package org.example;

import org.example.exeptions.AnimalException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.PropertiesException;
import org.example.zoo.Animal;
import org.example.zoo.AnimalFactory;
import org.example.zoo.FileMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Main {
    private static final int ANIMALS_NAMES_FILE_PATH_INDEX = 0;
    private static final String DELIMITER_ANIMAL_NAME_FROM_TEXT = " ";
    public static final String ANIMALS_CLASSES_PACKAGE = "org.example.zoo.";
    private static final String ANIMAL_PROPERTIES_FILE_NAME = "animal.properties";

    public static void main(String[] args) throws IncorrectFileNameException, AnimalException, PropertiesException {
        String animalsNamesFilePath = args[ANIMALS_NAMES_FILE_PATH_INDEX];
        String[] animalsNames = FileMethods.returnLineTextFromFile(animalsNamesFilePath).split(DELIMITER_ANIMAL_NAME_FROM_TEXT);
        createAnimalAndImplementsAnimalClassMethods(animalsNames);
    }

    private static void createAnimalAndImplementsAnimalClassMethods(String[] animalsNames)
            throws AnimalException, IncorrectFileNameException, PropertiesException {
        AnimalFactory animalFactory = new AnimalFactory();

        for (String animalName : animalsNames) {
            Animal animal = animalFactory.createAnimal(checkAnimalNameInAnimalProperties
                    (returnProperties(Main.class.getClassLoader().getResourceAsStream(ANIMAL_PROPERTIES_FILE_NAME)), (animalName)));
            animal.printYourName();
            animal.printYourSound();
        }
    }

    private static Properties returnProperties(InputStream propertiesFileInputStream) throws IncorrectFileNameException, PropertiesException {
        try {
            Properties properties = new Properties();
            properties.load(propertiesFileInputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new IncorrectFileNameException(String.format("incorrect file name %s", propertiesFileInputStream), e);
        } catch (IOException e) {
            throw new PropertiesException(String.format("failed read %s file", propertiesFileInputStream), e);
        }
    }

    private static String checkAnimalNameInAnimalProperties(Properties animalProperties, String animalName) {
        return animalProperties.getProperty(animalName, animalName);

    }
}
