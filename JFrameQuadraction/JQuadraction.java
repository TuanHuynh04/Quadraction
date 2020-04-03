package JFrameQuadraction;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import j_option_pane.Quadratic;

public class JQuadraction extends JFrame implements ActionListener,ItemListener,KeyListener,MouseListener{
	private int count;
	private JLabel lbTitle,lbA,lbB,lbC,lbResults;
	private JTextField txtA,txtB,txtC;
	private JTextArea txtResults;
	private JButton btnSolve,btnReset,btnExit;
	private JPanel pA,pB,pC,pResults,pButton,pRb,pTitle;
	private JRadioButton rb1,rb2;
	/**
	 * 
	 */
	public JQuadraction() {
		//1.thiet lap cho Frame
		super("Solving equations");
		super.setSize(500, 500);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//super.setVisible(true);
		super.show();
		super.setLayout(new GridLayout(8,2));
		Font font = new Font("Tahoma", Font.BOLD, 22);
		FlowLayout layout = new FlowLayout();
	    layout.setHgap(20);              
	    layout.setVgap(20);
		//2.Tao cac panels chua cac components
		pA = new JPanel(new FlowLayout());
		pB = new JPanel(new FlowLayout());
		pC = new JPanel(new FlowLayout());
		pResults = new JPanel(new FlowLayout());
		pButton = new JPanel(new FlowLayout());
		pButton.setLayout(layout);
		pRb = new JPanel(new FlowLayout());
		pTitle = new JPanel(new FlowLayout());
		
		//3.Them cac components vao panel
		lbTitle = new JLabel("Tier 1 Equations And Step Equations 2");
		lbTitle.setFont(font);
		lbTitle.setForeground(Color.pink);
		pTitle.add(lbTitle);
		super.add(pTitle);
		
		rb1 = new JRadioButton("Quadratic Equation");
		rb1.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,16));
		rb1.setForeground(Color.PINK);
		rb2 = new JRadioButton("Linear Equation");
		rb2.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,16));
		rb2.setForeground(Color.PINK);
		pRb.add(rb1); pRb.add(rb2); 
		//Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rb1);
	    group.add(rb2);
		super.add(pRb);
		
		lbA = new JLabel("Enter factor a");
		lbA.setFont(new Font("Courier New",Font.BOLD,14));
		lbA.setForeground(Color.PINK);
		txtA = new JTextField(10);
		txtA.setBackground(Color.LIGHT_GRAY);
		pA.add(lbA); pA.add(txtA);
		super.add(pA);
		
		lbB = new JLabel("Enter factor b");
		lbB.setFont(new Font("Courier New",Font.BOLD,14));
		lbB.setForeground(Color.PINK);
		txtB = new JTextField(10);
		txtB.setBackground(Color.LIGHT_GRAY);
		pB.add(lbB); pB.add(txtB);
		super.add(pB);
		
		lbC = new JLabel("Enter factor c");
		lbC.setFont(new Font("Courier New",Font.BOLD,14));
		lbC.setForeground(Color.PINK);
		txtC = new JTextField(10);
		txtC.setBackground(Color.LIGHT_GRAY);
		pC.add(lbC); pC.add(txtC);
		super.add(pC);
		
		lbResults = new JLabel("Results");
		lbResults.setFont(new Font("Courier New",Font.BOLD,16));
		lbResults.setForeground(Color.PINK);
		txtResults = new JTextArea(4,24);
		txtResults.setBackground(Color.LIGHT_GRAY);
		pResults.add(lbResults); pResults.add(txtResults);
		super.add(pResults);
		
		btnSolve = new JButton("Solve");
		btnSolve.setFont(new Font("Courier New",Font.BOLD,13));
		btnSolve.setForeground(Color.PINK);
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Courier New",Font.BOLD,13));
		btnReset.setForeground(Color.PINK);
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Courier New",Font.BOLD,13));
		btnExit.setForeground(Color.PINK);
		pButton.add(btnSolve); pButton.add(btnReset); pButton.add(btnExit);
		super.add(pButton);
		//4. Dang ki su kien
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		
		btnSolve.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		txtA.addKeyListener(this);
		txtB.addKeyListener(this);
		txtC.addKeyListener(this);
		txtResults.addKeyListener(this);
		btnSolve.addKeyListener(this);
		
		txtResults.addMouseListener(this);
		
	}
	public static void main(String[] args) {
		JQuadraction gui = new JQuadraction();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem() == rb1 ) {
			count = 1;
			lbA.setVisible(true);
			txtA.setVisible(true);
		}
		else 
			if(e.getItem() == rb2) {
				count = 2;
				lbA.setVisible(false);
				txtA.setVisible(false);
			}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit) {
			System.exit(0);
		}
		else 
			if(e.getSource() == btnReset) {
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
				txtResults.setText("");
			}
			else
				if(e.getSource() == btnSolve && count == 1) {
					int a = Integer.parseInt(txtA.getText());
					int b = Integer.parseInt(txtB.getText());
					int c = Integer.parseInt(txtC.getText());
					Quadratic s1 = new Quadratic(a,b,c);
					String s = s1.solve();
					txtResults.setText(s);
				}
				else 
					if(e.getSource() == btnSolve && count == 2) {
						int b = Integer.parseInt(txtB.getText());
						int c = Integer.parseInt(txtC.getText());
						LinearEquation s2 = new LinearEquation(b,c);
						String s = s2.solve();
						txtResults.setText(s);
						
					}
			}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == txtA)
			if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
				txtB.requestFocus();
			}
		if(e.getSource() == txtB)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtC.requestFocus();
			}
		if(e.getSource() == txtC) {
			if(count == 1) 
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int a = Integer.parseInt(txtA.getText());
					int b = Integer.parseInt(txtB.getText());
					int c = Integer.parseInt(txtC.getText());
					Quadratic s1 = new Quadratic(a,b,c);
					String s = s1.solve();
					txtResults.setText(s);
				}
			if(count == 2) 
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int b = Integer.parseInt(txtB.getText());
						int c = Integer.parseInt(txtC.getText());
						LinearEquation s2 = new LinearEquation(b,c);
						String s = s2.solve();
						txtResults.setText(s);
					}
			}
	}
			
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == txtResults) {
			String s = "Don't enter this box !!!";
			int a = JOptionPane.showConfirmDialog(null, "Don't enter this box !!!");
			if(a == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Please again!");
				btnSolve.requestFocus();
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
