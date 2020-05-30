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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
		
		recordList = new ArrayList<Record>();
		String sql = "select * from JCKB";
		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()) {
			String id = rs.getString("ҩƷ���");
			int count = rs.getInt("����");
			String time=rs.getString("ʱ��");
			String way = rs.getString("��ʽ");
			Record record = new Record(id,count,time,way);
			recordList.add(record);
		}
	return recordList;
		
	}

	@Override
	public void delRecord(Connection conn, String id,String time) throws SQLException {
		// TODO �Զ����ɵķ������
		String sql = "delete from JCKB where ҩƷ���=? and ʱ��=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, id);
		state.setString(2, time);
		state.executeUpdate();
	}

}
