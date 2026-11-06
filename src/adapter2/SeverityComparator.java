package adapter2;

import java.util.Comparator;

import domain.Symptom;

public class SeverityComparator implements Comparator {
	
	public int compare(Object arg0, Object arg1) {
		int s1 = ((Symptom)arg0).getSeverityIndex();
		int s2 = ((Symptom)arg1).getSeverityIndex();
		
		if(s1>s2) return 1;
		if(s1<s2) return -1;
		return 0;	
	}


}
