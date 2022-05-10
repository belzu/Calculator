package model;

public class ButtonInfo {
	private String buttonKey;
	private int[] buttonPosition;
	
	public ButtonInfo(String buttonKey, int[] buttonPosition) {
		this.buttonKey = buttonKey;
		this.buttonPosition = buttonPosition;
	}
	public String getButtonKey() {
		return buttonKey;
	}
	public void setButtonKey(String buttonKey) {
		this.buttonKey = buttonKey;
	}
	public int[] getButtonPosition() {
		return buttonPosition;
	}
	public void setButtonPosition(int[] buttonPosition) {
		this.buttonPosition = buttonPosition;
	}
	
}
