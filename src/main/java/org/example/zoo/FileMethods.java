package org.example.zoo;

import org.example.exeptions.IncorrectFileNameException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMethods {

    private FileMethods() {
    }

    public static String returnLineTextFromFile(String fileName) throws IncorrectFileNameException {
        try (Scanner readerFile = new Scanner(new File(fileName))) {
            return readerFile.nextLine();
        } catch (FileNotFoundException e) {
            throw new IncorrectFileNameException(String.format("incorrect file name %s,check if the argument is the correct name of the file", fileName), e);
        }
    }
}
