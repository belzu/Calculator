package model;

import javax.swing.JButton;

public class Button extends JButton {
	private ButtonInfo buttonInfo;

	public Button(ButtonInfo buttonInfo) {
		super(buttonInfo.getButtonKey());
		this.buttonInfo = buttonInfo;
		this.setBounds(buttonInfo.getButtonPosition()[0], buttonInfo.getButtonPosition()[1], 60, 40);
	}
	public Button(String buttonKey, int[] buttonPosition) {
		super("buttonKey");
		this.buttonInfo = new ButtonInfo(buttonKey,  buttonPosition);
		this.setBounds(buttonPosition[0], buttonPosition[1], 60, 40);
	}
	public ButtonInfo getButtonInfo() {
		return buttonInfo;
	}
	public void setButtonInfo(ButtonInfo buttonInfo) {
		this.buttonInfo = buttonInfo;
	}
	
	
}
