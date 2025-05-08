package deque;

import java.util.Comparator;

public class Dog {
    // Instance variables
    private String name;
    private String size;  // Small, Medium, Large, etc.

    // Default constructor
    public Dog() {
        this.name = "Unknown";
        this.size = "Medium";
    }

    // Parameterized constructor
    public Dog(String name, String size) {
        this.name = name;
        this.size = size;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for size
    public String getSize() {
        return size;
    }

    // Setter for size
    public void setSize(String size) {
        this.size = size;
    }

    // Method to make the dog bark
    public void bark() {
        if (size.equalsIgnoreCase("Small")) {
            System.out.println(name + " says: Yip! Yip!");
        } else if (size.equalsIgnoreCase("Medium")) {
            System.out.println(name + " says: Woof! Woof!");
        } else if (size.equalsIgnoreCase("Large")) {
            System.out.println(name + " says: WOOF! WOOF!");
        } else {
            System.out.println(name + " says: Bark!");
        }
    }

    // toString method to print dog details
    @Override
    public String toString() {
        return "Dog [name=" + name + ", size=" + size + "]";
    }

    // Example main method to demonstrate the Dog class
    public static void main(String[] args) {
        // Creating dog objects
        Dog dog1 = new Dog("Rex", "Large");
        Dog dog2 = new Dog("Bella", "Small");
        Dog dog3 = new Dog();  // Using default constructor

        // Setting name for dog3
        dog3.setName("Charlie");

        // Print details of all dogs
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);

        // Make all dogs bark
        dog1.bark();
        dog2.bark();
        dog3.bark();
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);

        }


    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}