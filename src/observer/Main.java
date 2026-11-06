package observer;

import java.util.Observable;

import adapter2.ShowPacientTableGUI;
import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SymptomFactory factory = new SymptomFactory();

		Covid19Pacient pacient = new Covid19Pacient("aitor", 35, factory);

		new PacientObserverGUI(pacient);
		new PacientThermometerGUI(pacient);
		new PacientSymptomGUI(pacient);

		Covid19Pacient pacient2 = new Covid19Pacient("ane", 29, factory);

		new PacientObserverGUI(pacient2);
		new PacientSymptomGUI(pacient2);

		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);

		ShowPacientTableGUI gui = new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
				new java.awt.Dimension(300, 200));
		gui.pack();
		gui.setVisible(true);

	}

}
