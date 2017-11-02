package persistance.structure_BDD;

public class Operation {

	private String nom_operation;
	private Double montant;
	
	
	public Operation(String nom_operation){
		this.nom_operation = nom_operation;
		this.montant = 0.0;
	}
	
	public Operation(String nom_operation,Double montant){
		this.nom_operation = nom_operation;
		this.montant = montant;
	}

	
	public String recuperer_Nom_operation() {
		return nom_operation;
	}

	public void changer_Nom_operation(String nom_operation) {
		this.nom_operation = nom_operation;
	}

	public Double recuperer_Montant() {
		return montant;
	}

	public Double modifier_Montant(Double montant) {
		this.montant = montant;
		return montant;
	}

	public String toString() {
		return "Operation [nom_operation=" + nom_operation + ", montant=" + montant + "]";
	}
}