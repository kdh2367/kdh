import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pay implements ActionListener{
	private String pnum;
	int total = 0;
	String stotal;
	
	Date d = new Date();
	String s = d.toString();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private JTable table;
	
	static String arr[][]=new String[12][5];
	
	Calendar cal = Calendar.getInstance();
	String year = String.valueOf(cal.get(Calendar.YEAR));
	String month = String.valueOf(cal.get(Calendar.MONTH)+1);
	String date = String.valueOf(cal.get(Calendar.DATE));
	String dDay = year + "-" + month + "-" + date;
	
	public Pay(JTable table){
		this.table = table;
	}
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
    	String quary1 = "insert into purchase(mname, oamount, mprice, oday) values(?,?,?,?)";
        
        con = DBConnection.getConnection();
        pst = con.prepareStatement(quary1);
        int n;
        int x = 1;
        int rowNum = model.getRowCount();
		int colNum = model.getColumnCount();
		for(int i=0; i<rowNum;i++) {
        	for(int j=0; j<colNum; j++) {
        		arr[i][j] = (String)model.getValueAt(i, j).toString();          
        	}
        }
        for(int i=0; i<rowNum;i++) {
        	for(int j=0; j<colNum; j++) {
        		
        		pst.setString(x, arr[i][j]);
        		x++;
               if(x==4) x=1;
               System.out.println(arr[i][j]);
        	}	
        	pst.setString(4, dDay);
        	pst.executeUpdate();
        }
        
    }catch (Exception e1) {
		e1.printStackTrace();
    }finally {
		try {
			if (null != pst) pst.close();
			if (null != con) con.close();
		}catch (Exception e1) {
			// TODO: handle exception
		}
	}
	}
}
