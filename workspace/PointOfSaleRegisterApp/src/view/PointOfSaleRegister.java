package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modal.CostOfProducts;
import modal.ProductOrder;
import modal.SaleOfProducts;

public class PointOfSaleRegister extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTotalitem;
	private JTextField txtTotalcost;
	private JTextField txtSkuno;

	String DISCOUNT = "DISCOUNT PERCENTAGE";
	String BUYXGET1 = "BUY X GET 1 FREE";
	String BUYXGETY = "BUY X FOR Y";

	ArrayList<ProductOrder> cart = new ArrayList<>();
	String cartMessage = "";
	int cartItems = 0;
	int cartTotal = 0;

	public PointOfSaleRegister() {

	//	Load cost data
		CostOfProducts cp = new CostOfProducts();

	//	Load sale data
		SaleOfProducts sp = new SaleOfProducts();

		setResizable(false);
		setTitle("Point of Sale Register");
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 389);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(230, 230, 250));
		setJMenuBar(menuBar);

		JMenu mnRegister = new JMenu("Register");
		menuBar.add(mnRegister);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnRegister.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exiting the application....");
				System.out.println("Application closed!!!");
				System.exit(DISPOSE_ON_CLOSE);

			}
		});

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic(KeyEvent.VK_H);
		mnHelp.setDisplayedMnemonicIndex(0);
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				About about = new About();
				about.setVisible(true);

			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 593, 183);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 205, 593, 134);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTotalItems = new JLabel("Total Items");
		lblTotalItems.setBounds(97, 25, 68, 14);
		panel.add(lblTotalItems);

		txtTotalitem = new JTextField();
		txtTotalitem.setEditable(false);
		txtTotalitem.setBounds(160, 22, 110, 20);
		panel.add(txtTotalitem);
		txtTotalitem.setColumns(10);
		txtTotalitem.setText("0");

		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setBounds(276, 25, 59, 14);
		panel.add(lblTotalCost);

		txtTotalcost = new JTextField();
		txtTotalcost.setEditable(false);
		txtTotalcost.setBounds(348, 22, 110, 20);
		panel.add(txtTotalcost);
		txtTotalcost.setColumns(10);
		txtTotalcost.setText("0");

		txtSkuno = new JTextField();
		txtSkuno.setBounds(160, 53, 139, 20);
		panel.add(txtSkuno);
		txtSkuno.setColumns(10);

		JLabel lblSku = new JLabel("SKU");
		lblSku.setBounds(127, 56, 26, 14);
		panel.add(lblSku);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String skuno = txtSkuno.getText();	
				if (skuno != null)
				{
					System.out.println("The SKU no. you have entered is: "+txtSkuno.getText());
					System.out.println("Validating the SKU with all "+cp.Cost_Data.size()+"SKU's present in the cost file");
                Boolean validSKU = false; 
					for(int i = 0 ; i < cp.Cost_Data.size(); i++){
						String sku =  cp.Cost_Data.get(i).getSKU();
						String desc = cp.Cost_Data.get(i).getDesc();
						int ucost = Integer.parseInt(cp.Cost_Data.get(i).getUCost());
					
						if (sku.equals(txtSkuno.getText())){
							System.out.println("SKU is valid");
						     
							addItemToCart(sku, cart, desc, ucost, sp);

							textArea.setText(getOrderText(cart));
							textArea.append(null);

							cartMessage = getOrderText(cart);
							cartItems = getTotalItems(cart);
							cartTotal = getTotalCost(cart, sp);

							txtTotalitem.setText("" + getTotalItems(cart));
							txtTotalcost.setText("" + getTotalCost(cart, sp));
                         
							validSKU = true;
						}
					}
					if (!validSKU){
						System.out.println("Invalid SKU...Please enter a valid SKU no!");
						txtSkuno.setText(null);
					}
				}
				 


			}

			private int getTotalCost(ArrayList<ProductOrder> cart, SaleOfProducts sp) {

				int cost = 0;
				for (ProductOrder po : cart) {
					if (po != null) {
						cost += po.getTotalCost();
					}
				}
				return cost;
			}

			private int getTotalItems(ArrayList<ProductOrder> cart) {
				int count = 0;
				for (ProductOrder po : cart) {
					if (po != null) {
						count += po.getCount();
						count += po.freeItems;
					}
				}
				return count;
			}

			private void addItemToCart(String sku, ArrayList<ProductOrder> cart, String desc, int ucost, SaleOfProducts sp) {

				boolean duplicate = false;
				for (ProductOrder po : cart) {
					if (po.getSku().equals(sku)) {
						po.incrementCount(sp);
						duplicate = true;
						break;
					}
				}

				if (!duplicate) {
					cart.add(new ProductOrder(sku, desc, ucost, sp));
				}
			}

			private String getOrderText(ArrayList<ProductOrder> cart) {

				String text = "";
				for (ProductOrder po : cart) {
					if (cart == null)
						continue;

					String t = po.getSku();
					t += "  " + po.getDes();
					t += "  " + po.getUprice();
					t += "  (" + po.getCount() + ")";
					t += " -  " + po.getTotalCost();
					t += "      (" + po.getNotes() + ", Applied:" + po.discountStatus() + " )";
					t += "\n";

					if (po.freeItems > 0) {
						t += po.getSku();
						t += "  " + po.getDes();
						t += "  free";
						t += "  (" + po.freeItems + ")";
						t += " -  0";
						t += "      (free item with offer: " + po.getNotes() + ")";
						t += "\n";
					}

					text += t;
				}

				return text;
			}
		});
		btnAddItem.setBackground(new Color(143, 188, 143));
		btnAddItem.setBounds(314, 52, 103, 23);
		panel.add(btnAddItem);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String line = "------------------------------------------------------------------\n";
				String finalLine = "Total item(s) in cart:" + cartItems + ",   Total Cost of cart:" + cartTotal+ " USD";
				String date = "DATE:" + new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
				String bill = cartMessage.trim() + "\n" + line + finalLine + "\n" + date;
				textArea.setText(bill);
				textArea.append(null);

				writeBillToFile(bill);
			}

			private void writeBillToFile(String bill) {
				try {
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Orders.txt", true)));
					out.println("\n**************************************************************************************");
					out.println(bill);
					out.println("**************************************************************************************");
					out.close();
				}catch (IOException e) {
					//exception handling left as an exercise for the reader
				}

			}
		});
		btnPay.setBackground(new Color(143, 188, 143));
		btnPay.setBounds(221, 84, 78, 23);
		panel.add(btnPay);

		JButton btnVoid = new JButton("Void");
		btnVoid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cart = new ArrayList<>();
				textArea.setText(null);
				txtTotalitem.setText(null);
				txtTotalcost.setText(null);
				txtSkuno.setText(null);

			}
		});
		btnVoid.setBackground(new Color(143, 188, 143));
		btnVoid.setBounds(314, 84, 78, 23);
		panel.add(btnVoid);

	}
}
