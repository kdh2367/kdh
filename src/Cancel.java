/*
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
class Cancel implements ActionListener{
	JTable table;

	Cancel(JTable table){
		this.table=table;
	}
	public void actionPerformed(ActionEvent e){
		--AddAction.cnt;
		AddAction.pri = AddAction.pri - 3000;
		int row=table.getSelectedRow();
		if(row==-1)
			return;
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setValueAt(AddAction.cnt, 0, 1);
		model.setValueAt(AddAction.pri, 0, 2);
	}
}
*/