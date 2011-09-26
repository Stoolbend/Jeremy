package me.Stoolbend.Jeremy;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.jpackages.jflashplayer.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Set parallel port input
import parport.ParallelPort;


public class Jeremy{
		
	public JFrame mainWindow;
	private JMenuItem About;
	private JMenuItem PortTest;
	private JMenu Jmenu;
	private JMenuBar TopMenu;
	private FlashPanel flashPanel;
	private JMenu mnTools;
	private JMenuItem openControlPad;
	
	public static void main(String[] args){
			
			System.load("C:/Java/DILLS/atl2k.dll");
			System.load("C:/Java/DILLS/jflash.dll");
			System.load("C:/Java/DILLS/parport.dll");
			
			Jeremy jezza = new Jeremy();
			jezza.mainWindow.setVisible(true);
			
	}
	
	public Jeremy() {
		createFrame();
	}
	
	private void createFrame() {
		mainWindow = new JFrame("Jeremy");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {
		
		// Create the flash panel
				try {	
					String flashFilePath = "resources/getcam.swf";
					flashPanel = new FlashPanel(new File(flashFilePath));
				} catch (JFlashLibraryLoadFailedException e) {			
					e.printStackTrace(); //("A required library (DLL) is missing or damaged.");
				} catch (FileNotFoundException e) {
					e.printStackTrace(); //exitError("Failed to find SWF file specified.");
				} catch (JFlashInvalidFlashException e) {
					e.printStackTrace(); //exitError("Required version " + flashVersionRequired + " of Flash is not installed.");
				}
		
		mainWindow.setTitle("Jeremy - Version 0.5");
		mainWindow.setResizable(false);
		mainWindow.getContentPane().add(flashPanel, BorderLayout.CENTER);
		mainWindow.setJMenuBar(getTopMenu());
		mainWindow.setSize(600, 423);
	}
	
	private JMenuBar getTopMenu() {
		if (TopMenu == null) {
			TopMenu = new JMenuBar();
			TopMenu.add(getJmenu());
			TopMenu.add(getMnTools());
		}
		return TopMenu;
	}

	private JMenu getJmenu() {
		if (Jmenu == null) {
			Jmenu = new JMenu();
			Jmenu.setText("Menu");
			Jmenu.setOpaque(false);
			Jmenu.add(getAbout());
		}
		return Jmenu;
	}

	private JMenuItem getAbout() {
		if (About == null) {
			About = new JMenuItem();
			About.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AboutBox aboutbox = new AboutBox();
					aboutbox.setVisible(true);
				}
			});
			About.setText("About Jeremy");
		}
		return About;
	}
	
	private JMenuItem getPortTest() {
		if (PortTest == null) {
			PortTest = new JMenuItem();
			PortTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg1) {

					ParallelPort port = new ParallelPort(0x378);
					port.write(54);
				}
			});
			PortTest.setText("Port Test");
		}
		return PortTest;
	}
	
	private JMenu getMnTools() {
		if (mnTools == null) {
			mnTools = new JMenu("Tools");
			mnTools.add(getOpenControlPad());
			mnTools.add(getPortTest());
		}
		return mnTools;
	}
	private JMenuItem getOpenControlPad() {
		if (openControlPad == null) {
			openControlPad = new JMenuItem("Control Pad");
			openControlPad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControlPad controlpad = new ControlPad();
					controlpad.setVisible(true);
				}
			});
		}
		return openControlPad;
	}
}
