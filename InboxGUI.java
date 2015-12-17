

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class InboxGUI extends JFrame {
	private JLabel hellolabel = new JLabel("Hello");
	private JLabel name = new JLabel("<username>");
	private JButton refreshbutton = new JButton("Refresh");
	private JButton composebutton = new JButton("Compose");
	private JButton deletebutton = new JButton("Delete");
	private JButton signoutbutton = new JButton("Sign out");
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("<mail address>");
	private DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
	private DefaultMutableTreeNode sent = new DefaultMutableTreeNode("Sent");
	private DefaultMutableTreeNode outbox = new DefaultMutableTreeNode("Outbox");
	private DefaultMutableTreeNode draft = new DefaultMutableTreeNode("Draft");
	private DefaultMutableTreeNode trash = new DefaultMutableTreeNode("Trash");
	
	TableModel model = new AbstractTableModel() {

		private String[] column = { "Check", "Read", "Subject", "From", "Date" };
		private Object[][] data = {
				{ new Boolean(true), new Boolean(true), "Mail Subject", "someone@host", "2010-11-18" } };

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

		      public Class getColumnClass(int columnIndex) {
		        return (getValueAt(0, columnIndex).getClass());
		      }
		    };

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
		c.ipady = 30;
		panel.add(hellolabel, c);
		c.gridx = 1;
		c.ipadx = 30;
		panel.add(name, c);
		c.gridx = 2;
		panel.add(refreshbutton, c);
		c.gridx = 3;
		panel.add(composebutton, c);
		c.gridx = 4;
		panel.add(deletebutton, c);
		c.gridx = 5;
		panel.add(signoutbutton, c);
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipadx = 0;
		JTree tree = createMailTree();
		panel.add(tree, c);
		panel.add(new JScrollPane(tree), c);
		c.gridx = 2;
		c.gridwidth = 4;
		JTable table = createMailTable();
		panel.add(new JScrollPane(table), c);
		return panel;
	}

	private JTree createMailTree() {
		JTree tree = new JTree(root);
		root.add(inbox);
		root.add(sent);
		root.add(outbox);
		root.add(draft);
		root.add(trash);
		return tree;
	}

	private JTable createMailTable() {
		JTable table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				if(column == 0 || column == 1) return true;
				else return false;
				}
		};
		table.setRowSelectionAllowed(true);
		return table;
	}

}
