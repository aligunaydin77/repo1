package test;

import java.util.function.*;
public class IkmTest {    
    public static void main (String [] args) {
    Storage s1 = new Storage(2, 4);
    Storage s2 = new Storage(6, 8);
    System.out.println(s1.data1 + ", " + s1.data2);
    System.out.println(s2.data1 + ", " + s2.data2);
    s1.modify(s1::getData1);
    s2.modify(s1::getData1);
    System.out.println(s1.data1 + ", " + s1.data2);
    System.out.println(s2.data1 + ", " + s2.data2);
    int modifier = 2;
    s1.modify(modifier);
    s2.modify(modifier);
    System.out.println(s1.data1 + ", " + s1.data2);
    System.out.println(s2.data1 + ", " + s2.data2);
    }
}

class Storage {
    int data1;
    float data2;
    Storage(int data1, float data2) {
        this.data1 = data1;
        this.data2 = data2;
    }
    Integer getData1() { return data1; }
    void modify(Supplier<Integer> i) {
        int value = i.get();
        this.data1 = this.data1 / value;
        this.data2 = this.data2 / value;
        value = value + 2;
    }
    void modify(int value) {
        this.data1 = this.data1 / value;
        this.data2 = this.data2 / value;
        value = value + 2;
    }
}