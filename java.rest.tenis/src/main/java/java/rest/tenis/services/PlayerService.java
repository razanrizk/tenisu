package java.rest.tenis.services;

import java.rest.tenis.models.Player;
import java.rest.tenis.models.Statistics;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tenis")
public class PlayerService {
	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Player> getPlayer_JSON() {
		List<Player> players = PlayerDAO.getAllPlayers();
		Arrays.sort(players.toArray());

		return players;
	}

	@GET
	@Path("/{id}")
	public Player getsPlayerById(@PathParam("id") int id) {
		return PlayerDAO.getPlayerByiD(id);
	}

	@GET
	@Path("/stat")
	public Statistics getStatistics() {
		return PlayerDAO.getStatistics();

	}

}
