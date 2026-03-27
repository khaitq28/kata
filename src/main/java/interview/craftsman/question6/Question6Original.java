package interview.craftsman.question6;

/**
 * INTERVIEW QUESTION 6 — Original (smelly) code.
 */
public class Question6Original {

    interface Animal {
        void eat();
        void fly();
        void swim();
        void run();
    }

    class Dog implements Animal {
        public void eat() { System.out.println("Dog eats"); }
        public void fly() { throw new UnsupportedOperationException("Dogs can't fly"); }
        public void swim() { System.out.println("Dog swims"); }
        public void run() { System.out.println("Dog runs"); }
    }

    class Eagle implements Animal {
        public void eat() { System.out.println("Eagle eats"); }
        public void fly() { System.out.println("Eagle flies"); }
        public void swim() { throw new UnsupportedOperationException("Eagles don't swim"); }
        public void run() { throw new UnsupportedOperationException("Eagles don't run"); }
    }

    class Goldfish implements Animal {
        public void eat() { System.out.println("Goldfish eats"); }
        public void fly() { throw new UnsupportedOperationException("Goldfish can't fly"); }
        public void swim() { System.out.println("Goldfish swims"); }
        public void run() { throw new UnsupportedOperationException("Goldfish can't run"); }
    }
}
