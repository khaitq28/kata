package interview.craftsman.question6;

import java.util.ArrayList;
import java.util.List;

public class Question6Correction {

    interface Animal {
        void eat();
    }

    interface WaterAnimal extends  Animal {
        void swim();
    }

    interface FlyAnimal extends  Animal {
        void fly();
    }

    interface OrdinaryAnimal extends Animal {
        void run();
    }

    class Dog implements Question6Correction.OrdinaryAnimal, Question6Correction.WaterAnimal {
        public void eat() { System.out.println("Dog eats"); }
        public void swim() { System.out.println("Dog swims"); }
        public void run() { System.out.println("Dog runs"); }
    }

    class Eagle implements  Question6Correction.FlyAnimal  {
        public void eat() { System.out.println("Eagle eats"); }
        public void fly() { System.out.println("Eagle flies"); }
    }

    class Goldfish implements Question6Correction.WaterAnimal  {
        public void eat() { System.out.println("Goldfish eats"); }
        public void swim() { System.out.println("Goldfish swims"); }
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Question6Correction().new Dog());
        animals.add(new Question6Correction().new Eagle());
        animals.add(new Question6Correction().new Goldfish());

        for (Animal animal : animals) {
            animal.eat();
            if (animal instanceof WaterAnimal) {
                ((WaterAnimal) animal).swim();
            }
            if (animal instanceof FlyAnimal) {
                ((FlyAnimal) animal).fly();
            }
            if (animal instanceof OrdinaryAnimal) {
                ((OrdinaryAnimal) animal).run();
            }
        }
    }
}
