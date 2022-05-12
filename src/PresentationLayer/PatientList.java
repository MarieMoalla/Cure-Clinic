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
import java.sql.PreparedStatement;
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

import DataAccessLayer.DBConnection;
import DataAccessLayer.Main;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class PatientList extends JFrame {

	private JPanel contentPane;
	private JTable table = new JTable();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientList frame = new PatientList();
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
			setTitle("Patients");
			setForeground(Color.DARK_GRAY);
			setBackground(Color.DARK_GRAY);
			setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hostel.png"));
			setBounds(100, 100, 1064, 559);
			
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
		
		JLabel AJOUTMEDECIN = new JLabel("Patients");
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
		content.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 960, 305);
			content.add(scrollPane);
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
						"ID","First Name", "Last Name", "maladie","Age","Telephone","LitId","Medecin Id"
					}
				));
				//table.getColumnModel().getColumn(3).setPreferredWidth(56);
				scrollPane.setViewportView(table);
			}
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 970, 49);
				content.add(panel);
				panel.setLayout(null);
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
									ajoutPatientButtonMousePressed(evt);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
	         });
				}	
					
					
					
					JButton deleteBtn = new JButton();
					deleteBtn.setBounds(794, 10, 176, 39);
					panel.add(deleteBtn);
					deleteBtn.setBackground(new Color(255, 182, 193));
					deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
					deleteBtn.setFont(new Font("Poppins Medium", Font.BOLD, 20));
					deleteBtn.setText("DELETE");
					deleteBtn.setToolTipText("\r\n");
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
					{
						JButton submit = new JButton("New button");
						submit.setBounds(608, 10, 176, 39);
						submit.setFont(new Font("Poppins Medium", Font.BOLD, 20)); // NOI18N
						submit.setForeground(new java.awt.Color(255, 255, 255));
						submit.setIcon(new ImageIcon(AjoutChambreFrom.class.getResource("/assets/btn300x60.png"))); // NOI18N
						submit.setText("Update");
						submit.setBorder(null);
						submit.setBorderPainted(false);
						submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
						submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
						//btnNewButton.setPreferredSize(new Dimension(260, 140));
						submit.setSelectedIcon(new ImageIcon(AjoutChambreFrom.class.getResource("/assets/btn300x60.png")));
						submit.addMouseListener(new java.awt.event.MouseAdapter() {
					        public void mousePressed(java.awt.event.MouseEvent evt) {
					            try {
					            	updateButtonMousePressed(evt);
								} 
								catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        }
					    });
						panel.add(submit);
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
		String patientQuery = "select * from Lit where id="+table.getModel().getValueAt(row, 6)+" and PatientId="+table.getModel().getValueAt(row, 0);
	    Statement statement = conn.createStatement();
	    
		ResultSet res = statement.executeQuery(patientQuery);
		
	//	if (res.next())  JOptionPane.showMessageDialog(null, "Pient is already taking care of his patient you cant remove him", "Action Denied", 0);
	//	else 
	//	{
		if (res.next()) {
			
			
			String deletelitQuery = "UPDATE lit SET Patientid =NULL WHERE PatientId="+table.getModel().getValueAt(row, 0);
		    Statement statement1 = conn.createStatement();
		    statement1.executeUpdate(deletelitQuery);
		    
		    String deletepatientQuery = "delete from patient where id="+table.getModel().getValueAt(row, 0);
		    Statement statement2 = conn.createStatement();
		    statement2.executeUpdate(deletepatientQuery);
		}else {
			 String deletepatientQuery = "delete from patient where id="+table.getModel().getValueAt(row, 0);
			    Statement statement2 = conn.createStatement();
			    statement2.executeUpdate(deletepatientQuery);
		}
			//ResultSet res2 = statement2.executeQuery(deleteQuery);
			ImageIcon icon = new ImageIcon("src/asstes/checked.png");
			JOptionPane.showMessageDialog(null, "Patient Successfully deleted!", "Done", 1,icon);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	

	public void updateButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception
	{
		int row = table.getSelectedRow();
		System.out.println("selected row to update"+table.getModel().getValueAt(row, 0));
		
		Connection conn = Main.getConnection();
		String patientQuery = "update patient set firstname=?,lastname=?,Maladie=?,age=?,telephone=? where id="+table.getModel().getValueAt(row, 0);
	    PreparedStatement  statement = DBConnection.connect().prepareStatement(patientQuery);
	    
	    statement.setString(1, table.getModel().getValueAt(row, 1).toString()); 
	    statement.setString(2, table.getModel().getValueAt(row, 2).toString()); 
	    statement.setString(3, table.getModel().getValueAt(row, 3).toString()); 
	    statement.setString(4, table.getModel().getValueAt(row, 4).toString()); 
	    statement.setString(5, table.getModel().getValueAt(row, 5).toString()); 
	    
	    statement.executeUpdate();
	    JOptionPane.showMessageDialog(null, "patient info updated!", "Updated", 1,null);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    
	}
	
//	}
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
		String allQuery = "select * from patient";
	    Connection conn = Main.getConnection();
	    Statement statement = conn.createStatement();
		ResultSet res = statement.executeQuery(allQuery);
		
		while(res.next())
		{	
			
			int id = res.getInt("id");
			//String patientQuery = "select * from patient where medecinid="+id;
		  //  Statement statement2 = conn.createStatement();
		//	ResultSet res2 = statement2.executeQuery(patientQuery);
		//	String patientList ="";
		//	if(res2 != null)
		//	{
		//		while(res2.next())
		//		{
		//			patientList = patientList+ res2.getString("id");
	//				patientList = patientList+" & ";
		//		}
	//		} 
			String fn = res.getString("FirstName");
			String ln = res.getString("LastName");
			String age = res.getString("Age");
			String m = res.getString("Maladie");
			String tel = res.getString("Telephone");
			String lit = res.getString("LitId");
			String med = res.getString("MedecinId");
			
			
			String tabData[] = {Integer.toString(id),fn,ln,m,age,tel,lit,med};
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			tblModel.addRow(tabData);
		}	
		
		

		
	}
	private void ajoutPatientButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {

		 AjoutPatientForm frame = new AjoutPatientForm();
	    frame.setVisible(true);
	           

	}
	
	public PatientList() throws Exception {
		initComponent();
		header();
		content();
		left();
		right();
	}

}
