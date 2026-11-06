package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientInvertedIteratorAdapter implements InvertedIterator {
	private List<Symptom> symptoms;
	private int position;

	public Covid19PacientInvertedIteratorAdapter(Covid19Pacient pacient) {
		symptoms = new ArrayList<Symptom>(pacient.getSymptoms());
		goLast();
	}

	@Override
	public Object previous() {
		Symptom symptom = symptoms.get(position);
		position--;
		return symptom;
	}

	@Override
	public boolean hasPrevious() {
		return position >= 0;
	}

	@Override
	public void goLast() {
		position = symptoms.size() - 1;
	}
}
