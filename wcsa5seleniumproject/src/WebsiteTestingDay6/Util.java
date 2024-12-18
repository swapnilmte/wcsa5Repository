package WebsiteTestingDay6;

public class Util {
	
	// Constants for test configuration
		// Time to wait when searching for a GUI element
		public static final int WAIT_TIME =20;       // Delay time to wait the website

		//Setting BaseURL
		public static final String BASE_URL = "http://www.demo.guru99.com/"; 
		// Valid account for login
		public static final String USER_NAME = "mngr603881"; 
		public static final String PASSWORD = "jYjYhEn";

		// Expected output
		public static final String EXPECT_TITLE="Guru99 Bank Manager HomePage";
		public static final String EXPECT_ERROR="User or Password is not valid";	
		
		public static final String PATTERN = ":";
		public static final String FIRST_PATTERN = "mngr";
		public static final String SECOND_PATTERN = "[0-9]+";
		
		//FireFox driver path
		public static final String FIREFOX_PATH = "./drivers/geckodriver.exe";
		public static final String SCREENSHOT_PATH="./screenshot";

}
