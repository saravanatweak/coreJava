package DesignPatterns.Creational.Builder;


public class BuilderPatternExp {

    public static void main(String[] args) {

/*
        //1. Pblm with plain bean approach;
        PblmWithSimpleBean pwsb = new PblmWithSimpleBean();

        pwsb.setAge(29);
        pwsb.setName("Saravana");

        //the problem here is even if you comment above lines it will print the null values
        System.out.println(pwsb.getName());
        System.out.println(pwsb.getAge());
*/
/*
        //2. Overcome with bean by telescoping
        ImmutableWithTelescopingConstructor teleApp = new ImmutableWithTelescopingConstructor("saravana");
        ImmutableWithTelescopingConstructor teleApp2 = new ImmutableWithTelescopingConstructor(null, 12);//So here is the problem
        //if i want to modifiy the name in both fields, its not possible as there is no setter methods.
*/

        //3. finally using Builder patter we are solving this pblm
        ClassWithBuilderPattern.Builder builder = new ClassWithBuilderPattern.Builder();

        //I was parsing these values out of a CSV file, out of a comma separated value files as I was going,
        // so I, instead of trying to gather all of those at once in all the different conditions, I could grab it,
        // and if that value existed, I could then append it on, and if it didn't I'd go to the next one. I could keep going through.
        //we also have that immutability that nobody can edit it.
        builder.name("saravana").age(12).number(1234);
        ClassWithBuilderPattern clasWithBuilder = builder.build();
        System.out.println(clasWithBuilder.getName()+" " +clasWithBuilder.getAge()+" "+clasWithBuilder.getNumber());

        //even if remove anyone of the element in teh above chain it will work like
        builder.name("Saravana").number(12345);
        ClassWithBuilderPattern clasWithBuilder1 = builder.build();
        System.out.println(clasWithBuilder1.getName()+" " +clasWithBuilder.getNumber());

        //public Builder() { } // but we can mandate that this constructor take arguments for things that are required.
        //if you did want to force them to have certain things in there, we can make it to where they have to
        // use one instance of the Builder with whatever those values are so we can get that benefit of the
        // telescoping constructors without the limitations or the problems of maintaining those individual constructors.



    }


}

class PblmWithSimpleBean {
    private String name;
    private int age;

    public PblmWithSimpleBean(){ //Problem wiht Bean
        /*So we're using this default no-arg constructor here, and then we have a getter and setter exposed for every individual property that we have there. The problem with this is for one, it's not immutable, meaning that after we create it we can go through and change it because we have all these setters, and it's really unclear what the contract is of what they must have or must not have to signify what their lunch order is. */

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //setter mthods are exposed, means
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class ImmutableWithTelescopingConstructor {
    private String name;
    private int age;
    private long number;

    public ImmutableWithTelescopingConstructor(){ }

    public ImmutableWithTelescopingConstructor(String name ) { this.name = name; }

    public ImmutableWithTelescopingConstructor(String name, int age) {
        this(name);// This approach is called Telescoping constructor
        this.age = age;
    }

    //Here there is a strong possiblity that we could pass name as null, it will end up pblm
    //Real poblem is what if i want to pass only name and number, in that case i have to again define a new constructor
    //And Though the setter methods is here we have to live up with ending up multiple constructors
    //It might overcome the bean class issue, but again we are ended up wiht living with multiple constructors and can set fiels wiht null value
    public ImmutableWithTelescopingConstructor(String name, int age, long number) {
        this(name, age);// This approach is called Telescoping constructor
        this.number = number;
    }


    public long getNumber() {
        return number;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class ClassWithBuilderPattern {

    public static class Builder {//skeleton of builder class
        //purpose of the below values are, is that the Builder is its own container until we tell what its needs to do
        private String name;
        private int age;
        private long number;


        public Builder() { } // but we can mandate that this constructor take arguments for things that are required. if the arqs should not be empty while creating

        public Builder name(String name) {//we could also use type-safe enums for this as well
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age= age;
            return this;
        }

        public Builder number (long number) {
            this.number= number;
            return this;
        }

        public ClassWithBuilderPattern build() {
            return new ClassWithBuilderPattern(this);
        }
    }

    private final String name;
    private final int age;
    private final long number;

    //we have the flexibility of the bean approach with the contract nature of the constructors.
    private ClassWithBuilderPattern(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.number= builder.number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getNumber() {
        return number;
    }
}
