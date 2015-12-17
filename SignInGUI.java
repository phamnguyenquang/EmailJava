import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignInGUI extends JFrame {
	private String[] arrMailHost = { "gmail.com", "stud.fra-uas.de", "others" };
	private JLabel namelabel = new JLabel("Username");
	private JLabel emaillabel = new JLabel("Email Address");
	private JLabel passwordlabel = new JLabel("Password");
	private JLabel info = new JLabel("");
	private JTextField name = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JPasswordField password = new JPasswordField(20);
	private JButton yes = new JButton("Yes");
	private JButton reset = new JButton("Reset");

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
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		panel.add(yes, c);
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = email.getText();
				//char[] pass = password.getPassword();
				String passString = new String (password.getPassword());
				Email test = new Email(user,passString);
				test.checkEmail();
				
			}
		});
		c.gridx = 2;
		panel.add(reset, c);
		c.gridx = 0;
		c.ipadx = 120;
		panel.add(info, c);
		return panel;
	}

	private JComboBox<String> createComboBox(String[] arrItem) {
		JComboBox<String> cb = new JComboBox<String>(arrItem);
		return cb;
	}
	
}
