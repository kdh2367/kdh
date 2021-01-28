import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.plaf.multi.MultiLabelUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class Payment extends JFrame{
	Container contentPane;
	int total=0;
	private JTable table;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Payment(JTable table) {
		this.table = table;
	}
	Payment(){
		Purchase purchase = new Purchase(table);

		setTitle("����");
		setSize(500 , 500);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout(20,10));
		String colNames[] = { "�޴�", "����", "����"};		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table1 = new JTable(model);	
		contentPane.add(new JScrollPane(table1), BorderLayout.CENTER);
		

		//for(int i=0; i<purchase.getTable().getRowCount();i++) {       		
       // 	model.insertRow(0, new Object[] {purchase.getTable().getValueAt(i, 0), purchase.getTable().getValueAt(i, 1), purchase.getTable().getValueAt(i, 2)});
     //   	table1.updateUI();
      //  	total += Integer.parseInt(String.valueOf(purchase.getTable().getValueAt(i, 2)));
       	
		//}
		
			
		
		JPanel panel1 = new JPanel(new GridLayout(4,1));
		JButton pay = new JButton("�����ϱ�");
		JButton part = new JButton("�κа���");
		JButton exit = new JButton("�ݱ�");
		
		//pay.addActionListener(new Pay());
		panel1.add(pay);
		panel1.add(part);
		panel1.add(exit);
		
		contentPane.add(panel1, BorderLayout.EAST);
		
		//part.addActionListener(new Cancel(table));
		//pay.addActionListener(new Pay(table));
		
		JPanel panel = new JPanel(new GridLayout(5, 5, 5, 5));
		JTextField text1 = new JTextField();
		text1.setText("�� �ݾ� : "+total);
		text1.setEditable(false);
		
		panel.add(text1);

		
		contentPane.add(panel, BorderLayout.NORTH);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
