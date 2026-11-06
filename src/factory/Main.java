package factory;

import domain.Covid19Pacient;
import domain.Medicament;

public class Main {

	public static void main(String[] args) {
		SymptomFactory factory=new SymptomFactory();
		Covid19Pacient p1=new Covid19Pacient("aitor", 35, factory);
		new PacientSymptomGUI(p1);
		new MedicalGUI(new Medicament("Ibuprofeno", factory));

	}

}
