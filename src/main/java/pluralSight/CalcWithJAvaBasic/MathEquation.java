package pluralSight.CalcWithJAvaBasic;

/**
 * Created by SaravanaTweak on 4/23/2017.
 */
public class MathEquation {

    private double leftVal;
    private double rightVal;
    private String opCode;
    private double result;

    public MathEquation() {}
    public MathEquation(String opCode) {
        this.opCode = opCode;
    }
    public MathEquation(String opCode, double leftVal, double rightVal) {
        this(opCode); // will automatically call the corresponding constructor
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
    
    public void execute() {
        switch(opCode) {
            case "a":
                result = leftVal + rightVal;
                break;
            case "s":
                result = leftVal - rightVal;
                break;
            case "m":
                result = leftVal * rightVal;
                break;
            case "d":
                result = leftVal != 0.0 ? leftVal/rightVal : 0.0;
                break;
            default:
                System.out.println("Invalid opCode");
                result = 0.0d;
                break;
        }
    }

    public void setLeftVal(double leftVal) {            this.leftVal = leftVal;    }

    public void setRightVal(double rightVal) {        this.rightVal = rightVal;    }

    public void setOpCode(String opCode) {        this.opCode = opCode;    }

    public String getOpCode() {        return opCode;    }

    public double getResult() {        return result;    }
}
