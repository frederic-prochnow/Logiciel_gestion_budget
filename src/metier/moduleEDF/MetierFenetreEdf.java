package metier.moduleEDF;

import java.util.HashMap;

public class MetierFenetreEdf {

	HashMap<Integer,Double> abonnementTarifTC = new HashMap<>();
	HashMap<Integer,Double> abonnementTarifHPHC = new HashMap<>();
	
	public Double abonnementTarifTC(int puissance){
		if(abonnementTarifTC.size() == 0){
			abonnementTarifTC.put(3,67.04);
			abonnementTarifTC.put(6,100.74);
			abonnementTarifTC.put(9,118.74);
			abonnementTarifTC.put(12,137.12);
			abonnementTarifTC.put(15,155.63);
			abonnementTarifTC.put(18,176.93);
			abonnementTarifTC.put(24,214.58);
			abonnementTarifTC.put(30,255.14);
			abonnementTarifTC.put(36,287.22);
		}
		return abonnementTarifTC.get(puissance);
	}
	
	public Double abonnementTarifHPHC(int puissance){
		if(abonnementTarifHPHC.size()==0){
			abonnementTarifHPHC.put(3,-1.0);
			abonnementTarifHPHC.put(6,114.42);
			abonnementTarifHPHC.put(9,140.65);
			abonnementTarifHPHC.put(12,164.74);
			abonnementTarifHPHC.put(15,187.05);
			abonnementTarifHPHC.put(18,207.59);
			abonnementTarifHPHC.put(24,238.60);
			abonnementTarifHPHC.put(30,276.03);
			abonnementTarifHPHC.put(36,310.39);
		}
		return abonnementTarifHPHC.get(puissance);
	}
	
	public Double tarifConsommationTC(int puissance){
		if(puissance == 3){
			return 0.1546;
		}else if(puissance == 6){
			return 0.1466;
		}else if(puissance == 9 ||
					puissance == 12 ||
					puissance == 15 ||
					puissance == 18 ||
					puissance == 24 ||
					puissance == 30 ||
					puissance == 36){
			return 0.1483;
		}else{
			return -1.0;
		}
	}
	
	public Double tarifConsommationHP(int puissance){
		if(puissance == 6 ||
				puissance == 9 ||
				puissance == 12 ||
				puissance == 15 ||
				puissance == 18 ||
				puissance == 24 ||
				puissance == 30 ||
				puissance == 36){
			return 0.1593;
		}else{
			return -1.0;
		}
	}
	
	public Double tarifConsommationHC(int puissance){
		if(puissance == 6 ||
				puissance == 9 ||
				puissance == 12 ||
				puissance == 15 ||
				puissance == 18 ||
				puissance == 24 ||
				puissance == 30 ||
				puissance == 36){
			return 0.1252;
		}else{
			return -1.0;
		}
	}

	public Double prixMensuelFactureTC(int puissance,int consommation){
		return abonnementTarifTC(puissance) + (consommation * tarifConsommationTC(puissance));
	}
	
	public Double prixAnnuelFactureTC(int puissance,int consommation){
		return 12 * prixMensuelFactureTC(puissance, consommation);
	}
	
	public Double prixMensuelFactureHPHC(int puissance,int consommation){
		if(puissance == 3){
			return -1.0;
		}
		//HP = 16 HEURE (2/3)  HC =8 HEURE (1/3)
		Double consoHP = ((2/3)*consommation) * tarifConsommationHP(puissance);
		Double consoHC = ((1/3)*consommation) * tarifConsommationHC(puissance);
		return abonnementTarifHPHC(puissance) + consoHP + consoHC;
	}
}
