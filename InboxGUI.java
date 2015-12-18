package email_client;

import java.awt.Dimension;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class InboxGUI extends JFrame {
	private JLabel name = new JLabel("Hello username@host.com.vn");
	private JTextField search = new JTextField(30);
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("<mail address>");
	private DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
	private DefaultMutableTreeNode sent = new DefaultMutableTreeNode("Sent");
	private DefaultMutableTreeNode outbox = new DefaultMutableTreeNode("Outbox");
	private DefaultMutableTreeNode draft = new DefaultMutableTreeNode("Draft");
	private DefaultMutableTreeNode trash = new DefaultMutableTreeNode("Trash");

	private AbstractAction composeAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new WriteMailGUI();
		}
	};

	private AbstractAction refreshAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add refresh mailbox function
		}
	};

	private AbstractAction deleteAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add delete checked mail function
		}
	};

	private AbstractAction signoutAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add close session function
		}
	};

	private AbstractAction searchAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO add search function
		}
	};

	private JButton createComposeButton() {
		JButton button = new JButton("C");
		button.addActionListener(composeAction);
		return button;
	};

	private JButton createRefreshButton() {
		JButton button = new JButton("R");
		button.addActionListener(refreshAction);
		return button;
	};

	private JButton createDeleteButton() {
		JButton button = new JButton("D");
		button.addActionListener(deleteAction);
		return button;
	};

	private JButton createSignoutButton() {
		JButton button = new JButton("O");
		button.addActionListener(signoutAction);
		return button;
	};

	private JButton createSearchButton() {
		JButton button = new JButton("S");
		button.addActionListener(searchAction);
		return button;
	}

	TableModel model = new AbstractTableModel() {

		private String[] column = { "Check", "Read", "Subject", "From", "Date" };
		private Object[][] data = {
				//TODO add fetched data from mail server
		};

		public int getColumnCount() {
			return column.length;
		}

		public String getColumnName(int columnIndex) {
			return column[columnIndex];
		}

		public int getRowCount() {
			return data.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}

		public Class<?> getColumnClass(int columnIndex) {
			return (getValueAt(0, columnIndex).getClass());
		}

		public void setValueAt(Object arg0, int arg1, int arg2) {
			data[arg1][arg2] = arg0;
		}

		public boolean isCellEditable(int row, int column) {
			if (column == 0 || column == 1)
				return true;
			else
				return false;
		}
	};

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout());
		panel.add(createRefreshButton());
		panel.add(createComposeButton());
		panel.add(createDeleteButton());
		panel.add(createSignoutButton());
		return panel;
	}


	public InboxGUI() {
		add(createMainPanel());
		setTitle("Inbox <mail address>");
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
		panel.add(name, c);
		c.ipadx = 320;
		panel.add(search, c);
		c.ipadx = 0;
		panel.add(createSearchButton(), c);
		c.gridy = 1;
		c.gridx = 0;
		c.ipady = 20;
		panel.add(createButtonPanel(), c);
		c.ipady = 0;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 2;
		panel.add(createMailTree(), c);
		c.gridy = 1;
		c.gridx = 1;
		c.ipadx = 320;
		c.gridheight = 2;
		c.gridwidth = 3;
		panel.add(createMailTable(), c);
		return panel;
	}

	private JScrollPane createMailTree() {
		JTree tree = new JTree(root);
		root.add(inbox);
		root.add(sent);
		root.add(outbox);
		root.add(draft);
		root.add(trash);
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		JScrollPane panel = new JScrollPane(tree);
		panel.setPreferredSize(new Dimension(120, 320));
		return panel;
	}

	private JScrollPane createMailTable() {
		JTable table = new JTable(model);
		table.setRowSelectionAllowed(true);
		JScrollPane panel = new JScrollPane(table);
		panel.setPreferredSize(new Dimension(240, 370));
		return panel;
	}

}
