package cn.jeff.tools;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MainWnd {

	private MainWndK k = new MainWndK();
	public Button btnStart;

	public void btnStartClick(ActionEvent event) {
		k.btnStartClick();
	}

}
