package javaPractice;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorRemove {

	public static void main(String[] args) {
		
		
		ArrayList<Emp>al=new ArrayList<Emp>();
		al.add(new Emp(101, "Ram", 5000.00f));
		al.add(new Emp(102, "Rakesh", 7250));
		al.add(new Emp(103, "Rajesh", 9550));
		
		Iterator<Emp>itr= al.iterator();
		
		while (itr.hasNext()) {
			
			Emp e=itr.next();
			if(e.Eid==102)
			{
				itr.remove();
			}
			
		}
		
		/*
		for(Emp o:al){
			System.out.println(o.Eid+" "+o.Ename+" "+o.sal);
		}*/
		
		Iterator<Emp>itr1=al.iterator();
		
		while(itr1.hasNext()){
			Emp e=itr1.next();
			System.out.println(e.Eid+" "+e.Ename+" "+e.sal);
		}
	}

}
