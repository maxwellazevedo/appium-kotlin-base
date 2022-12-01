package test

import core.BaseTest
import org.junit.Assert
import org.junit.Test
import screens.LoginScreen
import screens.NavigatorScreen

class LoginTest : BaseTest() {

    var login = LoginScreen()
    var nav = NavigatorScreen()

    @Test
    fun LoginSuccessTest() {
        nav.tapHamburger()
        nav.tapByText("FORMS")
        nav.tapByText("LOGIN")
        login.signIn("eu@papito.io", "qaninja")
        Assert.assertEquals("Show! Suas credenciais são validas.", login.toast())
    }

    @Test
    fun LoginFailureTest() {
        nav.tapHamburger()
        nav.tapByText("FORMS")
        nav.tapByText("LOGIN")
        login.signIn("eu@max.com", "1231")
        Assert.assertEquals("Senha inválida!", login.toast())
    }

}