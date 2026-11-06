package adapter;

import java.util.Comparator;
import java.util.Iterator;

import adapter2.NameComparator;
import adapter2.SeverityComparator;
import domain.Covid19Pacient;
import domain.Symptom;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient = new Covid19Pacient("aitor", 35);
		pacient.addSymptomByName("fiebre", 3);
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("nauseas", 1);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 2);

		InvertedIterator adapter = new Covid19PacientInvertedIteratorAdapter(pacient);

		System.out.println("Sorted by symptomName:");
		printSorted(adapter, new NameComparator());

		System.out.println("Sorted by severityIndex:");
		printSorted(adapter, new SeverityComparator());
	}

	private static void printSorted(InvertedIterator it, Comparator<Object> comparator) {
		Iterator<Object> sorted = Sorting.sortedIterator(it, comparator);
		while (sorted.hasNext()) {
			Symptom s = (Symptom) sorted.next();
			System.out.println(" - " + s.getName() + " (severityIndex: " + s.getSeverityIndex() + ")");
		}
	}
}
