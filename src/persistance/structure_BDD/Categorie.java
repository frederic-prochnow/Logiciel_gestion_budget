package persistance.structure_BDD;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private String nom_categorie;
	private List <Operation> liste_operations;
	private Double total;

	
	public Categorie(String nom_categorie){
		this.nom_categorie = nom_categorie;
		this.liste_operations = new ArrayList<>();
		this.total = 0.0;
	}
	
	public Categorie(String nom_categorie,List <Operation> liste_operations,Double total){
		this.nom_categorie = nom_categorie;
		this.liste_operations = liste_operations;
		this.total = total;
	}
	
	public String recuperer_Nom_categorie() {
		return nom_categorie;
	}

	public void changer_Nom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	
	public List<Operation> recuperer_liste_entiere(){
		return liste_operations;
	}
	
	public Operation recuperer_element_operation(Operation operation){
		for(Operation o : liste_operations){
			if(o == operation){
				return o;
			}
		}
		return null;
	}
	
	public Boolean supprimer_element_categorie(Operation operation){
		for(Operation o : liste_operations){
			if(o == operation){
				return liste_operations.remove(operation);	
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
	
	public String toString() {
		return "Categorie [liste_operations=" + liste_operations + ", total=" + total + "]";
	}
}