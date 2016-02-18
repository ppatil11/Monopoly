package modal;

public class ProductOrder {

	String DISCOUNT = "DISCOUNT";
	String BUYXGET1 = "BUY X GET 1 FREE";
	String BUYXGETY = "BUY X FOR Y";
	
	public int freeItems = 0;
	
	private String sku;
	private String des;
	private int uprice;
	private int count = 0;
	
	private int totalCost = 0;
	private String discountType = "NONE";
	private int discountAmt = 0;
	private String notes = "No discount";
	private String discountApplied = "NO";
	
	public ProductOrder(String sku, String des, int uprice, SaleOfProducts sp) {
		this.sku = sku;
		this.des = des;
		this.uprice = uprice;
		this.count = 1;
		//this.totalCost = uprice;
				
		if (sp != null) {
			for (Attributes at : sp.Sale_Data) {
				if (at.SKU.equals(this.sku)) {
					if (at.DiscountType.equals("DISCOUNT")) {
						discountType = DISCOUNT;
						notes = "By at " + at.DisPercent + "% discount";					
					} else if (at.DiscountType.equals("BUYXGET1FREE")) {
						discountType = BUYXGET1;
						notes = "BUY " + at.ValueX + " and GET 1 FREE"; 					
					} else if (at.DiscountType.equals("BUYXFORY")) {
						discountType = BUYXGETY;
						notes = "BUY " + at.ValueX + " at price of " + at.ValueY;
					}
					break;
				}
			}	
		}
		updateTotalCost(sp);

	}

	public void updateTotalCost(SaleOfProducts sp) {
		if (sp == null)
			return;
		
		if (discountType.equals("NONE")) {
			totalCost = uprice * count;
			return;
		}
		
		for (Attributes at : sp.Sale_Data) {
			if (at.SKU.equals(this.sku)) {
				if (at.DiscountType.equals("DISCOUNT")) {
					discountType = DISCOUNT;
					discountApplied = "YES";
					notes = "By at " + at.DisPercent + "% discount";
					
					totalCost = count * uprice;
					
					int discount = at.DisPercent;
					//System.out.println(totalCost + " " + uprice + " " + discount);
					totalCost -= ((1.0 * totalCost) * (discount/100.0));
					//System.out.println(totalCost);
				} else if (at.DiscountType.equals("BUYXGET1FREE")) {
					discountType = BUYXGET1;
					notes = "BUY " + at.ValueX + " and GET 1 FREE"; 
					
					int total = Integer.parseInt(at.ValueX) + 1;
					int units = Integer.parseInt(at.ValueX);

					boolean reduce = false;
					if (units == (count%total)) {
						count++;
						freeItems++;
						reduce = true;
					}

					totalCost = 0;
					int i=count;
					while (total <= i) {
						discountApplied = "YES";
						totalCost += units * uprice;
						i -= total;
					}
					
					if (i > 0) {
						totalCost += i * uprice;
					}
					
					if (reduce)
						count--;
					
				} else if (at.DiscountType.equals("BUYXFORY")) {
					discountType = BUYXGETY;
					notes = "BUY " + at.ValueX + " at price of " + at.ValueY;
					
					int targetUnits = Integer.parseInt(at.ValueY);
					int targetPrice = targetUnits * uprice;
					int purchaseUnits = Integer.parseInt(at.ValueX);
					
					totalCost = 0;
					int i=count;
					while (purchaseUnits <= i) {
						discountApplied = "YES";
						totalCost += targetPrice;
						i -= purchaseUnits;
					}
					
					if (i > 0) {
						totalCost += i * uprice;
					}

				}
			}
		}
	}
	
	public String discountStatus() {
		return discountApplied;
	}
	public String getNotes() {
		return notes;
	}
	
	public int getTotalCost() {
		return totalCost/100;
	}
	
	public void incrementCount(SaleOfProducts sp) {
		count++;
		updateTotalCost(sp);
	}
	
	public String getSku() {
		return sku;
	}

	public String getDes() {
		return des;
	}

	public int getUprice() {
		return uprice;
	}

	public int getCount() {
		return count;
	}
	
}
