package pluralSight.generics.compatability.implicationsOfErasure;

public class UncompilableException/*<T> */ extends Exception {
    public static void main(String[] args) {
        try {
            throw new UncompilableException();
        } catch (UncompilableException/*<T>*/ e) {
            e.printStackTrace();
        }
    }
}
