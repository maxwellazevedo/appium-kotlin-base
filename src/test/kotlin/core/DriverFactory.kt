package core

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit

object DriverFactory {

    private var driver: AndroidDriver<MobileElement>? = null

    fun getDriver(): AndroidDriver<MobileElement>? {
        if (driver == null) {
            createDriver()
        }
        return driver
    }


    private fun createDriver() {
        val desiredCapabilities = DesiredCapabilities()
        desiredCapabilities.setCapability("platformName", "Android")
        desiredCapabilities.setCapability("deviceName", "emulator-5554")
        desiredCapabilities.setCapability("automationName", "uiautomator2")
        desiredCapabilities.setCapability("wdaStartupRetries", "4");
        desiredCapabilities.setCapability("androidInstallPause","8000" );
        desiredCapabilities.setCapability("wdaStartupRetryInterval", "20000");
        desiredCapabilities.setCapability(
            MobileCapabilityType.APP,
            "/yourPath/resources/twp.apk"
        )
        try {
            driver =
                AndroidDriver<MobileElement>(URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        driver?.manage()?.timeouts()?.implicitlyWait(20, TimeUnit.SECONDS)
    }

    fun killDriver() {
        if (driver != null) {
            driver!!.quit()
            driver = null
        }
    }
}