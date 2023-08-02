package org.example;

import org.example.exeptions.AnimalException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.PropertiesException;
import org.example.zoo.Animal;
import org.example.zoo.AnimalFactory;
import org.example.zoo.FileMethods;
import org.example.zoo.PropertiesFileMethods;

public class Main {
    private static final int ANIMALS_NAMES_FILE_PATH_INDEX = 0;
    private static final String DELIMITER_ANIMAL_NAME_FROM_TEXT = " ";
    private static final String ANIMAL_PROPERTIES_FILE_NAME = "animal.properties";

    public static void main(String[] args) throws IncorrectFileNameException, AnimalException, PropertiesException {
        String animalsNamesFilePath = args[ANIMALS_NAMES_FILE_PATH_INDEX];
        String[] animalsNames = FileMethods.returnLineTextFromFile(animalsNamesFilePath).split(DELIMITER_ANIMAL_NAME_FROM_TEXT);
        createAnimalAndImplementsAnimalClassMethods(animalsNames);
    }

    private static void createAnimalAndImplementsAnimalClassMethods(String[] animalsNames)
            throws AnimalException, IncorrectFileNameException, PropertiesException {
        AnimalFactory animalFactory = new AnimalFactory(PropertiesFileMethods.returnProperties(ANIMAL_PROPERTIES_FILE_NAME));

        for (String animalName : animalsNames) {
            Animal animal = animalFactory.createAnimal(animalName);
            animal.printYourName();
            animal.printYourSound();
        }
    }

}
