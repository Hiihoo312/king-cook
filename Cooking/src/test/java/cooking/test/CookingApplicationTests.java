package cooking.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cooking.CookingApplication;
import mockit.Mocked;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CookingApplicationTests {

	@Mocked private CookingApplication cookingApplication;

	@Test
	public void contextLoads() {
	}

}
