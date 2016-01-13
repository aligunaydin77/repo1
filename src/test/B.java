package test;


 class A {
     public void m1() {
        System.out.print("A.m1, ");
    }
    protected void m2() {
        System.out.print("A.m2, ");
    }
    private void m3() {
        System.out.print("A.m3, ");
   }
    void m4() {
      System.out.print("A.m4, ");
    }
 }
 public class B {
    public static void main(String[] args) {
        A a = new A();
       a.m1();
        a.m2();
//       a.m3();
        a.m4();
    }
}
