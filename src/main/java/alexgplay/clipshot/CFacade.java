package alexgplay.clipshot;

import java.awt.Rectangle;

import alexgplay.clipshot.clipboard.CBoard;
import alexgplay.clipshot.shooter.CShooter;

/**
 * Facade for the CBoard and the CImage.
 * @author Alejandro García Parrondo
 */
public class CFacade {
	
	/**
	 * Facade instance for the singleton pattern.
	 */
	public static CFacade instance;
	
	/**
	 * Private constructor in order to implement the singleton pattern.
	 */
	private CFacade() {}
	
	/**
	 * Get instance method for the singleton pattern.
	 * @return The instance of the class.
	 */
	public static CFacade getInstance() {
		if(instance == null)
			instance = new CFacade();
		return instance;
	}
	
	/**
	 * Facade method that will make an screenshot and save it.<br>
	 * It will call the methods of the CBoard and the CImage in order to do that.
	 * @param rectangle -> Image that will be saved.
	 * @return 1 -> In case there isn't any problem.<br>
	 * 0 -> In case there is a problem in the process.
	 */
	public int saveScreenshot(Rectangle rectangle) {
		int tres = CShooter.getInstance().takeScreenshot(rectangle);
		if(tres == 0)
			return 0;
		
		int sres = CBoard.getInstance().saveData(CShooter.getInstance().getScreenshot());
		return sres;
	}
	
}
