package alexgplay.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import alexgplay.window.adapter.EscapeAdapter;
import alexgplay.window.panel.MainPane;

/**
 * Main window for the application.
 * @author Alejandro García Parrondo
 * @author MadProgrammer (stackoverflow)
 */
public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Main window constructor for the main window.
	 */
	public MainWindow() {
		setUndecorated(true);

		setIconImage( new ImageIcon( getClass().getClassLoader().getResource("Clipshot.png") ).getImage() );
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new MainPane(this));
		setBounds(getScreenBounds());
		setVisible(true);
		
		addKeyListener(new EscapeAdapter(this));
	}

	/**
	 * Returns the size of the computer screens.
	 * @return Rectangle with the size of the screens.
	 */
    private static Rectangle getScreenBounds() {
        Rectangle bounds = new Rectangle();

        GraphicsEnvironment enviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice devices[] = enviroment.getScreenDevices();
        for (GraphicsDevice screen : devices) 
            bounds.add(screen.getDefaultConfiguration().getBounds());

        return bounds;
    }
	
}
