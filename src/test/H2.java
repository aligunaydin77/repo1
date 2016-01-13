
package test;
interface StringMapper<T> {
	   String map(T t);
	}
	class X {
	    String s;
	    public X(String s) { this.s=s; }
	    @Override public String toString() { return s.toLowerCase();}
	    public String toLowerCase() { return s.toLowerCase();}
	}
	class Y<T> {
	    T s;
	    public Y(T s) { this.s=s; }
	    @Override public String toString() { return s.toString();}
	}
	public class H2 {
	    static String mapme(Y y, StringMapper<Y> t) {
	        return t.map(y);
	    }
	    static String mapme(X x, StringMapper<X> t) {
	        return t.map(x);
	    }
	    public static void main(String[] args) {
	    	System.out.println(mapme(new Y<>(new X("HELLO")),  e -> { return e.toString();}));
	    }
	}
