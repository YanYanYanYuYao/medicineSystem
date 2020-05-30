package entity;

public class Medicine {
	private String medId;//药品编号
	private String medName;//药品名称
	private String medPlant;//生产厂家
	private String medDate;//生产日期
	private int medPrice;//价格
	public Medicine(String medId,String medName,String medPlant,String medDate,int medPrice) {
		// TODO 自动生成的构造函数存根
		this.medId = medId;
		this.medName = medName;
		this.medPlant = medPlant;
		this.medDate = medDate;
		this.medPrice = medPrice;
	}
	public Medicine() {
		// TODO 自动生成的构造函数存根
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
