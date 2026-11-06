package adapter2;

import java.util.Comparator;

import domain.Symptom;

public class NameComparator implements Comparator {
	

	@Override
	public int compare(Object arg0, Object arg1) {
		
		Symptom s1 = ((Symptom)arg0).getName();
		Symptom s2 = ((Symptom)arg1).getName();
		
		return 
			
		}			
}
