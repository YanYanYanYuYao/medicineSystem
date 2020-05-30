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

		jmiAddClient = new JMenuItem("��ӿͻ�");
		jmiDelClient = new JMenuItem("ɾ���ͻ�");
		jmiSeaClient = new JMenuItem("��ѯ�ͻ�");

		jmiAddMedicine = new JMenuItem("����ҩƷ");
		jmiDelMedicine = new JMenuItem("ɾ��ҩƷ");
		jmiEditMedicine = new JMenuItem("�޸�ҩƷ��Ϣ");
		jmiSeaMedicine = new JMenuItem("����ҩƷ");
		jmiShowMedicine = new JMenuItem("��ʾȫ��");

		jmiEnter = new JMenuItem("��Ӽ�¼");
		jmiOut = new JMenuItem("ɾ����¼");
		jmiShow = new JMenuItem("��ʾ��¼");

		this.setTitle("ҩƷ���������ϵͳ");

	}

	public void createMenuBar() {
		JMenuBar menubar = new JMenuBar();

		JMenu jClient = new JMenu("�ͻ�����");
		JMenu jMedicine = new JMenu("ҩƷ����");
		JMenu jStock = new JMenu("������");

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
			// TODO �Զ����ɵķ������
			new AddClientDialog(Menu.this, "��ӿͻ�", clientDao).showMe(Menu.this);
		}
	}

	public class DelClientHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new DelClientDialog(Menu.this, "ɾ���ͻ�", clientDao).showMe(Menu.this);
		}
	}

	public class SeaClientHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // TODO �Զ����ɵķ������ new
			new SeaClientFrame("��ѯ�ͻ�", clientDao).showMe();
		}
	}

	private class AddMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new AddMedicineDialog().showMe();
		}
	}

	private class DelMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new DelMedicineDialog(Menu.this, "ɾ��ҩƷ", medicineDao).showMe(Menu.this);
		}
	}

	private class EditMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			// new ModifyMedicineDialog(Menu.this,"��ѯ���޸���Ϣ�Ŀͻ�",
			// medicineDao).showMe(Menu.this);
			new ModifyMedicineFrame(medicineDao);
		}
	}

	private class SeaMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new SeaMedicineFrame("����ҩƷ", medicineDao).showMe();
		}
	}

	private class ShowMedicineHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new ShowMedicineFrame("ҩƷ��", medicineDao).showMe();
		}
	}

	private class AddStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new AddRecordFrame();

		}
	}

	private class DelStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new DelRecordFrame("ɾ����¼", recordDao).showMe();
		}
	}

	private class ShowStockHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			new ShowRecordFrame("����", recordDao).showMe();
		}
	}
}
