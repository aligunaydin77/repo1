package test;

import java.util.HashMap;
import java.util.Map;

public class Key1 {
	private int data;
	public Key1(int data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	public int getData() {
		return data;
	}

	@Override
	public String toString() {
		return "has " + data;
	}
	
	public static void main(String[] args) {
		Key1 key11 = new Key1(3);
		Key1 key12 = new Key1(4);
		Map<Key1, String> myMap = new HashMap<Key1, String>();
		myMap.put(key11, "aa");
		myMap.put(key12, "bb");
		System.out.println(myMap);
	}
}
