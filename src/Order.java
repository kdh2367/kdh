import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.awt.*;

public class Order extends JFrame{
	Container contentPane;

	private JTable table;
	private int cnt1;
	private int cnt2;
	private int cnt3;
	private int cnt4;
	private int cnt5;
	private int cnt6;
	private int cnt7;
	private int cnt8;
	private int cnt9;
	private int cnt10;
	private int cnt11;
	private int cnt12;

	public Order(){		
		setTitle("ÁÖ¹®");	
		setSize(1000, 1000);
		Container contentPane = getContentPane();
		String colNames[] = { "¸Þ´º", "¼ö·®", "°¡°Ý"};		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		getContentPane().setLayout(null);
		JTable table = new JTable(model);	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(532, 0, 452, 716);
		contentPane.add(scrollPane);
			
		JPanel panel1 = new JPanel(new GridLayout(1,2));
		panel1.setBounds(0, 912, 984, 46);
		JButton purchase = new JButton("ÁÖ¹®ÇÏ±â");
		JButton exit = new JButton("´Ý±â");
		
		panel1.add(purchase);
		
		JButton btnNewButton = new JButton("°áÁ¦ÇÏ±â");
		panel1.add(btnNewButton);
		btnNewButton.addActionListener(new Pay(table));
		
		panel1.add(exit);
			
		contentPane.add(panel1);
		
		purchase.addActionListener(new Purchase(table));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(5, 5, 5, 5));
		panel.setBounds(0, 0, 518, 900);
		JButton button1 = new JButton("<html>¶±ººÀÌ¼øÇÑ¸À<br>3000¿ø</html> ");
		JButton button2 = new JButton("<html>¶±ººÀÌ¸Å¿î¸À<br>3500¿ø</html>");
		JButton button3 = new JButton("<html>¶±ººÀÌÂ¥Àå¸À<br>3500¿ø</html>");
		JButton button4 = new JButton("<html>±è¹ä<br>1500¿ø</html>");
		JButton button5 = new JButton("<html>¼ø´ë<br>3000¿ø</html>");
		JButton button6 = new JButton("<html>¾î¹¬3°³ <br>2000¿ø</html>");
		JButton button7 = new JButton("<html>ÀÏ¹ÝÆ¢±è6°³<br>3000¿ø</html>");
		JButton button8 = new JButton("<html>¸ðµÒÆ¢±è10°³<br>6000¿ø</html>");
		JButton button9 = new JButton("<html>ººÀ½¹ä<br>3000¿ø</html>");
		JButton button10 = new JButton("<html>¶ó¸é<br>2000¿ø</html>");
		JButton button11= new JButton("<html>¶±Ãß°¡<br>500¿ø</html>");
		JButton button12= new JButton("<html>¸é»ç¸®Ãß°¡<br>500¿ø</html>");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button10);
		panel.add(button11);
		panel.add(button12);
		
		contentPane.add(panel);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt1++;
				Add add1 = new Add(table, "¶±ººÀÌ¼øÇÑ¸À", 3000, cnt1);	
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt2++;
				Add add2 = new Add(table, "¶±ººÀÌ¸Å¿î¸À", 3500, cnt2);	
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt3++;
				Add add3 = new Add(table, "¶±ººÀÌÂ¥Àå¸À", 3500, cnt3);	
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt4++;
				Add add4 = new Add(table, "±è¹ä", 1500, cnt4);
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt5++;
				Add add5 = new Add(table, "¼ø´ë", 3000, cnt5);
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt6++;
				Add add6 = new Add(table, "¾î¹¬3°³", 3000, cnt6);
			}
		});
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt7++;
				Add add7 = new Add(table, "ÀÏ¹ÝÆ¢±è6°³", 3000, cnt7);
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt8++;
				Add add8 = new Add(table, "¸ðµÒÆ¢±è10°³", 6000, cnt8);
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt9++;
				Add add9 = new Add(table, "ººÀ½¹ä", 3000, cnt9);
			}
		});
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt10++;
				Add add10 = new Add(table, "¶ó¸é", 2000, cnt10);
			}
		});
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt11++;
				Add add11 = new Add(table, "¶±Ãß°¡", 500, cnt11);
			}
		});
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cnt12++;
				Add add12 = new Add(table, "¸é»ç¸®Ãß°¡", 500, cnt12);
			}
		});
table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() != -1) {
					int result = JOptionPane.showConfirmDialog(null, "¸Þ´º¸¦ Áö¿ì½Ã°Ú½À´Ï±î?", "Á¾·á", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						
						int select = table.getSelectedRow();
						
						String names = (String) model.getValueAt(select, 0);
						int c = (int) model.getValueAt(select, 1);
						int c1 = (int) model.getValueAt(select, 2);
						int d = c-1;
						
						model.setValueAt(d, select, 1);
						
						if(names == "¶±ººÀÌ¼øÇÑ¸À") {
							model.setValueAt(d*3000, select, 2);
							cnt1 = d;
						}else if(names == "¶±ººÀÌ¸Å¿î¸À") {
							model.setValueAt(d*3500, select, 2);
							cnt2 = d;
						}else if(names == "¶±ººÀÌÂ¥Àå¸À") {
							model.setValueAt(d*3500, select, 2);
							cnt3 = d;
						}else if(names == "±è¹ä") {
							model.setValueAt(d*1500, select, 2);
							cnt4 = d;
						}else if(names == "¼ø´ë") {
							model.setValueAt(d*3000, select, 2);
							cnt5 = d;
						}else if(names == "¾î¹¬3°³") {
							model.setValueAt(d*2000, select, 2);
							cnt6 = d;
						}else if(names == "ÀÏ¹ÝÆ¢±è6°³") {
							model.setValueAt(d*3000, select, 2);
							cnt7 = d;
						}else if(names == "¸ðµÒÆ¢±è10°Ô") {
							model.setValueAt(d*6000, select, 2);
							cnt8 = d;
						}else if(names == "ººÀ½¹ä") {
							model.setValueAt(d*3000, select, 2);
							cnt9 = d;
						}else if(names == "¶ó¸é") {
							model.setValueAt(d*2000, select, 2);
							cnt10 = d;
						}else if(names == "¶±Ãß°¡") {
							model.setValueAt(d*500, select, 2);
							cnt11 = d;
						}else if(names == "¸é»ç¸®Ãß°¡") {
							model.setValueAt(d*500, select, 2);
							cnt12 = d;
						}
						if(d == 0) {
							model.removeRow(select);
						}
						
					}				
		        }
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
