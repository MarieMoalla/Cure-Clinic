package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.util.StringUtils;

import DataAccessLayer.Main;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class LitList extends JFrame {

	private JPanel contentPane;
	private JTable table = new JTable();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LitList frame = new LitList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponent()
		{
			setFont(new Font("Poppins Medium", Font.PLAIN, 12));
			setTitle("Lits");
			setForeground(Color.DARK_GRAY);
			setBackground(Color.DARK_GRAY);
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hostel.png"));
			setBounds(100, 100, 1004, 559);
			
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.control);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(10, 5));
			setContentPane(contentPane);
		}
	
	public void header()
	{
		JPanel header = new JPanel();
		header.setToolTipText("");
		header.setBackground(new java.awt.Color(60, 185, 145));
		FlowLayout fl_header = (FlowLayout) header.getLayout();
		fl_header.setHgap(0);
		fl_header.setVgap(10);
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel AJOUTMEDECIN = new JLabel("Lits");
		AJOUTMEDECIN.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\medical-team.png"));
		AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
		AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 30));
		AJOUTMEDECIN.setForeground(Color.WHITE);
		AJOUTMEDECIN.setBackground(Color.WHITE);
		header.add(AJOUTMEDECIN);

	}	
	
	public void content() throws Exception
	{
		JPanel content = new JPanel();
		contentPane.add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(5, 5));
		{
			JScrollPane scrollPane = new JScrollPane();
			content.add(scrollPane, BorderLayout.CENTER);
			{
				
				table.setFillsViewportHeight(true);
				table.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				table.setBackground(new Color(230, 230, 250));
				table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				table.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
				table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				table.setGridColor(new java.awt.Color(102, 102, 102));
				table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						
					},
					new String[] {
						"ID","¨PatientId", "ChambreId"
					}
				));
				//table.getColumnModel().getColumn(3).setPreferredWidth(56);
				scrollPane.setViewportView(table);
			}
			{
				JPanel panel = new JPanel();
				content.add(panel, BorderLayout.NORTH);
				{
					
					{
						JButton addBtn = new JButton();
						addBtn.setBounds(422, 10, 176, 39);
						panel.add(addBtn);
						addBtn.setBackground(new Color(115, 147, 179));
						addBtn.setForeground(new java.awt.Color(255, 255, 255));
						addBtn.setFont(new Font("Poppins Medium", Font.BOLD, 20));
						addBtn.setText("ADD");
						addBtn.setToolTipText("\r\n");
						addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
					     
						public void mousePressed(java.awt.event.MouseEvent evt) {
				            	try {
									ajoutLitButtonMousePressed(evt);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
	         });
				}	
					
					{	
					JButton deleteBtn = new JButton();
					panel.add(deleteBtn);
					deleteBtn.setBackground(new Color(255, 182, 193));
					deleteBtn.setForeground(new java.awt.Color(255, 255, 255));

					deleteBtn.setFont(new Font("Poppins SemiBold", Font.BOLD,20));
					deleteBtn.setText("DELETE");
					deleteBtn.setToolTipText("Clear");
					deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
				        public void mousePressed(java.awt.event.MouseEvent evt) {
				            try {
								deleteButtonMousePressed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        }
				    });
				}
				}
			}
			getList();
			
		}

	}
	public void deleteButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception
	{
		int row = table.getSelectedRow();
		System.out.println(table.getModel().getValueAt(row, 0));
		
		Connection conn = Main.getConnection();
		String patientQuery = "select * from patient where litId="+table.getModel().getValueAt(row, 0);
	    Statement statement = conn.createStatement();
	    
		ResultSet res = statement.executeQuery(patientQuery);
		if (res.next())  JOptionPane.showMessageDialog(null, "Lit déja occupé par un patient vous ne pouvez pas le supprimer", "Action Denied", 0);
		else 
		{
			String deleteQuery = "delete from Lit where id="+table.getModel().getValueAt(row, 0);
		    Statement statement2 = conn.createStatement();
		    statement2.executeUpdate(deleteQuery);
			//ResultSet res2 = statement2.executeQuery(deleteQuery);
			ImageIcon icon = new ImageIcon("src/asstes/checked.png");
			JOptionPane.showMessageDialog(null, "Lit Successfully deleted!", "Done", 1,icon);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	public void left()
	{
		JPanel left = new JPanel();
		FlowLayout fl_left = (FlowLayout) left.getLayout();
		fl_left.setHgap(10);
		contentPane.add(left, BorderLayout.WEST);
	}
	
	public void right()
	{
		JPanel right = new JPanel();
		FlowLayout flowLayout = (FlowLayout) right.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(right, BorderLayout.EAST);
	}
	
	public void getList() throws Exception
	{
		String allQuery = "select * from Lit";
	    Connection conn = Main.getConnection();
	    Statement statement = conn.createStatement();
		ResultSet res = statement.executeQuery(allQuery);
		
		while(res.next())
		{	
			
			int id = res.getInt("id");
			String pi = res.getString("PatientId");
			String ci = res.getString("ChambreId");
			String tabData[] = {Integer.toString(id),pi,ci};
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			tblModel.addRow(tabData);
		}	
		
		

		
	}
	
	private void ajoutLitButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {

		 AjoutLitForm frame = new AjoutLitForm();
	    frame.setVisible(true);
	           

	}
	public LitList() throws Exception {
		initComponent();
		header();
		content();
		left();
		right();
	}

}
