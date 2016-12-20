package application.dto;

/**
 * @author akash.shinde 
 *
 */
public class Product {
	
	private String productDesc;
	private String productPrice;
	private String productName;

	public Product(String productDesc, String productPrice, String productName) {
		super();
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductId() {
		return productPrice;
	}

	public void setProductId(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
}
