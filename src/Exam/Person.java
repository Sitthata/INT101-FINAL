package Exam;
import java.util.*;

public class Person {
    public static int nextCode = 57;
    private int code;
    private String firstname;
    private String lastname;
    private int type;
    private static final int defaultType = 1;

    public Person(String firstname, String lastname, int type){
        this.firstname =  isValid(firstname) ? firstname : "Pattaradanai";
        this.lastname =   isValid(lastname) ? lastname : "Srichon";
        this.code = nextCode++;
        this.type = type > 0 ? type : defaultType;
    }

    public Person(String firstname, String lastname) {
        this.firstname =  isValid(firstname) ? firstname : "Pattaradanai";
        this.lastname =   isValid(lastname) ? lastname : "Srichon";
        this.type = defaultType;
    }

    public static boolean isValid(String str) {
        return str != null  && !str.isBlank();
    }

    public int getCode() {
        return code;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getType() {
        return type;
    }

    public void setFirstname(String firstname) {
        this.firstname =  isValid(firstname) ? firstname : "Pattaradanai";
    }

    public void setLastname(String lastname) {
        this.lastname =  isValid(lastname) ? lastname : "Pattaradanai";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[Person ");
        // [Person: CODE (FIRSTNAME LASTNAME) TYPE]
        sb.append("Code : ").append(code);
        sb.append(" (").append(firstname);
        sb.append(" ").append(lastname);
        sb.append("), Type : ").append(type);
        sb.append(']');
        return sb.toString();
    }
}
