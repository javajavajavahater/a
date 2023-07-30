package org.example;

import org.example.exeptions.CustomExeption;
import org.example.exeptions.NotFoundAnimalNameException;
import org.example.exeptions.IncorrectFileNameException;
import org.example.zoo.Animal;
import org.example.zoo.AnimalFactory;
import org.example.zoo.FileMethods;

public class Main {
    private static final int ANIMALS_NAMES_FILE_PATH_INDEX = 0;
    private static final String delimiterAnimalNameFromText = " ";

    public static void main(String[] args) throws IncorrectFileNameException, NotFoundAnimalNameException, CustomExeption {
        String animalsNamesFilePath = args[ANIMALS_NAMES_FILE_PATH_INDEX];
        String[] animalName = FileMethods.returnLineTextFromFile(animalsNamesFilePath).split(delimiterAnimalNameFromText);
        createAnimalClassAndImplementsMethodsOfAnimalClass(animalsNamesFilePath, animalName);
    }

    private static void createAnimalClassAndImplementsMethodsOfAnimalClass(String animalsNamesFilePath, String[] textFileSplitBySpace)
            throws NotFoundAnimalNameException, CustomExeption {
        AnimalFactory animalFactory = new AnimalFactory();

        for (String animalClassName : textFileSplitBySpace) {
            Animal animal = animalFactory.createAnimal(animalClassName);
            animal.printYourName();
            animal.printYourSound();
        }
    }
}