package DesignPatterns.Creational.Singleton;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


//Try to see pluralSight.SingletonExp as well
//If the below example is not working well, try to run this code in eclipse or sts by adding derby, derbyclient jars into the project
public class SingletonPatternExp{

    public static void main(String[] args) {
        ////Thumb rule1 : one instance is going to be created
/*
        STSingleInstance singleInstance1 = STSingleInstance.getInstance();
        STSingleInstance singleInstance2 = STSingleInstance.getInstance();
        System.out.println(singleInstance1);
        System.out.println(singleInstance2);
*/
/*
        //Thumb Rule2: Enabling Lazly loaded approach still it works
        STLazlyLoaded singleInstance1 = STLazlyLoaded.getInstance();
        STLazlyLoaded singleInstance2 = STLazlyLoaded.getInstance();
        System.out.println(singleInstance1);
        System.out.println(singleInstance2);
*/
        //Thumb Rule 3: Making code wiht thread safe, Very imp where you are implementing the thread safe,
        //as by introducing threa safe will hit your performance

        STThreadSafe st1 = STThreadSafe.getInstance();
        STThreadSafe st2 = STThreadSafe.getInstance();
        System.out.println(st1);
        System.out.println(st2);
        System.out.println();

        //With Database connection
        //uncomment the constructor part to run the appliacation

        long timeBefore = 0;
        long timeAfter = 0;

        STDataBase stdb1 = STDataBase.getInstance();

        timeBefore = System.currentTimeMillis();
        Connection conn = stdb1.getConnection(); //As bcoz getConnection method is not static we can call through instance of class only.
        timeAfter = System.currentTimeMillis();

        System.out.println(timeAfter - timeBefore);


        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta
                    .executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
                            + " City VARCHAR(20))");
            System.out.println("Table created.");
            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*for the 2nd time it will print zero time difference because
        it's actually optimized inside of the compiler to where it's now faster for us to retrieve it. So you can see where we can both control access to our application, but also increase performance by returning that same instance.*/

        timeBefore = System.currentTimeMillis();
        conn = stdb1.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println(timeAfter - timeBefore);

    }



}

class STSingleInstance {
    //Eagerly loaded (because we were creating this at the time that the JVM started up.)
    private static STSingleInstance instance = new STSingleInstance();
    //Cant create a instance of this class by providing private constructor
    private STSingleInstance() {} // Make sure nobody can create a object of this class

    public static STSingleInstance getInstance() {
        return instance;
    }

}

class STLazlyLoaded {

    //Coverting Eagerly loaded into Lazily loaded approach
    //Egarly loaded: It will delay the startup time of your application every time applications gets loaded
    private static STLazlyLoaded instance = null; // Eagerly to lazily


    private STLazlyLoaded() {}

    public static STLazlyLoaded getInstance() {
        if(instance == null) {
            return new STLazlyLoaded();
        }
        return instance;
    }

}

class STThreadSafe {

    private static STThreadSafe instance = null; // Eagerly to lazily
    private STThreadSafe() {} // Making sure nobody can create a object of this class

    //public static synchronized STThreadSafe getInstance() {
    //if we do like this, everybody who accesses our method every time is going to be synchronized,
    // and it's going to slow it down. We honestly only care about it being synchronized for the first time
    // that we run this and create that instance to make sure that there isn't a race condition.

    //So the better approach is
    public static STThreadSafe getInstance() {

        if(instance == null) {
            synchronized (STThreadSafe.class){
                if(instance == null)
                    instance = new STThreadSafe();
            }
        }
        return instance;
    }

}

class STDataBase{

    private static STDataBase instance = null;

    private Connection conn = null;

    private STDataBase () {
        /*try {
        //what this does is when we create our instance of our singleton its going to go through and register a driver for the database, so this will actually create our instance of our database for us or load our class into memory for us to utilize. *//*
        //add derby and derbyclient.jar, error will go away
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public static STDataBase getInstance() {
        if(instance == null) {
            synchronized(STDataBase.class) {
                if (instance == null) {
                    instance = new STDataBase();
                }
            }
        }

        return instance;
    }
/*this method is not static. this getConnection method has to be called once we have an instance of our singleton*/
    public Connection getConnection() {
        if(conn == null) {
            synchronized (STDataBase.class) {
                if(conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;
    }

}
