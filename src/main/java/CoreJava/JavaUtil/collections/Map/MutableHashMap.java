package CoreJava.JavaUtil.collections.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MutableHashMap {
    public static void main(String args[]){

        final Map<MutableString, String > brokenMap = new HashMap<>();

        final String value ="aaa";

        final MutableString key = new MutableString(value);
        brokenMap.put(key,value);


        //Before chaging the key value
        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);

        //AFter modifying hte key value
        key.set("bbb");
        System.out.println(brokenMap.get(key)); //,"Due to key modification it will produce null"));
        System.out.println(brokenMap);
    }

    private static class MutableString {
        private String value;

        public MutableString(String value) { set(value);}

        private void set(String value) {
            Objects.requireNonNull(value);
            this.value=value;
        }

        public String getValue() { return  this.value ;}

        public boolean equals( Object o) {
            if(this == o) return true;
            if( o == null || getClass() != o.getClass()) return false;
            MutableString current = (MutableString) o;
            return value.equals(current.value);
        }

        public int hashCode() { return value.hashCode();}

        public String toString(){ return this.value; }
        }
    }



