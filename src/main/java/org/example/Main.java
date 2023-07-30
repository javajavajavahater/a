package org.example;

import org.example.exeptions.NotFoundAnimalName;
import org.example.exeptions.IncorrectFileNameException;
import org.example.zoo.Animal;
import org.example.zoo.AnimalFactory;
import org.example.zoo.FileMethods;

public class Main {
    private static final int ANIMALS_NAMES_FILE_PATH_INDEX = 0;
    private static final String delimiterAnimalNameFromText = " ";

    public static void main(String[] args) throws IncorrectFileNameException, NotFoundAnimalName {
        String animalsNamesFilePath = args[ANIMALS_NAMES_FILE_PATH_INDEX];
        // todo better parameter name + better method name that gets delimiter as parameter
        String[] animalName = FileMethods.returnLineTextFromFile(animalsNamesFilePath).split(delimiterAnimalNameFromText);

        // todo rename yoel
        createAnimalClassAndImplementsMethodsOfAnimalClass(animalsNamesFilePath, animalName);
    }

    private static void createAnimalClassAndImplementsMethodsOfAnimalClass(String animalsNamesFilePath, String[] textFileSplitBySpace) throws NotFoundAnimalName {
        AnimalFactory animalFactory = new AnimalFactory();

        for (String animalClassName : textFileSplitBySpace) {
            Animal animal = animalFactory.createAnimal(animalClassName);
            animal.printYourName();
            animal.printYourSound();
        }
    }
}