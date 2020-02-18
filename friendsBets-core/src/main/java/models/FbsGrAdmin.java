package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
public class FbsGrAdmin extends FbsUser {
		@OneToMany(mappedBy="adminGroup")
		private List<FbsGroup> groupWhereAdmin;

		public FbsGrAdmin(FbsGroup group, FbsUser u) {
			super(u.getNickname(), u.getEmail(), u.getPassword());
			if(this.groupWhereAdmin == null ) 
				this.groupWhereAdmin = new ArrayList<FbsGroup>();
			else
				this.groupWhereAdmin.add(group);
		}
		
		
}
