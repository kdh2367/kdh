



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RefineryUtilities;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;


/**
 * This program demonstrates how to use JDatePicker to display a calendar 
 * component in a Swing program.
 * @author www.codejava.net
 *
 */
public class JDatePickerDemo extends JFrame implements ActionListener {
	
	private JDateChooser date_choose;
	private JDateChooser date_choose1;
	private int total;
	public JDatePickerDemo() {
		super("Calendar Component Demo");
		getContentPane().setLayout(null);
		
		String colNames[] = { "∏ﬁ¥∫", "ºˆ∑Æ", "∞°∞›"};		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(126, 50);
		scrollPane.setSize(563, 509);
		getContentPane().add(scrollPane);
		
		
		JLabel label = new JLabel("\uC2DC\uC791\uC77C\uC790");
		label.setBounds(134, 9, 63, 29);
		getContentPane().add(label);
		JLabel label1 = new JLabel("\uC885\uB8CC\uC77C\uC790");
		label1.setBounds(384, 9, 63, 29);
		getContentPane().add(label1);
		JLabel label_1 = new JLabel("√—æ◊ : ");
		label_1.setFont(new Font("±º∏≤", Font.PLAIN, 25));
		label_1.setBounds(703, 143, 200, 89);
		getContentPane().add(label_1);
		
		Calendar cal = Calendar.getInstance();
		 
		//«ˆ¿Á ≥‚µµ, ø˘, ¿œ
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) ;
		int date = cal.get ( cal.DATE ) ;
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		int min = cal.get ( cal.MINUTE );
		int sec = cal.get ( cal.SECOND );
		

		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");			
		Date time = new Date();			
		String time1 = format1.format(time);
				

		
		
		
		date_choose = new JDateChooser();
		date_choose.setBounds(200, 8, 100, 45);
		date_choose.setSize(150, 30);
		date_choose.setCalendar(cal);
		getContentPane().add(date_choose);
		date_choose.setDateFormatString("yyyy-MM-dd");
		
		date_choose1 = new JDateChooser();
		date_choose1.setBounds(450, 8, 100, 45);
		date_choose1.setSize(150, 30);
		date_choose1.setCalendar(cal);
		getContentPane().add(date_choose1);
		date_choose1.setDateFormatString("yyyy-MM-dd");
		
