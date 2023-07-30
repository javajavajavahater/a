package zoo;

public class Cat extends Animal{
    @Override
    public void printYourName() {
        System.out.println("Cat");
    }

    @Override
    public void printYourSound() {
        System.out.println("Miao");
    }
}
