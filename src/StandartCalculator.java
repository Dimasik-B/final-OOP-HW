public class StandartCalculator implements Calculable<Double>{
    private double result;


    public StandartCalculator() {
        this.result = 0;
    }

    @Override
    public void sum(Double a, Double b) {
        result = a + b;
    }

    @Override
    public void substract(Double a, Double b) {
        result = a - b;
    }

    @Override
    public void multiply(Double a, Double b) {
        result = a * b;
    }

    @Override
    public void division(Double a, Double b) {
        result = a / b;
    }

    public Double result(){
        return result;
    }
    public void resetResult(){
        this.result = 0;
    }
}
