// Daniel Lin
// CS 356 - 01
// Project 1
// IClicker Simulation

package cs356.Project1.dlin1;

import java.util.Hashtable;

public interface IClickerService 
{
   void totalAnswers(int number); 
   void submissionBreakdown(int answers);
   void showStudentAnswers(Question problem, int maxStudentNum);                                   
   void pushAnswers(Hashtable<Integer, String> table);                   

}