import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();

        System.out.print("Digite o valor de c: ");
        double c = scanner.nextDouble();

        System.out.print("Digite o valor de d: ");
        double d = scanner.nextDouble();

        System.out.print("Digite o valor de e: ");
        double e = scanner.nextDouble();

        System.out.print("Digite o valor de f: ");
        double f = scanner.nextDouble();

        scanner.close();

        Subtraction subtraction1 = new Subtraction(a, b);
        Addition addition1 = new Addition(c, d);
        Addition addition2 = new Addition(e, f);

        Thread thread1 = new Thread(subtraction1);
        Thread thread2 = new Thread(addition1);
        Thread thread3 = new Thread(addition2);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        double resultSubtraction1 = subtraction1.getResult();
        double resultAddition1 = addition1.getResult();
        double resultAddition2 = addition2.getResult();

        Multiplication multiplication = new Multiplication(resultSubtraction1, resultAddition1);
        Thread thread4 = new Thread(multiplication);
        thread4.start();

        try {
            thread4.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        double resultMultiplication = multiplication.getResult();

        Subtraction finalSubtraction = new Subtraction(resultMultiplication, resultAddition2);
        Thread thread5 = new Thread(finalSubtraction);
        thread5.start();

        try {
            thread5.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        double finalResult = finalSubtraction.getResult();

        System.out.println("O resultado da expressão ((a - b) * (c + d) - (e + f)) é: " + finalResult);
    }
}

class Subtraction implements Runnable {
    private double num1, num2;
    private double result;

    public Subtraction(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        result = num1 - num2;
    }

    public double getResult() {
        return result;
    }
}

class Addition implements Runnable {
    private double num1, num2;
    private double result;

    public Addition(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        result = num1 + num2;
    }

    public double getResult() {
        return result;
    }
}

class Multiplication implements Runnable {
    private double num1, num2;
    private double result;

    public Multiplication(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        result = num1 * num2;
    }

    public double getResult() {
        return result;
    }
}