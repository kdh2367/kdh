
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;

public class PolylineBarChart extends ApplicationFrame{
	 
    
	public PolylineBarChart(final String title) {
		super(title);
        final PieDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);
        chartPanel.setLayout(null);
        
        JButton btnNewButton = new JButton("닫기");
        btnNewButton.setBounds(895, 770, 105, 27);
        chartPanel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

        
		
	}


    private PieDataset createDataset() {
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
        
    	Connection conn = null; 
        PreparedStatement pst = null;  
        ResultSet rs = null;

        String arr[][]=new String[5000][5];	
		int i = 0;
	
		try {	
        	String quary = "select * from purchase";
            
            conn = DBConnection.getConnection();
            pst = conn.prepareStatement(quary);
            rs = pst.executeQuery();
           
               	
            
            
            while(rs.next()) {

            		String mname = rs.getString("mname");
            		String oamount = rs.getString("oamount");
            		String mprice = rs.getString("mprice");
            			
                	
                    arr[i][0] = mname;
                    arr[i][1] = oamount;
                    arr[i][2] = mprice;
                    		
                    i++;		
          	
        	}
         
            for(int x =0; x<i; x++) {
             	if(arr[x][0].equals("떡볶이순한맛")) {
             		oamount1 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("떡볶이매운맛")) {
             		oamount2 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("떡볶이짜장맛")) {
             		oamount3 += Integer.valueOf(arr[x][1]);
             	}else if(arr[x][0].equals("김밥")) {
             		oamount4 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("순대")) {
             		oamount5 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("어묵3개")) {
             		oamount6 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("일반튀김6개")) {
             		oamount7 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("모둠튀김10개")) {
             		oamount8 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("볶음밥")) {
             		oamount9 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("라면")) {
             		oamount10 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("떡추가")) {
             		oamount11 += Integer.valueOf(arr[x][1]);
             	}
             	else if(arr[x][0].equals("면사리추가")) {
             		oamount12 += Integer.valueOf(arr[x][1]);
             	}
            	          	
            }
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

        final DefaultPieDataset dataset = new DefaultPieDataset();
        


        dataset.setValue("떡볶이순한맛 : " + oamount1, new Double(oamount1));
        dataset.setValue("떡볶이매운맛 : " + oamount2, new Double(oamount2));
        dataset.setValue("떡볶이짜장맛 : " + oamount3, new Double(oamount3));
        dataset.setValue("김밥 : " + oamount4, new Double(oamount4));
        dataset.setValue("순대 : " + oamount5, new Double(oamount5));
        dataset.setValue("어묵3개  : " + oamount6, new Double(oamount6));
        dataset.setValue("일반튀김6개  : " + oamount7, new Double(oamount7));
        dataset.setValue("모둠튀김10개  : " + oamount8, new Double(oamount8));
        dataset.setValue("볶음밥 : " + oamount9, new Double(oamount9));
        dataset.setValue("라면 : " + oamount10, new Double(oamount10));
        dataset.setValue("떡추가 : " + oamount11, new Double(oamount11));
        dataset.setValue("면사리추가 : " + oamount12, new Double(oamount12));
        
        JFreeChart chart = ChartFactory.createPieChart("food", dataset, true,true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("돋음", Font.BOLD,13));
        chart.getLegend().setItemFont(new Font("돋음",Font.BOLD,20));
        
        return dataset;
        
    }
    
    private JFreeChart createChart(final PieDataset dataset) {
        final JFreeChart chart = ChartFactory.createPieChart(
            "메뉴별 판매현황",  
            dataset,             
            true,               
            true,
            false
        );
        
        chart.getTitle().setFont(new Font("굴림", Font.BOLD, 15));
        chart.getLegend().setItemFont(new Font("돋음",Font.BOLD,15));
        
        
        final PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("돋음",Font.BOLD,20));
        plot.setNoDataMessage("No data available");
        return chart;
    }
    
    public static void main(final String[] args) {

        final PolylineBarChart demo = new PolylineBarChart("Pie Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}

