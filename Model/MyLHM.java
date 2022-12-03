/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Model;

import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.Set;

public class MyLHM<T extends Automobile> {
private T obj;
LinkedHashMap<String,Automobile> LHM;

public MyLHM (){
	LHM = new LinkedHashMap<String, Automobile>();
}

public void add(String key, Automobile at) {
	
	key = at.getKey();
	LHM.put(key, at);
	System.out.println("You have successfully add: " + at.getAutomobileName()+ " to the LinkedHashMap");
}

public void remove(Automobile temp, String key) {
	Set st = LHM.keySet();
	Iterator it = st.iterator();
	if(LHM.containsKey(key)) {
		st.remove(key);
		System.out.println("You have succesfully removed it from the LinkedHashMap");
	}
	else {
		System.out.println("Cannot remove since the key is not mapped ");
	}

}

public Automobile get(Automobile at) {
	return LHM.get(at.getKey());
}
public boolean find(Automobile temp, String key) {
	Set st = LHM.keySet();
	Iterator it = st.iterator();
	while(it.hasNext()) {
	if(LHM.containsKey(key)) {
	return true;	
	}
	else {
		it.next();
	}
	}
	
	return false;
}

public void delete() {
	LHM.clear();
}

}

