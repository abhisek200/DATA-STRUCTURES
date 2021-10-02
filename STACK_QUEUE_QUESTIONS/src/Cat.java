public class Cat extends Animal {
    public Cat(String n){
        super(n);       //calls constructor of main class
    }

    public String name(){
        return "Cat:"+name;
    }
}
