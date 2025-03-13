abstract class Operation implements Runnable {
    protected double result;
    protected double operand1;
    protected double operand2;

    public Operation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    @Override
    public abstract void run();
}