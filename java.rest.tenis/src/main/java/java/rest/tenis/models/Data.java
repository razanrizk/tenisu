package java.rest.tenis.models;

public class Data {
	/**
	 * player rank
	 */
	private int rank;
	/**
	 * player 's points
	 */
	private int points;
	/**
	 * player's weight
	 */
	private int weight;
	/**
	 * player height
	 */
	private int height;
	/**
	 * player age
	 */
	private int age;
	/**
	 * player' s last 
	 */
	private int [] last;

	/**
	 * 
	 * the getters 
	 */
	public int getRank() {
		return rank;
	}
	public int getPoints() {
		return points;
	}
	public int getWeight() {
		return weight;
	}
	public int getHeight() {
		return height;
	}
	public int getAge() {
		return age;
	}
	public int[] getLast() {
		return last;
	}
	
	
	/**
	 * 
	 * The setters 
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setLast(int[] last) {
		this.last = last;
	}
	
	public Data(int rank, int points, int weight, int height, int age, int p1,int p2,int p3, int p4,int p5)
	{
		super();
		this.rank = rank;
		this.points = points;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.last[0] =p1;
		this.last[1] =p2;
		this.last[2] =p3;
		this.last[3] =p4;
		this.last[4] =p5;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
