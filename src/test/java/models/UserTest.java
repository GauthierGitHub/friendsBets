package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author barbet
 *
 */
@Tag("Unit Test")
public class UserTest {

	private List<Group> mockGrpList = new ArrayList<Group>();
	private Group grp = Mockito.mock(Group.class);
	
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		//MockitoAnnotations.initMocks(grp);
	}
	
	
	@Test
	public void addInAGrouptest() {
		//Mockito.when(mockGrpList.add(grp)).thenReturn(true, true);
	}

}
