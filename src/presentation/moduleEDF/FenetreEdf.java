package presentation.moduleEDF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import metier.moduleEDF.MetierFenetreEdf;

public class FenetreEdf {
	
	private JTextField fournisseur,conso;
	private JLabel labelNom,labelConso,infoConso;
	private JRadioButton p3,p6,p9,p12,p15,p18,p24,p30,p36;
	private JRadioButton hphc,tc; //hphc heure pleine / heure creuse -- tc tarif continu
	private JButton boutonInfoConso;

	public FenetreEdf() {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Calcul du prix mensuel de votre facture d'électricité");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(700, 400));
		fenetre.setLocationRelativeTo(null);
		
		//nom du forunisseur
		JPanel panFournisseur = new JPanel();
		panFournisseur.setBackground(Color.white);
		panFournisseur.setPreferredSize(new Dimension(220, 60));
		fournisseur = new JTextField();
		fournisseur.setPreferredSize(new Dimension(600, 25));
		panFournisseur.setBorder(BorderFactory.createTitledBorder("Nom du fournisseur d'électricité"));
	    labelNom = new JLabel("Saisir un nom :");
	    panFournisseur.add(labelNom);
	    panFournisseur.add(fournisseur);
	    
	    //La puissance
	    JPanel panPuissance = new JPanel();
	    panPuissance.setBackground(Color.white);
	    panPuissance.setBorder(BorderFactory.createTitledBorder("Puisance souscrite (en kVA) :"));
	    panPuissance.setPreferredSize(new Dimension(440, 60));
	    p3 = new JRadioButton("3 kVA");
	    p3.setSelected(true);
	    p6 = new JRadioButton("6 kVA");
	    p9 = new JRadioButton("9 kVA");
	    p12 = new JRadioButton("12 kVA");
	    p15 = new JRadioButton("15 kVA");
	    p18 = new JRadioButton("18 kVA");
	    p24 = new JRadioButton("24 kVA");
	    p30 = new JRadioButton("30 kVA");
	    p36 = new JRadioButton("36 kVA");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(p3);
	    bg.add(p6);
	    bg.add(p9);
	    bg.add(p12);
	    bg.add(p15);
	    bg.add(p18);
	    bg.add(p24);
	    bg.add(p30);
	    bg.add(p36);
	    panPuissance.add(p3);
	    panPuissance.add(p6);
	    panPuissance.add(p9);
	    panPuissance.add(p12);
	    panPuissance.add(p15);
	    panPuissance.add(p18);
	    panPuissance.add(p24);
	    panPuissance.add(p30);
	    panPuissance.add(p36);
	    
	    //Type de contrat
	    JPanel panContrat = new JPanel();
	    panContrat.setBackground(Color.white);
	    panContrat.setBorder(BorderFactory.createTitledBorder("Type de contrat souscrit :"));
	    panContrat.setPreferredSize(new Dimension(440, 60));
	    hphc = new JRadioButton("Heure pleine/Heure creuse");
	    tc =  new JRadioButton("Tarif continu (sans HP/HC)");
	    ButtonGroup bg2 = new ButtonGroup();
	    bg2.add(hphc);
	    bg2.add(tc);
	    panContrat.add(hphc);
	    panContrat.add(tc);
    
	    //Consommation
	    JPanel panConsommation = new JPanel();
	    panConsommation.setBackground(Color.white);
	    panConsommation.setPreferredSize(new Dimension(220, 60));
	    conso = new JTextField();
		conso.setPreferredSize(new Dimension(100, 25));
		boutonInfoConso = new JButton("Un peu d'aide !");
		boutonInfoConso.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		JFrame frameInfoConso = new JFrame();
	    		frameInfoConso.setTitle("Tableau de consommation de votre appareil ...");
	    		frameInfoConso.setPreferredSize(new Dimension(800,750));
	    		frameInfoConso.setLocationRelativeTo(null);
	    		
	    		infoConso = new JLabel(new ImageIcon("ext/Tableau-Calcul-Conso-Appareils.jpg"));
	    	    JPanel panTableauConso = new JPanel();
	    	    
	    	    panTableauConso.setBackground(Color.white);
	    	    panTableauConso.setLayout(new BorderLayout());
	    	    panTableauConso.add(infoConso);
	    	    
	    	    frameInfoConso.add(panTableauConso);
	    	    frameInfoConso.pack();
	    	    frameInfoConso.setVisible(true);
	    	}      
	    });
	    panConsommation.setBorder(BorderFactory.createTitledBorder("Quel est votre consommation mensuel en kwh"));
	    labelConso = new JLabel("Saisir votre consommation mensuel:");
	    panConsommation.add(labelConso);
	    panConsommation.add(conso);
	    panConsommation.add(boutonInfoConso);
	    
	    JPanel control = new JPanel();
	    control.setBackground(Color.gray);
	    JButton okBouton = new JButton("Calculer votre prix");
	    okBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {        
	    		JFrame frameInfoConso = new JFrame();
	    		frameInfoConso.setTitle("Estimation de votre facture d'électrcité");
	    		frameInfoConso.setPreferredSize(new Dimension(800,750));
	    		frameInfoConso.setLocationRelativeTo(null);
	    		if(!hphc.isSelected() && !tc.isSelected()){
	    			JOptionPane jop = new JOptionPane();
	    			jop.showMessageDialog(null, "Merci de sélectionner au moins un type de contrat", "Erreur", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		int puissance;
	    		int consommation;
	    		MetierFenetreEdf metier;
	    		
	    	    
	    	    frameInfoConso.pack();
	    	    frameInfoConso.setVisible(true);
	    	}     
	    });
	    JButton cancelBouton = new JButton("Quitter");
	    cancelBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    	}      
	    });
	    control.add(okBouton);
	    control.add(cancelBouton);
	    
	    fenetre.setLayout(new GridLayout(5, 1));
	    fenetre.add(panFournisseur);
	    fenetre.add(panPuissance);
	    fenetre.add(panContrat);
	    fenetre.add(panConsommation);
	    fenetre.add(control);
	    fenetre.pack();
		fenetre.setVisible(true);
	}
}
