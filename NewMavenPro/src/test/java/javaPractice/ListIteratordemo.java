package javaPractice;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratordemo {

	public static void main(String [] args){
		
		ArrayList<String>al=new ArrayList<String>();
		al.add("Bapi");
		al.add("Asu");
		al.add("Kanha");
		al.add("Dipun");
		
		ListIterator<String> lsitr=al.listIterator();
		lsitr.add("Faulad");
		
		while(lsitr.hasNext())
		{
			String s=lsitr.next();
			if(s.equals("Asu"))
			
				lsitr.remove();
			
			if(s.equals("Bapi"))
				lsitr.set("Soumya");
			
		}
		
		
			System.out.println(al);
		
	}
	
	
}
