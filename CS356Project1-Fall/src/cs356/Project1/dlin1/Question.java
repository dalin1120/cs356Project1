// Daniel Lin
// CS 356 - 01
// Project 1
// IClicker Simulation

package cs356.Project1.dlin1;
public class Question 
{
	private String problem;
	private String studentAnswer;
	
	public Question(String p, String ans)
   {
		problem = p;
		studentAnswer = ans;
	}

	public String getProblem()               //getter for problem
   {
		return problem;
	}
   
	public String getAnswer()                 //Getter for answer
   {
		return studentAnswer;
	}

	public void setProblem(String p)    //Sets problem
   {
		problem = p;
	}

	public void setAnswer(String ans)         //Sets answer
   {
		studentAnswer = ans;
	}
}
