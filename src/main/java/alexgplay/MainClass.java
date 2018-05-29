package alexgplay;

import alexgplay.window.MainWindow;

/**
 * Main class for the Clipshot application.
 * @author Alejandro García Parrondo
 */
public class MainClass {

	/**
	 * Main Method.
	 * @param args -> Args for the application.
	 */
	public static void main(String[] args) {
		new MainClass().run();
	}
	
	/**
	 * Run method which creates the main window.
	 */
	private void run() {
		new MainWindow();
	}
	
}
