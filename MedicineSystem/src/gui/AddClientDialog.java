package gui;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AddClientDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1713884083179034087L;
	private JLabel labelId = new JLabel("  �ͻ����:");
	private JTextField clientId = new JTextField(20);

	private JLabel labelName = new JLabel("  �ͻ�����:");
	private JTextField clientName = new JTextField(20);

	private JLabel labelPhone = new JLabel("  �ͻ��绰:");
	private JTextField clientPhone = new JTextField(20);

	private JButton buttonAdd = new JButton("��ӿͻ�");

	private int windowHeight = 160; // ���ڸ߶�
	private int windowWidth = 300; // ���ڿ��
	private ClientDao clientDao;
	private GetConnection conn;

	public AddClientDialog(JFrame parent, String msg, ClientDao clientDao) {
		super(parent, msg, true);
		this.clientDao = clientDao;
		conn = new GetConnection();
	}

	public void showMe(JFrame parent) {
		Panel pCenter = new Panel();
		Panel pSouth = new Panel();
		pSouth.add(buttonAdd);

		pCenter.add(labelId);
		pCenter.add(clientId);

		pCenter.add(labelName);
		pCenter.add(clientName);

		pCenter.add(labelPhone);
		pCenter.add(clientPhone);
		pCenter.add(pSouth);
		this.add(pCenter);

		buttonAdd.addActionListener(new ButtonAddHandler());

		// ����Ի������ʾλ��
		setPosition(parent);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private void setPosition(JFrame parent) {
		// ����Ի������ʾλ��
		int parentX = parent.getX();
		int parentY = parent.getY();
		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();
		int dialogX = parentX + (parentWidth - windowWidth) / 2;
		int dialogY = parentY + (parentHeight - windowHeight) / 2 + 40;
		this.setBounds(dialogX, dialogY, windowWidth, windowHeight);
	}

	private class ButtonAddHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			Client client = new Client();
			client.setClient_id(clientId.getText());
			client.setClient_name(clientName.getText());
			client.setClient_phone(clientPhone.getText());
			
			try {
				clientDao.addClient(conn.getConn(), client);
				JOptionPane.showMessageDialog(AddClientDialog.this, "��ӳɹ�!");
			} catch (SQLException e2) {
				// TODO �Զ����ɵ� catch ��
				e2.printStackTrace();
			}
			
			
			//String sql = "insert into KHB values(?,?,?)";
			/*
			 * try { PreparedStatement state = conn.getConn().prepareStatement(sql);
			 * state.setString(1, clientId.getText()); state.setString(2,
			 * clientName.getText()); state.setString(3, clientPhone.getText());
			 * state.executeUpdate(); JOptionPane.showMessageDialog(getParent(), "��ӳɹ�"); }
			 * catch (SQLException e1) { // TODO �Զ����ɵ� catch ��
			 * JOptionPane.showMessageDialog(getParent(), "�ͻ����ʧ��"); e1.printStackTrace(); }
			 */

		}
	}
}
