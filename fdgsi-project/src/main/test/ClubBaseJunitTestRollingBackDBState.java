

import org.apache.log4j.Logger;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;

@ContextConfiguration(locations = { "classpath:/test/config/junit-hibernate-context.xml" })

public class ClubBaseJunitTestRollingBackDBState extends
		AbstractTransactionalJUnit38SpringContextTests {
	
	//AbstractTransactionalJUnit38SpringContextTests is rolling back transactions after tests(no records in DB).
	
	/* ********uncomment 2 lines below to commit records in DB****** */
	//extends TestCase {
	//ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("ca/tci/clubs/config/junitTestContext.xml");

	
	private static Logger logger = Logger.getLogger(ClubBaseJunitTestRollingBackDBState.class.getName());

	public int getCurrValueSeq(String seqName ) {
		
		StringBuilder sql = new StringBuilder(50);
		sql.append("values nextval for ").append(seqName);	
		int value = simpleJdbcTemplate.queryForInt(sql.toString());
		return value;
	}

	public int getPrevValueSeq(String seqName ) {
		StringBuilder sql = new StringBuilder(50);
		sql.append("values prevval for ").append(seqName);	
		int value = simpleJdbcTemplate.queryForInt(sql.toString());
		return value;
	}
	
}
