package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class InfoGUI extends JDialog {

	/**
	 * Create the dialog.
	 */
	public InfoGUI() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setBounds(100, 100, 618, 423);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 600, 394);
		this.getContentPane().add(scrollPane);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		try {
		    FileReader fr = new FileReader("info.txt");
		    BufferedReader reader = new BufferedReader(fr);
		    textArea.read(reader, "textArea");
		    		
		}
		catch (IOException ioe) {
		    System.err.println(ioe);
		    System.exit(1);

		}
	}
}
