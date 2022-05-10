package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ExpGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtExp;
	private JButton btnOk = new JButton("OK");
	
	private JRadioButton rdbtnPower = new JRadioButton("Power");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnRoot = new JRadioButton("Root");
	private double result;
	private double num;
	private double exp;
	
	public double getRes() {
		return result;
	}
	/**
	 * Create the frame.
	 */
	public ExpGUI(CalculatorGUI calcGUI) {
		try 
        {
            setIconImage(Toolkit.getDefaultToolkit().getImage("icon/calculator.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(false);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setTitle("Pow | Root");
		setBounds(100, 100, 494, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		buttonGroup.add(rdbtnPower);
		buttonGroup.add(rdbtnRoot);
		txtNum = new JTextField();
		txtNum.setColumns(10);
		btnOk.setEnabled(true);		
		getRootPane().setDefaultButton(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					num = Double.parseDouble(txtNum.getText().toString());
//					exp = Double.parseDouble(txtExp.getText().toString());
					
					if(rdbtnRoot.isSelected()) calcGUI.actionAddSymbol(String.format("Math.sqrt(%s,%s)", txtNum.getText(),txtExp.getText())); //result = Math.pow(num, 1/exp);				
					else calcGUI.actionAddSymbol(String.format("Math.pow(%s,%s)", txtNum.getText(),txtExp.getText())); //result = Math.pow(num, exp);
					//calcGUI.actionAddSymbol(Double.toString(result));
					txtExp.setText("");
					txtNum.setText("");
					btnOk.setEnabled(true);
					setVisible(false);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(),"An error occurred\n"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
					txtExp.setText("");
					txtNum.setText("");
				}
				

			}
		});
		
		txtExp = new JTextField();
		txtExp.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		
		JLabel lblToThePower = new JLabel("to the power of");
		
		
		rdbtnRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumber.setText("");
				lblToThePower.setText("root");
							
			}
		});
		
		rdbtnPower.setSelected(true);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumber)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnPower, Alignment.TRAILING)
						.addComponent(txtNum, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOk)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblToThePower)
									.addGap(18)
									.addComponent(txtExp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addComponent(rdbtnRoot)))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		rdbtnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblToThePower.setText("to the power of");
				lblNumber.setText("Number ");
			}
		});
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPower)
						.addComponent(rdbtnRoot))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumber)
						.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblToThePower)
						.addComponent(txtExp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnOk)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
