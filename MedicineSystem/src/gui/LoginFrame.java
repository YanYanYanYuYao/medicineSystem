package gui;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import connect.GetConnection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7987655615381862682L;
	private JTextField textName;
	private JPasswordField passwordField;
	private JButton jbtLogin;
	private GetConnection conn = new GetConnection();
	public LoginFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 555, 420);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5, 5,
		 * 5)); contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */
		
		
		getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u767B\u5F55");
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/ico/medicines_72px_1213445_easyicon.net.png")));
		
		textName = new JTextField();
		textName.setColumns(20);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");
		
		 jbtLogin = new JButton("\u767B\u5F55");
		jbtLogin.setForeground(SystemColor.desktop);
		jbtLogin.setBackground(SystemColor.inactiveCaption);
		
		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addGap(182))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(238)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(267, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(229)
					.addComponent(jbtLogin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(263, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(jbtLogin, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
		);
		getContentPane().setLayout(groupLayout);
		this.addEventHandler();
	}
	

	
	public void addEventHandler() {
		jbtLogin.addActionListener(new LoginHandler());
	}
	
	private class LoginHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String name = textName.getText();
			String password = passwordField.getText();
			//PreparedStatement state = conn.getConn().prepareStatement(sql)
			
			if(name.equals("admin")&&password.equals("123456")) {
				System.out.println("ch");
				LoginFrame.this.setVisible(false);
				new Menu().showMe();
				//System.exit(0);
				
			}
			else if(!name.equals("admin")){
				JOptionPane.showMessageDialog(LoginFrame.this, "用户名错误！");
			}else if(!password.equals("123456")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "密码错误！");

			}
		}
	}
	
	public  void showMe() {
				try {
					//LoginFrame frame = new LoginFrame();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	
}
