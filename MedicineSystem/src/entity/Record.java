package entity;

public class Record {
	private String medId;//ҩƷ���
	private int medCount;//����
	private String medTime;//ʱ��
	private String way;//��ʽ
	public Record(String medId, int medCount, String medTime, String way) {
		super();
		this.medId = medId;
		this.medCount = medCount;
		this.medTime = medTime;
		this.way = way;
	}
	
	public Record() {
		// TODO �Զ����ɵĹ��캯�����
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
