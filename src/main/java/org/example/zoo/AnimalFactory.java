package org.example.zoo;

import org.example.exeptions.NotFoundAnimalName;

public class AnimalFactory {

    // todo read about reflection and turn this factory into a dynamic factory
    public Animal createAnimal(String className) throws NotFoundAnimalName {
        if (className.equals("Cat")) {
            return new Cat();
        } else if (className.equals("Dog")) {
            return new Dog();
        } else if (className.equals("Duck")) {
            return new Duck();
        }

        // todo throw custom exception here with a good message
        throw new NotFoundAnimalName("animal name %s not exist in classes".formatted(className), new Throwable().getCause());
    }
}
