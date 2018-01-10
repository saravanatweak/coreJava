package DesignPatterns.Creational.Prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saravanakumar_K05 on 11/20/2017.
 */
public class PrototypeExp {

        public static void main(String args[]) {

            String sql = "select * from movies where title = ?";

            List<String> parameters = new ArrayList<>();

            parameters.add("Mad Max");

            Record record = new Record();// Very first it will be empty object

            Statement firstStatement = new Statement(sql, parameters, record);
            System.out.println(firstStatement.getSql());
            System.out.println(firstStatement.getParameters());
            System.out.println(firstStatement.getRecord());

            //Will Return whatever teh above values has returned incluing the object reference of the getRecord object
            //So even though it went through and it did our clone inside of Statement:20, it just returned the references
            // to the array lists that were passed in and the references to the record object that were passed in.
            // This is an example of a shallow copy.because those objects are just getting returned the same as what we had passed in, so it's not necessarily a true copy. In fact, it's a little bit of a dangerous copy because we could go through and change the parameters in this array list, and it would reflect in both objects.
            Statement secondStatement = firstStatement.clone();
            System.out.println(secondStatement.getSql());
            System.out.println(secondStatement.getParameters());
            System.out.println(secondStatement.getRecord()); //pay attendtio to his

            /*Note : Now if we were doing a deep copy, it would return a new array list with those parameters passed into it and a new record object with whatever values the record object had stored in here, which currently is nothing.*/

        }


    }

class Statement implements Cloneable {

    private String sql;
    private List<String> parameters;
    private Record record;

    public Statement(String sql, List<String> parameters, Record record) {
        this.sql = sql;
        this.parameters = parameters;
        this.record = record;
    }

    public Statement clone() { //It then in turn creates an instance of this record object as Record is plain empty object
        try {
            return (Statement) super.clone(); //this is what returns our instance that we then cast to our Statement object.
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Record getRecord() {
        return record;
    }

    public String getSql() {
        return sql;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}

class Record {
}

