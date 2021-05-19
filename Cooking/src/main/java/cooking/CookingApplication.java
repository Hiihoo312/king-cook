package cooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot起動時に実行されるクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@SpringBootApplication
public class CookingApplication {
	/**
	 * メインメソッドです.
	 * @param args コマンドラインの引数。
	 */
	public static void main(String[] args) {
		SpringApplication.run(CookingApplication.class, args);
	}

}
