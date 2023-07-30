package zoo;

public class Duck extends Animal {
    @Override
    public void printYourName() {
        System.out.println("Duck");
    }

    @Override
    public void printYourSound() {
        System.out.println("Ga ga");
    }
}
