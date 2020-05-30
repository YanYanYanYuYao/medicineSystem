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

import dao.MedicineDao;
import connect.GetConnection;

public class DelMedicineDialog extends JDialog{
	private JLabel labelId = new JLabel("ҩƷ���");
	private JTextField medicineId = new JTextField(20);
	
	private JButton jbtDel = new JButton("ɾ��ҩƷ");
	private MedicineDao medicineDao;
	private GetConnection conn;
	private int windowHeight = 140; // ���ڸ߶�
	private int windowWidth = 300; // ���ڿ��
	
	public DelMedicineDialog(JFrame parent,String msg,MedicineDao medicineDao) {
		// TODO �Զ����ɵĹ��캯�����
		super(parent,msg,true);
		this.medicineDao = medicineDao;
		conn = new GetConnection();
	}
	
	public void showMe(JFrame parent) {
		Panel pCenter = new Panel();
		Panel pSouth = new Panel();
		pSouth.add(jbtDel);

		pCenter.add(labelId);
		pCenter.add(medicineId);

		pCenter.add(pSouth);
		this.add(pCenter);

		jbtDel.addActionListener(new ButtonDelHandler());

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
		int dialogY = parentY + (parentHeight - windowHeight) / 2 ;
		this.setBounds(dialogX, dialogY, windowWidth, windowHeight);
	}
	
	private class ButtonDelHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			String id = medicineId.getText();
			try {
				medicineDao.delMedicine(conn.getConn(), id);
				JOptionPane.showMessageDialog(DelMedicineDialog.this , "ɾ���ɹ���");
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				JOptionPane.showMessageDialog(DelMedicineDialog.this , "ɾ��ʧ�ܣ�");

				e1.printStackTrace();
			}
		}
	}
}
