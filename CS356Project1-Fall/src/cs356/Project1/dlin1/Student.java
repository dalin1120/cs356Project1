// Daniel Lin
// CS 356 - 01
// Project 1
// IClicker Simulation

package cs356.Project1.dlin1;
import java.util.Random;

public class Student
{
   protected String ans;
	private int studentNumberID;
	   
	public Student(int num)                               //Constructor for Student ID
   {
		this.setStudentNumID(num);
	}
   
	public void setStudentNumID(int id)                   //setter number ID
   {
		this.studentNumberID = id;
	}
   
	public int getStudentNumID()                          //getter for number ID
   {
		return studentNumberID;
	}
	
	public void answerGenerator(int number)               // generates answer with random number generator
   {
      Random choosenAnswerGenerator = new Random();
      int randomAnswer = choosenAnswerGenerator.nextInt(number);
		this.ans = "" + (char) (randomAnswer + 65);	
	}

	public void multipleAnswerOption(int number)          //generates multiple answers with number generator
   {
		String answerHolder = "";
		for (int a = 0; a < number; a++)
      {
			if (generateMultipleAnswers())
         {
				answerHolder += (char)(a + 65);
			}
		}
		ans = answerHolder;
	}
	
	public boolean generateMultipleAnswers()           //uses the random number generator multiple choice answers aren't all the same th ing
   {
      Random num = new Random();
      int randomNumber = num.nextInt(2);
		return randomNumber == 0;
	}
}