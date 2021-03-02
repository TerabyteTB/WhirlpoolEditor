package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
