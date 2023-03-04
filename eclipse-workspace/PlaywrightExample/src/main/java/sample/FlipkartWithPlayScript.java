package sample;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class FlipkartWithPlayScript {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.flipkart.com/");
      System.out.println(page.title());
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("✕")).click();
      page.getByPlaceholder("Search for products, brands and more").click();
      page.getByPlaceholder("Search for products, brands and more").fill("adidas shoes");
      page.getByRole(AriaRole.BUTTON).click();
      Page page1 = page.waitForPopup(() -> {
        page.locator("div:nth-child(6) > ._13oc-S > div:nth-child(3) > ._1xHGtK > ._2UzuFa").click();
      });
    }
  }
}