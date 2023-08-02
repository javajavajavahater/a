package org.example.zoo;

import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.PropertiesException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileMethods {
    private PropertiesFileMethods() {}

    public static Properties returnProperties(InputStream propertiesFileInputStream) throws IncorrectFileNameException, PropertiesException {
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


}
