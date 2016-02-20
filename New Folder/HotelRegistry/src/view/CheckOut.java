package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modal.Information;
import modal.ManageRooms;
import modal.RoomAvailability;

public class CheckOut extends JFrame {
	private static final long serialVersionUID = -9029272897197338177L;

//	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SuppressWarnings("unchecked")
	public CheckOut() {
		setResizable(false);
		setTitle("Check Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 187);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room to Check Out:");
		lblNewLabel.setBounds(10, 35, 119, 19);
		getContentPane().add(lblNewLabel);
			
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();		
		comboBox.setModel(new DefaultComboBoxModel( RoomAvailability.getAllAllocatedRooms().toArray() ));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114"}));
		comboBox.setMaximumRowCount(15);
		comboBox.setBounds(164, 35, 178, 20);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int roomNo = -1;
				try {
					System.out.println("Room number:" + comboBox.getSelectedItem());
					roomNo = Integer.parseInt(comboBox.getSelectedItem().toString());
				} catch (Exception e){
					view.ErrorMessage cin = new view.ErrorMessage("Invalid room number!");
					cin.setVisible(true);
				}
				
				Information info = new Information();
				if (!ManageRooms.releaseRoom(roomNo, info)) {
					System.out.println("Room could not be released!");
					view.ErrorMessage cin = new view.ErrorMessage("Room " + roomNo + " could not be released!");
					cin.setVisible(true);
				} else {
/*					view.ErrorMessage cin = new view.ErrorMessage("Room " + roomNo + 
								" is released! Invoice amount:" + info.invoiceAmount + 
								" Details: Name:" + info.fname + " Adults:" + info.adults +
								" Children:"+info.children);
					cin.setVisible(true);*/
				}
				MainMenu mm = new MainMenu();
				mm.setText();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(52, 92, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   MainMenu mm = new MainMenu();
	           mm.setVisible(true); 
	           mm.setText();
			   setVisible(false);
			}
		});
		btnNewButton_1.setBounds(187, 92, 89, 23);
		getContentPane().add(btnNewButton_1);
	}

	@SuppressWarnings({ "serial", "unused" })
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
