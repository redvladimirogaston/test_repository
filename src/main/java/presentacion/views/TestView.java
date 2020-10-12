package presentacion.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JButton;

public class TestView extends JFrame {

	private static final long serialVersionUID = -631354745486987852L;

	public static final String INPUT = "input";
	
	public static final String BUTTON = "save";
	
	private JPanel contentPane;
	
	private JTextField textField;
	
	private JButton btnNewButton;

	public TestView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(46, 12, 332, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setName(INPUT);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setBounds(261, 48, 117, 25);
		btnNewButton.setName(BUTTON);
		contentPane.add(btnNewButton);
	}
	
	public void display() {
		setVisible(true);
	}

	public void addSaveAction(ActionListener action) {
		this.btnNewButton.addActionListener(action);
	}

	public String getValue() {
		return this.textField.getText();
	}

	public void addColorInputFocusAction(FocusListener listener) {
		this.textField.addFocusListener(listener);
	}

	public void setColorInputBackground(Color color) {
		this.textField.setBackground(color);
	}
}