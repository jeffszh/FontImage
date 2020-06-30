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
		gc.fill = Color.TRANSPARENT
		gc.fillRect(30.0, 20.0, 100.0, 50.0)
		gc.font = Font.font("Courier New", 24.0)
		gc.stroke = Paint.valueOf("BLUE")
		gc.strokeText("ABC abc", 30.0, 20.0)
//		gc.fillText("ABC abc", 30.0, 20.0)
		val snapshotParameters = SnapshotParameters().also {
			it.fill = Color.TRANSPARENT
		}
		val img = j.workCanvas.snapshot(snapshotParameters, null)
		ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", File("myPic.png"))

//		val bufferedImage = BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB)
//		var gra = bufferedImage.createGraphics()
//		val image = gra.deviceConfiguration.createCompatibleImage(100, 50, Transparency.TRANSLUCENT)
//		gra.dispose()
//		gra = image.createGraphics()
//		gra.font = java.awt.Font("Courier New", java.awt.Font.PLAIN, 24)
//		gra.color = java.awt.Color.RED
//		gra.drawString("ABC 123 abc", 30, 20)
//		gra.drawLine(10, 20, 30, 40)
//		gra.dispose()
//		ImageIO.write(image, "png", File("pic2.png"))
	}

}
