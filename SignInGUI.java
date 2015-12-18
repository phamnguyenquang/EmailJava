package email_client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class SignInGUI extends JFrame {

	private JLabel namelabel = new JLabel("Username");
	private JLabel emaillabel = new JLabel("Email Address");
	private JLabel passwordlabel = new JLabel("Password");
	private JLabel rememberlabel = new JLabel("Remember me?");
	private JTextField name = new JTextField(30);
	private JTextField email = new JTextField(30);
	private JPasswordField password = new JPasswordField(20);
	private JCheckBox remember = new JCheckBox();

	private AbstractAction resetAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			name.setText("");
			email.setText("");
			password.setText("");
		}
	};

	private AbstractAction loginAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO: Add login function
		}
	};

	private JButton createLoginButton() {
		JButton login = new JButton("L");
		login.addActionListener(loginAction);
		return login;
	}

	private JButton createResetButton() {
		JButton reset = new JButton("R");
		reset.addActionListener(resetAction);
		return reset;
	}

	public SignInGUI() {
		add(createMainPanel());
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridwidth = 3;
		panel.add(namelabel, c);
		c.gridy = 1;
		panel.add(name, c);
		c.gridy = 2;
		panel.add(emaillabel, c);
		c.gridy = 3;
		panel.add(email, c);
		c.gridy = 4;
		panel.add(passwordlabel, c);
		c.gridy = 5;
		panel.add(password, c);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		panel.add(createRememberPanel(), c);
		c.gridx = 1;
		panel.add(createLoginButton(), c);
		c.gridx = 2;
		panel.add(createResetButton(), c);
		return panel;
	}

	private JPanel createRememberPanel() {
		JPanel rememberpanel = new JPanel(new GridLayout());
		rememberpanel.add(rememberlabel);
		rememberpanel.add(remember);
		return rememberpanel;
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		new SignInGUI();
		new InboxGUI();
	}
}
