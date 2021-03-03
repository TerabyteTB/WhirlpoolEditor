package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class TextEdit extends JFrame implements ActionListener{

	private static final long serialVersionUID = 2144770514856556800L;
	private JTextArea area;
	private JFrame frame;
	
	public TextEdit() {
		
		frame = new JFrame();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		area = new JTextArea();
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");
		JMenuItem mi1 = new JMenuItem("New"); 
        JMenuItem mi2 = new JMenuItem("Open"); 
        JMenuItem mi3 = new JMenuItem("Save"); 
        JMenuItem mi9 = new JMenuItem("Print"); 
        
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this); 
        
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);
        
        JMenu m2 = new JMenu("Edit"); 
        
        JMenuItem mi4 = new JMenuItem("cut"); 
        JMenuItem mi5 = new JMenuItem("copy"); 
        JMenuItem mi6 = new JMenuItem("paste"); 
        
        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this); 
        
        m2.add(mi4); 
        m2.add(mi5); 
        m2.add(mi6); 
        
        JMenuItem mc = new JMenuItem("close"); 
        
        mc.addActionListener(this); 
  
        mb.add(m1); 
        mb.add(m2); 
        mb.add(mc); 
  
        frame.setJMenuBar(mb); 
        frame.add(area); 
        frame.setSize(500, 500); 
        frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand(); 
		  
        if (s.equals("cut")) { 
            area.cut(); 
        } 
        else if (s.equals("copy")) { 
            area.copy(); 
        } 
        else if (s.equals("paste")) { 
            area.paste(); 
        } 
        else if (s.equals("Save")) { 
            // Create an object of JFileChooser class 
            JFileChooser j = new JFileChooser("f:"); 
  
            // Invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null); 
  
            if (r == JFileChooser.APPROVE_OPTION) { 
  
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    // Create a file writer 
                    FileWriter wr = new FileWriter(fi, false); 
  
                    // Create buffered writer to write 
                    BufferedWriter w = new BufferedWriter(wr); 
  
                    // Write 
                    w.write(area.getText()); 
  
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(frame, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(frame, "the user cancelled the operation"); 
        } 
        else if (s.equals("Print")) { 
            try { 
                // print the file 
                area.print(); 
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(frame, evt.getMessage()); 
            } 
        } 
        else if (s.equals("Open")) { 
            // Create an object of JFileChooser class 
            JFileChooser j = new JFileChooser("f:"); 
  
            // Invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null); 
  
            // If the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) { 
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    // String 
                    String s1 = "", sl = ""; 
  
                    // File reader 
                    FileReader fr = new FileReader(fi); 
  
                    // Buffered reader 
                    BufferedReader br = new BufferedReader(fr); 
  
                    // Initilize sl 
                    sl = br.readLine(); 
  
                    // Take the input from the file 
                    while ((s1 = br.readLine()) != null) { 
                        sl = sl + "\n" + s1; 
                    } 
  
                    // Set the text 
                    area.setText(sl); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(frame, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else
                JOptionPane.showMessageDialog(frame, "the user cancelled the operation"); 
        } 
        else if (s.equals("New")) { 
            area.setText(""); 
        } 
        else if (s.equals("close")) { 
            frame.setVisible(false); 
        } 
		
	}

}
