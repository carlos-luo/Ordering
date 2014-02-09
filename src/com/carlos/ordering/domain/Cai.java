package com.carlos.ordering.domain;



public class Cai {
	private int id;
	private String caiID;
	private String name;
	private String amount;
	private String price;
	private String recommanded;
	private String publishDate;
	
	public Cai(){
		
	}
	
	public Cai(String caiID, String name, String amount, String price,
			String recommanded, String publishDate) {
		super();
		this.caiID = caiID;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.recommanded = recommanded;
		this.publishDate = publishDate;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the recommanded
	 */
	public String getRecommanded() {
		return recommanded;
	}
	/**
	 * @param recommanded the recommanded to set
	 */
	public void setRecommanded(String recommanded) {
		this.recommanded = recommanded;
	}
	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getCaiID() {
		return caiID;
	}
	public void setCaiID(String caiID) {
		this.caiID = caiID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cai [caiID=" + caiID + ", name=" + name + ", amount=" + amount
				+ ", price=" + price + ", recommanded=" + recommanded
				+ ", publishDate=" + publishDate + "]";
	}
	
	
}
