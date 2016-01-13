package test;

public interface Intf1 {
	int getInt();
	default String getString() {
		return "de";
	}
}
