package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entity.Record;

public interface RecordDao {
	public void addRecord(Connection conn,Record record) throws SQLException;
	public void delRecord(Connection conn,String id,String time) throws SQLException;
	//public void delMedicine(Connection con,Medicine medicine);
	//public void modifyMedicine(Connection con,Medicine medicine);
	public List<Record> showRecord(Connection conn) throws SQLException;
}
