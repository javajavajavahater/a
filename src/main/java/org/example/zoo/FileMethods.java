package org.example.zoo;

import org.example.exeptions.IncorrectFileNameException;

import java.io.*;
import java.util.Scanner;

public class FileMethods {

    public static String returnLineTextFromFile(String fileName) throws IncorrectFileNameException {
        try(Scanner readerFile = new Scanner(new File(fileName))) {
             return readerFile.nextLine();
        } catch (FileNotFoundException e) {
            throw new IncorrectFileNameException("incorrect file name, check if the argument is the correct name of the file", e);
        }
    }
}
