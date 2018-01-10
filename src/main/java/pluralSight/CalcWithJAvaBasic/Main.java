package pluralSight.CalcWithJAvaBasic;

import pluralSight.CalcWithJAvaBasic.Adder;
import pluralSight.CalcWithJAvaBasic.Divider;
import pluralSight.CalcWithJAvaBasic.DynamicHelper;
import pluralSight.CalcWithJAvaBasic.InvalidStatementException;
import pluralSight.CalcWithJAvaBasic.CalculateBase;
import pluralSight.CalcWithJAvaBasic.CalculateHelper;
import pluralSight.CalcWithJAvaBasic.MathEquation;
import pluralSight.CalcWithJAvaBasic.MathProcessing;
import pluralSight.CalcWithJAvaBasic.Multiplier;
import pluralSight.CalcWithJAvaBasic.Subtractor;


/**
 * Created by SaravanaTweak on 4/23/2017.
 */
public class Main
{
    public static void main(String args[]) {

        MathEquation[] mathEquations = getMathEquations();
        //Using Constructor
        usingConstructor(mathEquations);

        //Using class members for all functionality by means of abstract
        usingClassMembers();

        //Using String of passing values, and taking abstract derived classes help to
        //Acheive the calc App
        usingStringArrayPassingWithExceptionHandling();

        //Using Interface implementation to the calculations;
        usingInterface();

    }

    private static void usingInterface() {
        String[] statements = {
                "add 5.0 1.0",
                "subtract 6.0 2.0",
                "multiply 7.0 3.0",
                "divide 8.0 4.0"
        };

        DynamicHelper helper = new DynamicHelper(
                new MathProcessing[] {
                        new Adder(),
                        new Subtractor(),
                        new Multiplier(),
                        new Divider()
                }
        );

        for (String statement: statements) {
            System.out.println(helper.process(statement));
        }
    }

    private static void usingStringArrayPassingWithExceptionHandling() {
        //Using String of passing values, and taking abstract derived classes help to
        //Acheive the calc App
        String[] statements = {
                "add 1.0",              //error: Incorrect no of values
                "Add xx 2.0",           //error: Non-numeric value
                "asdf 3.0 4.0",        //error: Invalid command to perform
                "add 3.0 1.0",
                "subtract 4.0 2.0",
                "multiply 5.0 3.0",
                "divide 12.0 4.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for(String statement : statements) {
            try{
                helper.process(statement);
                System.out.println(helper);
            }catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if(e.getCause() !=null)
                    System.out.println("Cause: "+e.getCause());
            }

        }
    }

    private static void usingClassMembers() {

        CalculateBase[] calculateBases = {
                new Adder(2.0, 1.0),
                new Subtractor(3.0, 2.0),
                new Multiplier(4.0, 3.0),
                new Divider(8.0, 4.0)
        };

        for(CalculateBase calculator : calculateBases) {
            calculator.calculate();
            System.out.print("result: ");
            System.out.println(calculator.getResult());
        }
    }

    private static void usingConstructor(MathEquation[] mathEquations) {
        mathEquations[0] = new MathEquation("a", 1.0, 1.0);
        mathEquations[1] = new MathEquation("s", 2.0, 2.0);
        mathEquations[2] = new MathEquation("m", 3.0, 3.0);
        mathEquations[3] = new MathEquation("d", 4.0, 4.0);


//        for(MathEquation equation : mathEquations) {
//            equation.execute();
//            System.out.print("result for "+equation.getOpCode());
//            System.out.println(" : "+equation.getResult());
//        }
    }

    private static MathEquation[] getMathEquations() {
        //        mathEquations[0] = create(5.0, 1.0, "a");
//        mathEquations[1] = create(6.0, 2.0, "s");
//        mathEquations[2] = create(7.0, 3.0, "m");
//        mathEquations[3] = create(8.0, 4.0, "d");
        return new MathEquation[4];
    }

    public static MathEquation create(double leftVal, double rightVal, String opCode){
        MathEquation mathEquation = new MathEquation();
        mathEquation.setLeftVal(leftVal);
        mathEquation.setRightVal(rightVal);
        mathEquation.setOpCode(opCode);

        return mathEquation;
    }
}
