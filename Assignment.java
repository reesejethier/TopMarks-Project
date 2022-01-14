/***********************************************************************************************************************
 * Class Name:      Assignment.java
 * Description:     This is the representation of an assignment that a student has completed and been given a grade. An
 *                  Assignment has a score which is the grade the student has received for the assignment and a name to
 *                  keep track of which assignment it is.
 **********************************************************************************************************************/
public class Assignment {

    private String name;    //The Assignment's name
    private double score;   //The grade the Student got on the Assignment

    /************************************************************************
     * Method Name:     Assignment
     * Description:     The constructor of Assignment.java
     * Parameters:      name: the name of the Assignment
     *                  score: the grade the student got on the Assignment
     * Pre-Condition:   The object is not created yet
     * Post-Condition:  The object is created, or an
     *                  IllegalArgumentException is thrown.
     **********************************************************************/
    public Assignment(String name, double score) throws IllegalArgumentException {
        /*Checks to make sure that the score is greater than equal to zero otherwise throws an exception*/
        if(score < 0.0) {
            throw new IllegalArgumentException("Score must be greater than or equal to Zero");
        }
        this.name = name;   //initializes the attribute name with the parameter
        this.score = score; //initializes the attribute name with the parameter

    }

    /************************************************************************
     * Method Name:     Assignment
     * Description:     The default constructor of Assignment.java
     * Parameters:      name: the name of the Assignment
     *                  score: the grade the student got on the Assignment
     * Pre-Condition:   The object is not created yet and the score and name
     *                  of the assignment is unknown
     * Post-Condition:  The object is created with the default values.
     **********************************************************************/
    public Assignment() {

        this.name = "";
        this.score = 0;

    }

    /************************************************************************
     * Method Name:     setName
     * Description:     Mutator for the name attribute
     * Parameters:      name: the new name of the Assignment
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the name attribute is changed
     **********************************************************************/
    public void setName(String name)
    {
        this.name = name;   //changes the name attribute to its new value
    }

    /************************************************************************
     * Method Name:     setScore
     * Description:     Mutator for the score attribute
     * Parameters:      score: the new score of the Assignment
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the score attribute is changed,
     *                  or an IllegalArgumentException is thrown, because
     *                  the new score is less than zero.
     ***********************************************************************/
    public void setScore(double score) throws IllegalArgumentException{
        /*Checks to make sure that the score is greater than equal to zero otherwise throws an exception*/
        if(score < 0.0) {
            throw new IllegalArgumentException("Score must be greater than or equal to Zero");
        }

        this.score = score; //changes the score attribute to its new valid value

    }

    /************************************************************************
     * Method Name:     getScore
     * Description:     accessor for the score attribute
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the attribute is passed
     ***********************************************************************/
    public String getName(){
        return name;
    }

    /************************************************************************
     * Method Name:     getName
     * Description:     accessor for the name attribute
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the attribute is passed
     ***********************************************************************/
    public double getScore(){
        return score;
    }

    /************************************************************************
     * Method Name:     toString
     * Description:     puts the attributes into a string to be utilized
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The attributes are put int a String
     ***********************************************************************/
    @Override
    public String toString()
    {
        return String.format("%s\t%.2f", getName(), getScore());
    }

}
