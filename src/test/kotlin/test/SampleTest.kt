package test

import core.BaseTest
import core.DriverFactory
import core.DriverFactory.getDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.qameta.allure.Allure
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.ByteArrayInputStream
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit

class SampleTest : BaseTest() {


    @Test
    fun sampleTest() {

        val hamburger = "//android.widget.ImageButton[@content-desc='Open navigation drawer']"
        getDriver()?.findElement(By.xpath(hamburger))?.click();

        getDriver()?.findElement(By.xpath("//*[@text='FORMS']"))?.click();
        getDriver()?.findElement(By.xpath("//*[@text='LOGIN']"))?.click();

        getDriver()?.findElement(By.id("io.qaninja.android.twp:id/etEmail"))?.sendKeys("eu@papito.io")
        getDriver()?.findElement(By.id("io.qaninja.android.twp:id/etPassword"))?.sendKeys("qaninja")

    }
}