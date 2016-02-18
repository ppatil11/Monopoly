package modal;

public class CostAttributes extends Attributes {
    
	
	 public CostAttributes(String SKU, String Description, String UCost) {
		// TODO Auto-generated constructor stub
	   this.SKU = SKU;
	   this.Description = Description;
	   this.UCost = UCost;
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
