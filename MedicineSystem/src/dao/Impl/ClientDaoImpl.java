package dao.Impl;

import java.sql.*;

import dao.ClientDao;
import entity.Client;


public class ClientDaoImpl implements ClientDao{

	@Override
	public ResultSet queryClient(Connection conn, String phone) throws SQLException {
		//ResultSet resultClient = null;
		String sql = "select * from KHB where ��ϵ�绰=?";
		PreparedStatement state = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		state.setString(1, phone);
		return state.executeQuery();
	}

	@Override
	public void addClient(Connection conn, Client client) throws SQLException {
		String sql = "insert into KHB values(?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, client.getClient_id());
		state.setString(2, client.getClient_name());
		state.setString(3, client.getClient_phone());
		state.executeUpdate();
	}

	@Override
	public void delClient(Connection conn, Client client) throws SQLException {
		// TODO �Զ����ɵķ������
		String sql = "delete from KHB where �ͻ����=?";
		PreparedStatement state = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		state.setString(1,client.getClient_id());
		state.executeUpdate();
	}

}
