package core

import core.DriverFactory.getDriver
import core.DriverFactory.killDriver
import io.qameta.allure.Allure
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.io.ByteArrayInputStream


open class BaseTest {

//    @Rule
//    var testName = TestName()

    @Before
    open fun setUp(): Unit {
        //Evento de clique no botão Começar
        getDriver()?.findElement(By.xpath("//android.widget.Button[@text='COMEÇAR']"))?.click()
    }


    //@AfterClass
    fun finalizaClasse() {
        killDriver()
    }

    @After
    fun tearDown() {
        takeScreenShot("testName")
        killDriver()
    }

    open fun takeScreenShot(testName: String) {
        Allure.addAttachment(testName, ByteArrayInputStream((getDriver() as TakesScreenshot).getScreenshotAs(OutputType.BYTES)))
    }

}