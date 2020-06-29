package cn.jeff.tools.misc

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

fun showMessage(msg: String) {
	Alert(Alert.AlertType.NONE, msg, ButtonType.CLOSE).showAndWait()
}

fun showInfo(info: String) {
	Alert(Alert.AlertType.INFORMATION, info).showAndWait()
}
