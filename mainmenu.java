// Fouad ATM source code.
// In order to access the ATM features you must first login with your card number and PIN code.
// I check the validity of the card by a hypothetical condition. 
//(which is the card number must be even and the PIN code must be odd).
// After successfully logging in to your account you can access the features.
// you can deposit or withdraw money to/from your balance,check current balance,check last transactions.



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class mainmenu extends JFrame {

	// declaring and initializing some variables to be used
	
	    private JPanel contentPane;
	    public JTextField textField;
	    public static float balance = 0; 
	    public static int anotherTransaction;
	    public static float [] transactions = new float[5];
	    public static int i=-1;
	    public static float amount;
	    public static int cardnumber;
	    public static int PIN;
	    public static String card,p,amountstring;
        static JButton btnNext1 = new JButton("Next");
		static JButton btnPrevious = new JButton("Previous");
	    private static JTextField textField_3;
	    private JPasswordField passwordField;
	    private JPasswordField passwordField_1;
	    private static JTextField textField_2;
	    private static JTextField textField_4;
	    
// starting the application.
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// creating the frame.
	
	public mainmenu() {
		
		// creating contents of the frame(labels,buttons,textFields,passwordFields,.....).
		
		setTitle("Fouad's ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Enter your card number");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		textField.setBounds(140, 11, 225, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCardNumber.setBackground(Color.RED);
		lblCardNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardNumber.setBounds(0, 13, 142, 35);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPin.setForeground(Color.BLACK);
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setBounds(345, 13, 94, 35);
		contentPane.add(lblPin);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setEnabled(false);
		btnDeposit.setForeground(new Color(128, 0, 0));
		btnDeposit.setToolTipText("Click to add an amount of money to your balance");
		// action to happen after clicking on Deposit button.
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call the deposit method.
				depositmethod();
			}
			
			});
		btnDeposit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnDeposit.setBounds(10, 192, 230, 77);
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		// action to happen after clicking on Withdraw button.
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call the withdraw method.
				withdrawmethod();
				}
				
				
			}
		);
		btnWithdraw.setEnabled(false);
		btnWithdraw.setForeground(new Color(128, 0, 0));
		btnWithdraw.setToolTipText("Click to withdraw an amount of money from your balance");
		btnWithdraw.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnWithdraw.setBounds(252, 192, 230, 77);
		contentPane.add(btnWithdraw);
		
		JButton btnBalanceInquiry = new JButton("Balance Inquiry");
		// action to happen after clicking on Balance Inquiry button.
		btnBalanceInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("Your current balance is "+balance+" LE ");
				textField_4.setText("");
			
			}
		});
		btnBalanceInquiry.setEnabled(false);
		btnBalanceInquiry.setForeground(new Color(128, 0, 0));
		btnBalanceInquiry.setToolTipText("Click to check your current balance");
		btnBalanceInquiry.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnBalanceInquiry.setBounds(494, 192, 230, 77);
		contentPane.add(btnBalanceInquiry);
		
		
		
		JButton btnLastTransactions = new JButton("Last Transactions");
		// action to happen after clicking on Last Transactions button.
		btnLastTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNext1.setEnabled(true);	
				btnPrevious.setEnabled(true);
				textField_2.setText("Here is your last transactions");
				// calling a method called history which shows you the history of the user's transactions.
				history();
			}
		});
		btnLastTransactions.setEnabled(false);
		btnLastTransactions.setToolTipText("Click to show your last 5 transactions.");
		btnLastTransactions.setForeground(new Color(128, 0, 0));
		btnLastTransactions.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnLastTransactions.setBounds(494, 274, 230, 77);
		contentPane.add(btnLastTransactions);
		
		JButton btnAnotherTransction = new JButton("Another Transction");
		// action to happen after clicking on ANother Transaction button.
		btnAnotherTransction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				amount=0;
				textField_2.setText("Choose the type of the transaction ");
				textField_4.setText(" ");
				textField_3.setText(" ");
			}
		});
		btnAnotherTransction.setEnabled(false);
		btnAnotherTransction.setToolTipText("Click to make another transaction");
		btnAnotherTransction.setForeground(new Color(128, 0, 0));
		btnAnotherTransction.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		btnAnotherTransction.setBounds(494, 352, 230, 77);
		contentPane.add(btnAnotherTransction);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setToolTipText("Enter the amount you wish to withdraw/deposit here");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setBounds(9, 353, 473, 77);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		// action to happen after clicking on Login button.
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//scanning the card number and PIN code.
				card=textField.getText();
				p=passwordField_1.getText();
				cardnumber=Integer.parseInt(card);
				PIN=Integer.parseInt(p);
				//checking the validity of the card number and checking the PIN code.
				if (cardnumber%2 == 0 && PIN%2!=0 ) {
					//if the user enters a valid card number and correct PIN code he can access the features.
					btnDeposit.setEnabled(true);
					btnWithdraw.setEnabled(true);
					btnBalanceInquiry.setEnabled(true);
					btnLastTransactions.setEnabled(true);
					btnAnotherTransction.setEnabled(true);
					textField_3.setEnabled(true);
					textField_2.setText("Welcome To Our Bank! ");
				}
				else if (cardnumber%2 == 0 && PIN%2==0)
				{
					textField_2.setText("Wrong PIN.\\nThanks for using our bank!");
				}
				else if (cardnumber%2 != 0 && PIN%2!=0) {
					textField_2.setText("Invalid card number.\nThanks for using our bank!");
				}
				else if (cardnumber%2 != 0 && PIN%2==0){
					textField_2.setText("Invalid card number.\\nThanks for using our bank!");
				}
			}
		});
		btnLogin.setToolTipText("Click to login.");
		btnLogin.setForeground(new Color(0, 0, 139));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(602, 11, 115, 34);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(574, 21, -151, 22);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField_1.setBounds(435, 11, 127, 32);
		contentPane.add(passwordField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setToolTipText("Screen to show instructions");
		textField_2.setEditable(false);
		textField_2.setBackground(new Color(248, 248, 255));
		textField_2.setBounds(19, 59, 705, 45);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Screen to show transactions");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setEditable(false);
		textField_4.setBackground(new Color(248, 248, 255));
		textField_4.setBounds(20, 117, 704, 62);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(602, 381, 97, 25);
		contentPane.add(btnNewButton);
		
		
		btnNext1.setEnabled(false);
		btnNext1.setToolTipText("Click to show the later transaction");
		btnNext1.setForeground(new Color(139, 0, 0));
		btnNext1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnNext1.setBounds(252, 274, 230, 77);
		contentPane.add(btnNext1);
		
		
		
		btnPrevious.setToolTipText("Click to show the previous transaction");
		btnPrevious.setEnabled(false);
		btnPrevious.setForeground(new Color(139, 0, 0));
		btnPrevious.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		btnPrevious.setBounds(10, 274, 230, 77);
		contentPane.add(btnPrevious);
	}
	 public static void history() {
		   //for showing the last transactions.
		   
		   textField_4.setText(" "+transactions[i]+" your current balance is "+balance+"");
		   //action to happen when clicking on the Next button.
		   btnNext1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int j=i+1;
					if (transactions[j]==0.0 || j>4) {
				textField_2.setText("No next transactions ");
				btnNext1.setEnabled(false);
				  textField_4.setText("");
					}
					else {
						textField_4.setText(" "+transactions[j]+"  your current balance is "+balance+" LE");
						if (j==4) {
							btnNext1.setEnabled(false);
							
						}
					}
				}
			});
		   // action to happen when clicking on the Previous button.
		   btnPrevious.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int k=i-1;
					if (k==-1) {
						textField_2.setText("No previous transactions ");
						btnPrevious.setEnabled(false);
						  textField_4.setText("");
					}
					else {
						textField_4.setText(" "+transactions[k]+"  your current balance is "+balance+"");	
					}
				}
			});
		   
		   
		  
	   }
	 // the deposit method.
	 public static void depositmethod() {
	
		 textField_2.setText("Enter the amount you want to deposit then click on Deposit button ");
			amountstring=textField_3.getText();
			amount = Integer.parseInt(amountstring);
			balance = balance+amount;
			if (amount!=0.0) {
			textField_4.setText("You have successfully added "+amount+" LE to your balace");}
			textField_3.setText(" ");
			i=i+1;
			transactions[i]=amount;
			}
	 // the withdraw method.
	 public static void withdrawmethod() {
		 amount=0;
		 textField_2.setText("Enter the amount you want to withdraw then click on Withdraw button ");
			amountstring=textField_3.getText();
			
			
				amount = Integer.parseInt(amountstring);
				if (balance>=amount) {
					balance=balance-amount;
					textField_4.setText("You have successfully withdrawn "+amount+" LE from your balace");	
					i=i+1;
					transactions[i]=-amount;
				}
				else 
				{
					textField_2.setText("Insufficient Balance.");
				}
				textField_3.setText(" ");
	 

	 }}

