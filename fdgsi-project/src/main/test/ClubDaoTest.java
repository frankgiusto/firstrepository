

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;


import ca.tci.clubs.common.*;
import ca.tci.clubs.entity.Club;
	
	public class ClubDaoTest  extends  ClubBaseJunitTestRollingBackDBState {	
	
	private static Logger logger = Logger.getLogger(ClubBaseJunitTestRollingBackDBState.class.getName());	
	static ClubDao clubDao;
	
	@Before
	public void setUp() throws Exception {

		clubDao = (ClubDao) applicationContext.getBean("clubDao");	   	 
		logger.debug("setUp");
		
	}

	//@Ignore
	 public void testGet(){		
	
		Club club = clubDao.get(1);
		assertEquals(1,club.getId());
		assertEquals("asdfasf",club.getName());		

	}	
	
	public void testSaveOrUpdate(){

		int testID = 10001;
		Club club = new Club();
		club.setId(testID );
		club.setName("Toyota33");	
		
		//clubDao.saveOrUpdate(club);
		clubDao.save(club);
		
		
	    club = clubDao.get(testID);
	    assertEquals(testID,club.getId());
	
	}
	
	//@Ignore
	/**
	 * Todo insert x number of records and compare size of array.
	 */
	public void testFind(){		
		
		int expSize = 2;
		List<Club> l= clubDao.find();
		
		for (Club club : l) {			
		logger.debug(club.getId());
		logger.debug(","+club.getName());
		}
		
		assertEquals(expSize,l.size());
	}
	
	
	


}
