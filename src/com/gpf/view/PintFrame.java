package com.gpf.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.gpf.bean.User;
import com.gpf.jdbc.JDBCUtils;

import java.awt.Color;

public class PintFrame extends JInternalFrame
{
	private JTable StuTable;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		EventQueue.invokeLater(new Runnable() {
//			public void run()
//			{
//				try
//				{
//					PintFrame frame = new PintFrame();
//					frame.setVisible(true);
//				} catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PintFrame()
	{
		setIconifiable(true);
		setClosable(true);
		setTitle("显示学生信息");
		setBounds(100, 100, 845, 464);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		
		StuTable = new JTable();
		StuTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u4E13\u4E1A", "\u7C7B\u578B", "\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(StuTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new User());

	}
	public void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel)StuTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		conn=JDBCUtils.getConnection();
		Statement statement = null;
		try
		{
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Stu");
			while(result.next()) {
				 Vector v = new Vector();
				 v.add(result.getInt("IdName"));
				 v.add(result.getString("uname"));
				 v.add(result.getString("Gender"));
				 v.add(result.getInt("Age"));
				 v.add(result.getString("Major"));
				 v.add(result.getInt("type"));
				 v.add(result.getString("upass"));
				 dtm.addRow(v);
				}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
