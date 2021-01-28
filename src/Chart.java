

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;
import javax.swing.JButton;

/**
 * A simple demonstration application showing how to create a bar chart overlaid
 * with a line chart.
 */
public class Chart {


       // Run As > Java Application 占쏙옙占쏙옙 占쏙옙占쏙옙占싹몌옙 占쌕뤄옙 확占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙.
    public static void main(final String[] args) {
       Chart demo = new Chart();
             JFreeChart chart = demo.getChart();
             ChartFrame frame1=new ChartFrame("Bar Chart",chart);
             frame1.setSize(800,400);
             frame1.getChartPanel().setLayout(null);
             
             JButton btnNewButton = new JButton("바차트보기");
             btnNewButton.setBounds(679, 331, 105, 27);
             btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame1.setVisible(false);
				}
			});
             frame1.getChartPanel().add(btnNewButton);
             frame1.setVisible(true);
         
    }


	public JFreeChart getChart() {
        // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
    	Connection conn = null; 
        PreparedStatement pst = null;  
        ResultSet rs = null;
        int to = 0;
        int arr[] = new int[13];
		try {	
        	String quary = "select * from purchase";
            
            conn = DBConnection.getConnection();
            pst = conn.prepareStatement(quary);
            rs = pst.executeQuery();
           
               	
            
            
            while(rs.next()) {

            		
            		Date day = rs.getDate("oday");
            		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM");					
            		String time1 = format1.format(day);
            		int mprice = rs.getInt("mprice");

            			if(time1.equals("2019-01")) {            				
            				arr[1] += mprice;          				
            			}else if(time1.equals("2019-02")) {
            				arr[2] += mprice;
            				
            			}else if(time1.equals("2019-03")) {
            				arr[3] += mprice;
            				
            			}else if(time1.equals("2019-04")) {
            				arr[4] += mprice;
            				
            			}else if(time1.equals("2019-05")) {
            				arr[5] += mprice;
            				
            			}else if(time1.equals("2019-06")) {
            				
            				arr[6] += mprice;
            			}else if(time1.equals("2019-07")) {
            				arr[7] += mprice;
            				
            			}else if(time1.equals("2019-08")) {
            				arr[8] += mprice;
            				
            			}else if(time1.equals("2019-09")) {
            				arr[9] += mprice;
            				
            			}else if(time1.equals("2019-10")) {
            				arr[10] += mprice;
            				
            			}else if(time1.equals("2019-11")) {
            				arr[11] += mprice;
            				
            			}else if(time1.equals("2019-12")) {
            				arr[12] += mprice;
            				
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
		
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1



        dataset1.addValue(arr[1], "S1", "1占쏙옙");
        dataset1.addValue(arr[2], "S1", "2占쏙옙");
        dataset1.addValue(arr[3], "S1", "3占쏙옙");
        dataset1.addValue(arr[4], "S1", "4占쏙옙");
        dataset1.addValue(arr[5], "S1", "5占쏙옙");
        dataset1.addValue(arr[6], "S1", "6占쏙옙");
        dataset1.addValue(arr[7], "S1", "7占쏙옙");
        dataset1.addValue(arr[8], "S1", "8占쏙옙");
        dataset1.addValue(arr[9], "S1", "9占쏙옙");
        dataset1.addValue(arr[10], "S1", "10占쏙옙");
        dataset1.addValue(arr[11], "S1", "11占쏙옙");
        dataset1.addValue(arr[12], "S1", "12占쏙옙");
      
        final BarRenderer renderer = new BarRenderer();

        
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER 
            );
        final ItemLabelPosition p_below = new ItemLabelPosition(
                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
                     );
        Font f = new Font("Gulim", Font.BOLD, 14);
        Font axisF = new Font("Gulim", Font.PLAIN, 14);

        

        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(p_center);
        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(0,162,255));

  
        // plot 占쏙옙占쏙옙
        final CategoryPlot plot = new CategoryPlot();

        // plot 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
 
  
     
 

        // plot 占썩본 占쏙옙占쏙옙
        plot.setOrientation(PlotOrientation.VERTICAL);             // 占쌓뤄옙占쏙옙 표占쏙옙 占쏙옙占쏙옙
        plot.setRangeGridlinesVisible(true);                       // X占쏙옙 占쏙옙占싱듸옙 占쏙옙占쏙옙 표占시울옙占쏙옙
        plot.setDomainGridlinesVisible(true);                      // Y占쏙옙 占쏙옙占싱듸옙 占쏙옙占쏙옙 표占시울옙占쏙옙

        // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 : dataset 占쏙옙占� 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 ( 占쏙옙, 占쏙옙占쏙옙 占쏙옙占쏙옙璣占� 占싣뤄옙占쏙옙 占쏙옙 )
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
        // X占쏙옙 占쏙옙占쏙옙
        plot.setDomainAxis(new CategoryAxis());              // X占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
        plot.getDomainAxis().setTickLabelFont(axisF); // X占쏙옙 占쏙옙占쌥띰옙 占쏙옙트 占쏙옙占쏙옙
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // 카占쌓곤옙 占쏙옙 占쏙옙치 占쏙옙占쏙옙

        // Y占쏙옙 占쏙옙占쏙옙
        plot.setRangeAxis(new NumberAxis());                 // Y占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y占쏙옙 占쏙옙占쌥띰옙 占쏙옙트 占쏙옙占쏙옙

        // 占쏙옙占시듸옙 plot占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 chart 占쏙옙占쏙옙
        final JFreeChart chart = new JFreeChart(plot);
//        chart.setTitle("Overlaid Bar Chart"); // 占쏙옙트 타占쏙옙틀
//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
//        chart.addSubtitle(copyright);  // 占쏙옙트 占쏙옙占쏙옙 타占쏙옙틀
        return chart;

    }
}