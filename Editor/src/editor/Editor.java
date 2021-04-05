package editor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.Constants;
import utils.session.Session;
import utils.session.SessionHandler;

/**
 * 
 * Main editor class
 * @author TerabyteTB
 * @version 1.4
 * @since 1.0
 *
 */
public class Editor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2144770514856556800L;
	private JTextArea area;
	private JFrame frame;
	private JPanel panel;
	private Session currentSession;
	private String value;
	
	/**
	 * Makes new editor
	 * @throws IOException
	 */
	public Editor() throws IOException {
		init();
	}

	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand(); 
		  
        if (s.equals("Cut")) { 
            area.cut(); 
        } 
        else if (s.equals("Copy")) { 
            area.copy(); 
        } 
        else if (s.equals("Paste")) { 
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
                SessionHandler.removeSession(currentSession);
				currentSession = SessionHandler.newSession(fi.getAbsolutePath());
  
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
                    area.setVisible(true);
                    br.close();
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(frame, evt.getMessage()); 
                } 
            } 
            // If the user cancelled the operation 
            else {
                JOptionPane.showMessageDialog(frame, "the user cancelled the operation"); 
            }
        } 
        else if (s.equals("New")) { 
        	area.setText(""); 
        	area.setVisible(true);
            SessionHandler.removeSession(currentSession);
			currentSession = SessionHandler.newSession();
        } 
        else if (s.equals("Quit")) { 
            frame.setVisible(false); 
            System.exit(0);
        } 
        else if (s.equals("Stop Session")) {
        	SessionHandler.removeSession(currentSession);
        	area.setText("");
        	area.setVisible(false);
        }
		
	}
	
	/**
	 * Init method
	 * @throws IOException
	 */
	private void init() throws IOException {
		
		frame = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		area = new JTextArea();
		panel = new JPanel(new BorderLayout());
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");
		JMenuItem mi1 = new JMenuItem("New"); 
        JMenuItem mi2 = new JMenuItem("Open"); 
        JMenuItem mi3 = new JMenuItem("Save"); 
        JMenuItem mi9 = new JMenuItem("Print"); 
        JMenuItem mi10 = new JMenuItem("Quit");
        JMenuItem mi11 = new JMenuItem("Stop Session");
        JScrollPane scrollPane = new JScrollPane(area);
        
        File fi;
        FileReader fr;
        BufferedReader br;
        
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this);
        mi10.addActionListener(this);
        mi11.addActionListener(this);
        
        mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        mi1.setIcon(new ImageIcon("res/new.png"));
        mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        mi2.setIcon(new ImageIcon("res/open.png"));
        mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        mi3.setIcon(new ImageIcon("res/save.png"));
        mi9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        mi9.setIcon(new ImageIcon("res/print.png"));
        
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);
        m1.add(mi10);
        m1.add(mi11);
        
        JMenu m2 = new JMenu("Edit"); 
        
        JMenuItem mi4 = new JMenuItem("Cut"); 
        JMenuItem mi5 = new JMenuItem("Copy"); 
        JMenuItem mi6 = new JMenuItem("Paste"); 
        
        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this); 
        
        mi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        mi4.setIcon(new ImageIcon("res/cut.png"));
        mi5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        mi5.setIcon(new ImageIcon("res/copy.png"));
        mi6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        mi6.setIcon(new ImageIcon("res/paste.png"));
        
        m2.add(mi4); 
        m2.add(mi5); 
        m2.add(mi6); 
  
        mb.add(m1); 
        mb.add(m2); 
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        area.setLineWrap(false);
        area.setEditable(true);
        
        panel.add(area, BorderLayout.CENTER);
  
        frame.setJMenuBar(mb); 
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(scrollPane);
        frame.pack();
        frame.setSize(500, 500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        if(initSession().equalsIgnoreCase("none")) {
        	area.setVisible(false);
        	File dir = new File("C:\\temp\\");
        	dir.mkdirs();
        	fi = new File("C:\\temp\\temp.tmp");
        	fi.createNewFile();
        } else {
        	File temp = new File("C:\\temp\\temp.tmp");
        	if(temp.exists()) {
        		temp.delete();
        	}
        	area.setVisible(true);
            fi = new File(initSession());
        }
        
        try { 
            // String 
            String s1 = ""; 
            String sl = ""; 
            
            if(fi.getAbsolutePath().equalsIgnoreCase("C:\\temp\\temp.tmp")) {
                area.setVisible(false);
                area.setText(sl);
            } else {
            	fr = new FileReader(fi); 

                // Buffered reader 
                br = new BufferedReader(fr);
                
                sl = br.readLine(); 

                // Take the input from the file 
                while ((s1 = br.readLine()) != null) { 
                    sl = sl + "\n" + s1; 
                } 
                // Set the text 
                area.setText(sl); 
            }

        } 
        catch (Exception evt) { 
            JOptionPane.showMessageDialog(frame, evt.getMessage()); 
        } 
		
	}
	
	/**
	 * Init session(s)
	 * @return The value of sessions
	 * @throws IOException
	 */
	private String initSession() throws IOException {
		
		File dir = new File(Constants.DIR);
		File[] filesArray = null;
		if(dir.listFiles().length > 0) {
			filesArray = dir.listFiles();
		    ArrayList<File> files = new ArrayList<>(Arrays.asList(filesArray));
		    for(File file : files) {
		    	String[] fileName = file.getName().split("[.]");
	        	String[] nameID = fileName[0].split("_");
	        	value = SessionHandler.openExistingSession(Integer.parseInt(nameID[1]));
		    }
		    currentSession = SessionHandler.newSession(value);
		} else {
			currentSession = SessionHandler.newSession();
			value = currentSession.getValue();
		}
		
        return value;

	}
	
}
