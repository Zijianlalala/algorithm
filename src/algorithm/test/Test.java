package algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.binary.Binary;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2 = list1;
		list2.remove(1);
		System.out.println(list1.hashCode());
		System.out.println(list2.hashCode());
		
		
	}

}
