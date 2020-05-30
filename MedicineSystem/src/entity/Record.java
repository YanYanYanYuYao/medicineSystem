package entity;

public class Record {
	private String medId;//药品编号
	private int medCount;//数量
	private String medTime;//时间
	private String way;//方式
	public Record(String medId, int medCount, String medTime, String way) {
		super();
		this.medId = medId;
		this.medCount = medCount;
		this.medTime = medTime;
		this.way = way;
	}
	
	public Record() {
		// TODO 自动生成的构造函数存根
	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public int getMedCount() {
		return medCount;
	}

	public void setMedCount(int medCount) {
		this.medCount = medCount;
	}

	public String getMedTime() {
		return medTime;
	}

	public void setMedTime(String medTime) {
		this.medTime = medTime;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
	
	
}
