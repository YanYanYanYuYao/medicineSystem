package entity;

public class Client {
	private String client_id;
	private String client_name;
	private String client_phone;
	
	public Client(String id,String name,String phone) {
		// TODO 自动生成的构造函数存根
		this.client_id = id;
		this.client_name = name;
		this.client_phone = phone;
	}
	public Client() {
		// TODO 自动生成的构造函数存根
	}
	
	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}
	
	
}
