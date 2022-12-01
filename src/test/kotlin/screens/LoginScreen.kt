package screens

import core.BaseScreen
import org.openqa.selenium.By

class LoginScreen : BaseScreen() {

    fun signIn(email: String?, password: String?) {
        writeText(By.id("io.qaninja.android.twp:id/etEmail"),email)
        writeText(By.id("io.qaninja.android.twp:id/etPassword"),password)
        clickAny(By.id("io.qaninja.android.twp:id/btnSubmit"))
    }

    fun toast(): String? {
        return getText(By.xpath("//android.widget.Toast"));
    }

}