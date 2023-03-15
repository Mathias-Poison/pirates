package pirate.controller.api;

public interface Views {
	
	public static interface Common {}
	
	public static interface Compte extends Common {}
	
	public static interface Capitaine extends Compte {}
	
	public static interface Client extends Compte {}
	
	public static interface Admin extends Compte {}
	
	public static interface Enchere extends Common {}
	
	public static interface Bateau extends Common {}
	
	public static interface Mission extends Common {}
}
