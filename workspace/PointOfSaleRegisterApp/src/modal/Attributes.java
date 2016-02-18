package modal;

public abstract class Attributes {

	String SKU;
	String Description;
	String UCost;
	String DiscountType;
	int DisPercent ;
	String ValueX;
	String ValueY;
	
	public abstract String getSKU();
	public abstract String getDesc();
	public abstract String getUCost();
	public abstract String getDiscountType();
	public abstract int getDisPercent();
	public abstract String getValueX();
	public abstract String getValueY();
}
