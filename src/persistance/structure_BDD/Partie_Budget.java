package persistance.structure_BDD;

import java.util.ArrayList;
import java.util.List;

public abstract class Partie_Budget {

	private String nom_partie;
	private List <Categorie> liste_categories;
	private Double total;
	
	protected Partie_Budget(String nom_partie){
		this.nom_partie = nom_partie;
		this.liste_categories = new ArrayList<>();
		this.total = 0.0;
	}
	
	protected Partie_Budget(String nom_partie,List <Categorie> liste_categories,Double total){
		this.nom_partie = nom_partie;
		this.liste_categories = liste_categories;
		this.total = total;
	}

	public String recuperer_Nom_partie() {
		return nom_partie;
	}

	public void changer_Nom_partie(String nom_partie) {
		this.nom_partie = nom_partie;
	}
	
	public List<Categorie> recuperer_liste_entiere(){
		return liste_categories;
	}
	
	public Categorie recuperer_element_categorie(Categorie categorie){
		for(Categorie c : liste_categories){
			if(c == categorie){
				return c;
			}
		}
		return null;
	}
	
	public Boolean supprimer_element_categorie(Categorie categorie){
		for(Categorie c : liste_categories){
			if(c == categorie){
				return liste_categories.remove(categorie);	
			}
		}
		return null;
	}
	
	public Double total(){
		return total;
	}
	
	public Double ajouter_au_total(Double ajout){
		total+=ajout;
		return total();
	}
	
	public Double retirer_au_total(Double retrait){
		total-=retrait;
		return total();
	}
	
	public void remise_a_zero_total(){
		total = 0.0;
	}
}