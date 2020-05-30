package dao;


import java.sql.*;
import java.util.List;

import entity.Medicine;

public interface MedicineDao {
	public void addMedicine(Connection con,Medicine medicine) throws SQLException;
	public void delMedicine(Connection con,String id) throws SQLException;
	public void modifyMedicine(Connection con,Medicine medicine) throws SQLException;
	public ResultSet queryMedicine(Connection con,String id) throws SQLException;
	public List<Medicine> showMedicine(Connection conn) throws SQLException;

}
