package pluralSight.CalcWithJAvaBasic;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathCommand command;
    private double leftVal;
    private double rightVal;
    private Double result;

    public void process (String statement) throws InvalidStatementException {
        //add 5.0 1.0
        String[] parts = statement.split(" ");
        if(parts.length != 3)
            throw new InvalidStatementException("total no of fields is missing", statement);

        String commandString = parts[0];
        try {
            leftVal = Double.parseDouble(parts[1]);
            rightVal = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-Numberic values",statement, e.getCause());
        }

        setCommand(commandString);
        if(command == null)
            throw  new InvalidStatementException("Invalid command to perform",statement);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftVal,rightVal);  break;
            case Subtract:
                calculator = new Subtractor(leftVal, rightVal); break;
            case Multiply:
                calculator = new Multiplier(leftVal, rightVal); break;
            case Divide:
                calculator = new Divider(leftVal, rightVal); break;
        }
        calculator.calculate();
        result = calculator.getResult();
    }

    public void setCommand(String commandString) {
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())){
            command = MathCommand.Add;
        }
        if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString())){
            command = MathCommand.Subtract;
        }
        if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            command = MathCommand.Multiply;
        }
        if(commandString.equalsIgnoreCase(MathCommand.Divide.toString())){
            command = MathCommand.Divide;
        }
    }

    public String toString() {
        char symbol = 0;
        switch (command) {
            case Add: symbol= ADD_SYMBOL; break;
            case Subtract: symbol=SUBTRACT_SYMBOL; break;
            case Multiply: symbol=MULTIPLY_SYMBOL; break;
            case Divide: symbol=DIVIDE_SYMBOL; break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightVal);
        sb.append("=");
        sb.append(result);

        return  sb.toString();
    }
}
