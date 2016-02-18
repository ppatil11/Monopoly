package modal;

public class SaleAttributes extends Attributes{

	
	 public SaleAttributes(String SKU, String Distype, int percent) {
		// TODO Auto-generated constructor stub
		 this.SKU = SKU;
		 this.DiscountType = Distype;
		 this.DisPercent = percent;
	}
	 public SaleAttributes(String SKU , String DisType, String x) {
		// TODO Auto-generated constructor stub
		 this.SKU = SKU;
		 this.DiscountType = DisType;
		 this.ValueX = x;
	}
	 public SaleAttributes(String SKU , String DisType, String x , String y) {
			// TODO Auto-generated constructor stub
		 this.SKU = SKU;
		 this.DiscountType = DisType;
		 this.ValueX = x;
		 this.ValueY = y;
		}

	@Override
	public String getSKU() {
		// TODO Auto-generated method stub
		return SKU;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return Description;
	}

	@Override
	public String getUCost() {
		// TODO Auto-generated method stub
		return UCost;
	}

	@Override
	public String getDiscountType() {
		// TODO Auto-generated method stub
		return DiscountType;
	}

	@Override
	public int getDisPercent() {
		// TODO Auto-generated method stub
		return DisPercent;
	}

	@Override
	public String getValueX() {
		// TODO Auto-generated method stub
		return ValueX;
	}

	@Override
	public String getValueY() {
		// TODO Auto-generated method stub
		return ValueY;
	}

}
