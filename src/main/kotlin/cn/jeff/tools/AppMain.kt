package cn.jeff.tools

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class AppMain : Application() {

	@Throws(Exception::class)
	override fun start(primaryStage: Stage) {
		val root = FXMLLoader.load<Parent>(javaClass.getResource("/fxml/MainWnd.fxml"))
		primaryStage.title = "字体截取工具（将字体作为图片存起来）"
		primaryStage.scene = Scene(root)
		primaryStage.show()
	}

	companion object {
		@JvmStatic
		fun main(vararg args: String) {
			launch(AppMain::class.java, *args)
		}
	}

}
