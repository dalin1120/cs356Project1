// Daniel Lin
// CS 356 - 01
// Project 1
// IClicker Simulation

package cs356.Project1.dlin1;
import java.util.Hashtable;

public class ClickerProgram implements IClickerService 
{	
   private int total = 0;
	private int[] studentIDSet;
	Hashtable<Integer, String> set = new Hashtable<Integer, String>();
	
	public ClickerProgram(int[] studentIDSet)
   {
		this.studentIDSet = studentIDSet;
	}
     
 	public void totalAnswers(int number)                                       // Holds the total amount of answers submitted by students
   {
		this.total = number;
	}  
   
	public void pushAnswers(Hashtable<Integer, String> studentAnswers)       //Submits the answer to the hashtable
   {
		this.set = studentAnswers;
	}   

 	public void showStudentAnswers(Question problem, int maxStudentNum)       // Counts the total number of students who have the correct answer and prints out correct and inccorrect total
   {
		int correct = 0;
		int incorrect = 0;
		for (int a = 0; a < maxStudentNum; a++)
      {
			if (problem.getAnswer().equals(set.get(studentIDSet[a]))) 
         {
				correct++;
			}
		}
      incorrect = maxStudentNum - correct;      
	
		System.out.println("Number of students with correct answers: " + correct);
		System.out.println("Number of students with incorrect answers: " + incorrect);
	}  
   
	public void submissionBreakdown(int answers)                               // Breaks down the answers categorically
   {
		
		int A = 0, B = 0, C = 0, D = 0;

		for (int i = 0; i < studentIDSet.length; i++) 
      {
			for (int j = 0; j < set.get(studentIDSet[i]).length(); j++)
         {
				if (set.get(studentIDSet[i]).charAt(j) == 'A') 
            {
					A++;
				}
				if (set.get(studentIDSet[i]).charAt(j) == 'B') 
            {
					B++;
				}
				if (set.get(studentIDSet[i]).charAt(j) == 'C') 
            {
					C++;
				}
				if (set.get(studentIDSet[i]).charAt(j) == 'D') 
            {
					D++;
				}
			}
		}
      System.out.println("Data for each answer: ");
		System.out.println("A: " + A);
      System.out.println("B: " + B);
      System.out.println("C: " + C);
      System.out.println("D: " + D);
      System.out.println();
	}

}
