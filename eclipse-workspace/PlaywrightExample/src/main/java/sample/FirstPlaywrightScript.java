package sample;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class FirstPlaywrightScript {

	public static void main(String[] args) {
		LaunchOptions ls = new LaunchOptions();
	    ls.setChannel("chrome");
	    ls.setHeadless(false);
	    
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(ls);
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
		String title = page.title();
		System.out.println(title);
		//playwright.close();

	}

}
