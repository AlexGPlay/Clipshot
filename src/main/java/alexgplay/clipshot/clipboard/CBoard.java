package alexgplay.clipshot.clipboard;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import alexgplay.clipshot.entity.CImage;

/**
 * Singleton class that manages the clipboard data, it is used to save the screenshot into the system clipboard.
 * @author Alejandro García Parrondo
 */
public class CBoard implements ClipboardOwner{

	/**
	 * Singleton instance of CBoard class.
	 */
	private static CBoard instance;

	/**
	 * System clipboard instance.
	 */
	private Clipboard clipboard;

	/**
	 * Private constructor used to implement Singleton pattern.
	 */
	private CBoard() {
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	/**
	 * Static method created to obtain the singleton instance of the class.
	 * @return The instance of the class.
	 */
	public static CBoard getInstance() {
		if(instance == null)
			instance = new CBoard();
		return instance;
	}

	/**
	 * Saves the transferable data into the clipboard.
	 * @param transferable -> Data which will be saved into the clipboard.
	 * @return 1 -> If the data is saved without any problem. <br>
	 *  0 -> If there is a problem saving the data.
	 */
	public int saveData(Transferable transferable) {
		try {
			clipboard.setContents(transferable, this);
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * Transforms the given image into a transferable making it possible to save that image.
	 * @param image -> The image that is going to be stored.
	 * @return 1 -> If the data is saved without any problem. <br>
	 *  0 -> If there is a problem saving the data.
	 */
	public int saveData(Image image) {
		return saveData(new CImage(image));
	}


	////////////////////////////////////////////////////////////////////////
	///																	 ///
	///																	 ///
	///							INTERFACE METHOD						 ///
	///																	 ///
	///																	 ///
	////////////////////////////////////////////////////////////////////////

	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		return;
	}



}
