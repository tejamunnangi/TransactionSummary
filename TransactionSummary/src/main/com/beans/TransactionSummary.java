package main.com.beans;

public class TransactionSummary {
	private Client clientInfo;
	private Product productInfo;
	private TransactionAmount transactionAmount;
	
	public Client getClientInfo() {
		return clientInfo;
	}
	
	public void setClientInfo(Client clientInfo) {
		this.clientInfo = clientInfo;
	}
	
	public Product getProductInfo() {
		return productInfo;
	}
	
	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}
	
	public TransactionAmount getTransactionAmount() {
		return transactionAmount;
	}
	
	public void setTransactionAmount(TransactionAmount transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
}
