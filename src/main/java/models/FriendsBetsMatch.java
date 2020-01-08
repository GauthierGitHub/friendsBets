package models;

import java.util.List;

import javax.persistence.*;


/**
 * @Entity
 * @author Gauthier Barbet
 * TODO keep match persistant or not like Graze.OsmElements ?
 */
@Entity
public class FriendsBetsMatch {
	// TODO convert/parse API. 
	@Id
    private long id; // id set by API
    private String matchStartDate;
    private String matchEndDate;
    private Integer currentMatchday;
    private String winner;
    //private Object winner; Object can't be use by hibernate
    @OneToMany(mappedBy = "match")
    private List<FriendsBetsBet> betList;
    
    public FriendsBetsMatch() {}
}
