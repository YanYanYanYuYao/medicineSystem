package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connect.GetConnection;
import dao.RecordDao;
import entity.Record;

public class ShowRecordFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1611421136529651126L;
	private RecordDao recordDao;
	private GetConnection conn;
	private JTable recordTable;
	private JPanel pCenter;
	private List<Record> recordList;
	private JButton jbtDelRecord;

	public ShowRecordFrame(String str, RecordDao recordDao) {
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
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void createTable() {
		String[] tableName = { "药品编号", "药品数量", "时间", "方式" };
		Object[][] data = null;
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

		recordTable = new JTable(data, tableName);
		recordTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane scrollPane = new JScrollPane(recordTable);
		ShowRecordFrame.this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		jbtDelRecord = new JButton("删除");
		ShowRecordFrame.this.add(jbtDelRecord,BorderLayout.SOUTH);

		ShowRecordFrame.this.setVisible(true);
	}
}
