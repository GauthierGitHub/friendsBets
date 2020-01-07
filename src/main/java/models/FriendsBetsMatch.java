package models;

import java.util.List;

import javax.persistence.*;


/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FriendsBetsMatch {
	// TODO convert/parse API. Id need a bigInt cause json from api do ?
	@Id
    private long id;
    private String matchStartDate;
    private String matchEndDate;
    private Integer currentMatchday;
    private String winner;
    //private Object winner; Object can't be use by hibernate
    @OneToMany(mappedBy = "match")
    private List<FriendsBetsBet> betList;
    
    public FriendsBetsMatch() {}
}
