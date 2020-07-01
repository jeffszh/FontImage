package cn.jeff.tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class MainWnd {

	private MainWndK k = new MainWndK(this);
	public Button btnStart;
	public Canvas workCanvas;
	public FlowPane outputPane;

	public void btnStartClick() {
		k.btnStartClick();
	}

}
