package cn.jeff.tools

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import tornadofx.*
import java.net.URL

class WelcomeWnd : View("字体截取工具") {

	override val root = hbox {
		prefWidth = 400.0
		prefHeight = 300.0
		label("请等待……")
		runLater(1.seconds) {
			loadMainWnd()
//			hide()
		}
	}

	private fun loadMainWnd() {
		val url: URL = javaClass.getResource("/fxml/MainWnd.fxml")
		println("===================================================")
		println(url)
		println("===================================================")
		val root = FXMLLoader.load<Parent>(url)
//		primaryStage.title = "Hello World"
//		primaryStage.scene = Scene(root, 700.0, 100.0)
		primaryStage.scene = Scene(root)
		primaryStage.show()
	}

}
