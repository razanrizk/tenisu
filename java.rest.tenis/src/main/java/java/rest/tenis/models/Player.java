package java.rest.tenis.models;

public class Player  implements Comparable<Player> {
	/**
	 * Player id number
	 */
	private int id;

	/**
	 * Player first name
	 */
	private String firstname;

	/**
	 * Player last name
	 */
	private String lastname;

	/**
	 * Player short name
	 */
	private String shortname;

	/**
	 * Player sex
	 */
	private String sex;
	/**
	 * Player country
	 */
	private Country country;
	
	/**
	 * Player's picture 
	 */
	private String picture;

	/**
	 * Player's data 
	 */
	private Data data;

	public int getId() {
		return id;
	}

	
	/**
	 * The getters 
	 * 
	 */
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getShortname() {
		return shortname;
	}

	public String getSex() {
		return sex;
	}

	public Country getCountry() {
		return country;
	}

	public String getPicture() {
		return picture;
	}

	public Data getData() {
		return data;
	}

	/**
	 * The setters 
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setShortname(String shortname) {
		this.shortname = shortname;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(Player p) {
        return this.getData().getPoints() - p.getData().getPoints();
    }

   
	public Player(int id, String firstname, String lastname, String shortname, String sex, Country country,
			String picture, Data data) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.shortname = shortname;
		this.sex = sex;
		this.country = country;
		this.picture = picture;
		this.data = data;
	}


	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	
