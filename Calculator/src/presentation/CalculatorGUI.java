package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea screen;
	JTextArea txtResult;
	private ExpGUI exp = new ExpGUI(this);
	private InfoGUI info = new InfoGUI();
	private CalculatorGUI frame = this;
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
//    String foo;
//    System.out.println(engine.eval(foo));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ScriptException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setTitle("Calculator");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTextArea getScreen() {
		return screen;
	}
	public void solve() {
		try {
			System.out.println(engine.eval(screen.getText()));
//			screen.setText(engine.eval(screen.getText()).toString());
//			Math.pow(9, 3));
			
			txtResult.setText(engine.eval(screen.getText()).toString());
//			JOptionPane.showMessageDialog(new JFrame()," RESULT:\n"+engine.eval(screen.getText()).toString(),"Solution",JOptionPane.INFORMATION_MESSAGE);
//			JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
			screen.setText("");
		}
		catch(ScriptException e) {
			JOptionPane.showMessageDialog(new JFrame(),"An error occurred\nPlease, get sure you wrote everything correctly","ERROR",JOptionPane.ERROR_MESSAGE);
			System.err.println("ERROR PRODUCED:\n"+ e);
		}
	    		
	}
	
	
	
	
	

	/**
	 * Create the frame.;
	 */
	public CalculatorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try 
        {
            setIconImage(Toolkit.getDefaultToolkit().getImage("icon/calculator_white.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		setBounds(100, 100, 587, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		screen = new JTextArea("");
		screen.setLineWrap(true);
		txtResult = new JTextArea("");
		txtResult.setLineWrap(true);
		txtResult.setFont(new Font("Consolas", Font.PLAIN, 35));
		screen.setFont(new Font("Consolas", Font.PLAIN, 30));
		screen.setEditable(false);
		txtResult.setEditable(false);
		
//		if(screen.getCaretPosition()>screen.getWidth()) {
//			screen.setCaretPosition(screen.getDocument().getLength());
//		}
		screen.setCaretPosition(screen.getDocument().getLength());
		txtResult.setCaretPosition(txtResult.getDocument().getLength());
		
		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"1");
			}
		});
		
		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"2");
			}
		});
		
		JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"3");
			}
		});
		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"4");
			}
		});
		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"5");
			}
		});
		JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"6");
			}
		});
		JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"7");
			}
		});
		JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"8");
			}
		});
		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"9");
			}
		});
		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"0");
			}
		});
		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"+");
			}
		});
		JButton buttonMinus = new JButton("-");
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"-");
			}
		});
		JButton buttonBy = new JButton("*");
		buttonBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"*");
			}
		});
		JButton buttonDivision = new JButton("/");
		buttonDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"/");
			}
		});
		JButton buttonRemove = new JButton("<");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!screen.getText().equals("")) screen.setText(screen.getText().substring(0, screen.getText().length()-1));
			}
		});
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText("");
			}
		});
		JButton buttonEqual = new JButton("=");
		buttonEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!screen.getText().equals("")) solve();
			}
		});
		JButton buttonOpenPar = new JButton("(");
		buttonOpenPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"(");
			}
		});
		JButton buttonClosePar = new JButton(")");
		buttonClosePar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+")");
			}
		});
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+".");
			}
		});
		
		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+"E");
			}
		});
		String j = "<html>x<sup>y</sup></html>";
		JButton buttonExp = new JButton(j);
		buttonExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				exp.setVisible(true);
			}
		});
		
		JButton btnResult = new JButton("Result");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText()+txtResult.getText());
			}
		});
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(screen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button1)
											.addGap(18)
											.addComponent(button2)
											.addGap(18)
											.addComponent(button3))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button4)
											.addGap(18)
											.addComponent(button5)
											.addGap(18)
											.addComponent(button6))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button7)
											.addGap(18)
											.addComponent(button8)
											.addGap(18)
											.addComponent(button9))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button0)
											.addGap(18)
											.addComponent(btnResult)))
									.addGap(83)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(buttonBy, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(buttonRemove, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
													.addComponent(buttonEqual, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
											.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(buttonPlus, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(buttonMinus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buttonExp, 0, 0, Short.MAX_VALUE)
										.addComponent(buttonDivision, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buttonClosePar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buttonOpenPar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
								.addComponent(txtResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(179)
							.addComponent(btnInfo)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(screen, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInfo)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button1)
						.addComponent(button2)
						.addComponent(button3)
						.addComponent(buttonPlus)
						.addComponent(buttonOpenPar)
						.addComponent(buttonMinus))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button4)
						.addComponent(button5)
						.addComponent(button6)
						.addComponent(buttonBy)
						.addComponent(buttonDivision)
						.addComponent(buttonClosePar))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button7)
						.addComponent(button8)
						.addComponent(button9)
						.addComponent(buttonRemove)
						.addComponent(btnC)
						.addComponent(btnDot))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonEqual)
						.addComponent(buttonExp)
						.addComponent(btnResult)
						.addComponent(button0)
						.addComponent(btnE, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtResult, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
