package lab2.kndr.codecheck;

public class Grades
{
    /**
     This method examines the two arrays of test grades (double)
     identified by the two parameters, and creates an array
     containing the average values of these two arrays.
     The test scores for each student (given in the same row in each test
     array) are combined to find the average score for each student.
     This average is placed in the corresponding row in the new array.
     @param test1, the array of scores for the first test
     @param test2, the array of scores for the second test
     @return, the array containing the average scorres
     */
    public static double[] makeAverage(double[] test1, double[] test2)
    {
        double[] averageMarks = new double[test1.length];
        for(int i = 0; i < test1.length; ++i)
            averageMarks[i] = (test1[i] + test2[i]) /2;
        return averageMarks;


    }
}
