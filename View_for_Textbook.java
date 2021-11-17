import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class View_for_Textbook extends Inventory {

	// SPECIFY THE GUI APP ELEMENTS: UI AND OBJECTS
	public JTextField textBookTxt;
	public JTextField skuTxt;
	public JTextField priceTxt;
	public JTextField quantTxt;
	public JFrame appWindow;
	public JButton addBook;
	public JButton checkInven;
	public JButton removeBook;
	public JButton AboutBook;
	public JFrame myAddView;
	public JFrame myIventoryView;
	public JTextPane myIvenScroll;
	public JFrame myBSView;
	public JPanel myBSPanel;
	public FileWriter fileWriter;
	public JButton submitSKU;
	public JButton remove; 
	public JFrame myCheckOutView; 
	public Inventory in; 
	

	public View_for_Textbook() throws IOException {

		// INITIALIZE THE INVENTORY OBJECT
		in = new Inventory();

		// CREATE THE APPLICATION WINDOW
		appWindow = new JFrame();
		appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appWindow.setBounds(495, 0, 543, 487);
		appWindow.setForeground(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(Color.BLACK);
		panel.setPreferredSize(new Dimension(543, 487));
		JLabel viewBackground;
		panel.setLayout(null);

		// add panel onto the JFrame
		appWindow.getContentPane().add(panel);
		viewBackground = new JLabel(
				(Icon) new ImageIcon(ImageIO.read(new File("C:\\Users\\antho\\Desktop\\addie_new"))));
		viewBackground.setBackground(new Color(0, 0, 0));
		viewBackground.setBounds(-68, 44, 342, 439);
		viewBackground.setOpaque(true);
		panel.add(viewBackground);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(new Color(128, 0, 0));
		menuBar_1.setBackground(new Color(128, 0, 0));
		menuBar_1.setBounds(0, 0, 543, 47);
		panel.add(menuBar_1);

		// build buttons
		// ***********************this is the about book button*************//
		AboutBook = new JButton("About a Book Selection");
		menuBar_1.add(AboutBook);
		AboutBook.setForeground(Color.white);
		AboutBook.setOpaque(false);
		AboutBook.setContentAreaFilled(false);
		AboutBook.setBorderPainted(false);
		AboutBook.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		AboutBook.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				aboutBookSelection();
			}
			
		});
		// ******************this is the add button edits **********************//
		addBook = new JButton("Add A Book");
		menuBar_1.add(addBook);
		addBook.setForeground(Color.white);
		addBook.setOpaque(false);
		addBook.setContentAreaFilled(false);
		addBook.setBorderPainted(false);
		addBook.setFont(new Font("Times New Roman", Font.BOLD, 12));

		addBook.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openAddBook();
			}
		});
		// *******************************this is the check button******************//
		checkInven = new JButton("Check Inventory");
		menuBar_1.add(checkInven);
		checkInven.setForeground(Color.white);
		checkInven.setOpaque(false);
		checkInven.setContentAreaFilled(false);
		checkInven.setBorderPainted(false);
		checkInven.setFont(new Font("Times New Roman", Font.BOLD, 12));

		checkInven.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//in.generateReport();
				checkInventory();
			}
		});
		// *************************this is the remove book button***************//
		removeBook = new JButton("Check Out a Book");
		menuBar_1.add(removeBook);
		removeBook.setForeground(Color.white);
		removeBook.setOpaque(false);
		removeBook.setContentAreaFilled(false);
		removeBook.setBorderPainted(false);
		removeBook.setFont(new Font("Times New Roman", Font.BOLD, 12));

		JTextPane txtpnWelcomeToYour = new JTextPane();
		txtpnWelcomeToYour.setForeground(new Color(189, 183, 107));
		txtpnWelcomeToYour.setFont(new Font("Corbel", txtpnWelcomeToYour.getFont().getStyle() & ~Font.BOLD,
				txtpnWelcomeToYour.getFont().getSize() + 12));
		txtpnWelcomeToYour.setText("Welcome to your Local TextBook Store!");
		txtpnWelcomeToYour.setBounds(300, 137, 216, 220);
		panel.add(txtpnWelcomeToYour);
		removeBook.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				removeBook.setForeground(Color.ORANGE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				removeBook.setForeground(Color.WHITE);
			}
		});
		
		removeBook.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeText();
			}
		});
		
		//CHECKING INVENTORY TAB ANIMATIONS

		checkInven.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				checkInven.setForeground(Color.ORANGE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				checkInven.setForeground(Color.WHITE);
			}
		});
		
		//ADDING BOOK TAB ANIMATIONS 

		addBook.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBook.setForeground(Color.ORANGE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBook.setForeground(Color.WHITE);
			}
		});
		AboutBook.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				AboutBook.setForeground(Color.ORANGE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				AboutBook.setForeground(Color.WHITE);
			}
		});

		// make app window visible
		appWindow.pack();
		appWindow.setVisible(true);
	}

	// these are the methods that will open new windows based on the buttons that
	// are pressed

	// ******THIS IS THE OPEN ADD VIEW************
	public void openAddBook() {

		// before initializing this view
		// close appWindow view first
		appWindow.setVisible(false);

		// Initialize the add view frame and its panel
		myAddView = new JFrame();
		myAddView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myAddView.setBounds(500, 0, 250, 250);
		JPanel myAddPanel = new JPanel();
		myAddPanel.setPreferredSize(new Dimension(100, 100));

		// build the labels
		JLabel itembtn = new JLabel("Textbook");
		textBookTxt = new JTextField(18);
		// length of a textbook name
		JLabel skuLbl = new JLabel("S_K_U");
		skuTxt = new JTextField(25);
		JLabel priceLbl = new JLabel("price");
		priceTxt = new JTextField(25);
		JLabel quantLbl = new JLabel("Quant: ");
		quantTxt = new JTextField(10);

		// add labels to panel
		myAddPanel.add(itembtn);
		myAddPanel.add(textBookTxt);
		myAddPanel.add(quantLbl);
		myAddPanel.add(quantTxt);
		myAddPanel.add(priceLbl);
		myAddPanel.add(priceTxt);
		myAddPanel.add(skuLbl);
		myAddPanel.add(skuTxt);

		// add panel to frame
		myAddView.add(myAddPanel);
		myAddView.pack();
		myAddView.setVisible(true);

		// make submit button
		JButton submit = new JButton("Submit");
		myAddPanel.add(submit);

		submit.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// add book selection to the textbook ArrayList
				Inventory.addBook(skuTxt.getText(), textBookTxt.getText(), Double.parseDouble(priceTxt.getText()),
						Integer.parseInt(quantTxt.getText()));
				try {
					// instantiate fileoutputers
					fileWriter = new FileWriter("C:\\Users\\antho\\Desktop\\myTextbookInven.txt"); 
					PrintWriter printWriter = new PrintWriter(fileWriter); 
				 
					// go through textbook arraylist and write to the file
					for (int i = 0; i < Inventory.bookList.size(); i++) {
						printWriter.print(Inventory.bookList.get(i).toString() + "\n");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						fileWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				myAddView.setVisible(false);
				appWindow.setVisible(true);
			}
		});

	}

	// ******THIS IS FOR CHECKING THE INVENTORY******
	public void checkInventory() {
		// display inventory in a window for the user to see

		// close appWindow view first
		appWindow.setVisible(false);

		// Initialize the add view frame and its panel
		myIventoryView = new JFrame();
		myIventoryView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myIventoryView.setBounds(500, 0, 250, 250);
		JPanel myInvenPanel = new JPanel();
		myInvenPanel.setPreferredSize(new Dimension(200, 200));

		// Create a File reader
		try {
			File myFile = new File("C:\\\\Users\\\\antho\\\\Desktop\\\\myTextbookInven.txt");
			Scanner myScanner = new Scanner(myFile);
			while (myScanner.hasNext()) {
				String data = myScanner.next();
				myIvenScroll = new JTextPane();
				//myIvenScroll.setBounds(500, 0, 200, 200);
				myIvenScroll.setText(data.toString());
			}
			myScanner.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// add textpane to the panel
		myInvenPanel.add(myIvenScroll);

		// create close button
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myIventoryView.setVisible(false);
				appWindow.setVisible(true);
			}
		});

		myInvenPanel.add(closeBtn);
		myIventoryView.add(myInvenPanel);
		myIventoryView.pack();
		myIventoryView.setVisible(true);
	}

	// **********THIS FOR DISPLAYING A TEXTBOOk********////
	public void aboutBookSelection() {
		// display inventory in a window for the user to see

		// close appWindow view first
		appWindow.setVisible(false);

		// Initialize the add view frame and its panel
		myBSView = new JFrame();
		myBSView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myBSView.setBounds(500, 0, 250, 250);
		JPanel myBSPanel = new JPanel();
		myBSPanel.setPreferredSize(new Dimension(200, 200));

		// create textfield for user to enter their sku
		JTextField bookSKU = new JTextField("Enter an SKU: ");
		
		// create button to send the book sku off
		 submitSKU = new JButton("LOOK");
		// create textfield that will display info
		JTextField output = new JTextField("This was found: ");
		
		// create close button
		JButton close = new JButton("Close");

		// once submit button has been pressed
		submitSKU.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String foundResult = Inventory.displayBookInfo(bookSKU.getText());
				output.setText(foundResult);
			}
		});

		// if close has been pressed
		close.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				appWindow.setVisible(true);
				myBSView.setVisible(false);
			}
		});

		// add everything to the panel
		myBSPanel.add(bookSKU);
		myBSPanel.add(submitSKU);
		myBSPanel.add(output);
		myBSPanel.add(close);

		// add panel to the frame
		myBSView.add(myBSPanel);

		// set the myBSView visibility to true
		myBSView.setVisible(true);
		myBSView.pack();

	}
	
	//this is the checkout process (to remove a book) 
	public void removeText() {
		// display removal in a window for the user to see

				// close appWindow view first
				appWindow.setVisible(false);

				// Initialize the add view frame and its panel
				myCheckOutView = new JFrame();
				myCheckOutView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myCheckOutView.setBounds(500, 0, 250, 250);
				JPanel myCOPanel = new JPanel();
				myCOPanel.setPreferredSize(new Dimension(200, 200));

				// create textfield for user to enter their sku
				JTextField bookToRemove = new JTextField("Enter an SKU: ");
				
				// create button to send the book sku off
				 remove = new JButton("Checkout!");
				 
				 //another close button 
				 JButton close2 = new JButton("Close");
				 
				 //Output response
				 JTextField yourProcessing = new JTextField("Processing...");
				 
				// once submit button has been pressed
					remove.addActionListener((ActionListener) new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Inventory.removeText(bookToRemove.getText());
							yourProcessing.setText("You have checkout this book! ");
							
							// Create a File reader
							try {
								File myFile1 = new File("C:\\\\Users\\\\antho\\\\Desktop\\\\myTextbookInven.txt");
								Scanner myScanner1 = new Scanner(myFile1);
								while (myScanner1.hasNextLine()) {
									String data1 = myScanner1.nextLine();
									if(data1.contains(bookToRemove.getText())) {
										data1.replaceAll(data1, "");
									}
									
								}
								myScanner1.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							
						}
					});

					// if close has been pressed
					close2.addActionListener((ActionListener) new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							appWindow.setVisible(true);
							myCheckOutView.setVisible(false);
						}
					});

					// add everything to the panel
					myCOPanel.add(bookToRemove);
					myCOPanel.add(remove);
					myCOPanel.add(close2);
					myCOPanel.add(yourProcessing);

					// add panel to the frame
					myCheckOutView.add(myCOPanel);

					// set the myBSView visibility to true
					myCheckOutView.setVisible(true);
					myCheckOutView.pack();
				 
	}
}