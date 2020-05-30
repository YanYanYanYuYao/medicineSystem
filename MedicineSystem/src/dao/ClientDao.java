package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Client;

public interface ClientDao {
	public ResultSet queryClient(Connection conn,String id) throws SQLException;//���ݱ�Ų�ѯ�û�
	public void addClient(Connection conn,Client client) throws SQLException;//����û�
	public void delClient(Connection conn,Client client) throws SQLException;
}
