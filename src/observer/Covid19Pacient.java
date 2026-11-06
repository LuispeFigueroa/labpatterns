package observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import domain.Symptom;
import factory.SymptomFactory;

public class Covid19Pacient extends Observable {
	private String  name; 
	private int age;
	private Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();
	private SymptomFactory factory;

	public Covid19Pacient(String name, int years, SymptomFactory factory) {
		this.name = name;
		this.age = years;
		this.factory = factory;
	}

	public Covid19Pacient(String name, int years) {
		this(name, years, new SymptomFactory());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight(Symptom s) {
		return symptoms.get(s);
	}

	public Set<Symptom> getSymptoms() {
		return symptoms.keySet();
	}
	
	public Symptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= getSymptoms().iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().equals(symptomName)) return s;
		}
		return null;	
	}

	public Symptom addSymptomByName(String symptom, Integer w){
		Symptom s=null;
		s=factory.createSymptom(symptom);
		if (s!=null) {
			symptoms.put(s,w);
			setChanged();
			notifyObservers();
		}
		return s;
	}

	public Symptom removeSymptomByName(String symptomName) {
		Symptom s=getSymptomByName(symptomName);
		System.out.println("Simptom to remove: "+s);
		if (s!=null) {
			symptoms.remove(s);
			setChanged();
			notifyObservers();
		}
		return s;
	}
	
	public double covidImpact() {
		double afection=0;
		double increment=0;
		double impact=0;
		
		if (symptoms.isEmpty()) return 0;
		
		//calculate afection
		for (Symptom c: symptoms.keySet()) {
			if (c!=null )
			   afection=afection+c.getSeverityIndex()*symptoms.get(c);
		}
		afection=afection/symptoms.size();
		
		//calculate increment
		if (getAge()>65) increment=afection*0.5;
		
		//calculate impact
		impact=afection+increment;
		return impact;
	}
}
