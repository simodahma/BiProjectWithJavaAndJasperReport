import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTree;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Menu extends JFrame {

	private JPanel contentPane;
	static Menu frame;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//frame.setVisible(false);
				GestionEtudiant newFrame = new GestionEtudiant();
				newFrame.setVisible(true);
				Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
		        int iCoordX = (objDimension.width - newFrame.getWidth()) / 2;
		        int iCoordY = (objDimension.height - newFrame.getHeight()) / 2;
		        newFrame.setLocation(iCoordX,iCoordY); 
				DataBase.loadComboBox(GestionEtudiant.comboBox);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/student.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(54, 161, 80, 94);
		contentPane.add(lblNewLabel);
		
		JLabel lblGestionDesEtudiants = new JLabel("Gestion Des Etudiants");
		lblGestionDesEtudiants.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		lblGestionDesEtudiants.setBounds(35, 252, 156, 14);
		contentPane.add(lblGestionDesEtudiants);
		
		JLabel labelfiliere = new JLabel("");
		labelfiliere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
 				Filière newFrame = new Filière();
				newFrame.setVisible(true);
				Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
		        int iCoordX = (objDimension.width - newFrame.getWidth()) / 2;
		        int iCoordY = (objDimension.height - newFrame.getHeight()) / 2;
		        newFrame.setLocation(iCoordX, iCoordY); 
				
			}
		});
		Image imgg = new ImageIcon(this.getClass().getResource("/et.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		labelfiliere.setIcon(new ImageIcon(imgg));
		labelfiliere.setBounds(242, 161, 98, 94);
		contentPane.add(labelfiliere);
		
		JLabel label_1 = new JLabel("Gestion Des Filières");
		label_1.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		label_1.setBounds(230, 252, 156, 14);
		contentPane.add(label_1);
 
		
		JLabel labelrapport = new JLabel("");
		labelrapport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				try {

					if ((new File("./Blank_A4.pdf")).exists()) {
						System.out.println("Done");

						Process p = Runtime
						   .getRuntime()
						   .exec("rundll32 url.dll,FileProtocolHandler "+getClass().getResource("./Blank_A4.pdf"));
						p.waitFor();
							
					} else {

						System.out.println("File is not exists");

					}
	  } catch (Exception ex) {
					ex.printStackTrace();
				  }
	            
			}
		});
		Image imgr = new ImageIcon(this.getClass().getResource("/rapport.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		labelrapport.setIcon(new ImageIcon(imgr));
		labelrapport.setBounds(428, 155, 85, 100);
		contentPane.add(labelrapport);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image imgi = new ImageIcon(this.getClass().getResource("/icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(imgi));
		lblNewLabel_1.setBounds(382, 11, 52, 61);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Gestion Des Rapports");
		label.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		label.setBounds(413, 252, 156, 14);
		contentPane.add(label);
		
		JLabel lblGestionDesEtudiants_1 = new JLabel("Gestion Des Rapports");
		lblGestionDesEtudiants_1.setForeground(new Color(255, 204, 0));
		lblGestionDesEtudiants_1.setFont(new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 21));
		lblGestionDesEtudiants_1.setBounds(189, 11, 183, 61);
		contentPane.add(lblGestionDesEtudiants_1);
		Image imgc = new ImageIcon(this.getClass().getResource("/cadre.png")).getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		
		
		JLabel exit = new JLabel("");
		Image imge = new ImageIcon(this.getClass().getResource("/exit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(imge));
		exit.setBounds(514, 409, 40, 41);
		contentPane.add(exit);
 
		
 	}
}
