package core

import org.openqa.selenium.By

import core.DriverFactory
import core.DriverFactory.getDriver


open class BaseScreen{

    fun writeText(by: By?, text: String?) {
        getDriver()?.findElement(by)?.sendKeys(text)
    }

    fun getText(by: By?): String? {
        return getDriver()?.findElement(by)?.getText()
    }

    fun clickAny(by: By?) {
        getDriver()?.findElement(by)?.click()
    }

    fun clickByText(text: String) {
        clickAny(By.xpath("//*[@text='$text']"))
    }

    fun selectCombo(by: By?, value: String) {
        getDriver()?.findElement(by)?.click()
        clickByText(value)
    }
}