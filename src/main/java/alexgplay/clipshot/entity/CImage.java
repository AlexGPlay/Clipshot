package alexgplay.clipshot.entity;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * CImage class made in order to save the image into de clipboard.
 * @author Alejandro García Parrondo
 * @author Nathan Pruett (coderanch)
 */
public class CImage implements Transferable{

	/**
	 * Image which will be saved into the clipboard.
	 */
	private Image image;
	
	/**
	 * CImage constructor to make the Image transferable.
	 * @param image -> The image that will be stored.
	 */
	public CImage(Image image) {
		this.image = image;
	}
	
	
	////////////////////////////////////////////////////////////////////////
	///																	 ///
	///																	 ///
	///							INTERFACE METHODS						 ///
	///																	 ///
	///																	 ///
	////////////////////////////////////////////////////////////////////////
	
	@Override
	public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
		if(dataFlavor.equals(DataFlavor.imageFlavor) && image != null)
			return image;
		
		throw new UnsupportedFlavorException(dataFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{ DataFlavor.imageFlavor };
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
		return dataFlavor.equals(getTransferDataFlavors()[0]);
	}

	
	
}
