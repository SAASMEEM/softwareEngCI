package org.example;

public class Application {
    public int getFibonacciNumberAt(int n) {
        if (n < 2) {
            return n;
        } else {
            return getFibonacciNumberAt(n - 1) + getFibonacciNumberAt(n - 2);
        }
    }

    public void print(String bla) {
        System.out.println(bla);
    }

    public static void main(String... args) {
        Application application = new Application();
        System.out.println(application.getFibonacciNumberAt(5));
    }
}
