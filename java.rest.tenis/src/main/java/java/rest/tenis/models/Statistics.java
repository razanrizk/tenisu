package java.rest.tenis.models;

import java.util.Map;

public class Statistics {
	
	

	/**
	 * the high country ratio 
	 */
	private String highstCountry ;
	
	/**
	 * IMc by player
	 */
	private Map<String, Double> imcByPlayer ;
			
	/**
	 *Median high 
	 */
	private	double medianPlayers;

	
	/**
	 * The getters
	 */
	public String getHighstCountry() {
		return highstCountry;
	}

	public Map<String, Double> getImcByPlayer() {
		return imcByPlayer;
	}

	public double getMedianPlayers() {
		return medianPlayers;
	}

	/**
	 * 
	 * The setters 
	 */
	public void setHighstCountry(String highstCountry) {
		this.highstCountry = highstCountry;
	}

	public void setImcByPlayer(Map<String, Double> imcByPlayer) {
		this.imcByPlayer = imcByPlayer;
	}

	public void setMedianPlayers(double medianPlayers) {
		this.medianPlayers = medianPlayers;
	}
	
	/**
	 * 
	 * @param highstCountry
	 * @param imcByPlayer
	 * @param medianPlayers
	 */
	public Statistics(String highstCountry, Map<String, Double> imcByPlayer, double medianPlayers) {
		super();
		this.highstCountry = highstCountry;
		this.imcByPlayer = imcByPlayer;
		this.medianPlayers = medianPlayers;
	}
	
	
	
}
