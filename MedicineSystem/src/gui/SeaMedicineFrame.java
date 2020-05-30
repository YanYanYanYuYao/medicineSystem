package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import dao.MedicineDao;
import connect.GetConnection;

public class SeaMedicineFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 682135341555818922L;
	private JLabel labelName = new JLabel("ҩƷ����:");
	private JTextField medicineName = new JTextField(20);
	
	private JButton jbtSea = new JButton("��ѯҩƷ");
	private MedicineDao medicineDao;
	private GetConnection conn;
	private JTable medicineTable ;
	private JPanel pNorth,pCenter;
	
	public SeaMedicineFrame(String str,MedicineDao medicineDao) {
		super(str);
		this.medicineDao = medicineDao;
		conn = new GetConnection();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	public void init() {
		pNorth = new JPanel();
		pCenter =new JPanel();
		pNorth.add(labelName,FlowLayout.LEFT);
		pNorth.add(medicineName,FlowLayout.CENTER);
		pNorth.add(jbtSea,FlowLayout.RIGHT);
		getContentPane().add(pNorth,BorderLayout.NORTH);
		getContentPane().add(pCenter,BorderLayout.CENTER);
	}
	public void showMe() {
		init();
		this.setBounds(430,320,550,300);
		//this.pack();
		this.setVisible(true);
		this.addEventHandler();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void addEventHandler() {
		jbtSea.addActionListener(new SeaMedicineHandler());
	}
	private class SeaMedicineHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			ResultSet rs;
			String name = medicineName.getText();
			Object[][] data = null;
			String[] tableName = {"ҩƷ���","ҩƷ����","��������","��������","�۸�"};
			try {
				rs=medicineDao.queryMedicine(conn.getConn(),name);
				rs.last();
				int rows = rs.getRow();
				ResultSetMetaData meta = rs.getMetaData();
				int colcount = meta.getColumnCount();
				rs.beforeFirst();
				int k=0;
				data= new Object[rows][colcount];
				while(rs.next()) {
					//Object[] row =new Object[colcount];
					for(int i=1;i<=colcount;i++) {
						data[k][i-1] = rs.getObject(i);
					}		
					k++;
				}
			}catch(Exception a) {             
				a.printStackTrace();
			}
			
			
			  medicineTable = new JTable(data,tableName);
			  medicineTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
			  JScrollPane scrollPane = new JScrollPane(medicineTable);
			  SeaMedicineFrame.this.getContentPane().add(scrollPane, BorderLayout.CENTER);
			    // �ٽ������������ӵ��м�������
			    //f.setTitle("�����Դ���");
			    
			  SeaMedicineFrame.this.getContentPane().validate();
			   // SeaClientFrame.this.pack();
			  SeaMedicineFrame.this.setVisible(true);
	
			 
		}
	}
}
