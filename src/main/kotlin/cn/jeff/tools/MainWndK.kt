package cn.jeff.tools

import javafx.embed.swing.SwingFXUtils
import javafx.geometry.Rectangle2D
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.Text
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.ceil

class MainWndK(private val j: MainWnd) {

	companion object {
		private const val outputPath = "font-png"
		//
//		private val textFont: Font = Font.font("Inconsolata", 30.0)
//		private val textFont: Font = Font.font("Cousine", 26.0)
		private val textFont: Font = Font.font("Courier New", 28.0)
//		private val textFont: Font = Font.font("Consolas", 26.0)
	}

	fun btnStartClick() {
		// 计算字体尺寸
		val tempText = Text("A")
		tempText.font = textFont
		val (xSize, ySize) = with(tempText.layoutBounds) {
			ceil(width + 1) to ceil(height)
		}
		println("$xSize, $ySize")

		val desiredFontColors = arrayOf("black", "red", "blue")
		desiredFontColors.forEach { fontColor ->
			val gc = j.workCanvas.graphicsContext2D
			gc.fill = Color.TRANSPARENT
			gc.fillRect(0.0, 0.0, 800.0, 200.0)
			gc.font = textFont
			gc.fill = Color.valueOf(fontColor)
			gc.stroke = Paint.valueOf(fontColor)
//		gc.strokeText("ABC abc", 30.0, 20.0)
////		gc.fillText("ABC abc", 30.0, 20.0)
//		val snapshotParameters = SnapshotParameters().also {
//			it.fill = Color.TRANSPARENT
//			it.viewport = Rectangle2D(30.0, 10.0, 50.0, 40.0)
//		}
//		val img = j.workCanvas.snapshot(snapshotParameters, null)
//		ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", File("myPic.png"))

			val upperCaseLetters = ('A'..'Z').toList().toCharArray()
			val lowerCaseLetters = ('a'..'z').toList().toCharArray()
			val digitNumbers = ('0'..'9').toList().toCharArray()
			val punctuations = " !@#$%^&*(),.'\"?/<>".toCharArray()
			val characterArrays = arrayOf(upperCaseLetters, lowerCaseLetters, digitNumbers, punctuations)

			// 创建对应颜色的输出目录
			File("$outputPath/$fontColor").mkdirs()

			characterArrays.forEachIndexed { y, chars ->
				chars.forEachIndexed { x, c ->
					gc.strokeText(c.toString(), x * xSize + 1, y * ySize + ySize)
					gc.fillText(c.toString(), x * xSize + 1, y * ySize + ySize)
				}
				chars.forEachIndexed { x, c ->
					val snapshotParameters = SnapshotParameters().also {
						it.fill = Color.TRANSPARENT
						it.viewport = Rectangle2D(x * xSize, y * ySize + 6, xSize, ySize)
					}
					val img = j.workCanvas.snapshot(snapshotParameters, null)
					j.outputPane.children.add(Canvas(xSize, ySize).also {
						it.graphicsContext2D.drawImage(img, 0.0, 0.0)
					})
					ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png",
							File("$outputPath/$fontColor/[${c.toByte()}].png"))
				}
			}
		}
	}

}
