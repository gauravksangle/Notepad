import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class About extends JDialog{

	JLabel l1;
	JButton b1;
	
	About()
	{
		setVisible(true);
		setSize(400, 400);
		setLocation(200, 200);
		setTitle("About");
		
		l1=new JLabel("Verion");
		b1=new JButton("Ok");
		
		this.add(l1);
		this.add(b1);
		this.setLayout(new FlowLayout());
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About.this.dispose();
				setModal(true);
			}
		});
		
	}
	
}
