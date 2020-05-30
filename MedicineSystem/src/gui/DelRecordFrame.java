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
	private String[] tableName = { "药品编号", "药品数量", "时间", "方式" };
	private Object[][] data = null;

	public DelRecordFrame(String str, RecordDao recordDao) {
		// TODO 自动生成的构造函数存根
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

	public void createTableData() {//更新表里数据
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
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
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

		jbtDelRecord = new JButton("删除");
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
			// TODO 自动生成的方法存根
			try {
				recordDao.delRecord(conn.getConn(), id, time);
				JOptionPane.showMessageDialog(DelRecordFrame.this, "记录删除成功!");
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				JOptionPane.showMessageDialog(DelRecordFrame.this, "记录删除失败!");

				e1.printStackTrace();
			}
			DefaultTableModel dtm=(DefaultTableModel)recordTable.getModel();
			dtm.setRowCount(0);//清空表格
			createTableData();
			recordTable.setModel(new DefaultTableModel(data,tableName));
		}
	}

	private class GetDataHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			int index = recordTable.getSelectedRow();
			id = recordTable.getValueAt(index, 0).toString();
			time = recordTable.getValueAt(index, 2).toString();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根

		}
	}
}
