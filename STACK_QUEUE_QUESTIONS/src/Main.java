public class Main {
    public static void main(String[] args) {
        AnimalQueue animals=new AnimalQueue();
        animals.enQueue(new Cat("kiki"));
        animals.enQueue(new Cat("kari"));
        animals.enQueue(new Dog("spider"));
        animals.enQueue(new Dog("leo"));
        animals.enQueue(new Cat("shine"));

        System.out.println(animals.dequeueAny().name); //kiki
        System.out.println(animals.dequeueDogs().name); //spider
    }
}
