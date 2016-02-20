//package view;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import modal.Information;
//import modal.ManageRooms;
//import modal.RoomAvailability;
//
//
//class RadioListener implements ActionListener{
//
//	@SuppressWarnings("rawtypes")
//	JComboBox JComboBox;
//	
//    public RadioListener(@SuppressWarnings("rawtypes") JComboBox cBox_Room){
//        this.JComboBox = cBox_Room;
//    }
//
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//	public void actionPerformed(ActionEvent e){
//        JRadioButton button = (JRadioButton) e.getSource();
//
//        String []list = new String[100];
//        
//        if (button.getText().equals("King")) {
//        	list = RoomAvailability.getRoomList(ManageRooms.KING).toArray(list);
//        } else if (button.getText().equals("One Queen")) {
//        	list = RoomAvailability.getRoomList(ManageRooms.QUEEN).toArray(list);
//        } else if (button.getText().equals("Two Double Bed")) {
//        	list = RoomAvailability.getRoomList(ManageRooms.DOUBLE_BED).toArray(list);
//        } else if (button.getText().equals("Two Double Beds Plus Cot")) {
//        	list = RoomAvailability.getRoomList(ManageRooms.DOUBLE_BED_COT).toArray(list);
//        }
//
//        //JComboBox.setModel(new DefaultComboBoxModel(new String[] {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114"}));
//
//        JComboBox.setModel(new DefaultComboBoxModel(list));
//        
//    }
//}  
//
//
//@SuppressWarnings("serial")
//public class CheckIn extends JFrame {
//
//	// INFO OBJECT
//	Information info = new Information();
////	MainMenu mm = new MainMenu();
//	
//	
//	/*
// * First name(txtFname), Last name(txtLname), 
// * Room Type(rdbKing, rdbQueen, rdbDouble, dbDoublePlus)
// * and Room Number(cBox_Room) these 4 things should be
// * passed from this class after applying all the checks
// */
//	private JPanel contentPane;
//	private JTextField txtFname;
//	private JTextField txtLname;
//	private JTextField txtAddress;
//	private JTextField txtCity;
//	private JTextField txtState;
//	private JTextField txtZip;
//	/**
//	 * Create the frame.
//	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public CheckIn() {
//		
//		setTitle("Check In");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 547, 249);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblFirstName = new JLabel("First Name:");
//		lblFirstName.setBounds(10, 11, 70, 14);
//		contentPane.add(lblFirstName);
//		
//		txtFname = new JTextField();
////		txtFname.setText("Fname");
//		txtFname.setBounds(90, 8, 137, 20);
//		contentPane.add(txtFname);
//		txtFname.setColumns(10);
//		
//		JLabel lblLastName = new JLabel("Last Name:");
//		lblLastName.setBounds(289, 11, 85, 14);
//		contentPane.add(lblLastName);
//		
//		txtLname = new JTextField();
////		txtLname.setText("Lname");
//		txtLname.setBounds(384, 8, 137, 20);
//		contentPane.add(txtLname);
//		txtLname.setColumns(10);
//		
//		JLabel lblAddress = new JLabel("Address:");
//		lblAddress.setBounds(10, 36, 70, 14);
//		contentPane.add(lblAddress);
//		
//		txtAddress = new JTextField();
////		txtAddress.setText("Add");
//		txtAddress.setBounds(90, 33, 431, 20);
//		contentPane.add(txtAddress);
//		txtAddress.setColumns(10);
//		
//		JLabel lblNewLabel = new JLabel("City:");
//		lblNewLabel.setBounds(10, 61, 46, 14);
//		contentPane.add(lblNewLabel);
//		
//		txtCity = new JTextField();
////		txtCity.setText("City");
//		txtCity.setBounds(90, 58, 85, 20);
//		contentPane.add(txtCity);
//		txtCity.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("State:");
//		lblNewLabel_1.setBounds(185, 61, 46, 14);
//		contentPane.add(lblNewLabel_1);
//		
//		txtState = new JTextField();
////		txtState.setText("State");
//		txtState.setBounds(263, 58, 85, 20);
//		contentPane.add(txtState);
//		txtState.setColumns(10);
//		
//		JLabel lblNewLabel_2 = new JLabel("Zip Code:");
//		lblNewLabel_2.setBounds(358, 61, 67, 14);
//		contentPane.add(lblNewLabel_2);
//		
//		txtZip = new JTextField();
////		txtZip.setText("zip");
//		txtZip.setBounds(435, 58, 86, 20);
//		contentPane.add(txtZip);
//		txtZip.setColumns(10);
//		
//		JLabel lblAdults = new JLabel("Number of Adults:");
//		lblAdults.setBounds(10, 86, 115, 14);
//		contentPane.add(lblAdults);
//		
//		JComboBox cBox_Adults = new JComboBox();
//		cBox_Adults.setToolTipText("");
//		cBox_Adults.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
//		cBox_Adults.setMaximumRowCount(5);
//		cBox_Adults.setBounds(135, 83, 107, 20);
//		contentPane.add(cBox_Adults);
//		
//		JLabel lblChildren = new JLabel("Number of children:");
//		lblChildren.setBounds(273, 89, 131, 14);
//		contentPane.add(lblChildren);
//		
//		JComboBox cBox_Children = new JComboBox();
//		cBox_Children.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
//		cBox_Children.setMaximumRowCount(5);
//		cBox_Children.setBounds(414, 86, 107, 20);
//		contentPane.add(cBox_Children);
//		
//    	 ButtonGroup bG = new ButtonGroup();
//
//    	JRadioButton rdbKing = new JRadioButton("King");
// 		//rdbKing.setSelected(true);
// 		rdbKing.setBounds(16, 135, 85, 23);
// 		contentPane.add(rdbKing);
//    	 
//    	JRadioButton rdbQueen = new JRadioButton("One Queen");
//		rdbQueen.setBounds(111, 135, 91, 23);
//		contentPane.add(rdbQueen);
//		
//		
//		JRadioButton rdbDouble = new JRadioButton("Two Double Bed");
//		rdbDouble.setBounds(204, 135, 130, 23);
//		contentPane.add(rdbDouble);
//		
//		JRadioButton rdbDoubleplus = new JRadioButton("Two Double Beds Plus Cot");
//		rdbDoubleplus.setBounds(336, 135, 185, 23);
//		contentPane.add(rdbDoubleplus);
//		
//		bG.add(rdbKing);
//		bG.add(rdbQueen);
//		bG.add(rdbDouble);
//		bG.add(rdbDoubleplus);
//				
//		JLabel lblNewLabel_3 = new JLabel("Room");
//		lblNewLabel_3.setBounds(10, 180, 46, 14);
//		contentPane.add(lblNewLabel_3);
//		
//		JComboBox cBox_Room = new JComboBox();
//// Should be visible only if all 3 checks are valid
//		cBox_Room.setEnabled(true);
//// Room no.s should be updated dynamically based on checks
//		//cBox_Room.setModel(new DefaultComboBoxModel(new String[] {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114"}));
//		cBox_Room.setMaximumRowCount(15);
//		cBox_Room.setBounds(90, 177, 85, 20);
//		contentPane.add(cBox_Room);
//		
//		RadioListener listener = new RadioListener(cBox_Room);
//		rdbKing.addActionListener(listener);
//		rdbQueen.addActionListener(listener);
//		rdbDouble.addActionListener(listener);
//		rdbDoubleplus.addActionListener(listener);
//
//		
//		JButton btnRegister = new JButton("Register");
//		btnRegister.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				// ADD FOLLOWING CONTENT TO INFO OBJECT WHEN "REGISTER" BUTTON IS CLICKED
//				info.fname =    txtFname.getText();
//				info.lname =    txtLname.getText();
//				info.address =  txtAddress.getText();
//				info.city =     txtCity.getText();
//				info.state =    txtState.getText();
//				info.zipcode =  txtZip.getText();
//				info.adults =   cBox_Adults.getSelectedIndex();
//				info.children = cBox_Children.getSelectedIndex();
//				
//				try {
//					info.roomNumber = Integer.parseInt(cBox_Room.getSelectedItem().toString());
//				} catch(Exception e) {
//					info.roomNumber = -1;
//				}
////				info.numberOfDays = 
//				//Information info = getSubmittedInfo();
//				
//			   if (rdbKing.isSelected())
//				   info.roomType = ManageRooms.KING;
//			   else if (rdbQueen.isSelected())
//				   info.roomType = ManageRooms.QUEEN;
//			   else if (rdbDouble.isSelected())
//				   info.roomType = ManageRooms.DOUBLE_BED;
//			   else if (rdbDoubleplus.isSelected())
//				   info.roomType = ManageRooms.DOUBLE_BED_COT;
//				
//				if (ManageRooms.allocateRoom(info) == null) {
//					System.out.println("Room could not be allocated!");
//					view.ErrorMessage cin = new view.ErrorMessage("Room could not be allocated!");
//					cin.setVisible(true);
//				}
//				MainMenu mm = new MainMenu();
//				mm.setText();
//				mm.setVisible(true);
//				setVisible(false);
//			}
//		});
//		btnRegister.setBounds(214, 176, 134, 23);
//		contentPane.add(btnRegister);
//		
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				MainMenu mmm = new MainMenu();
//				mmm.setText();
//				mmm.setVisible(true); 
//			   setVisible(false);
//			}
//		});
//		btnCancel.setBounds(358, 176, 134, 23);
//		contentPane.add(btnCancel);
//	}
//	
//	public Information getSubmittedInfo() {
//		return info;
//	}
//}
//---------------------------------------------------------------------
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import modal.Information;
import modal.ManageRooms;
import modal.RoomAvailability;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.ProcessBuilder.Redirect;
import java.awt.event.ActionEvent;


