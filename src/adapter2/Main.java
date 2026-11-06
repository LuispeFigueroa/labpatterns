package adapter2;

import domain.Covid19Pacient;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35);
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.pack();
		gui.setVisible(true);

		Covid19Pacient pacient2=new Covid19Pacient("ane", 29);

		pacient2.addSymptomByName("fiebre", 3);
		pacient2.addSymptomByName("tos seca", 2);
		pacient2.addSymptomByName("nauseas", 1);

		ShowPacientTableGUI gui2=new ShowPacientTableGUI(pacient2);
		gui2.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui2.pack();
		gui2.setVisible(true);

	}

}
