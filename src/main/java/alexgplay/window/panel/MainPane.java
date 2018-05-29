package alexgplay.window.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.geom.Area;

import javax.swing.JPanel;

import alexgplay.window.MainWindow;
import alexgplay.window.adapter.ShotAdapter;

/**
 * Main pane that will cover all the screens and prepare the selection pane in order to select a new 
 * rectangle and repaint it in order to store that rectangle.
 * @author Alejandro García Parrondo
 * @author MadProgrammer (stackoverflow)
 */
public class MainPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Selection pane that will cover the selected zone.
	 */
    private SelectionPane selectionPane;

    /**
     * Main pane constructor.
     * @param window -> Main window instance needed to dispose it when the screenshot is done.
     */
    public MainPane(MainWindow window) {
        setOpaque(false);
        setLayout(null);
        selectionPane = new SelectionPane();
        add(selectionPane);
        MouseAdapter adapter = new ShotAdapter(selectionPane, window);
        
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
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

        Graphics2D g2d = (Graphics2D) g.create();

        Rectangle bounds = new Rectangle(0, 0, getWidth(), getHeight());
        Area area = new Area(bounds);
        area.subtract(new Area(selectionPane.getBounds()));

        g2d.setColor(new Color(192, 192, 192, 64));
        g2d.fill(area);

    }
    
}
