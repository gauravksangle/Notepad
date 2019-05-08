import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayMouseCoordinates extends JFrame implements MouseMotionListener{

	JLabel MouCor,m1;
	
	public DisplayMouseCoordinates()
	{
		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("Mouse Coordinates");
		
		Container cp=getContentPane();
		JPanel panel=new JPanel();
		MouCor=new JLabel();
		m1=new JLabel();
		panel.add(BorderLayout.CENTER,MouCor);
		panel.add(BorderLayout.CENTER,m1);
		cp.add(panel);
		
		panel.addMouseMotionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		DisplayMouseCoordinates d=new DisplayMouseCoordinates();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		String data=("X: "+e.getX()+" , "+"Y: "+e.getY());
		m1.setText("Coordinates: "+data);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		String data=("X: "+e.getX()+" , "+"Y: "+e.getY());
		MouCor.setText("Coordinates: "+data);
	}
	
	
	
	
	
}
