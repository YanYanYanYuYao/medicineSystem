package gui;



import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ClientDao;
import entity.Client;
import connect.GetConnection;



public class DelClientDialog extends JDialog{
	private JLabel labelId = new JLabel("客户编号:");
	private JTextField clientId = new JTextField(20);
	
	private JButton jbtDel = new JButton("删除客户");
	private ClientDao clientDao;
	private GetConnection conn;
	private int windowHeight = 140; // 窗口高度
	private int windowWidth = 300; // 窗口宽度
	
	public DelClientDialog(JFrame parent,String msg,ClientDao clientDao) {
		// TODO 自动生成的构造函数存根
		super(parent,msg,true);
		this.clientDao = clientDao;
		conn = new GetConnection();
	}
	
	public void showMe(JFrame parent) {
		Panel pCenter = new Panel();
		Panel pSouth = new Panel();
		pSouth.add(jbtDel);

		pCenter.add(labelId);
		pCenter.add(clientId);

		pCenter.add(pSouth);
		this.add(pCenter);

		jbtDel.addActionListener(new ButtonDelHandler());

		// 计算对话框的显示位置
		setPosition(parent);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	private void setPosition(JFrame parent) {
		// 计算对话框的显示位置
		int parentX = parent.getX();
		int parentY = parent.getY();
		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();
		int dialogX = parentX + (parentWidth - windowWidth) / 2;
		int dialogY = parentY + (parentHeight - windowHeight) / 2 ;
		this.setBounds(dialogX, dialogY, windowWidth, windowHeight);
	}
	
	private class ButtonDelHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			Client client = new Client();
			client.setClient_id(clientId.getText());
			try {
				clientDao.delClient(conn.getConn(),client);
				JOptionPane.showMessageDialog(getParent(), "删除成功");
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				JOptionPane.showMessageDialog(getParent(), "删除失败");
				e1.printStackTrace();
			}
		}
	}
}
