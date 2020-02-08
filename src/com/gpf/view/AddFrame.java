package com.gpf.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gpf.bean.User;
import com.gpf.dao.UserDao_Imp;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddFrame extends JInternalFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField IdName;
	private JTextField uname;
	private JTextField Gender;
	private JTextField Age;
	private JTextField Major;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPasswordField password;

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
//					AddFrame frame = new AddFrame();
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
	public AddFrame()
	{
		setClosable(true);
		setIconifiable(true);
		setTitle("学生信息添加");
		setBounds(100, 100, 522, 380);
		
		JLabel lblNewLabel = new JLabel("学号:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("性别:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("年龄:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("专业:");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		IdName = new JTextField();
		IdName.setColumns(10);
		
		uname = new JTextField();
		uname.setColumns(10);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		
		Age = new JTextField();
		Age.setColumns(10);
		
		Major = new JTextField();
		Major.setColumns(10);
		
		btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPerformed(e);
			}

		});
		
		btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uname.setText("");
				IdName.setText("");
				Gender.setText("");
				Age.setText("");
				Major.setText("");
				password.setText("");
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("密码:");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		password = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(152)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(password)
								.addComponent(Major)
								.addComponent(Age)
								.addComponent(Gender)
								.addComponent(uname)
								.addComponent(IdName, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(IdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(uname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(Major, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 为提交按钮添加事件
	 */
	private void InsertPerformed(ActionEvent e)
	{
		int idname=Integer.parseInt(IdName.getText());
		String name=uname.getText();
		String gender=Gender.getText();
		int age=Integer.parseInt(Age.getText());
		String major=Major.getText();
		String upass=password.getText();
		User user = new User(idname,name,gender,age,major,upass);
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		boolean flog = userDao_Imp.insert(user);
		if(flog) {
			JOptionPane.showMessageDialog(null,"添加成功");
			uname.setText("");
			IdName.setText("");
			Gender.setText("");
			Age.setText("");
			Major.setText("");
			password.setText("");
			
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
			uname.setText("");
			IdName.setText("");
			Gender.setText("");
			Age.setText("");
			Major.setText("");
			password.setText("");
		}
	}
}
