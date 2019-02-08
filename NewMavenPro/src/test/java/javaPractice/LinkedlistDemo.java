package javaPractice;

import java.util.LinkedList;

public class LinkedlistDemo {

	public static void main(String[] args) {

		LinkedList<String>ll=new LinkedList<String>();
		ll.add("Rama");
		ll.add("Hari");
		ll.add("Shyama");
		System.out.println(ll);

		ll.addFirst("aaa");
		ll.addLast("zzz");
		
		System.out.println(ll);
		
		ll.add(2, "sita");
		System.out.println(ll);
		ll.set(3,"Siba");
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);
		
		ll.remove("Siba");
		System.out.println(ll);
		
		ll.removeFirst();
		System.out.println(ll);
		
		ll.removeLast();
		System.out.println(ll);
		
		System.out.println(ll.isEmpty());
		//ll.clear();
		//System.out.println(ll.isEmpty());
	}

}
