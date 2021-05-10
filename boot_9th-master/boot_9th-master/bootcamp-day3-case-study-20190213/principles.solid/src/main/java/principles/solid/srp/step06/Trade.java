package principles.solid.srp.step06;

public class Trade {
	//
	private String sourceCurrencyCode;
	private String destinationCurrencyCode;
	private float lots;
	private float price;
	
	public Trade(String sourceCurrencyCode, String destinationCurrencyCode, float lots, float price) {
		//
		this.sourceCurrencyCode = sourceCurrencyCode;
		this.destinationCurrencyCode = destinationCurrencyCode;
		this.lots = lots;
		this.price = price;
	}

	public String getSourceCurrencyCode() {
		return sourceCurrencyCode;
	}

	public String getDestinationCurrencyCode() {
		return destinationCurrencyCode;
	}

	public float getLots() {
		return lots;
	}

	public float getPrice() {
		return price;
	}
	
}