
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

public class Main extends JFrame {
	private JPanel contentPane;
	public static int c;

	static JButton btnTable1 = new JButton("Table1");
	static JButton btnTable2 = new JButton("Table2");
	static JButton btnTable3 = new JButton("Table3");
	static JButton btnTable4 = new JButton("Table4");
	static JButton btnTable5 = new JButton("Table5");
	static JButton btnTable6 = new JButton("Table6");
	
	static JButton btnOrder = new JButton("\uC8FC\uBB38\uD558\uAE30");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1229, 969);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setTitle("¸ÞÀÎ");	
		setContentPane(contentPane);
		
		
				
		
		
		
	
		
		btnTable1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable1.setBounds(14, 23, 310, 401);		
		btnTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				c = 1;					
			}
		});		
		contentPane.add(btnTable1);
		
		btnTable2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable2.setBounds(14, 496, 310, 401);
		btnTable2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = 2;				
			}
		});
		contentPane.add(btnTable2);
				
		btnTable3.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable3.setBounds(379, 23, 310, 401);
		btnTable3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=3;
			}
		});
		contentPane.add(btnTable3);
		
		btnTable4.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable4.setBounds(379, 496, 310, 401);
		btnTable4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=4;
			}
		});
		contentPane.add(btnTable4);
		
		btnTable5.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable5.setBounds(739, 23, 310, 401);
		btnTable5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=5;
			}
		});
		contentPane.add(btnTable5);
		
		btnTable6.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnTable6.setBounds(739, 496, 310, 401);
		btnTable6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=6;
			}
		});
		contentPane.add(btnTable6);
		
		
		JButton btnOrder = new JButton("ÁÖ¹® ¹× °áÁ¦");
		btnOrder.setBounds(1098, 23, 115, 117);
		btnOrder.addActionListener(new ActionListener() {
			
			Order order1 = new Order();
			Order order2 = new Order();
			Order order3 = new Order();
			Order order4 = new Order();
			Order order5 = new Order();
			Order order6 = new Order();
			public void actionPerformed(ActionEvent e) {
							
				switch (c) {	
				case 1:
					order1.setVisible(true);
					break;
				case 2:
					order2.setVisible(true);
					break;
				case 3:
					order3.setVisible(true);
					break;
				case 4: 
					order4.setVisible(true);
					break;
				case 5:
					order5.setVisible(true);
					break;
				case 6:
					order6.setVisible(true);
					break;
				default:
					System.out.println("xxx");
					break;
				}
				
				
			}
				
		});
		contentPane.add(btnOrder);
		
		JButton button = new JButton("°á»ê ¹× Â÷Æ®");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JDatePickerDemo().setVisible(true);
			}
		});
		button.setBounds(1098, 180, 115, 117);
		contentPane.add(button);
	}
}

