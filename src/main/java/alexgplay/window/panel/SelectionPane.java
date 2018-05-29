package alexgplay.window.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * Selection pane that will be used to paint the rectangle that will be saved.
 * @author Alejandro García Parrondo
 * @author MadProgrammer (stackoverflow)
 */
public class SelectionPane extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Selection pane constructor.
	 */
	public SelectionPane() {
		setOpaque(false);
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.gridy++;
	}
	
	
	////////////////////////////////////////////////////////////////////////
	///																	 ///
	///																	 ///
	///								CLASS METHOD						 ///
	///																	 ///
	///																	 ///
	////////////////////////////////////////////////////////////////////////

	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.dispose();
	}
}
