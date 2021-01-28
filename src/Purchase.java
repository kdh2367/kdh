
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Purchase implements ActionListener{
	 private JTable table;
	 static String arr[][]=new String[12][5];

		
	public Purchase(JTable table){
		this.table=table;
	}

	public void actionPerformed(ActionEvent e) {
		
		DefaultTableModel model=(DefaultTableModel) table.getModel();
        	
        int i;
        int j = 0;
        int rowNum = model.getRowCount();
		int colNum = model.getColumnCount();
		
        
        for(i=0; i<rowNum;i++) {
        	for(j=0; j<colNum; j++) {
        		arr[i][j] = (String)model.getValueAt(i, j).toString();          
        	}
        }
      
        System.out.println(Main.c);
			
        
        int total = 0;
        String strP= "<html>";
        for(int t=0; t<rowNum; t++) {
        	total += Integer.valueOf(arr[t][2]);
        }
        for(int t=0; t<rowNum; t++) {
        	for(int z=0; z<colNum; z++) {
        		strP += arr[t][z] + ", ";
        		if(z==2) strP += "<br>";
        		
        	}
        	if(t==rowNum) strP += "</html>"; 
        }
        switch (Main.c) {
		case 1:			
			Main.btnTable1.setText(strP+"ÃÑ±Ý¾× : " + total);	
			
			break;
		case 2:			
			Main.btnTable2.setText(strP+"ÃÑ±Ý¾× : " + total);			
			break;
		case 3:			
			Main.btnTable3.setText(strP+"ÃÑ±Ý¾× : " + total);			
			break;
		case 4:			
			Main.btnTable4.setText(strP+"ÃÑ±Ý¾× : " + total);			
			break;
		case 5:			
			Main.btnTable5.setText(strP+"ÃÑ±Ý¾× : " + total);			
			break;
		case 6:			
			Main.btnTable6.setText(strP+"ÃÑ±Ý¾× : " + total);			
			break;
		default:
			break;
		}     
	}
}
