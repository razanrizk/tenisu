package java.rest.tenis.models;

public class Country {
	

	/**
	 * The picture of the country
	 */
	private String picture;
	/**
	 * The code of the Country
	 */
	private String code;
	
	/**
	 * the getters 
	 * 
	 */
	public String getPicture() {
		return picture;
	}
	public String getCode() {
		return code;
	}
	/**
	 * The setters 
	 * 
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	public Country(String picture, String code) {
		super();
		this.picture = picture;
		this.code = code;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
