package me.Stoolbend.Jeremy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import parport.ParallelPort;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class ControlPad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPad frame = new ControlPad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControlPad() {
		setTitle("Jeremy Control Pad");
		setBounds(100, 100, 300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea panel = new JTextArea();
		panel.setFont(new Font("Monospaced", Font.PLAIN, 5));
		panel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				// Create the parallel port connection.
				ParallelPort port = new ParallelPort(0x378);
				
				int directionPressed = e.getKeyCode();
									
				if(directionPressed == 37){
					port.write(40);
				}
				else if(directionPressed == 38){
					port.write(10);
				}
				else if(directionPressed == 39){
					port.write(80);
				}
				else if(directionPressed == 40){
					port.write(20);
				}
				else{
					port.write(00);			
				}
			}
		});
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblClickInsideThe = new JLabel("<html><center>Click inside the box and use the arrow keys<br>\r\nto steer Jeremy!</center></html>");
		lblClickInsideThe.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblClickInsideThe, BorderLayout.SOUTH);
	}

}
