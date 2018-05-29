package alexgplay.window.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * KeyAdapter done in order to close the application if the escape key is pressed.
 * @author Alejandro García Parrondo
 */
public class EscapeAdapter extends KeyAdapter{

	/**
	 * Main jframe that will be closed.
	 */
	private JFrame frame;
	
	/**
	 * Adapter constructor done in order to assign the main window.
	 * @param frame -> Application main window.
	 */
	public EscapeAdapter(JFrame frame) {
		this.frame = frame;
	}
	
	
	////////////////////////////////////////////////////////////////////////
	///																	 ///
	///																	 ///
	///								CLASS METHOD						 ///
	///																	 ///
	///																	 ///
	////////////////////////////////////////////////////////////////////////
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			frame.dispose();
	}
	
}