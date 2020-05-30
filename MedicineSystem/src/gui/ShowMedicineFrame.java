package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dao.MedicineDao;
import entity.Medicine;
import connect.GetConnection;

public class ShowMedicineFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7162271656175982481L;
	private MedicineDao medicineDao;
	private GetConnection conn;
	private JTable medTable;
	private JPanel pCenter;
	private List<Medicine> medicineList;

	public ShowMedicineFrame(String str, MedicineDao medicineDao) {
		// TODO 自动生成的构造函数存根
		super(str);
		this.medicineDao = medicineDao;
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
		String[] tableName = { "药品编号", "药品名称", "生产厂家", "生产日期", "价格" };
		Object[][] data = null;
		try {
			medicineList = medicineDao.showMedicine(conn.getConn());
			data = new Object[medicineList.size()][5];
			int i = 0;
			for (Medicine m : medicineList) {
				data[i][0] = m.getMedId();
				data[i][1] = m.getMedName();
				data[i][2] = m.getMedPlant();
				data[i][3] = m.getMedDate();
				data[i][4] = m.getMedPrice();
				i++;
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		medTable = new JTable(data, tableName);
		medTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane scrollPane = new JScrollPane(medTable);
		ShowMedicineFrame.this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		ShowMedicineFrame.this.setVisible(true);

	}
}
