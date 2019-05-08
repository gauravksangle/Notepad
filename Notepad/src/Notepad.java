import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame{

	JMenu m1,m2,m3,m4;
	JMenuItem mt1,mt2,mt3,mt4,mt5,mt6,mt7,mt8,mt9,mt10,mt11;
	JTextArea txtarea;
	JMenuBar mbr;
	JPopupMenu pmn;
	JMenuItem mtt1,mtt2,mtt3;
	JScrollPane pane;
	
	Notepad()
	{
		setVisible(true);
		setSize(400, 400);
		setLocation(200, 200);
		setTitle("Untitled-Notepad-Gaurav");
		
		m1=new JMenu("File");
			mt1=new JMenuItem("New");
			mt2=new JMenuItem("Open");
			mt3=new JMenuItem("Save");
			mt4=new JMenuItem("Exit");
			m1.add(mt1);
			m1.addSeparator();
			m1.add(mt2);
			m1.addSeparator();
			m1.add(mt3);
			m1.addSeparator();
			m1.add(mt4);
		
		m2=new JMenu("Edit");
			mt5=new JMenuItem("Cut");
			mt6=new JMenuItem("Copy");
			mt7=new JMenuItem("Paste");
			m2.add(mt5);
			m2.addSeparator();
			m2.add(mt6);
			m2.addSeparator();
			m2.add(mt7);
			
		m3=new JMenu("Color");
			mt8=new JMenuItem("Font Color");
			mt9=new JMenuItem("Background Color");
			m3.add(mt8);
			m3.addSeparator();
			m3.add(mt9);
			
		m4=new JMenu("Help");
			mt10=new JMenuItem("View Help");
			mt11=new JMenuItem("About");
			m4.add(mt10);
			m4.addSeparator();
			m4.add(mt11);
			
		mbr=new JMenuBar();
		mbr.add(m1);
		mbr.add(m2);
		mbr.add(m3);
		mbr.add(m4);
		
		pmn=new JPopupMenu();
			mtt1=new JMenuItem("Cut");
			mtt2=new JMenuItem("Copy");
			mtt3=new JMenuItem("Paste");
			pmn.add(mtt1);
			pmn.addSeparator();
			pmn.add(mtt2);
			pmn.addSeparator();
			pmn.add(mtt3);
		
		txtarea=new JTextArea();
		pane=new JScrollPane(txtarea);
		this.add(pane);
		this.setJMenuBar(mbr);
		
		mt8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt8)
				{
					Color c=JColorChooser.showDialog(Notepad.this, "Select Color",Color.red);
					txtarea.setForeground(c);
				}				
			}
		});
		
		mt9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt9)
				{
					Color c=JColorChooser.showDialog(Notepad.this, "Select Color",Color.red);
					txtarea.setBackground(c);
				}	
			}
		});
		
		txtarea.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger())
				{
					pmn.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		mt5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt5)
				{
					txtarea.cut();
				}
			}
		});
		
		mt6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt6)
				{
					txtarea.copy();
				}
			}
		});
		
		mt7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt7)
				{
					txtarea.paste();
				}
			}
		});
		
		mtt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mtt1)
				{
					txtarea.cut();
				}
			}
		});
		
		mtt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mtt2)
				{
					txtarea.copy();
				}
			}
		});
		
		mtt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mtt3)
				{
					txtarea.paste();
				}
			}
		});
		
		mt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtarea.getText().equals(""))
				{
					
				}
				else
				{
					JFileChooser jf=new JFileChooser(".");
					int savefile=jf.showSaveDialog(Notepad.this);
					
					if(savefile==0)
					{
						File savef=jf.getSelectedFile();
							FileOutputStream fout = null;
							try {
								fout = new FileOutputStream(savef);
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						
						String text=txtarea.getText();
						try {
							fout.write(text.getBytes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		
		mt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser j=new JFileChooser(".");
				int val=j.showOpenDialog(Notepad.this);
				if(val==0)
				{
					File f=j.getSelectedFile();
					
					StringBuffer str=new StringBuffer();
					String s;
					BufferedReader br = null;
					
					try {
						br=new BufferedReader(new FileReader(f.getAbsolutePath()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						while((s=br.readLine())!=null)
						{
							str.append(s);
							str.append("\n");
						}
						txtarea.setText(str.toString());
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					setTitle("Gaurav-"+f.getName());
				}
				
			}
		});
		
		mt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt4)
				{
					if(txtarea.getText().equals(""))
					{	
						Notepad.this.dispose();
					}
					else
					{
						int n=JOptionPane.showConfirmDialog(Notepad.this, "Do you want to save?");
						if(n==0)
						{
							JFileChooser jf=new JFileChooser(".");
							int savefile=jf.showSaveDialog(Notepad.this);
							
							if(savefile==0)
							{
								File savef=jf.getSelectedFile();
									FileOutputStream fout = null;
									try {
										fout = new FileOutputStream(savef);
									} catch (FileNotFoundException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
								
								String text=txtarea.getText();
								try {
									fout.write(text.getBytes());
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							Notepad.this.dispose();
						}
						else if(n==1)
						{
							Notepad.this.dispose();
						}
					}
				}
			}
		});
		
		mt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt1)
				{
					if(!(txtarea.getText().equals("")))
					
				{
					int n=JOptionPane.showConfirmDialog(Notepad.this, "Do you want to save?");
					if(n==0){
						JFileChooser jf=new JFileChooser(".");
						int savefile=jf.showSaveDialog(Notepad.this);
							
						if(savefile==0)
						{
							File savef=jf.getSelectedFile();
								FileOutputStream fout = null;
								try {
									fout = new FileOutputStream(savef);
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
							String text=txtarea.getText();
							try {
								fout.write(text.getBytes());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								
						}
					}
					
					else if(n==1)
					{
						txtarea.setText("");
					}
					else
					{
						
					}
					
				}
				}
			}
		});
		
		mt10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewHelp v=new ViewHelp();
			}
		});
		
		mt11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About a=new About();
			}
		});
		
		/*mt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mt4)
				{
					//JOptionPane.showConfirmDialog(Notepad.this, "Do You Want to Exit?");
					//JOptionPane.showConfirmDialog(null, "Do You Want to Exit?");
					//JOptionPane.showConfirmDialog(null, "Do You Want to Exit?", "Exit", "YES_NO_CANCEL_OPTION", "QUESTION_MESSAGE", 2);
					int n=JOptionPane.showConfirmDialog(null,"do ","hi",1,1);
					if(n==0)
					{
							JFileChooser jf=new JFileChooser(".");
							int savefile=jf.showSaveDialog(Notepad.this);
							File savef=jf.getSelectedFile();
							FileOutputStream fout = null;
							try {
								fout = new FileOutputStream(savef);
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						
						String text=txtarea.getText();
						try {
							fout.write(text.getBytes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
					}
						
						txtarea.setText("");
					}
					if(n==1)
					{
						JFontChooser fd = new JFontChooser(this,txtDoc.getFont());
						fd.show();
						if(fd.getReturnStatus() == fd.RET_OK){
						       txtDoc.setFont(fd.getFont());
						}
						
						Notepad.this.dispose();
						
						
					}
				}
			}
		});*/
		
		/*txtarea.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger())
				{
					pmn.show(e.getComponent(),e.getX(),e.getY());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Notepad n=new Notepad();
	}
	
}
