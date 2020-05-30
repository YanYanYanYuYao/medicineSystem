package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.GetConnection;
import dao.MedicineDao;
import entity.Medicine;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ModifyMedicineFrame extends JFrame {
	private static final long serialVersionUID = -8819104334702102763L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	private JTextField textPlant;
	private JTextField textField;
	private JTextField textField_1;
	private MedicineDao medicineDao;
	private GetConnection conn;
	private JTable medTable;
	private JButton btnNewButton;
	private GroupLayout gl_contentPane;
	private List<Medicine> medicineList;
	private DefaultTableModel model;
	String[] tableName = { "药品编号", "药品名称", "生产厂家", "生产日期", "价格" };
	Object[][] data = null;

	public ModifyMedicineFrame(MedicineDao medicineDao) {
		
		//super(str);
		this.medicineDao = medicineDao;
		conn = new GetConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 820, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ModifyMedicineFrame.this.getContentPane().add(contentPane,BorderLayout.NORTH);
		
		JLabel medicineName = new JLabel("\u836F\u54C1\u540D\u79F0:");
		
		JLabel medicineId = new JLabel("\u836F\u54C1\u7F16\u53F7:");
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setColumns(20);
		
		textName = new JTextField();
		textName.setColumns(20);
		
		JLabel medicinePlant = new JLabel("\u751F\u4EA7\u5382\u5BB6:");
		
		textPlant = new JTextField();
		textPlant.setColumns(20);
		
		JLabel medicineDate = new JLabel("\u751F\u4EA7\u65E5\u671F:");
		
		textField = new JTextField();
		textField.setColumns(20);
		
		JLabel medicinePrice = new JLabel("\u4EF7\u683C:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		
		model = new DefaultTableModel();
		medTable = new JTable(model);	
		this.createTable();
		medTable.setModel(new DefaultTableModel(data,tableName));
		//medTable = new JTable(data, tableName);
		medTable.setRowSelectionAllowed(true);
		medTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
		JScrollPane scrollPane = new JScrollPane(medTable);
		
		
		btnNewButton = new JButton("\u4FEE\u6539");
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(medicineId, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(medicineDate, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField)))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(medicineName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textName, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(medicinePlant, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(medicinePrice, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPlant, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(medicineId)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(medicineName)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(medicinePlant)
						.addComponent(textPlant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(medicineDate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(medicinePrice)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(80)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.addEventHandler();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void addEventHandler() {
		medTable.addMouseListener(new GetDataHandler());
		btnNewButton.addActionListener(new ModifyDataHandler());
	}
	
	private class ModifyDataHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			Medicine medicine = new Medicine(textId.getText(), textName.getText(), textPlant.getText(), textField.getText(), Integer.parseInt(textField_1.getText()));
			try {
				medicineDao.modifyMedicine(conn.getConn(),medicine);
				JOptionPane.showMessageDialog(ModifyMedicineFrame.this, "修改成功");
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			DefaultTableModel dtm=(DefaultTableModel)medTable.getModel();
			dtm.setRowCount(0);//清空表格
			createTable();
			medTable.setModel(new DefaultTableModel(data,tableName));
			
		}
	}
	private class GetDataHandler implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
			int index = medTable.getSelectedRow();
			textId.setText(medTable.getValueAt(index, 0).toString());
			textName.setText(medTable.getValueAt(index,1).toString());
			textPlant.setText(medTable.getValueAt(index, 2).toString());
			textField.setText(medTable.getValueAt(index, 3).toString());
			textField_1.setText(medTable.getValueAt(index, 4).toString());
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
	
	
	public void createTable() {
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
		ModifyMedicineFrame.this.setVisible(true);

	}
}
