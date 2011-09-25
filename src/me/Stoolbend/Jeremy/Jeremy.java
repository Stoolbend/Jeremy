package me.Stoolbend.Jeremy;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JPanel;
import com.jpackages.jflashplayer.*;

import org.dyno.visual.swing.layouts.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jeremy{
		
	public JFrame mainWindow;
	private JMenuItem About;
	private JMenu Jmenu;
	private JMenuBar TopMenu;
	
	FlashPanel flashPanel;
	
	public static void main(String[] args){
			
			System.load("C:/Java/JFlash/atl2k.dll");
			System.load("C:/Java/JFlash/jflash.dll");
			
			Jeremy jezza = new Jeremy();
			jezza.mainWindow.setVisible(true);
			
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
					flashPanel.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							
						}
					});
				} catch (JFlashLibraryLoadFailedException e) {			
					e.printStackTrace(); //("A required library (DLL) is missing or damaged.");
				} catch (FileNotFoundException e) {
					e.printStackTrace(); //exitError("Failed to find SWF file specified.");
				} catch (JFlashInvalidFlashException e) {
					e.printStackTrace(); //exitError("Required version " + flashVersionRequired + " of Flash is not installed.");
				}
		
		mainWindow.setTitle("Jeremy - Version 0.3");
		mainWindow.setResizable(false);
		mainWindow.getContentPane().add(flashPanel, BorderLayout.CENTER);
		mainWindow.setJMenuBar(getTopMenu());
		mainWindow.setSize(600, 423);
	}
	
	/*
	 private JPanel getCameraFrame() {
	 
		
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
		
		CameraFrame = new JPanel();
		CameraFrame.setBackground(new Color(254, 194, 141));
		CameraFrame.setLayout(new GroupLayout());
		//CameraFrame.add(flashPanel, BorderLayout.CENTER);
		
		return CameraFrame;
	}
	*/

	private JMenuBar getTopMenu() {
		if (TopMenu == null) {
			TopMenu = new JMenuBar();
			TopMenu.add(getJmenu());
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

	public Jeremy() {
		createFrame();
	}
	
}
