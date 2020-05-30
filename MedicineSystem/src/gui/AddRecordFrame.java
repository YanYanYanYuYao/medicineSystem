package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.GetConnection;
import dao.RecordDao;
import dao.Impl.RecordDaoImpl;
import entity.Record;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class AddRecordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField medicineName;
	private JTextField medCount;
	private JRadioButton RadioButtonOut;
	private JRadioButton RadioButtonIn;
	private JButton btnNewButton;
	private RecordDao recordDao;
	private GetConnection conn;
	private ButtonGroup btnGroup;
	private String way;
	



	/**
	 * Create the frame.
	 */
	public AddRecordFrame() {
		recordDao = new RecordDaoImpl(); 
		conn = new GetConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 427, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7:");
		
		medicineName = new JTextField();
		medicineName.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u6570\u91CF:");
		
		medCount = new JTextField();
		medCount.setColumns(10);
		
		RadioButtonIn = new JRadioButton("\u5165\u5E93");
		
		JLabel lblNewLabel_2 = new JLabel("\u64CD\u4F5C\u65B9\u5F0F:");
		
		RadioButtonOut = new JRadioButton("\u51FA\u5E93");
		btnGroup = new ButtonGroup();
		btnGroup.add(RadioButtonIn);
		btnGroup.add(RadioButtonOut);
		
		RadioButtonIn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				way = "入库";
			}
		});
		RadioButtonOut.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				way = "出库";
			}
		});
		
		btnNewButton = new JButton("\u6DFB\u52A0\u8BB0\u5F55");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(RadioButtonIn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(RadioButtonOut, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(medicineName, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(medCount)))
					.addContainerGap(130, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(medicineName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(medCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(RadioButtonOut)
						.addComponent(RadioButtonIn))
					.addGap(61)
					.addComponent(btnNewButton)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		addEventHandler();
	}
	public void addEventHandler() {
		btnNewButton.addActionListener(new AddRecordHandler());
	}
	private class AddRecordHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String id = medicineName.getText();
			String count = medCount.getText();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			String time = df.format(System.currentTimeMillis());
			//Record record = new Record(id,Integer.parseInt(count),time,way);
			Record record =new Record();
			record.setMedId(id);
			record.setMedCount(Integer.parseInt(count));
			record.setMedTime(time);
			record.setWay(way);
			System.out.println(id+" "+count+" "+time+" "+way);
			try {
				recordDao.addRecord(conn.getConn(),record);
				JOptionPane.showMessageDialog(AddRecordFrame.this, "记录添加成功!");
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			System.out.println(way);
		}
	}
}
