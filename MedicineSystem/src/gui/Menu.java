package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import dao.Impl.ClientDaoImpl;
import dao.Impl.MedicineDaoImpl;
import dao.Impl.RecordDaoImpl;
import dao.ClientDao;
import dao.MedicineDao;
import dao.RecordDao;

public class Menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8599004191587502110L;
	private JMenuItem jmiAddClient, jmiDelClient, jmiSeaClient, jmiAddMedicine, jmiDelMedicine, jmiSeaMedicine,
			jmiShowMedicine, jmiEditMedicine, jmiEnter, jmiOut, jmiShow;
	private ClientDao clientDao;
	private MedicineDao medicineDao;
	private RecordDao recordDao;

	public Menu() {
		
		  
	
		  
		 

		clientDao = new ClientDaoImpl();
		medicineDao = new MedicineDaoImpl();
		recordDao = new RecordDaoImpl();

		jmiAddClient = new JMenuItem("添加客户");
		jmiDelClient = new JMenuItem("删除客户");
		jmiSeaClient = new JMenuItem("查询客户");

		jmiAddMedicine = new JMenuItem("增加药品");
		jmiDelMedicine = new JMenuItem("删除药品");
		jmiEditMedicine = new JMenuItem("修改药品信息");
		jmiSeaMedicine = new JMenuItem("搜索药品");
		jmiShowMedicine = new JMenuItem("显示全部");

		jmiEnter = new JMenuItem("添加记录");
		jmiOut = new JMenuItem("删除记录");
		jmiShow = new JMenuItem("显示记录");

		this.setTitle("药品进销存管理系统");

	}

	public void createMenuBar() {
		JMenuBar menubar = new JMenuBar();

		JMenu jClient = new JMenu("客户管理");
		JMenu jMedicine = new JMenu("药品管理");
		JMenu jStock = new JMenu("库存管理");

		menubar.add(jClient);
		menubar.add(jMedicine);
		menubar.add(jStock);

		jClient.add(jmiAddClient);
		jClient.add(jmiDelClient);
		jClient.add(jmiSeaClient);

		jMedicine.add(jmiAddMedicine);
		jMedicine.add(jmiDelMedicine);
		jMedicine.add(jmiEditMedicine);
		jMedicine.add(jmiSeaMedicine);
		jMedicine.add(jmiShowMedicine);

		jStock.add(jmiEnter);
		jStock.add(jmiOut);
		jStock.add(jmiShow);

		this.setJMenuBar(menubar);
	}

	public void init() {
		createMenuBar();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 400));
		this.add(panel, BorderLayout.CENTER);
	}

	public void showMe() {
		init();
		this.setBounds(300, 200, 800, 400);
		this.pack();
		this.setVisible(true);
		this.addEventHandler();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void addEventHandler() {
		jmiAddClient.addActionListener(new AddClientHandler());
		jmiDelClient.addActionListener(new DelClientHandler());
		jmiSeaClient.addActionListener(new SeaClientHandler());

		jmiAddMedicine.addActionListener(new AddMedicineHandler());
		jmiDelMedicine.addActionListener(new DelMedicineHandler());
		jmiEditMedicine.addActionListener(new EditMedicineHandler());
		jmiSeaMedicine.addActionListener(new SeaMedicineHandler());
		jmiShowMedicine.addActionListener(new ShowMedicineHandler());

		jmiEnter.addActionListener(new AddStockHandler());
		jmiOut.addActionListener(new DelStockHandler());
		jmiShow.addActionListener(new ShowStockHandler());

	}

	public class AddClientHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new AddClientDialog(Menu.this, "添加客户", clientDao).showMe(Menu.this);
		}
	}

	public class DelClientHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new DelClientDialog(Menu.this, "删除客户", clientDao).showMe(Menu.this);
		}
	}

	public class SeaClientHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // TODO 自动生成的方法存根 new
			new SeaClientFrame("查询客户", clientDao).showMe();
		}
	}

	private class AddMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new AddMedicineDialog().showMe();
		}
	}

	private class DelMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new DelMedicineDialog(Menu.this, "删除药品", medicineDao).showMe(Menu.this);
		}
	}

	private class EditMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			// new ModifyMedicineDialog(Menu.this,"查询需修改信息的客户",
			// medicineDao).showMe(Menu.this);
			new ModifyMedicineFrame(medicineDao);
		}
	}

	private class SeaMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new SeaMedicineFrame("搜索药品", medicineDao).showMe();
		}
	}

	private class ShowMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new ShowMedicineFrame("药品表", medicineDao).showMe();
		}
	}

	private class AddStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new AddRecordFrame();

		}
	}

	private class DelStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new DelRecordFrame("删除记录", recordDao).showMe();
		}
	}

	private class ShowStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new ShowRecordFrame("库存表", recordDao).showMe();
		}
	}
}
