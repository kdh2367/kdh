import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
public class Add {
	private JTable table;
	public static String name;
	public static int pri;
	
	Add(JTable table, String name, int pri, int cnt){
		
			
		
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		
		if(cnt == 1){
			model.insertRow(0, new Object[] {name, 1 , pri});
			table.updateUI();			
						
		} else if(cnt>1){
			
			for(int i=0; i<model.getRowCount(); i++) {
				if(model.getValueAt(i, 0).equals(name)) {
				
				model.setValueAt(cnt, i, 1);
				model.setValueAt(pri*cnt, i, 2);
				}
				
			}
		}
		
	}
}
