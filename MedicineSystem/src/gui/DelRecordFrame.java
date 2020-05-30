package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.GetConnection;
import dao.RecordDao;
import entity.Record;

public class DelRecordFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1345148668305490150L;
	private RecordDao recordDao;
	private GetConnection conn;
	private JTable recordTable;
	private JPanel pCenter;
	private List<Record> recordList;
	private JButton jbtDelRecord;
	private String id;
	private String time;
	private DefaultTableModel model;
	private String[] tableName = { "ҩƷ���", "ҩƷ����", "ʱ��", "��ʽ" };
	private Object[][] data = null;

	public DelRecordFrame(String str, RecordDao recordDao) {
		// TODO �Զ����ɵĹ��캯�����
		super(str);
		this.recordDao = recordDao;
		conn = new GetConnection();

	}

	public void init() {
		pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
	}

	public void showMe() {
		init();
		this.setBounds(430, 320, 550, 300);
		this.createTable();
		this.addEventHandler();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void createTableData() {//���±�������
		try {
			recordList = recordDao.showRecord(conn.getConn());
			data = new Object[recordList.size()][5];
			int i = 0;
			for (Record m : recordList) {
				data[i][0] = m.getMedId();
				data[i][1] = m.getMedCount();
				data[i][2] = m.getMedTime();
				data[i][3] = m.getWay();
				i++;
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
	}

	public void createTable() {
		try {
			recordList = recordDao.showRecord(conn.getConn());
			data = new Object[recordList.size()][4];
			int i = 0;
			for (Record m : recordList) {
				data[i][0] = m.getMedId();
				data[i][1] = m.getMedCount();
				data[i][2] = m.getMedTime();
				data[i][3] = m.getWay();
				i++;
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}

		model = new DefaultTableModel();
		recordTable = new JTable(model);
		recordTable.setModel(new DefaultTableModel(data, tableName));
		// recordTable = new JTable(data, tableName);
		recordTable.setRowSelectionAllowed(true);
		recordTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane scrollPane = new JScrollPane(recordTable);
		DelRecordFrame.this.getContentPane().add(scrollPane, BorderLayout.CENTER);

		jbtDelRecord = new JButton("ɾ��");
		DelRecordFrame.this.add(jbtDelRecord, BorderLayout.SOUTH);

		DelRecordFrame.this.setVisible(true);
	}

	public void addEventHandler() {
		jbtDelRecord.addActionListener(new DelRecordHandler());
		recordTable.addMouseListener(new GetDataHandler());
	}

	private class DelRecordHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			try {
				recordDao.delRecord(conn.getConn(), id, time);
				JOptionPane.showMessageDialog(DelRecordFrame.this, "��¼ɾ���ɹ�!");
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				JOptionPane.showMessageDialog(DelRecordFrame.this, "��¼ɾ��ʧ��!");

				e1.printStackTrace();
			}
			DefaultTableModel dtm=(DefaultTableModel)recordTable.getModel();
			dtm.setRowCount(0);//��ձ��
			createTableData();
			recordTable.setModel(new DefaultTableModel(data,tableName));
		}
	}

	private class GetDataHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			int index = recordTable.getSelectedRow();
			id = recordTable.getValueAt(index, 0).toString();
			time = recordTable.getValueAt(index, 2).toString();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �Զ����ɵķ������

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������

		}
	}
}
