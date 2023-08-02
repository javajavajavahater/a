package org.example.zoo;

import org.example.exeptions.IncorrectFileNameException;
import org.example.exeptions.PropertiesException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileMethods {
    private PropertiesFileMethods() {
    }

    public static Properties returnProperties(String propertiesFileName) throws IncorrectFileNameException, PropertiesException {
        try {
            Properties properties = new Properties();
            properties.load(FileMethods.getResourceFileAsInputStream(propertiesFileName));
            return properties;
        } catch (FileNotFoundException e) {
            throw new IncorrectFileNameException(String.format("incorrect file name %s", propertiesFileName), e);
        } catch (IOException e) {
            throw new PropertiesException(String.format("failed read %s file", propertiesFileName), e);
        }
    }
}
