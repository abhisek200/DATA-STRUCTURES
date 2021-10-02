import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    //enQueue
    public void enQueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog)       //user will state which class to go to, dog or cat
            dogs.addLast((Dog) a);
        else if (a instanceof Cat)
            cats.addLast((Cat) a);
    }

    //size
    int size() {
        return dogs.size() + cats.size();
    }

    //deQueue Dogs
    Dog dequeueDogs() {
        return dogs.poll(); //removes 1st element , in LL library
    }

    //peek dogs
    Dog peekDogs() {
        return dogs.peek(); //returns 1st element , in LL library
    }

    Cat dequeueCats() {
        return cats.poll(); //removes 1st element , in LL library
    }

    //peek dogs
    Cat peekCats() {
        return cats.peek(); //returns 1st element , in LL library
    }

    //deQueueAny
    public Animal dequeueAny() {
        if (dogs.size() == 0)
            dequeueCats();
        else if (cats.size() == 0)
            dequeueDogs();
        Dog dog = dogs.peek(); //1st element
        Cat cat = cats.peek();


        if (dog.isOlderThan(cat))  //both the cases
            return dogs.poll();
        else
            return cats.poll();
    }

    //peek
    Animal peek() {
        if (dogs.size() == 0)
            return cats.peek();
        else if (cats.size() == 0)
            return dogs.peek();
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat))
            return dogs.peek();
        else
            return cats.peek();
    }
}
