package entity;

public class Medicine {
	private String medId;//ҩƷ���
	private String medName;//ҩƷ����
	private String medPlant;//��������
	private String medDate;//��������
	private int medPrice;//�۸�
	public Medicine(String medId,String medName,String medPlant,String medDate,int medPrice) {
		// TODO �Զ����ɵĹ��캯�����
		this.medId = medId;
		this.medName = medName;
		this.medPlant = medPlant;
		this.medDate = medDate;
		this.medPrice = medPrice;
	}
	public Medicine() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public String getMedId() {
		return medId;
	}
	public void setMedId(String medId) {
		this.medId = medId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedPlant() {
		return medPlant;
	}
	public void setMedPlant(String medPlant) {
		this.medPlant = medPlant;
	}
	public String getMedDate() {
		return medDate;
	}
	public void setMedDate(String medDate) {
		this.medDate = medDate;
	}
	public int getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(int medPrice) {
		this.medPrice = medPrice;
	}
	
}
