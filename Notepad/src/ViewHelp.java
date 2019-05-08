import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ViewHelp extends JDialog{

	JLabel l1;
	JButton b1;
	
	ViewHelp()
	{
		setVisible(true);
		setSize(400, 400);
		setLocation(200, 200);
		setTitle("About");
		
		l1=new JLabel("Help is given");
		b1=new JButton("Ok");
		
		this.add(l1);
		this.add(b1);
		this.setLayout(new FlowLayout());
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewHelp.this.dispose();
				setModal(true);
			}
		});
		
	}
	
}
