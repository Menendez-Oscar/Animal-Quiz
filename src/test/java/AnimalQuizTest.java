/*Think of an animal...
Is it an elephant?  (y or n)
n
You win.  Help me learn from my mistake before you go...
What animal were you thinking of?
a rabbit
Give me a question to distinguish a rabbit from an elephant.
Is it a small animal?
For a rabbit, what is the answer to your question?  (y or n)
y
Thanks.
Play again?  (y or n)
y
Think of an animal...
Is it a small animal?  (y or n)
y
Is it a rabbit?  (y or n)
n
You win.  Help me learn from my mistake before you go...
What animal were you thinking of?
a Shih Tzu
Give me a question to distinguish a Shih Tzu from a rabbit.
Is it a kind of dog?
For a Shih Tzu, what is the answer to your question?  (y or n)
y
Thanks.
Play again?  (y or n)
y
Think of an animal...
Is it a small animal?  (y or n)
y
Is it a kind of dog?  (y or n)
y
Is it a Shih Tzu?  (y or n)
y
I win.  Pretty smart, aren't I?
Play again?  (y or n)
n

@Author Oscar Menendez
June 26th 2015
*/
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalQuizTest {

	static AnimalQuiz quiz;
	
	@BeforeClass
	public static void setUp(){
		quiz = new AnimalQuiz("an elephant");
	}

	@Test
    public void testTraverseToRoot() {
    	
    	AnimalQuiz q = new AnimalQuiz();
    	Animal questionOne = new Animal("Is it a feline?", true);
		Animal cat = new Animal("a cat", false);
		Animal dog = new Animal("a dog", false);
		
		// custom tree with two leaf nodes and one inner question node.
		Animal tree = questionOne;
		cat.parent = tree;
		tree.yes = cat;
		dog.parent = tree;
		tree.no = dog;
		
		Animal testTree = tree.no;
		
		// Must be 'a dog'
		assertEquals("Is it a dog?", testTree.getQuestion());
		
		Animal result = q.traverseToRoot(testTree);
		// Test traverseToRoot
        assertEquals("Is it a feline?", result.getQuestion());
        // Make sure both yes and no node are still there
        assertEquals("Is it a cat?", result.yes.getQuestion());
        assertEquals("Is it a dog?", result.no.getQuestion());
    }
    
    //This will test adding a third animal and a second question
	@Test
    public void testAddFirst() {
    	
    	Animal newQuestion = new Animal("Is it a small animal?", true);
        Animal newAnimal = new Animal("a rabbit", false);
        
        // There should only be one Animal in the tree 'an elephant'
        Animal lastAnimal = quiz.getAnimalTree(); 
		
		quiz.addNewAnimal(newQuestion, newAnimal, lastAnimal, "n", "y");
		
		// Now the tree should contain 2 animals and one question.
		Animal result = quiz.getAnimalTree(); 
		//Test traverseToRoot first Try
        assertEquals("Is it a small animal?", result.getQuestion());
        assertEquals("Is it a rabbit?", result.yes.getQuestion());
        assertEquals("Is it an elephant?", result.no.getQuestion());
    }
    
    //This will test adding a second animal and one question
	@Test
    public void testAddSecond() {
    	
    	Animal newQuestion = new Animal("Is it a kind of dog?", true);
        Animal newAnimal = new Animal("a Shih Tzu", false);
        // There should only be two Animal in the tree 'a rabbit and an elephant',
        // and one question(the root node)
        Animal lastAnimal = quiz.getAnimalTree().yes; 
		
		quiz.addNewAnimal(newQuestion, newAnimal, lastAnimal, "y", "y");
		
		// Now the tree should contain 2 animals and one question.
		Animal result = quiz.getAnimalTree(); 
		//Test traverseToRoot first Try
        assertEquals("Is it a small animal?", result.getQuestion());
        assertEquals("Is it a kind of dog?", result.yes.getQuestion());
        assertEquals("Is it a Shih Tzu?", result.yes.yes.getQuestion());
    }
}
