package WebsiteTestingDay2;


/*
 * Declare some common parameters for scripts
 * You can change them to adapt your environment
 *
 */

public class Util {
	 
			//FireFox driver path
			public static final String FIREFOX_PATH = "./drivers/geckodriver.exe";
			
			//Setting BaseURL
			public static final String BASE_URL = "http://www.demo.guru99.com/";
			
			// Constants for test configuration
			// Time to wait when searching for a GUI element
			public static final int WAIT_TIME =30;       // Delay time to wait the website
		 
			// Valid account for login
			public static final String USER_NAME = "mngr603881"; 
			public static final String PASSWORD = "jYjYhEn";

			// Expected output
			public static final String EXPECT_TITLE="Guru99 Bank Manager HomePage";
				
}