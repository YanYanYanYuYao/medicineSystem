package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Client;

public interface ClientDao {
	public ResultSet queryClient(Connection conn,String id) throws SQLException;//根据编号查询用户
	public void addClient(Connection conn,Client client) throws SQLException;//添加用户
	public void delClient(Connection conn,Client client) throws SQLException;
}
