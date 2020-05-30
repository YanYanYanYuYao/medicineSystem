package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RecordDao;
import entity.Record;

public class RecordDaoImpl implements RecordDao{
	private List<Record> recordList;
	@Override
	public void addRecord(Connection conn, Record record) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "insert into JCKB values(?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, record.getMedId());
		state.setInt(2, record.getMedCount());
		state.setString(3, record.getMedTime());
		state.setString(4, record.getWay());
		state.executeUpdate();
		
	}

	@Override
	public List<Record> showRecord(Connection conn) throws SQLException {
		// TODO 自动生成的方法存根
		
		
		recordList = new ArrayList<Record>();
		String sql = "select * from JCKB";
		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()) {
			String id = rs.getString("药品编号");
			int count = rs.getInt("数量");
			String time=rs.getString("时间");
			String way = rs.getString("方式");
			Record record = new Record(id,count,time,way);
			recordList.add(record);
		}
	return recordList;
		
	}

	@Override
	public void delRecord(Connection conn, String id,String time) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "delete from JCKB where 药品编号=? and 时间=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, id);
		state.setString(2, time);
		state.executeUpdate();
	}

}
