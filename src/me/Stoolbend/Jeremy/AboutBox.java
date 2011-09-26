package me.Stoolbend.Jeremy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AboutBox extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutBox frame = new AboutBox();
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
	public AboutBox() {
		setTitle("About Jeremy");
		setAlwaysOnTop(true);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblJeremy = new JLabel("Project Jeremy");
		lblJeremy.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(lblJeremy, BorderLayout.NORTH);
		
		JLabel lblcopyConor = new JLabel("<html>&copy; 2011 Conor Morgan</html>");
		lblcopyConor.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblcopyConor, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("<html><b>Project Jeremy</b> is a Java-based software solution to allow the control & feedback from the <b>Jeremy</b> rover unit.<br><br>This software is released under the <b>Attribute Only (Public) License</b> (<a href=\"http://aol.nexua.org\">http://aol.nexua.org></a>)<br><br>The source code for this project is available over at <b><a href=\"http://www.github.com/Stoolbend/Jeremy\">https://github.com/Stoolbend/Jeremy/</a></b></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\nThis program uses the <b>JFlashPlayer</b> API<br>\r\n&copy; 2011 VersaEdge Software, LLC.<br>\r\n<br>\r\nThis program requires<br> <b>Adobe Flash Player 9</b><br> and newer.\r\n</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1, BorderLayout.EAST);
	}

}
