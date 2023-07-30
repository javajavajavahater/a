package zoo;

import zoo.AnimalFactory;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //todo להעיף את ההערות, שם הקובץ יגיע מהארגיומנט
        // todo שהמימוש יהיה הכי להגדרה
        //todo להעביר לפונקציות עם שמות משמעותיים
        //todo

        String dataFromFile = "";
        FileWriter fileWriter;
        File fileAnimals;
        String[] animalsNames;
        AnimalFactory animalFactory = new AnimalFactory();


        try {
            fileAnimals = new File(args[0]);
            Scanner myReader = new Scanner(fileAnimals);
            dataFromFile = myReader.next();

            // todo what happens if an exception is thrown before (it won't close the file) - read about 'finally'
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        animalsNames = dataFromFile.split(" ");

        for (int i = 0; i< animalsNames.length; i++) {
            Animal animal;
            animal = animalFactory.createAnimal(animalsNames[i]);
            animal.printYourName();
            animal.printYourSound();
        }

    }
}