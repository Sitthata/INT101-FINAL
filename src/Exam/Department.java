package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Exam.Person.*;

public class Department {

    private int code;
    private String title;
    private Person[] staff;
    private int count;
    public static int nextCode = 400;
    public static int size = 10;
    public static int[] emptyArray = new int[size];


    public Department(String title) {
        this.title = isValid(title) ? title : "Assumption College" ;
        this.code = nextCode++;
        staff = new Person[size];
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCount() {
        return count;
    }

    public boolean addStaff(String firstname, String lastname, int type) {
        if(!isValid(firstname) && !isValid(lastname) && count == size) {
            return false;
        }
        staff[count] = new Person(firstname,lastname,type);
        count++;
        return true;
    }

    public int[] getAllCode() {
        int[] allCode = new int[size];

        for (int i = 0; i < size; i++) {
            allCode[i] = staff[i].getCode();
        }
        return allCode;
    }

    public Person getStaff(int code) {
        for (int i = 0; i < size; i++) {
            if(staff[i].getCode() == code) return staff[i];
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[Department");
        sb.append("Code: ").append(code);
        sb.append(" (").append(title);
        sb.append(") Count: ").append(count);
        sb.append(']');
        return sb.toString();
    }

    public int[] getAllType() {
        int[] allType = new int[size];

        for (int i = 0; i < size; i++) {
            allType[i] = staff[i].getType();
        }
        Arrays.sort(allType);
        int check = allType.length;
        
        for (int i = 0; i < check; i++) {
            for (int j = i + 1; j < check; j++) {
                if(allType[i] == allType[j]) {
                    allType[j] = allType[check - 1];
                    check--;
                    j--;
                }
            }

        }
        int[] result = Arrays.copyOf(allType, check);
        Arrays.sort(result);
        return result;

        /*
        int check = allType.length;
        int j = 0;
        int[] temp = new int[check];
        for (int i = 0; i < check - 1; i++) {
            if(allType[i] != allType[i + 1]){
                temp[j++] = allType[i];
                check--;
            }
        }
        temp[j++] = allType[check - 1];
        for (int i = 0; i < check; i++) {
            allType[i] = temp[i];
        }
        */
    }

}
