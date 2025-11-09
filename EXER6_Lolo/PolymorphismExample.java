class Animal {
    public void speak() {
        System.out.println("Tiger: Roar!");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog: Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Cat: Meow!");
    }
}

public class PolymorphismExample {
    public static void makeAnimalSpeak(Animal animal) {
        animal.speak();
    }

    public static void main(String[] args) {
        Animal dog = new Dog();  
        Animal cat = new Cat();
        Animal genericAnimal = new Animal();

        makeAnimalSpeak(dog);       
        makeAnimalSpeak(cat);   
        makeAnimalSpeak(genericAnimal); 
    }
}
