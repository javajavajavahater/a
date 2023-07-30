package zoo;

public class AnimalFactory {
    public Animal createAnimal(String className) {
            if (className.equals("Cat")) {
                return new Cat();
            } else if (className.equals("Dog")) {
                return new Dog();
            } else if (className.equals("Duck")) {
                return new Duck();
            }

        return null;
    }
}
