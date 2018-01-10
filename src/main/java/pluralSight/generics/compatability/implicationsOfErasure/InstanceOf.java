package pluralSight.generics.compatability.implicationsOfErasure;

public class InstanceOf<T> {
    public boolean equals(Object o) {
        // Banned
        if (o instanceof InstanceOf/*<T>*/) {
            return true;
        }

        return false;
    }
}
