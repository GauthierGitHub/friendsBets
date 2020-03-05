package friendsbets.core.sb.models;

import java.util.List;

import javax.persistence.*;


/**
 * @Entity
 * @author Gauthier Barbet
 * TODO keep match persistant or not like Graze.OsmElements ?
 */
@Entity
@Table(name="FbsMatch")
public class Match {
	// TODO convert/parse API. 
	
	@Id
	@GeneratedValue // TODO: CHANGE FOR API ID ?
    private int id; // id set by API
    private String matchStartDate;
    private String matchEndDate;
    private Integer currentMatchday;
    private String winner;
    //private Object winner; Object can't be use by hibernate
    @OneToMany(mappedBy = "match")
    private List<Bet> betList;
    
    public Match() {}
}
