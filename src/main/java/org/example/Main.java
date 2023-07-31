package org.example;

import org.example.exeptions.AnimalExeption;
import org.example.exeptions.NotFoundAnimalNameException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.zoo.Animal;
import org.example.zoo.AnimalFactory;
import org.example.zoo.FileMethods;

public class Main {
    private static final int ANIMALS_NAMES_FILE_PATH_INDEX = 0;
    private static final String DELIMITER_ANIMAL_NAME_FROM_TEXT = " ";

    public static void main(String[] args) throws IncorrectFileNameException, NotFoundAnimalNameException, AnimalExeption {
        String animalsNamesFilePath = args[ANIMALS_NAMES_FILE_PATH_INDEX];
        String[] animalName = FileMethods.returnLineTextFromFile(animalsNamesFilePath).split(DELIMITER_ANIMAL_NAME_FROM_TEXT);
        createAnimalClassAndImplementsMethodsOfAnimalClass(animalName);
    }

    private static void createAnimalClassAndImplementsMethodsOfAnimalClass(String[] textFileSplitBySpace)
            throws NotFoundAnimalNameException, AnimalExeption {
        AnimalFactory animalFactory = new AnimalFactory();

        for (String animalClassName : textFileSplitBySpace) {
            Animal animal = animalFactory.createAnimal(animalClassName);
            animal.printYourName();
            animal.printYourSound();
        }
    }
}