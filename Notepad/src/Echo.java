import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Echo extends JFrame implements KeyListener{

	JPanel Panel;
	JLabel lblSource,lblDestination;
	JTextField txtSource,txtDestination;
	
	public Echo()
	{
		setVisible(true);
		setSize(300,150);
		setTitle("Echo Demo");
		setLocationRelativeTo(null);
		
		Container cp=getContentPane();
		Panel=new JPanel(new GridLayout(3,2,5,5));
		
		lblSource=new JLabel("Source");
		lblDestination=new JLabel("Destination");
		
		txtSource=new JTextField();
		txtDestination=new JTextField();
		txtDestination.setEditable(false);
		
		
		Panel.add(lblSource);
		Panel.add(txtSource);
		Panel.add(lblDestination);
		Panel.add(txtDestination);
		
		cp.add(Panel);	
		
		txtSource.addKeyListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Echo echo=new Echo();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		txtDestination.setText(txtSource.getText());
	}
	
	
	
}
