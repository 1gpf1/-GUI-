package com.gpf.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MangerFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane table=null;

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
//					MangerFrame frame = new MangerFrame();
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
	public MangerFrame()
	{
		setTitle("学生信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 506);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem addItem = new JMenuItem("添加学生信息");
		mnNewMenu.add(addItem);
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame addFrame = new AddFrame();
				addFrame.setVisible(true);
				table.add(addFrame);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("删除学生信息");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelteteFrame delteteFrame = new DelteteFrame();
				delteteFrame.setVisible(true);
				table.add(delteteFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("修改学生信息");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFrame updateFrame = new UpdateFrame();
				updateFrame.setVisible(true);
				table.add(updateFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("查找学生信息");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectFrame selectFrame = new SelectFrame();
				selectFrame.setVisible(true);
				table.add(selectFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("显示学生信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PintFrame pintFrame = new PintFrame();
				pintFrame.setVisible(true);
				table .add(pintFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("帮助");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("帮助");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpFrame helpFrame = new HelpFrame();
				helpFrame.setVisible(true);
				table.add(helpFrame);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_4 = new JMenu("退出");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem quititem = new JMenuItem("安全退出");
		quititem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "是否安全退出");
				if(showConfirmDialog == 0) {
					System.exit(0);
				}
				
			}
		});
		mnNewMenu_4.add(quititem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		//设置最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
