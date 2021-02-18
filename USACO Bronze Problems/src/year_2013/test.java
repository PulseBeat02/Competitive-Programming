package year_2013;

import java.util.Set;
import java.util.TreeMap;

public class test {

	public static void main(String a[]) {
		TreeMap<String, String> hm = new TreeMap<String, String>();
		// add key-value pair to TreeMap
		hm.put("second", "SECOND INSERTED");
		hm.put("first", "FIRST INSERTED");
		hm.put("third", "THIRD INSERTED");
		System.out.println(hm);
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
	}

}
