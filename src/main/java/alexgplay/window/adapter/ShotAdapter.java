package alexgplay.window.adapter;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import alexgplay.clipshot.CFacade;

/**
 * Mouse adapter to update the selection area and to take the screenshot.
 * @author Alejandro García Parrondo
 * @author MadProgrammer (stackoverflow)
 *
 */
public class ShotAdapter extends MouseAdapter{

	/**
	 * Mouse first click point.
	 */
	private Point mouseAnchor;
	
	/**
	 * Mouse actual point.
	 */
	private Point dragPoint;
	
	/**
	 * Selected area by the point and move.
	 */
    private JPanel selectionPane;
    
    /**
     * Main application window.
     */
    private JFrame window;
	
    /**
     * ShotAdapter constructor.
     * @param selectionPane -> Selection pane instance.
     * @param window -> Main window instance.
     */
    public ShotAdapter(JPanel selectionPane, JFrame window) {
    	this.selectionPane = selectionPane;
    	this.window = window;
    }
    
    /**
     * Takes the screenshot and closes the application.
     */
    protected void takeScreenshot() {
        Rectangle fixed = fixRectangle();
        fixed = new Rectangle(fixed.x+1, fixed.y+1, fixed.width-2, fixed.height-2);
    	CFacade.getInstance().saveScreenshot(fixed);
    	window.dispose();
    }
    
    /**
     * Repaints the selection pane with the new data.
     */
    protected void repaintSelectionPane() {
        Rectangle fixed = fixRectangle();
        selectionPane.setBounds(fixed);
        selectionPane.revalidate();
        selectionPane.repaint();
    }
    
    /**
     * Checks the rectangle bounds and fix them if needed.
     * @return A rectangle instance with the correct bounds.
     */
    protected Rectangle fixRectangle() {
        int width = dragPoint.x - mouseAnchor.x;
        int height = dragPoint.y - mouseAnchor.y;

        int x = mouseAnchor.x;
        int y = mouseAnchor.y;

        if (width < 0) {
            x = dragPoint.x;
            width *= -1;
        }
        if (height < 0) {
            y = dragPoint.y;
            height *= -1;
        }
        
        return new Rectangle(x, y, width, height);
    }
    
    
	////////////////////////////////////////////////////////////////////////
	///																	 ///
	///																	 ///
	///								CLASS METHODS						 ///
	///																	 ///
	///																	 ///
	////////////////////////////////////////////////////////////////////////
    
	@Override
    public void mousePressed(MouseEvent e) {
        mouseAnchor = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragPoint = e.getPoint();
        repaintSelectionPane();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        dragPoint = e.getPoint();
        takeScreenshot();
    }
   
	
}
