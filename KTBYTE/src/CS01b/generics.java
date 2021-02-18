package CS01b;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class generics {
	
	<T, U> ArrayList<Pair<T, U>> pairUp(ArrayList<T> first, ArrayList<U> second) {
	    
	    ArrayList<Pair<T, U>> list = new ArrayList<Pair<T, U>>();
	    
	    for (int i = 0; i < first.size(); i++) {
	        
	        for (int j = 0; j < second.size(); j++) {
	            
	            list.add(new Pair<T, U>(first.get(i), second.get(i)));
	            
	        }
	        
	    }
	    
	    return list;
	    
	}
	
	<T> TreeMap<T, Integer> getFrequencyCount(List<T> array) {
		TreeMap<T, Integer> map = new TreeMap<>();
		for(T x : array) {
			if(map.containsKey(x)) {
				map.put(x,  map.get(x) + 1);
			} else {
				map.put(x,  1);
			}
		}
		return map;
	}
	  
	  

}

class Pair<T, U> {
    private T a;
    private U b;
    
    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }
    
    T getA() {
        return a;
    }
    
    U getB() {
        return b;
    }
}
