package java.rest.tenis.services;

import java.io.IOException;
import java.rest.tenis.json.JsonReaderToList;
import java.rest.tenis.models.Country;
import java.rest.tenis.models.Data;
import java.rest.tenis.models.Player;
import java.rest.tenis.models.Statistics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PlayerDAO {

	//private static final Map<String, Player> playerMap = new HashMap<String, Player>();
	private static List<Player> Players = new ArrayList<Player>() ;
	
	static {
		//initPlayers();
		try {
			Players = initPlayersfromJson();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	
	
//	private static void initPlayers() {
//
//		Country srb = new Country("https://data.latelier.co/training/tennis_stats/resources/Serbie.png", "SRB");
//		Country usa = new Country("https://data.latelier.co/training/tennis_stats/resources/USA.png", "USA");
//		Country sui = new Country("https://data.latelier.co/training/tennis_stats/resources/Suisse.png", "SUI");
//		Country esp = new Country("https://data.latelier.co/training/tennis_stats/resources/Espagne.png", "ESP");
//
//		Data data1 = new Data(2, 2542, 80000, 188, 31, 1, 1, 1, 1, 1);
//		Data data2 = new Data(52, 1105, 74000, 185, 38, 0, 1, 0, 0, 1);
//		Data data3 = new Data(21, 1784, 81000, 183, 33, 1, 1, 1, 0, 1);
//		Data data4 = new Data(10, 3521, 72000, 175, 37, 0, 1, 1, 1, 0);
//		Data data5 = new Data(1, 1982, 85000, 185, 33, 1, 0, 0, 0, 1);
//
//		Player player1 = new Player(52, "Novak", "Djokovic", "N.DJO", "M", srb,
//				"https://data.latelier.co/training/tennis_stats/resources/Djokovic.png", data1);
//		Player player2 = new Player(95, "Venus", "Williams", "V.WI", "F", usa,
//				"https://data.latelier.co/training/tennis_stats/resources/Venus.webp", data2);
//		Player player3 = new Player(65, "Stan", "Wawrinka", "S.WAW", "M", sui,
//				"https://data.latelier.co/training/tennis_stats/resources/Wawrinka.png", data3);
//		Player player4 = new Player(102, "Serena", "Williams", "S.WIL", "F", usa,
//				"https://data.latelier.co/training/tennis_stats/resources/Serena.png", data4);
//		Player player5 = new Player(17, "Rafael", "Nadal", "R.NAD", "M", esp,
//				"https://data.latelier.co/training/tennis_stats/resources/Nadal.png", data5);
//
//		playerMap.put(player1.getShortname(), player1);
//		playerMap.put(player2.getShortname(), player2);
//		playerMap.put(player3.getShortname(), player3);
//		playerMap.put(player4.getShortname(), player4);
//		playerMap.put(player5.getShortname(), player5);
//
//	}
	
	
	private static List<Player>initPlayersfromJson() throws IOException {
		return JsonReaderToList.getPlayers();
	}
	
	/**
	 * 
	 * @param id
	 * @return player by Id
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static Player getPlayerByiD(int id) {
		return Players.get(id);
		
	}

	
	/**
	 * 
	 * @return All Players 
	 */
	public static List<Player> getAllPlayers() {
			return Players;
	}

	/**
	 * 
	 * @return statistics
	 */
	public static Statistics getStatistics() {
		List<Player> players = getAllPlayers();

		// The Country who has the High Ratio
		String highstCountry = getHighstCountry(players);

		// IMc by player
		Map<String, Double> imcByPlayer = getIMC(players);
				
		//Median high  
		double medianPlayers= getMedian(players);
		
		Statistics statistics= new Statistics(highstCountry,imcByPlayer,medianPlayers);
		return statistics;
	
	}

	//get the Median high 'player
	public static double getMedian(List<Player> players) {

		double[] m = null;
		int i = 0;
		for (Player player : players) {
			m[i] = player.getData().getHeight();
			i++;
		}

		int middle = m.length / 2;
		if (m.length % 2 == 1) {
			return m[middle];
		} else {
			return (m[middle - 1] + m[middle]) / 2.0;
		}

	}

	// Getting Imc By Player
	public static Map<String, Double> getIMC(List<Player> players) {

		Map<String, Double> imcByPlayer = new HashMap<>();

		for (Player player : players) {
			double imcPlayer = player.getData().getWeight() / player.getData().getWeight()
					* player.getData().getHeight();
			imcByPlayer.computeIfAbsent(player.getShortname(), k -> imcPlayer);
		}

		return imcByPlayer;

	}

	// Getting the country who has the high ratio
	public static String getHighstCountry(List<Player> players) {

		Map<String, List<Integer>> pointsByCountry = new HashMap<>();
		Map<String, Integer> pointsByCountryfinal = new HashMap<>();
		for (Player player : players) {
			pointsByCountry.computeIfAbsent(player.getCountry().getCode(), k -> new ArrayList<>())
					.add(player.getData().getPoints());
		}
		Iterator iterator = pointsByCountry.entrySet().iterator();
		String highCountryRatio = "";
		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();

			List<Integer> points = (List<Integer>) mapentry.getValue();
			if (points.size() > 1) {
				int sum = 0;
				for (int value : points) {
					sum += value;
				}
				points.removeAll(points);
				points.add(sum);
			}

			pointsByCountryfinal.put((String) mapentry.getKey(), points.get(0));

			System.out.println("clé: " + mapentry.getKey() + " | valeur: " + mapentry.getValue());

			System.out.println("clé: " + mapentry.getKey() + " | valeur: " + mapentry.getValue());

			int maxValueInMap = (Collections.max(pointsByCountryfinal.values())); // This will return max value in the
																					// HashMap
			for (Entry<String, Integer> entry : pointsByCountryfinal.entrySet()) { // Iterate through HashMap
				if (entry.getValue() == maxValueInMap) {
					highCountryRatio = entry.getKey();
					System.out.println(entry.getKey()); // Print the key with max value
				}
			}

		}
		return highCountryRatio;
	}

}
