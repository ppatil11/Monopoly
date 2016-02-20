
package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




@SuppressWarnings("serial")
public class ErrorMessage extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ErrorMessage(String message) {
		setResizable(false);
		
		setTitle("Notification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel(message);
		lblFirstName.setBounds(10, 11, 770, 264);
		contentPane.add(lblFirstName);
	}	
}

