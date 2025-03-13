public class Calculator {
    public static void main(String[] args) {

        double a = 11, b = 4, c = 2, d = 3, e = 5, f = 1;

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