package pluralSight.CalcWithJAvaBasic;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword(); // add
    char getSymbol();   // +
    double doCalculate(double leftVal, double rightVal);
}
