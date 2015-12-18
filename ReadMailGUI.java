package email_client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ReadMailGUI extends JFrame {
	private JLabel fromlabel = new JLabel("From :");
	private JLabel sender = new JLabel("<sender email>");
	private JLabel tolabel = new JLabel("To :");
	private JLabel receiver = new JLabel("<receiver email>");
	private JLabel subjectlabel = new JLabel("Subject :");
	private JLabel mailsubject = new JLabel("<email subject>");

	private AbstractAction replyAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add reply function
		}
	};

	private AbstractAction forwardAction = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add forward function
		}
	};

	private AbstractAction deleteAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add delete function
		}

	};

	private JButton createReplyButton() {
		JButton button = new JButton("Reply");
		button.addActionListener(replyAction);
		return button;
	};

	private JButton createForwardButton() {
		JButton button = new JButton("Forward");
		button.addActionListener(forwardAction);
		return button;
	}

	private JButton createDeleteButton() {
		JButton button = new JButton("Delete");
		button.addActionListener(deleteAction);
		return button;
	}

	private JTextArea createContentBox() {
		JTextArea content = new JTextArea();
		content.setEditable(false);
		content.setText("Example");
		return content;
	}

	private JPanel createButtonPanel() {
		JPanel buttonpanel = new JPanel(new GridLayout());
		buttonpanel.add(createReplyButton());
		buttonpanel.add(createForwardButton());
		buttonpanel.add(createDeleteButton());
		return buttonpanel;
	}

	public ReadMailGUI() {
		add(createMainPanel());
		setTitle("<mail subject>");
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
		panel.add(fromlabel, c);
		c.gridy = 1;
		panel.add(tolabel, c);
		c.gridy = 2;
		panel.add(subjectlabel, c);
		c.ipadx = 260;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(sender, c);
		c.gridy = 1;
		panel.add(receiver, c);
		c.gridy = 2;
		panel.add(mailsubject, c);
		c.gridy = 0;
		c.gridx = 3;
		c.gridheight = 3;
		c.ipady = 30;
		c.ipadx = 90;
		panel.add(createButtonPanel(), c);
		c.gridy = 2;
		c.gridx = 0;
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 6;
		c.gridheight = 5;
		c.ipady = 300;
		c.ipadx = 590;
		panel.add(new JScrollPane(createContentBox()), c);
		return panel;
	}
}
