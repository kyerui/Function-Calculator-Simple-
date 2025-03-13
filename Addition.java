class Addition extends Operation {
    public Addition(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public void run() {
        result = operand1 + operand2;
    }
}