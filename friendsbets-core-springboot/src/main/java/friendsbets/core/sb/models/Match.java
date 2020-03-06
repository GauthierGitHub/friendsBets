package friendsbets.core.sb.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * @Entity
 * @author Gauthier Barbet
 * TODO keep match persistant or not like Graze.OsmElements ?
 */
@Entity
@Table(name="MatchFbs")
public class Match {
	// TODO convert/parse API. 
	
	@Id
	@GeneratedValue // TODO: CHANGE FOR API ID ?
    private int id; // id set by API
    private String matchStartDate;
    private int[] result =  new int[2];
    //private Object winner; Object can't be use by hibernate
    @OneToMany(mappedBy = "match")
    private List<Bet> betList;
    
    public Match() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatchStartDate() {
		return matchStartDate;
	}

	public void setMatchStartDate(String matchStartDate) {
		this.matchStartDate = matchStartDate;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}

	public List<Bet> getBetList() {
		return betList;
	}

	public void setBetList(List<Bet> betList) {
		this.betList = betList;
	}
}
