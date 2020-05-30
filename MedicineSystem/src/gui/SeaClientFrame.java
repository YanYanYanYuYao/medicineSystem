package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.ClientDao;
import connect.GetConnection;


public class SeaClientFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5421941889175391760L;
	private JLabel labelId = new JLabel("�ͻ��绰:");
	private JTextField clientPhone = new JTextField(20);
	
	private JButton jbtSea = new JButton("��ѯ�ͻ�");
	private ClientDao clientDao;
	private GetConnection conn;
	private JTable clientTable ;
	private JPanel pNorth,pCenter;
	
	public SeaClientFrame(String str,ClientDao clientDao) {
		super(str);
		this.clientDao = clientDao;
		conn = new GetConnection();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	public void init() {
		pNorth = new JPanel();
		pCenter =new JPanel();
		pNorth.add(labelId,FlowLayout.LEFT);
		pNorth.add(clientPhone,FlowLayout.CENTER);
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
		jbtSea.addActionListener(new SeaClientHandler());
	}
	private class SeaClientHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			//pCenter.add(labelId,BorderLayout.CENTER);
			//pCenter.validate();
			//SeaClientFrame.this.add(pCenter,BorderLayout.CENTER);
			//this.vi
			
			//DefaultTableModel tbmodel=new DefaultTableModel();
			ResultSet rs;
			String phone = clientPhone.getText();
			Object[][] data = null;
			String[] tableName = {"�ͻ����","�ͻ�����","��ϵ�绰"};
			try {
				rs=clientDao.queryClient(conn.getConn(),phone);
				rs.last();
				int rows = rs.getRow();
				ResultSetMetaData meta=rs.getMetaData();
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
			
			
			  clientTable = new JTable(data,tableName);
			  clientTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
			  JScrollPane scrollPane = new JScrollPane(clientTable);
			  SeaClientFrame.this.getContentPane().add(scrollPane, BorderLayout.CENTER);
			    // �ٽ������������ӵ��м�������
			    //f.setTitle("�����Դ���");
			    
			  SeaClientFrame.this.getContentPane().validate();
			   // SeaClientFrame.this.pack();
			  SeaClientFrame.this.setVisible(true);
	
			 
		}
	}
}