		JButton btnNewButton = new JButton("∞·ªÍ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date day1 = null;
				Date day2 = null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					day1 = format.parse(df.format(date_choose.getDate()));
					day2 = format.parse(df.format(date_choose1.getDate()));
				} catch (ParseException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				Connection conn = null; 
		        PreparedStatement pst = null;  
		        ResultSet rs = null;
		        Date day;
		        String name;
		        String arr[][]=new String[5000][5];	
				int i = 0;
				model.setNumRows(0);	
				try {	
		        	String quary = "select * from purchase";
		            
		            conn = DBConnection.getConnection();
		            pst = conn.prepareStatement(quary);
		            rs = pst.executeQuery();
		           
		            int oamount1=0;
		            int oamount2=0;
		            int oamount3=0;
		            int oamount4=0;
		            int oamount5=0;
		            int oamount6=0;
		            int oamount7=0;
		            int oamount8=0;
		            int oamount9=0;
		            int oamount10=0;
		            int oamount11=0;
		            int oamount12=0;      	
		            
		            
		            while(rs.next()) {
		            	day = rs.getDate("oday");
		            	name = rs.getString("mname");
		            	int compare = day1.compareTo(day);
		            	int compare1 = day2.compareTo(day);
		            	
		            	if(compare<=0 && compare1>=0) {
		            		String mname = rs.getString("mname");
		            		String oamount = rs.getString("oamount");
		            		String mprice = rs.getString("mprice");
		            			
		                	
		                    arr[i][0] = mname;
		                    arr[i][1] = oamount;
		                    arr[i][2] = mprice;
		                    		
		                    i++;		
		                             	 
		            	}
		            	
	            	}
                 
		            for(int x =0; x<i; x++) {
		             	if(arr[x][0].equals("∂±∫∫¿Ãº¯«—∏¿")) {
		             		oamount1 += Integer.valueOf(arr[x][1]);
		             	}else if(arr[x][0].equals("∂±∫∫¿Ã∏≈øÓ∏¿")) {
		             		oamount2 += Integer.valueOf(arr[x][1]);
		             	}else if(arr[x][0].equals("∂±∫∫¿Ã¬•¿Â∏¿")) {
		             		oamount3 += Integer.valueOf(arr[x][1]);
		             	}else if(arr[x][0].equals("±Ëπ‰")) {
		             		oamount4 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("º¯¥Î")) {
		             		oamount5 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("æÓπ¨3∞≥")) {
		             		oamount6 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("¿œπ›∆¢±Ë6∞≥")) {
		             		oamount7 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("∏µ“∆¢±Ë10∞≥")) {
		             		oamount8 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("∫∫¿Ωπ‰")) {
		             		oamount9 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("∂Û∏È")) {
		             		oamount10 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("∂±√ﬂ∞°")) {
		             		oamount11 += Integer.valueOf(arr[x][1]);
		             	}
		             	else if(arr[x][0].equals("∏ÈªÁ∏Æ√ﬂ∞°")) {
		             		oamount12 += Integer.valueOf(arr[x][1]);
		             	}
		            	          	
		            }
		           // model1.insertRow(0, new Object[] {"√—«’", oamount1+oamount2+oamount3 , oamount1*3000+oamount2*3500+oamount3*3900});         		           		
		        	//table.updateUI();
		           
		            model.insertRow(0, new Object[] {"∂±∫∫¿Ãº¯«—∏¿", oamount1 , oamount1*3000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∂±∫∫¿Ã∏≈øÓ∏¿", oamount2 , oamount2*3500});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∂±∫∫¿Ã¬•¿Â∏¿", oamount3 , oamount3*3500});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"±Ëπ‰", oamount4 , oamount4*1500});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"º¯¥Î", oamount5 , oamount5*3000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"æÓπ¨3∞≥", oamount6 , oamount6*2000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"¿œπ›∆¢±Ë6∞≥", oamount7 , oamount7*3000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∏µ“∆¢±Ë10∞≥", oamount8 , oamount8*6000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∫∫¿Ωπ‰", oamount9 , oamount9*3000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∂Û∏È", oamount10 , oamount10*2000});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∂±√ﬂ∞°", oamount11 , oamount11*500});         		           		
		        	table.updateUI();
		        	model.insertRow(0, new Object[] {"∏ÈªÁ∏Æ√ﬂ∞°", oamount12 , oamount12*500});         		           		
		        	table.updateUI();
		        	 int compare2 = day1.compareTo(day2);
			            if(compare2>0){
		            		JOptionPane.showMessageDialog(null, "Ω√¿€¿œ¿⁄∏¶ ¡æ∑·¿œ¿⁄∫∏¥Ÿ ¿Ã¿¸¿∏∑Œ º±≈√«ÿ¡÷Ω Ω√ø¿.");
		            		model.setNumRows(0);
		            	}
			            total=oamount1*3000+oamount2*3500+oamount3*3500+oamount4*1500+oamount5*3000+oamount6*2000+oamount7*3000+oamount8*6000+oamount9*3000+oamount10*2000+oamount11*500+oamount12*500;
           	 	label_1.setText("√—æ◊ : " + total);
				}catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}finally {
				
					try {
						if (null != rs) rs.close();
						if (null != pst) pst.close();
						if (null != conn) conn.close();
					}catch (Exception e1) {
						// TODO: handle exception
						e1.getStackTrace();
					}
				}
				
			}
			
		});
		btnNewButton.setBounds(703, 54, 105, 47);
		getContentPane().add(btnNewButton);
		
		
		
		setSize(1013, 753);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Connection conn = null; 
        PreparedStatement pst = null;  
        ResultSet rs = null;
        String day;
        String arr[][]=new String[50][5];
		int i = 0;
		
		try {	
        	String quary = "select * from purchase";
            
            conn = DBConnection.getConnection();
            pst = conn.prepareStatement(quary);
            rs = pst.executeQuery();
            
            int oamount1=0;
            int oamount2=0;
            int oamount3=0;
            int oamount4=0;
            int oamount5=0;
            int oamount6=0;
            int oamount7=0;
            int oamount8=0;
            int oamount9=0;
            int oamount10=0;
            int oamount11=0;
            int oamount12=0;      	
            
            
            while(rs.next()) {
            	day = rs.getString("oday");
            	String name = rs.getString("mname");
            	if(day.equals(time1 + " " + "00:00:00")) {
            		String mname = rs.getString("mname");
            		String oamount = rs.getString("oamount");
            		String mprice = rs.getString("mprice");
            			
            		
                	
                    arr[i][0] = mname;
                    arr[i][1] = oamount;
                    arr[i][2] = mprice;
                    		
                    i++;	
                  
            	}
            	 
            }
            for(int x =0; x<i; x++) {
             	if(arr[x][0].equals("∂±∫∫¿Ãº¯«—∏¿")) {
             		oamount1 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("∂±∫∫¿Ã∏≈øÓ∏¿")) {
             		oamount2 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("∂±∫∫¿Ã¬•¿Â∏¿")) {
             		oamount3 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("±Ëπ‰")) {
             		oamount4 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("º¯¥Î")) {
             		oamount5 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("æÓπ¨3∞≥")) {
             		oamount6 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("¿œπ›∆¢±Ë6∞≥")) {
             		oamount7 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("∏µ“∆¢±Ë10∞≥")) {
             		oamount8 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("∫∫¿Ωπ‰")) {
             		oamount9 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("∂Û∏È")) {
             		oamount10 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("∂±√ﬂ∞°")) {
             		oamount11 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("∏ÈªÁ∏Æ√ﬂ∞°")) {
             		oamount12 += Integer.valueOf(arr[x][1]);
             	}
            	           	
            }
           
          
        
            model.insertRow(0, new Object[] {"∂±∫∫¿Ãº¯«—∏¿", oamount1 , oamount1*3000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∂±∫∫¿Ã∏≈øÓ∏¿", oamount2 , oamount2*3500});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∂±∫∫¿Ã¬•¿Â∏¿", oamount3 , oamount3*3500});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"±Ëπ‰", oamount4 , oamount4*1500});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"º¯¥Î", oamount5 , oamount5*3000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"æÓπ¨3∞≥", oamount6 , oamount6*2000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"¿œπ›∆¢±Ë6∞≥", oamount7 , oamount7*3000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∏µ“∆¢±Ë10∞≥", oamount8 , oamount8*6000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∫∫¿Ωπ‰", oamount9 , oamount9*3000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∂Û∏È", oamount10 , oamount10*2000});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∂±√ﬂ∞°", oamount11 , oamount11*500});         		           		
        	table.updateUI();
        	model.insertRow(0, new Object[] {"∏ÈªÁ∏Æ√ﬂ∞°", oamount12 , oamount12*500});         		           		
        	table.updateUI();

        	total=oamount1*3000+oamount2*3500+oamount3*3500+oamount4*1500+oamount5*3000+oamount6*2000+oamount7*3000+oamount8*6000+oamount9*3000+oamount10*2000+oamount11*500+oamount12*500;
            label_1.setText("√—æ◊ : " + total);   
            

            JButton button = new JButton("∆ƒ¿Ã ¬˜∆Æ ∫∏±‚");
            button.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		final PolylineBarChart demo = new PolylineBarChart("Pie Chart");
                    demo.pack();
                    RefineryUtilities.centerFrameOnScreen(demo);
                    demo.setVisible(true);
                    
            		
            		
            		
            		
            	}
            });
            button.setBounds(703, 512, 105, 47);
            getContentPane().add(button);
            
            JButton button_1 = new JButton("πŸ ¬˜∆Æ ∫∏±‚");
            button_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Chart demo1 = new Chart();
                    JFreeChart chart = demo1.getChart();
                    ChartFrame frame1=new ChartFrame("Bar Chart",chart);
                    frame1.setSize(800,400);  
                    frame1.setVisible(true);
            		
            	}
            });
            button_1.setBounds(701, 451, 105, 47);
            getContentPane().add(button_1);
            
            
		}catch (Exception e2) {
			// TODO: handle exception
			e2.getStackTrace();
		}finally {
			try {
				if (null != rs) rs.close();
				if (null != pst) pst.close();
				if (null != conn) conn.close();
			}catch (Exception e1) {
				// TODO: handle exception
				e1.getStackTrace();
			}
		}

	}

	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JDatePickerDemo().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}
}