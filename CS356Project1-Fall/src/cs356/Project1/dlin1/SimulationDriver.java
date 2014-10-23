// Daniel Lin
// CS 356 - 01
// Project 1
// IClicker Simulation

package cs356.Project1.dlin1;
import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class SimulationDriver 
{

	public static void main(String[] args)
   {      
      Random num = new Random();
      int studentNumberGenerator = num.nextInt(50) + 1;                          //Random number generator to generate student amount
		final int maxStudentNum = studentNumberGenerator;
		ArrayList<Student> classRoster = new ArrayList<Student>();                 //Array list to hold the class
		int count = 0;
      int input;
      Scanner keyboard = new Scanner(System.in);
      int[] idHolder;                                                            //Array for student IDs
      ClickerProgram iclicker;  
      
      Random idGen = new Random();                                               // Random generator to generate student ID
      int idNumGenerator = idGen.nextInt(100000000) + 100000000;
		for (int i = 0; i < maxStudentNum; i++) 
      {
			classRoster.add(new Student(idNumGenerator));                           //For loop to add the Ids to the roster
         idNumGenerator = idGen.nextInt(100000000) + 100000000;                  //Resetting the number generator so it doesn't use the same seed
		}
      
		idHolder = new int[classRoster.size()];                                    //sets max size of arrrya that holds id
		for (int i = 0; i < maxStudentNum; i++) 
      {
			idHolder[i] = classRoster.get(i).getStudentNumID();                     //adds the IDs to the holder
		}
		iclicker = new ClickerProgram(idHolder);
      
      System.out.println("Press 1 if you want a single choice question or 2 if you want a question with multiple answers");
      input = keyboard.nextInt();
      
      if(input == 1)
      {
         singleAnswer(iclicker, maxStudentNum, classRoster, count);
 
      }
      else if(input == 2)
      {
         multipleAnswer(iclicker, maxStudentNum, classRoster, count);
      }
      else
      {
         System.out.println("Wrong input! Closing simulator");
      }	
	
	}
   
   private static void singleAnswer(ClickerProgram iclicker, int maxStudentNum, ArrayList<Student> classRoster, int count)
   {
      System.out.println("This is a single choice question. Multiple submissions are allowed. Newer submissions will override your previous submissions.");		
      Question singleProblem = new Question("1.Which of the following is not a month in our calendar year?\n A: November \n B: January \n C: Sepubrary \n D: August\n", "C");     //Passes prompt as well as answer
      System.out.println(singleProblem.getProblem());
      
      Random num2 = new Random();                                                                  //Second random number generator for the first question. So that they dont share the same seed
      int holder = num2.nextInt(40) + 1;
      int randomNumber2 = holder;      
      for (int i = 0; i < maxStudentNum; i++) 
      {
         while (true)
         {
            if (randomNumber2 > 0 && randomNumber2 <= 40)
            {
               iclicker.pushAnswers(random(classRoster, maxStudentNum, singleProblem, 4));         //submit the answers per student to the hashtable
               randomNumber2--;
               count++;
            } 
            else if(randomNumber2 == 0)
            {
               iclicker.totalAnswers(count);                                                     //count the total number of submissions
               break;
            }
         }
         count = 0;
         holder = num2.nextInt(40) + 1;
         randomNumber2 = holder;
      }
      System.out.println("The answer to this question was C");
      iclicker.showStudentAnswers(singleProblem, maxStudentNum);
      iclicker.submissionBreakdown(4);      
   }
   
   private static void multipleAnswer(ClickerProgram iclicker, int maxStudentNum, ArrayList<Student> classRoster, int count)
   {
      Random num3 = new Random();                                                                          //Third random generator for 2nd question. So that they don't share the same seed
      int holder = num3.nextInt(40) + 1;
      int randomNumber3 = holder;
      System.out.println("This question has multiple answers. Multiple submissions are allowed. Newer submissions will override your previous submissions. ");
      Question multipleAnsProblem = new Question("2. Who is playing in this years World Series?\n A: San Francisco Giants \n B: Baltimore Orioles \n C: St. Louis Tigers \n D: Kansas City Royals\n", "AD"); // Passes prompt as well as answer
      System.out.println(multipleAnsProblem.getProblem());
      for (int i = 0; i < maxStudentNum; i++)
      {
         while (true)
         {
            if (randomNumber3 > 0 && randomNumber3 <= 40)                                 
            {
               iclicker.pushAnswers(random(classRoster, maxStudentNum, multipleAnsProblem, 4));         //submit the answers per question to the hashtable
               randomNumber3--;
               count++;
            } 
            else if(randomNumber3 == 0)
            {
               iclicker.totalAnswers(count);                                                             // count the total number of submissions
               break;
            }
         } 
         count = 0;
         holder = num3.nextInt(40) + 1;
         randomNumber3 = holder;
         
      }
      System.out.println("The answers to this question were A and D");
      iclicker.showStudentAnswers(multipleAnsProblem, maxStudentNum);                                  // show the number of students who got it correct
      iclicker.submissionBreakdown(4);                                                        // breaks down answers by the numbers
   }
	private static Hashtable<Integer, String> random (ArrayList<Student> classRoster, int maxStudentNum, Question problem, int answers) // Stores IDs into a hashtable
   {                                                                                                                                            // has a branch statement to check for each question prompt
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		
		for (int i = 0; i < maxStudentNum; i++) 
      {
			if (problem.getAnswer().length() == 1)
         {
				classRoster.get(i).answerGenerator(answers);
			} 
         else 
         {
				classRoster.get(i).multipleAnswerOption(answers);
			}
		}
      for (int i = 0; i < maxStudentNum; i++)                                                                                               
      {
			table.put(classRoster.get(i).getStudentNumID(), classRoster.get(i).ans);
		}
		return table;
	}
}