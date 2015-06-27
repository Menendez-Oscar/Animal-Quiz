import java.util.Scanner;
/*
 * @Author Oscar Menendez
 * June 26th 2015
 */
public class AnimalQuiz {
	
	Animal tree;
	Animal lastAnimal;
	Scanner sc;
	// In case we want a null true, to test things like traverseToRoot using a custom tree.
	public AnimalQuiz(){
		sc = new Scanner(System.in);
	}
	
	
	public AnimalQuiz(String firstAnimal){
		tree = new Animal(firstAnimal, false);
		sc = new Scanner(System.in);
	}
	
	public void play(){
		System.out.println("Think of an animal...");
		Animal currentNode = tree;
		String response = "";
		String answer = "";
		while(currentNode != null){
			answer = ask(currentNode.getQuestion());
			if(answer.equalsIgnoreCase("y")){
                if(currentNode.yes != null)response = answer;
				currentNode = currentNode.yes;
			}else{
                if(currentNode.no != null)response = answer;
				lastAnimal = currentNode;
				currentNode = currentNode.no;
			}	
		}
		if(answer.equalsIgnoreCase("y")){
			answer = ask("I win.  Pretty smart, aren't I?\nPlay again?  (y or n)");
			if(answer.equalsIgnoreCase("y"))
				play();
			else
				return;
		}else{
			answer = ask("You win. Help me learn from my mistake before you go..."
			  			 + "\nWhat animal were you thinking of?");
			Animal newAnimal = new Animal(answer, false);
			answer = ask("Give me a question to distinguish " + newAnimal.getAnimal() + " from " + lastAnimal.getAnimal() + "?");
			Animal newQuestion = new Animal(answer, true);
			answer = ask("For " + newAnimal.getAnimal() + ", what is the answer to your question?  (y or n)");
			addNewAnimal(newQuestion, newAnimal, lastAnimal, response, answer);
			
			answer = ask("Play again?  (y or n)");
			if(answer.equalsIgnoreCase("y"))
				play();
			else
				return;
		}			
	}
	
	
	public Animal getAnimalTree(){
		return tree;
	}
	
	/**
	 * Yeah way too many arguments, this helps for testing.
	 * @param answerForNewQuestion is the response to 'For <newAnimal>, what is the answer to <newQuestion>?  (y or n)'
	 */
	public void addNewAnimal(Animal newQuestion, Animal newAnimal, Animal lastAnimal, String lastAnswer, String answerForNewQuestion){

        Animal newNode;
        if (lastAnimal.parent != null) {
            newNode = lastAnimal.parent;
            if(lastAnswer.equalsIgnoreCase("y")) {
                if(answerForNewQuestion.equalsIgnoreCase("y")){
                    newQuestion.yes = newAnimal;
                    newQuestion.no = lastAnimal;
                }else{
                    newQuestion.yes = lastAnimal;
                    newQuestion.no = newAnimal;
                }
                newNode.yes = newQuestion;
            }
            else{
                if(answerForNewQuestion.equalsIgnoreCase("y")){
                    newQuestion.yes = newAnimal;
                    newQuestion.no = lastAnimal;
                }else{
                    newQuestion.yes = lastAnimal;
                    newQuestion.no = newAnimal;
                }
                newNode.no = newQuestion;
            }
        } else {
            newNode = newQuestion;
            lastAnimal.parent = newQuestion;
            newAnimal.parent = newQuestion;
            if (answerForNewQuestion.equalsIgnoreCase("y")) {
                newNode.yes = newAnimal;
                newNode.no = lastAnimal;
            } else {
                newNode.yes = lastAnimal;
                newNode.no = newAnimal;
            }

        }
		tree = traverseToRoot(newNode);
	}
	
	public Animal traverseToRoot(Animal node){
		Animal currentNode = node;
		while(currentNode.parent != null)
			currentNode = currentNode.parent;
		return currentNode;			
	}
	public String ask(String question){
		System.out.println(question);
		String answer = sc.nextLine();
		return answer;
	}
	
}
