package program;

import java.util.ArrayList;
import java.util.List;

import model.ButtonInfo;
import presentation.CalculatorGUI;

public class ApplicationLauncher {

	public static void main(String[] args){
		List<ButtonInfo> buttonInfoList = new ArrayList<ButtonInfo>();
		buttonInfoList.add(new ButtonInfo("1", new int[]{10,110}));
		buttonInfoList.add(new ButtonInfo("2", new int[]{80,110}));
		buttonInfoList.add(new ButtonInfo("3", new int[]{150,110}));
		buttonInfoList.add(new ButtonInfo("4", new int[]{10,161}));
		buttonInfoList.add(new ButtonInfo("5", new int[]{80,161}));
		buttonInfoList.add(new ButtonInfo("6", new int[]{150,161}));
		buttonInfoList.add(new ButtonInfo("7", new int[]{10,212}));
		buttonInfoList.add(new ButtonInfo("8", new int[]{80,212}));
		buttonInfoList.add(new ButtonInfo("9", new int[]{150,212}));
		buttonInfoList.add(new ButtonInfo("0", new int[]{80,263}));	
		buttonInfoList.add(new ButtonInfo("=", new int[]{150,263}));
		buttonInfoList.add(new ButtonInfo("Res", new int[]{10,263}));
		buttonInfoList.add(new ButtonInfo("+", new int[]{279,110}));
		buttonInfoList.add(new ButtonInfo("-", new int[]{349,110}));
		buttonInfoList.add(new ButtonInfo("*", new int[]{419,110}));
		buttonInfoList.add(new ButtonInfo("/", new int[]{279,161}));
		buttonInfoList.add(new ButtonInfo("^", new int[]{349,161}));
		buttonInfoList.add(new ButtonInfo("E", new int[]{419,161}));
		buttonInfoList.add(new ButtonInfo("(", new int[]{279,212}));
		buttonInfoList.add(new ButtonInfo(")", new int[]{349,212}));
		buttonInfoList.add(new ButtonInfo(".", new int[]{419,212}));
		buttonInfoList.add(new ButtonInfo("<", new int[]{279,263}));
		buttonInfoList.add(new ButtonInfo("C", new int[]{349,263}));
		buttonInfoList.add(new ButtonInfo("info", new int[]{419,263}));
		new CalculatorGUI("Calculator", buttonInfoList);
	}

}
