package javaPractice;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedlistEmp {

	public static void main(String[] args) {
		
		LinkedList<Emp>ll=new LinkedList<Emp>();
		ll.add(new Emp(100, "Subha", 7500));
		ll.add(new Emp(101, "Anuj", 7500));
		ll.add(new Emp(102, "Suresh", 7000));
		
		ListIterator<Emp>lstitr=ll.listIterator();
		
		while(lstitr.hasNext()){
			Emp x=lstitr.next();
			if(x.Ename.equalsIgnoreCase("Suresh")){
				lstitr.remove();
			}
		}
		
		for(Emp el:ll){
			System.out.println(el.Eid+" "+el.Ename+" "+el.sal);
		}

		
	}

}