class RadioListener implements ActionListener{

	JComboBox JComboBox;
	
    public RadioListener(JComboBox cBox_Room){
        this.JComboBox = cBox_Room;
    }

    public void actionPerformed(ActionEvent e){
        JRadioButton button = (JRadioButton) e.getSource();

        String []list = new String[100];
        
        if (button.getText().equals("King")) {
        	list = RoomAvailability.getRoomList(ManageRooms.KING).toArray(list);
        } else if (button.getText().equals("One Queen")) {
        	list = RoomAvailability.getRoomList(ManageRooms.QUEEN).toArray(list);
        } else if (button.getText().equals("Two Double Bed")) {
        	list = RoomAvailability.getRoomList(ManageRooms.DOUBLE_BED).toArray(list);
        } else if (button.getText().equals("Two Double Beds Plus Cot")) {
        	list = RoomAvailability.getRoomList(ManageRooms.DOUBLE_BED_COT).toArray(list);
        }

        //JComboBox.setModel(new DefaultComboBoxModel(new String[] {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114"}));

        JComboBox.setModel(new DefaultComboBoxModel(list));
        
    }
}  


public class CheckIn extends JFrame {

	// INFO OBJECT
	Information info = new Information();
	
	
	
	/*
 * First name(txtFname), Last name(txtLname), 
 * Room Type(rdbKing, rdbQueen, rdbDouble, dbDoublePlus)
 * and Room Number(cBox_Room) these 4 things should be
 * passed from this class after applying all the checks
 */
	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	/**
	 * Create the frame.
	 */
	public CheckIn() {
		
		setTitle("Check In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 11, 70, 14);
		contentPane.add(lblFirstName);
		
		txtFname = new JTextField();
//		txtFname.setText("Fname");
		txtFname.setBounds(90, 8, 137, 20);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(289, 11, 85, 14);
		contentPane.add(lblLastName);
		
		txtLname = new JTextField();
//		txtLname.setText("Lname");
		txtLname.setBounds(384, 8, 137, 20);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 36, 70, 14);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
//		txtAddress.setText("Add");
		txtAddress.setBounds(90, 33, 431, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("City:");
		lblNewLabel.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCity = new JTextField();
//		txtCity.setText("City");
		txtCity.setBounds(90, 58, 85, 20);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("State:");
		lblNewLabel_1.setBounds(185, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtState = new JTextField();
//		txtState.setText("State");
		txtState.setBounds(263, 58, 85, 20);
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Zip Code:");
		lblNewLabel_2.setBounds(358, 61, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		txtZip = new JTextField();
//		txtZip.setText("zip");
		txtZip.setBounds(435, 58, 86, 20);
		contentPane.add(txtZip);
		txtZip.setColumns(10);
		
		JLabel lblAdults = new JLabel("Number of Adults:");
		lblAdults.setBounds(10, 86, 115, 14);
		contentPane.add(lblAdults);
		
		JComboBox cBox_Adults = new JComboBox();
		cBox_Adults.setToolTipText("");
		cBox_Adults.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cBox_Adults.setMaximumRowCount(5);
		cBox_Adults.setBounds(135, 83, 107, 20);
		contentPane.add(cBox_Adults);
		
		JLabel lblChildren = new JLabel("Number of children:");
		lblChildren.setBounds(273, 89, 131, 14);
		contentPane.add(lblChildren);
		
		JComboBox cBox_Children = new JComboBox();
		cBox_Children.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
		cBox_Children.setMaximumRowCount(5);
		cBox_Children.setBounds(414, 86, 107, 20);
		contentPane.add(cBox_Children);
		
    	 ButtonGroup bG = new ButtonGroup();

    	JRadioButton rdbKing = new JRadioButton("King");
 		//rdbKing.setSelected(true);
 		rdbKing.setBounds(16, 135, 85, 23);
 		contentPane.add(rdbKing);
    	 
    	JRadioButton rdbQueen = new JRadioButton("One Queen");
		rdbQueen.setBounds(111, 135, 91, 23);
		contentPane.add(rdbQueen);
		
		
		JRadioButton rdbDouble = new JRadioButton("Two Double Bed");
		rdbDouble.setBounds(204, 135, 130, 23);
		contentPane.add(rdbDouble);
		
		JRadioButton rdbDoubleplus = new JRadioButton("Two Double Beds Plus Cot");
		rdbDoubleplus.setBounds(336, 135, 185, 23);
		contentPane.add(rdbDoubleplus);
		
		bG.add(rdbKing);
		bG.add(rdbQueen);
		bG.add(rdbDouble);
		bG.add(rdbDoubleplus);
				
		JLabel lblNewLabel_3 = new JLabel("Room");
		lblNewLabel_3.setBounds(10, 180, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cBox_Room = new JComboBox();
// Should be visible only if all 3 checks are valid
		cBox_Room.setEnabled(true);
// Room no.s should be updated dynamically based on checks
		//cBox_Room.setModel(new DefaultComboBoxModel(new String[] {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114"}));
		cBox_Room.setMaximumRowCount(15);
		cBox_Room.setBounds(90, 177, 85, 20);
		contentPane.add(cBox_Room);
		
		RadioListener listener = new RadioListener(cBox_Room);
		rdbKing.addActionListener(listener);
		rdbQueen.addActionListener(listener);
		rdbDouble.addActionListener(listener);
		rdbDoubleplus.addActionListener(listener);

		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ADD FOLLOWING CONTENT TO INFO OBJECT WHEN "REGISTER" BUTTON IS CLICKED
				info.fname =    txtFname.getText();
				info.lname =    txtLname.getText();
				info.address =  txtAddress.getText();
				info.city =     txtCity.getText();
				info.state =    txtState.getText();
				info.zipcode =  txtZip.getText();
				info.adults =   cBox_Adults.getSelectedIndex();
				info.children = cBox_Children.getSelectedIndex();
				
				try {
					info.roomNumber = Integer.parseInt(cBox_Room.getSelectedItem().toString());
				} catch(Exception e) {
					info.roomNumber = -1;
				}
//				info.numberOfDays = 
				//Information info = getSubmittedInfo();
				
			   if (rdbKing.isSelected())
				   info.roomType = ManageRooms.KING;
			   else if (rdbQueen.isSelected())
				   info.roomType = ManageRooms.QUEEN;
			   else if (rdbDouble.isSelected())
				   info.roomType = ManageRooms.DOUBLE_BED;
			   else if (rdbDoubleplus.isSelected())
				   info.roomType = ManageRooms.DOUBLE_BED_COT;
				
				if (ManageRooms.allocateRoom(info) == null) {
					System.out.println("Room could not be allocated!");
					view.ErrorMessage cin = new view.ErrorMessage("Room could not be allocated!");
					cin.setVisible(true);
				}
				
				MainMenu mm = new MainMenu();
				
				mm.setText();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		btnRegister.setBounds(214, 176, 134, 23);
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				MainMenu mm = new MainMenu();		
				mm.setText();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setBounds(358, 176, 134, 23);
		contentPane.add(btnCancel);
		
		
		

	}
	
	public Information getSubmittedInfo() {
		return info;
	}
}


