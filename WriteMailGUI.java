package email_client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WriteMailGUI extends JFrame {
	private JLabel tolabel = new JLabel("To :");
	private JTextField toreceiver = new JTextField(30);
	private JLabel cclabel = new JLabel("CC :");
	private JTextField ccreceiver = new JTextField(30);
	private JLabel bcclabel = new JLabel("BCC :");
	private JTextField bccreceiver = new JTextField(30);
	private JLabel subjectlabel = new JLabel("Subject :");
	private JTextField mailsubject = new JTextField(30);
	private JTextArea content = new JTextArea();

	private AbstractAction resetAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			toreceiver.setText("");
			ccreceiver.setText("");
			bccreceiver.setText("");
			mailsubject.setText("");
			content.setText("");
		}
	};

	private AbstractAction attachAction = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			createAttachment();
		}
	};

	private AbstractAction sendAction = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO: add send mail function
		}
	};

	private JFrame createAttachment() {
		JFrame frame = new JFrame();
		JFileChooser filechooser = new JFileChooser();
		frame.add(filechooser);
		int i = filechooser.showOpenDialog(frame);
		if (i == JFileChooser.APPROVE_OPTION) {
			@SuppressWarnings("unused")
			File f = filechooser.getSelectedFile();
			// file operation
		}
		return frame;
	}

	private JButton createAttachButton() {
		JButton button = new JButton("Attach");
		button.addActionListener(attachAction);
		return button;
	};

	private JButton createResetButton() {
		JButton button = new JButton("Reset");
		button.addActionListener(resetAction);
		return button;
	}

	private JButton createSendButton() {
		JButton button = new JButton("Send");
		button.addActionListener(sendAction);
		return button;
	}

	private JPanel createButtonPanel() {
		JPanel buttonpanel = new JPanel(new GridLayout());
		buttonpanel.add(createSendButton());
		buttonpanel.add(createResetButton());
		buttonpanel.add(createAttachButton());
		return buttonpanel;
	}

	public WriteMailGUI() {
		add(createMainPanel());
		setTitle("Compose");
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
		panel.add(tolabel, c);
		c.gridy = 1;
		panel.add(cclabel, c);
		c.gridy = 2;
		panel.add(bcclabel, c);
		c.gridy = 3;
		panel.add(subjectlabel, c);
		c.gridx = 1;
		c.ipadx = 35;
		c.gridy = 0;
		panel.add(toreceiver, c);
		c.gridy = 1;
		panel.add(ccreceiver, c);
		c.gridy = 2;
		panel.add(bccreceiver, c);
		c.gridy = 3;
		panel.add(mailsubject, c);
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 4;
		c.ipady = 30;
		c.ipadx = 90;
		panel.add(createButtonPanel(), c);
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 6;
		c.ipady = 240;
		c.ipadx = 590;
		panel.add(new JScrollPane(content), c);
		return panel;
	};
}
