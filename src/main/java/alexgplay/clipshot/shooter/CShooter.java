package alexgplay.clipshot.shooter;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import alexgplay.clipshot.entity.CImage;

/**
 * CShooter singleton class is used to take a screenshot of a certain screen zone.
 * @author Alejandro García Parrondo
 */
public class CShooter {

	/**
	 * CShooter singleton instance.
	 */
	private static CShooter instance;
	
	/**
	 * BufferedImage which will contain the screenshot.
	 */
	private BufferedImage screenshot;
	
	/**
	 * Private constructor used to create the singleton instance.
	 */
	private CShooter() {}
	
	/**
	 * Singleton method used to get instance of the class or to create it if necessary.
	 * @return The instance of the class.
	 */
	public static CShooter getInstance() {
		if(instance == null)
			instance = new CShooter();
		return instance;
	}
	
	/**
	 * Takes a screenshot of the zone passed as parameter.
	 * @param rectangle -> Zone of the screen that will be captured.
	 * @return 1 -> If there isn't any problem doing the screenshot. <br>
	 * 0 -> If there is any problem and the screenshot isn't done.
	 */
	public int takeScreenshot(Rectangle rectangle) {
		try {
			screenshot = new Robot().createScreenCapture(rectangle);
			return 1;
		} catch (HeadlessException | AWTException e) {
			return 0;
		}
	}
	
	/**
	 * Screenshot getter.
	 * @return The saved screenshot.
	 */
	public BufferedImage getScreenshot() {
		return screenshot;
	}
	
	/**
	 * Transferable screenshot getter.
	 * @return The saved screenshot.
	 */
	public CImage getTransferableScreenshot() {
		return new CImage(screenshot);
	}
	
}
