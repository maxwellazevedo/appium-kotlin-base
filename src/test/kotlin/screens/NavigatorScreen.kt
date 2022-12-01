package screens

import core.BaseScreen
import core.DriverFactory
import org.openqa.selenium.By

class NavigatorScreen : BaseScreen() {

    fun tapHamburger() {
        val hamburger = "//android.widget.ImageButton[@content-desc='Open navigation drawer']"
        //getDriver().findElement(By.xpath(hamburger)).click();
        clickAny(By.xpath(hamburger))
    }


    fun tapByText(target: String?) {
        clickByText(target!!)
    }
}