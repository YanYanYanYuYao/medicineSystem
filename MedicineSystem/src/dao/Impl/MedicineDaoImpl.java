package dao.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.MedicineDao;
import entity.Medicine;

public class MedicineDaoImpl implements MedicineDao{
	private List<Medicine> medicineList;
	@Override
	public void addMedicine(Connection conn, Medicine medicine) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "insert into YPB values(?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, medicine.getMedId());
		state.setString(2, medicine.getMedName());
		state.setString(3, medicine.getMedPlant());
		state.setString(4, medicine.getMedDate());
		state.setInt(5, medicine.getMedPrice());
		state.executeUpdate();
	}

	@Override
	public void delMedicine(Connection conn,String id) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "delete from YPB where 药品编号=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, id);
		state.executeUpdate();
	}

	@Override
	public void modifyMedicine(Connection conn, Medicine medicine) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "update YPB set 药品名称=?,生产厂家=?,生产日期=?,价格=? where 药品编号=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, medicine.getMedName());
		state.setString(2,medicine.getMedPlant());
		state.setString(3, medicine.getMedDate());
		state.setInt(4, medicine.getMedPrice());
		state.setString(5, medicine.getMedId());
		state.executeUpdate();

	}

	@Override
	public ResultSet queryMedicine(Connection conn, String name) throws SQLException{
		// TODO 自动生成的方法存根
		String sql = "select * from YPB where 药品名称 like ?";
		PreparedStatement state = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		state.setString(1,"%"+name+"%");
		return state.executeQuery();
		
	
	}

	@Override
	public List<Medicine> showMedicine(Connection conn) throws SQLException {
		// TODO 自动生成的方法存根
		medicineList = new ArrayList<Medicine>();
		String sql = "select * from YPB";
		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()) {
			String id = rs.getString("药品编号");
			String name = rs.getString("药品名称");
			String plant=rs.getString("生产厂家");
			String date = rs.getString("生产日期");
			int price = rs.getInt("价格");
			Medicine med = new Medicine(id,name,plant,date,price);
			medicineList.add(med);
		}
	return medicineList;
	}

}
