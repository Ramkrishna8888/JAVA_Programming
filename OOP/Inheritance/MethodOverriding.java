// Superclass
class Animal {
    // Method in the superclass
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Dog extends Animal {
    // Overriding the method in the subclass
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(); // Creating an object of Animal class
        animal.sound(); // Calling the method from Animal class
        
        Dog dog = new Dog(); // Creating an object of Dog class
        dog.sound(); // Calling the overridden method from Dog class
    }
}
