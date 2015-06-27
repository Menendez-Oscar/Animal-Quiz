	
/**
 * Animal class that will act as the node class for our tree.
 */
public class Animal {
	public Animal parent,no,yes;
		private String question, animal;
		public Animal(String value, boolean isQuestion){
			if(isQuestion){
				question = value;
			}else{
				animal = value;
				question = "Is it " + value + "?";
			}
		}
		
		public String getQuestion(){return question;}
		public String getAnimal(){return animal;}
}
