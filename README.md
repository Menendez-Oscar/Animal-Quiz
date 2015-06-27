#Animal-Quiz#
My solution to the RubyQuiz challenge Animal Quiz proposed by Jim Weirich The program is an animal quiz program.
It works like this. The program starts by telling the user to think of an animal.
It then begins asking a series of yes/no questions about that animal: does it swim, does it have hair, etc.
Eventually, it will narrow down the possibilities to a single animal and guess that (Is it a mouse?).
If the program has guessed correctly, the game is over and may be restarted with a new animal.
If the program has guess incorrectly,
it asks the user for the kind of animal they were thinking of
and then asks for the user to provide a question that can distinguish between its incorrect guess
and the correct answer.
It then adds the new question and animal to its "database" and will guess that animal in the future (if appropriate).

----------------------------------------------------------------
Sample run
----------------------------------------------------------------
Is it an elephant?  (y or n)<br>
n<br>
You win.  Help me learn from my mistake before you go...<br>
What animal were you thinking of?<br>
a rabbit<br>
Give me a question to distinguish a rabbit from an elephant.<br>
Is it a small animal?<br>
For a rabbit, what is the answer to your question?  (y or n)<br>
y<br>
Thanks.<br>
Play again?  (y or n)<br>
y<br>
Think of an animal...<br>
Is it a small animal?  (y or n)<br>
y<br>
Is it a rabbit?  (y or n)<br>
n<br>
You win.  Help me learn from my mistake before you go...<br>
What animal were you thinking of?<br>
a Shih Tzu<br>
Give me a question to distinguish a Shih Tzu from a rabbit.<br>
Is it a kind of dog?<br>
For a Shih Tzu, what is the answer to your question?  (y or n)<br>
y<br>
Thanks.<br>
Play again?  (y or n)<br>
y<br>
Think of an animal...<br>
Is it a small animal?  (y or n)<br>
y<br>
Is it a kind of dog?  (y or n)<br>
y<br>
Is it a Shih Tzu?  (y or n)<br>
y<br>
I win.  Pretty smart, aren't I?<br>
Play again?  (y or n)<br>
n
