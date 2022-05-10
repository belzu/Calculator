package presentation;

import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.Button;
import model.ButtonInfo;
import model.businessLogic.OperationMaker;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class CalculatorGUI extends JFrame {
	private OperationMaker operationMaker;
	private JTextArea operationScreen;
	private JTextField resultScreen;
	private Map<String, Button> buttonMap;
	private List<ButtonInfo> buttonInfoList;
	private InfoGUI infoGUI;
	private ExpGUI expGUI;
	private JScrollPane scrollPane;
	
	/**
	 * Create the frame.;
	 */
	public CalculatorGUI(String title, List<ButtonInfo> buttonInfoList) {
		this.initializeElements(title, buttonInfoList);
		this.assignEvents();
	}
	
	private void initializeElements(String title, List<ButtonInfo> buttonInfoList) {
		this.setAlwaysOnTop(true);
		this.getContentPane().setLayout(null);
		this.operationScreen = new JTextArea();
		this.operationScreen.setColumns(10);
		this.scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setBounds(10, 11, 469, 62);
		getContentPane().add(this.scrollPane);

		this.scrollPane.setViewportView(this.operationScreen);
		this.setVisible(true);
		this.setTitle(title);
		this.setResizable(false);
		this.setSize(new Dimension(513, 461));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.infoGUI = null;
		this.expGUI = null;
		
		this.operationMaker = new OperationMaker();
		System.out.println(this.operationMaker.getEngine());
		this.buttonInfoList = buttonInfoList;
		this.buttonMap = new TreeMap<String, Button>();
		for(int i = 0; i<this.buttonInfoList.size();i++) {
			Button newButton = new Button(buttonInfoList.get(i));
			this.buttonMap.put(buttonInfoList.get(i).getButtonKey(), newButton);
			newButton.getModel().setRollover(true);
			getContentPane().add((JButton) newButton);
		}
		this.resultScreen = new JTextField();
		this.resultScreen.setColumns(10);
		this.resultScreen.setEditable(false);
		this.resultScreen.setBounds(10, 338, 469, 62);
		getContentPane().add(resultScreen);
		super.repaint();
	}
	
	protected OperationMaker getOperationMaker() {
		return this.operationMaker;
	}
	
	protected void actionAddSymbol(String symbol) {
		int caretPosition = this.operationScreen.getCaretPosition();
		StringBuffer sb_before = new StringBuffer(this.operationScreen.getText().substring(0, caretPosition));
		StringBuffer sb_after = new StringBuffer(this.operationScreen.getText().substring(caretPosition, this.operationScreen.getText().length()));
		sb_before.append(symbol);		
		this.operationScreen.setText(sb_before.append(sb_after).toString());
		this.operationScreen.setCaretPosition(caretPosition+symbol.length());
		this.operationScreen.getCaret().setVisible(true);
	}
	
	private void actionRemoveSymbol() {
		int caretPosition = this.operationScreen.getCaretPosition();
		StringBuffer sb_before = new StringBuffer(this.operationScreen.getText().substring(0, caretPosition));
		StringBuffer sb_after = new StringBuffer(this.operationScreen.getText().substring(caretPosition, this.operationScreen.getText().length()));
		sb_before.deleteCharAt(sb_before.length()-1); 
		this.operationScreen.setText(sb_before.append(sb_after).toString());
		this.operationScreen.setCaretPosition(caretPosition-1);
		this.operationScreen.getCaret().setVisible(true);
		this.operationScreen.getSelectedText();
	}
	
	private void actionRemoveAllSymbols() {
		StringBuffer sb = new StringBuffer();
		this.operationScreen.setText(sb.toString());
		this.operationScreen.setCaretPosition(0);
		this.operationScreen.getCaret().setVisible(true);
	}
	
	private void actionMakeOperation() throws ScriptException{

		try {			
			String result = this.operationMaker.makeOperation(this.operationScreen.getText());
			this.resultScreen.setText(result);
		}
		catch(ScriptException e) {
			this.resultScreen.setText("An error occured when making this operation!!");
			throw new ScriptException(e);
		}
	}
	
	private void actionResult(){
		StringBuffer sb = new StringBuffer(this.operationScreen.getText());
		sb.append(this.resultScreen.getText());
		this.operationScreen.setText(sb.toString());
	}
	
	private void actionInfo(){
		if(infoGUI==null || !infoGUI.isVisible() ) infoGUI = new InfoGUI();
	}
	
	private void actionSqrOrPwr() {
		if(expGUI==null || !expGUI.isVisible() ) expGUI = new ExpGUI(this);
	}
	
	private void assignEvents() {
		String[] screenSymbols = new String[]{ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", ")", "+", "*", "-", "/", "."};
		for(int i = 0; i<screenSymbols.length;i++) {
			String symbol = screenSymbols[i];
			this.buttonMap.get(symbol).addActionListener(x->this.actionAddSymbol(symbol));
		}
		this.buttonMap.get("<").addActionListener(x->this.actionRemoveSymbol());
		this.buttonMap.get("C").addActionListener(x->this.actionRemoveAllSymbols());
		this.buttonMap.get("=").addActionListener(x-> {
			try {
				this.actionMakeOperation();
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		});
		this.buttonMap.get("Res").addActionListener(x->this.actionResult());
		this.buttonMap.get("info").addActionListener(x->this.actionInfo());
		this.buttonMap.get("^").addActionListener(x->this.actionSqrOrPwr());
	}
}
