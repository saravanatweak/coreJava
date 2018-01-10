package pluralSight.CalcWithJAvaBasic;

/**
 * Created by SaravanaTweak on 4/24/2017.
 */
public class Adder extends CalculateBase implements MathProcessing{
    public Adder() {}
    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }
    @Override
    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculate(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
