package persistance.modelisation_BDD.entree;

import persistance.structure_BDD.Categorie;
import persistance.structure_BDD.Partie_Budget;

public class Entree extends Partie_Budget {

	Entree() {
		super("Entree");
	}
	
	public void Entree_de_base(){
		Categorie revenus = new Categorie("Revenus");
		Categorie revenus_exeptionnel = new Categorie("Revenus_exeptionnel");
		super.recuperer_liste_entiere().add(revenus);
		super.recuperer_liste_entiere().add(revenus_exeptionnel);
	}
}
