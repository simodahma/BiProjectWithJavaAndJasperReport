import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import javax.swing.JTable;


public class GestionEtudiant extends JFrame {
 
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private javax.swing.JTextField status;
	private JLabel stdparcourir;
	static GestionEtudiant frame;
	JTextField path;
	private static final int baseSize = 1000;
	private static final String basePath ="/Desktop/";
	File targetFile;
	BufferedImage targetImg;
	ImageIcon icon;
	static JComboBox comboBox;
	private JTextField textField_5;
	private JTable table;
 /* 
	 * Launch the application.
	 */
	public ImageIcon ResizeImage(String ImagePath)
	{
	    ImageIcon MyImage = new ImageIcon(ImagePath);
	    Image img = MyImage.getImage();
	    Image newImg = img.getScaledInstance(stdparcourir.getWidth(), stdparcourir.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon image = new ImageIcon(newImg);
	    return image;
	}
	public void Browse()
	{
		  JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              stdparcourir.setIcon(ResizeImage(path));
              
          }
	}
         
	 
	/**
	 * Create the frame.
	 */
	public GestionEtudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 512);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		textField.setBounds(64, 114, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		lblNom.setBounds(64, 97, 46, 14);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		textField_1.setBounds(64, 167, 135, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		lblPrnom.setBounds(64, 154, 71, 14);
		contentPane.add(lblPrnom);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		textField_2.setBounds(64, 222, 135, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCodeNational = new JLabel("Code National:");
		lblCodeNational.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		lblCodeNational.setBounds(64, 208, 104, 14);
		contentPane.add(lblCodeNational);
		
	 
		
		JButton btnNewButton = new JButton("Parcourir ...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 
				Browse();
				
			}
		});
		btnNewButton.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setBounds(230, 199, 135, 23);
		contentPane.add(btnNewButton);
 
		
	  
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(64, 278, 135, 20);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("Note Génerale:");
		label.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		label.setBounds(64, 264, 104, 14);
		contentPane.add(label);
		
		  stdparcourir = new JLabel("");
 	 		Image imgst = new ImageIcon(this.getClass().getResource("/pop.png")).getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT);
			stdparcourir.setIcon(new ImageIcon(imgst));
			stdparcourir.setBounds(230, 85, 135, 102);
			contentPane.add(stdparcourir);
			
		JTextArea textArea = new JTextArea();
		textArea.setBounds(89, 359, 4, 22);
		contentPane.add(textArea);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(153, 204, 255));
		comboBox.setBounds(64, 335, 135, 20);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("Filière:");
		label_1.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		label_1.setBounds(64, 319, 104, 14);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Spinnaker", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(229, 278, 135, 20);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Note National:");
		label_2.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		label_2.setBounds(229, 264, 104, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				    Menu frame = new Menu();
					//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"))); 		
					Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
			        int iCoordX = (objDimension.width - frame.getWidth()) / 2;
			        int iCoordY = (objDimension.height - frame.getHeight()) / 2;
			        frame.setLocation(iCoordX, iCoordY); 
					frame.setVisible(true);
			}
		});
		Image imgre = new ImageIcon(this.getClass().getResource("/retour.png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		label_3.setIcon(new ImageIcon(imgre));
		label_3.setBounds(10, 0, 54, 56);
 		contentPane.add(label_3);
		
 	   
 		JLabel lblGestionDeFilieres = new JLabel("GESTION DES ETUDIANTS");
 		lblGestionDeFilieres.setForeground(new Color(147, 112, 219));
  		lblGestionDeFilieres.setFont(new Font("Spinnaker", Font.PLAIN, 17));
  		lblGestionDeFilieres.setBounds(220, 43, 253, 14);
  		contentPane.add(lblGestionDeFilieres);
  		
 		JLabel enr = new JLabel("");
 		enr.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent arg0) {
 				
 				DataBase.OpenConnexion();
				try 
				{
					DataBase.AjouterEtudiant(textField.getText(),textField_1.getText(),textField_2.getText(),Float.parseFloat(textField_3.getText()),Float.parseFloat(textField_4.getText()),comboBox.getSelectedItem().toString());
					GUI g = new GUI();
					JOptionPane.showMessageDialog(g,"Données Enregistrés");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				
 				
 				
 				
 				
 				
 				
 				
 				
 			}
 		});
		Image enrr = new ImageIcon(this.getClass().getResource("/savee.png")).getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
		enr.setIcon(new ImageIcon(enrr));
		enr.setBounds(279, 383, 104, 41);
 		contentPane.add(enr);
 		
 		JLabel cdr = new JLabel("");
		Image cdrr = new ImageIcon(this.getClass().getResource("/cdr.png")).getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		cdr.setIcon(new ImageIcon(cdrr));
		cdr.setBounds(26, 27, 399, 407);
 		contentPane.add(cdr);
 		
 		 path = new JTextField();
  		path.setBounds(240, 222, 86, 20);
  		contentPane.add(path);
  		path.setColumns(10);
  		
  		
  		
  		table = new JTable();
  		table.setBounds(471, 127, 263, 280);
  		contentPane.add(table);
  		
  		
 		
 		
 		 
		
	}
}
