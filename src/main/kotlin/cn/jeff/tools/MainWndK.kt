package cn.jeff.tools

import javafx.embed.swing.SwingFXUtils
import javafx.scene.SnapshotParameters
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import java.io.File
import javax.imageio.ImageIO

class MainWndK(private val j: MainWnd) {

	fun btnStartClick() {
		val gc = j.workCanvas.graphicsContext2D
		gc.font = Font.font("Courier New", 24.0)
		gc.stroke = Paint.valueOf("BLUE")
		gc.strokeText("ABC abc", 30.0, 20.0)
//		gc.fillText("ABC abc", 30.0, 20.0)
		val snapshotParameters = SnapshotParameters().also {
			it.fill = Color.TRANSPARENT
		}
		val img = j.workCanvas.snapshot(snapshotParameters, null)
		ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", File("myPic.png"))
	}

}
