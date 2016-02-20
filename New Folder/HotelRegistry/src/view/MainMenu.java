package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import modal.ManageRooms;
import modal.RoomAvailability;

public class MainMenu extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// These are the variables were Guest names needs to be populated
	private JPanel contentPane;
	private JTextField txt100;
	private JTextField txt101;
	private JTextField txt102;
	private JTextField txt103;
	private JTextField txt104;
	private JTextField txt105;
	private JTextField txt106;
	private JTextField txt107;
	private JTextField txt108;
	private JTextField txt109;
	private JTextField txt110;
	private JTextField txt111;
	private JTextField txt112;
	private JTextField txt113;
	private JTextField txt114;
// In these variables No. of specific room types available needs to be populated
	private JTextField txtQueen;
	private JTextField txtDouble;
	private JTextField txtDoublePlus;
	private JTextField txtKing;

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Hotel Registry");
		setResizable(false);
		
		RoomAvailability.Initialize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistry = new JMenu("Registry");
		menuBar.add(mnRegistry);
		
		JMenuItem mntmCheckIn = new JMenuItem("Check In");
		mnRegistry.add(mntmCheckIn);
		
		JMenuItem mntmCheckOut = new JMenuItem("Check Out");
		mnRegistry.add(mntmCheckOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnRegistry.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vacancies", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(201, 0, 306, 429);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 0, 0, 0, 20};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblKing = new JLabel("King");
		GridBagConstraints gbc_lblKing = new GridBagConstraints();
		gbc_lblKing.anchor = GridBagConstraints.WEST;
		gbc_lblKing.insets = new Insets(0, 0, 5, 5);
		gbc_lblKing.gridx = 0;
		gbc_lblKing.gridy = 4;
		panel_1.add(lblKing, gbc_lblKing);
		
		txtKing = new JTextField();
		txtKing.setText("" + RoomAvailability.getAvailableRoomsForType(ManageRooms.KING));
		txtKing.setEditable(false);
		GridBagConstraints gbc_txtKing = new GridBagConstraints();
		gbc_txtKing.insets = new Insets(0, 0, 5, 5);
		gbc_txtKing.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKing.gridx = 2;
		gbc_txtKing.gridy = 4;
		panel_1.add(txtKing, gbc_txtKing);
		txtKing.setColumns(10);
		
		JLabel lblOneQueen = new JLabel("One Queen");
		GridBagConstraints gbc_lblOneQueen = new GridBagConstraints();
		gbc_lblOneQueen.anchor = GridBagConstraints.WEST;
		gbc_lblOneQueen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOneQueen.gridx = 0;
		gbc_lblOneQueen.gridy = 7;
		panel_1.add(lblOneQueen, gbc_lblOneQueen);
		
		txtQueen = new JTextField();
		txtQueen.setText("" + RoomAvailability.getAvailableRoomsForType(ManageRooms.QUEEN));
		txtQueen.setEditable(false);
		GridBagConstraints gbc_txtQueen = new GridBagConstraints();
		gbc_txtQueen.insets = new Insets(0, 0, 5, 5);
		gbc_txtQueen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQueen.gridx = 2;
		gbc_txtQueen.gridy = 7;
		panel_1.add(txtQueen, gbc_txtQueen);
		txtQueen.setColumns(10);
		
		JLabel lblTwoDoubleBeds = new JLabel("Two Double Beds");
		GridBagConstraints gbc_lblTwoDoubleBeds = new GridBagConstraints();
		gbc_lblTwoDoubleBeds.anchor = GridBagConstraints.WEST;
		gbc_lblTwoDoubleBeds.insets = new Insets(0, 0, 5, 5);
		gbc_lblTwoDoubleBeds.gridx = 0;
		gbc_lblTwoDoubleBeds.gridy = 10;
		panel_1.add(lblTwoDoubleBeds, gbc_lblTwoDoubleBeds);
		
		txtDouble = new JTextField();
		txtDouble.setText("" + RoomAvailability.getAvailableRoomsForType(ManageRooms.DOUBLE_BED));
		txtDouble.setEditable(false);
		GridBagConstraints gbc_txtDouble = new GridBagConstraints();
		gbc_txtDouble.insets = new Insets(0, 0, 5, 5);
		gbc_txtDouble.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDouble.gridx = 2;
		gbc_txtDouble.gridy = 10;
		panel_1.add(txtDouble, gbc_txtDouble);
		txtDouble.setColumns(10);
		
		JLabel lblTwoDoubleBeds_1 = new JLabel("Two Double Beds Plus Cot");
		GridBagConstraints gbc_lblTwoDoubleBeds_1 = new GridBagConstraints();
		gbc_lblTwoDoubleBeds_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTwoDoubleBeds_1.gridx = 0;
		gbc_lblTwoDoubleBeds_1.gridy = 13;
		panel_1.add(lblTwoDoubleBeds_1, gbc_lblTwoDoubleBeds_1);
		
		txtDoublePlus = new JTextField();
		txtDoublePlus.setText("" + RoomAvailability.getAvailableRoomsForType(ManageRooms.DOUBLE_BED_COT));
		txtDoublePlus.setEditable(false);
		GridBagConstraints gbc_txtDoublePlus = new GridBagConstraints();
		gbc_txtDoublePlus.insets = new Insets(0, 0, 5, 5);
		gbc_txtDoublePlus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDoublePlus.gridx = 2;
		gbc_txtDoublePlus.gridy = 13;
		panel_1.add(txtDoublePlus, gbc_txtDoublePlus);
		txtDoublePlus.setColumns(10);
		
		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setBounds(10, 11, 61, 14);
		contentPane.add(lblRooms);
		lblRooms.setHorizontalAlignment(SwingConstants.LEFT);
		lblRooms.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblGuest = new JLabel("Guest");
		lblGuest.setBounds(81, 11, 46, 14);
		contentPane.add(lblGuest);
		
		JLabel label = new JLabel("100:");
		label.setBounds(10, 40, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("101:");
		label_1.setBounds(10, 65, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("102");
		label_2.setBounds(10, 90, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("103:");
		label_3.setBounds(10, 115, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("104:");
		label_4.setBounds(10, 140, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("105:");
		label_5.setBounds(10, 165, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("106:");
		label_6.setBounds(10, 190, 46, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("107:");
		label_7.setBounds(10, 215, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("108:");
		label_8.setBounds(10, 240, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("109:");
		label_9.setBounds(10, 265, 46, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("110:");
		label_10.setBounds(10, 290, 46, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("111:");
		label_11.setBounds(10, 315, 46, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("112:");
		label_12.setBounds(10, 340, 46, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("113:");
		label_13.setBounds(10, 365, 46, 14);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("114:");
		label_14.setBounds(10, 390, 46, 14);
		contentPane.add(label_14);
		
		txt100 = new JTextField();
// Set text after it is being changed
		
//		
		
		
		txt100.setEditable(false);
		txt100.setBounds(77, 36, 86, 20);
		contentPane.add(txt100);
		txt100.setColumns(10);
		txt100.setText("" + RoomAvailability.getGuestsInRoom(100));
		
		txt101 = new JTextField();
		txt101.setEditable(false);
		txt101.setBounds(77, 62, 86, 20);
		contentPane.add(txt101);
		txt101.setColumns(10);
		txt101.setText("" + RoomAvailability.getGuestsInRoom(101));
		
		txt102 = new JTextField();
		txt102.setEditable(false);
		txt102.setBounds(77, 87, 86, 20);
		contentPane.add(txt102);
		txt102.setColumns(10);
		txt102.setText("" + RoomAvailability.getGuestsInRoom(102));
		
		txt103 = new JTextField();
		txt103.setEditable(false);
		txt103.setBounds(77, 112, 86, 20);
		contentPane.add(txt103);
		txt103.setColumns(10);
		txt103.setText("" + RoomAvailability.getGuestsInRoom(103));
		
		txt104 = new JTextField();
		txt104.setEditable(false);
		txt104.setBounds(77, 137, 86, 20);
		contentPane.add(txt104);
		txt104.setColumns(10);
		txt104.setText("" + RoomAvailability.getGuestsInRoom(104));
		
		txt105 = new JTextField();
		txt105.setEditable(false);
		txt105.setBounds(77, 162, 86, 20);
		contentPane.add(txt105);
		txt105.setColumns(10);
		txt105.setText("" + RoomAvailability.getGuestsInRoom(105));
		
		txt106 = new JTextField();
		txt106.setEditable(false);
		txt106.setBounds(77, 187, 86, 20);
		contentPane.add(txt106);
		txt106.setColumns(10);
		txt106.setText("" + RoomAvailability.getGuestsInRoom(106));
		
		txt107 = new JTextField();
		txt107.setEditable(false);
		txt107.setBounds(77, 212, 86, 20);
		contentPane.add(txt107);
		txt107.setColumns(10);
		txt107.setText("" + RoomAvailability.getGuestsInRoom(107));
		
		txt108 = new JTextField();
		txt108.setEditable(false);
		txt108.setBounds(77, 237, 86, 20);
		contentPane.add(txt108);
		txt108.setColumns(10);
		txt108.setText("" + RoomAvailability.getGuestsInRoom(108));
		
		txt109 = new JTextField();
		txt109.setEditable(false);
		txt109.setBounds(77, 262, 86, 20);
		contentPane.add(txt109);
		txt109.setColumns(10);
		txt109.setText("" + RoomAvailability.getGuestsInRoom(109));
		
		txt110 = new JTextField();
		txt110.setEditable(false);
		txt110.setBounds(77, 287, 86, 20);
		contentPane.add(txt110);
		txt110.setColumns(10);
		txt110.setText("" + RoomAvailability.getGuestsInRoom(110));
		
		txt111 = new JTextField();
		txt111.setEditable(false);
		txt111.setBounds(77, 312, 86, 20);
		contentPane.add(txt111);
		txt111.setColumns(10);
		txt111.setText("" + RoomAvailability.getGuestsInRoom(111));
		
		txt112 = new JTextField();
		txt112.setEditable(false);
		txt112.setBounds(77, 337, 86, 20);
		contentPane.add(txt112);
		txt112.setColumns(10);
		txt112.setText("" + RoomAvailability.getGuestsInRoom(112));
		
		txt113 = new JTextField();
		txt113.setEditable(false);
		txt113.setBounds(77, 362, 86, 20);
		contentPane.add(txt113);
		txt113.setColumns(10);
		txt113.setText("" + RoomAvailability.getGuestsInRoom(113));
		
		txt114 = new JTextField();
		txt114.setEditable(false);
		txt114.setBounds(77, 387, 86, 20);
		contentPane.add(txt114);
		txt114.setColumns(10);
		txt114.setText("" + RoomAvailability.getGuestsInRoom(114));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 191, 440);
		contentPane.add(panel);

//		Add Actions to the buttons
		mntmCheckIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Check In button is pressed!");
				CheckIn checkIn = new CheckIn();
				checkIn.setVisible(true);
				setVisible(false);
//				Information info = checkIn.getSubmittedInfo();
//				ManageRooms.allocateRoom(info);
			}
		});
		
		mntmCheckOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Check Out button is pressed!");
				CheckOut checkOut = new CheckOut();
				checkOut.setVisible(true);
				setVisible(false);
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Exit button is pressed....");
				System.out.println("Exiting the application....");
				System.out.println("Bbye....");
			    System.exit(DISPOSE_ON_CLOSE);
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
//				About about = new About();
				
				
				JPopupMenu Myinfo = new JPopupMenu("About");
				JLabel myName = new JLabel("Prashant Patil");
				JLabel myANo = new JLabel("A20356927");
				JButton ok = new JButton("OK");
				Myinfo.add(myName);
				Myinfo.add(myANo);
				Myinfo.add(ok);
				Myinfo.setVisible(true);
				
				ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Myinfo.setVisible(false);
					}
				});
			}
		});
	}
//	Update the texts on runtime
	public void setText()
	{
		txt100.setText(RoomAvailability.getFullName(100));
		txt101.setText(RoomAvailability.getFullName(101));
		txt102.setText(RoomAvailability.getFullName(102));
		txt103.setText(RoomAvailability.getFullName(103));
		txt104.setText(RoomAvailability.getFullName(104));
		txt105.setText(RoomAvailability.getFullName(105));
		txt106.setText(RoomAvailability.getFullName(106));
		txt107.setText(RoomAvailability.getFullName(107));
		txt108.setText(RoomAvailability.getFullName(108));
		txt109.setText(RoomAvailability.getFullName(109));
		txt110.setText(RoomAvailability.getFullName(110));
		txt111.setText(RoomAvailability.getFullName(111));
		txt112.setText(RoomAvailability.getFullName(112));
		txt113.setText(RoomAvailability.getFullName(113));
		txt114.setText(RoomAvailability.getFullName(114));

	}
}
