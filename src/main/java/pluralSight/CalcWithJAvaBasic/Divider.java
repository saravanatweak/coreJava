package pluralSight.CalcWithJAvaBasic;

/**
 * Created by SaravanaTweak on 4/24/2017.
 */
public class Divider extends CalculateBase implements MathProcessing {
    public Divider() {}
    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() != 0.0 ? getLeftVal()/ getRightVal() : 0.0);
    }

    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public char getSymbol() {
        return '/';
    }

    @Override
    public double doCalculate(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
