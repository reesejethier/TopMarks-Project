/***********************************************************************************************************************
 * Class Name:      Category.java
 * Author:          James Singleton
 * Description:     This is the representation of each assignment category in a Student’s Course. A Category has a name,
 *                  an ArrayList of Assignments called grades, a distMod which is used to give the Category a specific
 *                  weight in terms of final grade and the number of lowest assignments that will be dropped for this
 *                  category if any called numDrop.
 **********************************************************************************************************************/
import java.util.ArrayList;

public class Category {
    private String name;                    //The name of the Category
    private ArrayList<Assignment> grades;   //The datastructure that will store the Assignments
    private double distMod;                 //The weight of the category (ex: the Quiz Category is worth 20%)
    private int numDrop;                    //The number of Assignments that are dropped in this Category

     /************************************************************************
     * Method Name:     Category
     * Description:     Constructor for Category
     * Parameters:      name: the name of the Category
                        grades: a pre made ArrayList of Assignments
                        distMod: The Weight of the Category
                        numDrop: The number of grades that will be ignored
                            in the grade calculations.
     * Pre-Condition:   The object is not yet created and instantiated
     * Post-Condition:  The object is created and instantiated with intial
                            values, or an Exception is thrown 
                            (either IllegalArgumentException or a 
                            NullPointerException).
     **********************************************************************/
    public Category (String name, ArrayList<Assignment> grades, double distMod, int numDrop) throws IllegalArgumentException, throws NullPointerException {
        /*Ensures that the weight of the category is not less than zero*/
        if(distMod < 0.0)
            throw new IllegalArgumentException("The Distribution Modifier must be greater than equal to zero");
        /*Ensures that the number of Assignments that are ingnored in the grade calculations are not Less than zero. */
        if(numDrop < 0)
            throw new IllegalArgumentException("The number of grades dropped must be greater than or equal to zero");
        /*Ensure that the inital ArrayList of Assignments is not a null object*/
        if(grades == null)
            throw new NullPointerException("The ArrayList of Assignments must not be Null");

        this.name = name;           //initializes the attribute name with tha parameter
        this.grades = grades;       //initializes the attribute grades with tha parameter
        this.distMod = distMod;     //initializes the attribute distMod with tha parameter
        this.numDrop = numDrop;     //initializes the attribute numDrop with tha parameter
    }

    /************************************************************************
     * Method Name:     Category
     * Description:     Constructor for Category
     * Parameters:      name: the name of the Category
                        distMod: The Weight of the Category
                        numDrop: The number of grades that will be ignored
                            in the grade calculations.
     * Pre-Condition:   The object is not yet created and instantiated
     * Post-Condition:  The object is created and instantiated with intial
                            values, and the grades ArrayList Object is 
                            created with an initial size of Zero, or
                            an IllegalArgumentException is thrown.
     **********************************************************************/
    public Category(String name, double distMod, int numDrop) throws IllegalArgumentException {
        /*Ensures that the weight of the category is not less than zero*/
        if(distMod < 0.0)
            throw new IllegalArgumentException("The Distribution Modifier must be greater than equal to zero");
         /*Ensures that the number of Assignments that are ingnored in the grade calculations are not Less than zero. */
        if(numDrop < 0)
            throw new IllegalArgumentException("The number of grades dropped must be greater than or equal to zero");

        this.grades = new ArrayList<Assignment>(0); //creates the grades ArrayList Object with Zero elements
        this.name = name;                           //initializes the attribute name with tha parameter
        this.distMod = distMod;                     //initializes the attribute distMod with tha parameter
        this.numDrop = numDrop;                     //initializes the attribute numDrop with tha parameter
    }

    /************************************************************************
     * Method Name:     setName
     * Description:     Mutator for the name attribute
     * Parameters:      name: the new name of the Category
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the name attribute is changed
     **********************************************************************/
    public void setName(String name)
    {
        this.name = name;
    }

    /************************************************************************
     * Method Name:     setNumDrop
     * Description:     Mutator for the numDrop attribute
     * Parameters:      numDrop: the new number of Assignments to drop
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the score attribute is changed,
     *                  or an IllegalArgumentException is thrown, because
     *                  the new numDrop is less than zero.
     ***********************************************************************/
    public void setNumDrop(int numDrop) throws IllegalArgumentException {
        if(numDrop < 0)
            throw new IllegalArgumentException("The number of grades dropped must be greater than or equal to zero");

        this.numDrop = numDrop;
    }
    
     /************************************************************************
     * Method Name:     setDistMod
     * Description:     Mutator for the distMod attribute
     * Parameters:      distMod: the new weight of the Category
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the distMod attribute is changed,
     *                  or an IllegalArgumentException is thrown, because
     *                  the new distMod is less than zero.
     ***********************************************************************/
    public void setDistMod(double distMod) throws IllegalArgumentException {
        if(distMod < 0.0)
            throw new IllegalArgumentException("The Distribution Modifier must be greater than equal to zero");

        this.distMod = distMod;
    }

    /************************************************************************
     * Method Name:     addAssignment
     * Description:     adds an Assignment object to the end of the grades
                            ArrayList
     * Parameters:      newGrade: the new Assignment to be added to the 
                            end of grades
     * Pre-Condition:   The object is created.
     * Post-Condition:  Either newGrade is added to the end of the grades 
                            ArrayList, if newGrade is Null then a 
                            NullPointerException is thrown, or an 
                            IllegalArgumentException if the grade was not
                            added successfully.
     ***********************************************************************/
    public void addAssignment(Assignment newGrade) throws NullPointerException, IllegalArgumentException {
        boolean worked = false;//used to determine if the newGrade was added Successfully

        /*Ensures that the newGrade is not a null object*/
        if(newGrade == null)
            throw new NullPointerException("The New Grade must not be Null");

        worked = grades.add(newGrade);//attempts to add newGrade to the end of grades and records if successfully was

        /*If newGrade wasn't added successfully to grades then this exception is thrown*/
        if (worked == false)
            throw new IllegalArgumentException("The New Grade wasn't added successful.");
    }


    /************************************************************************
     * Method Name:     removeAssignment
     * Description:     Finds an Assignment based on its name then removes 
                            it from the grades ArrayList
     * Parameters:      assignmentName: the name of the Assignment that 
                            is to be removed
     * Pre-Condition:   The object is created.
     * Post-Condition:  The assignment is removed from the grades ArrayList
                            or the assignment wasn't found in the ArrayList
                            and then an IllegalArgumentException is thrown
     ***********************************************************************/
    public void removeAssignment(String assignmentName) throws IllegalArgumentException {
        int index = getIndex(assignmentName);//stores -1 if Assignment wasn't found, otherwise stores index

        /*-1 signifies the Assignment wasn't found and therefor the assignmentName does not contain a 
        name of an Assignment*/
        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", assignmentName));

        grades.remove(index);//removes the Assignment if the Assignment was found

    }

    /************************************************************************
     * Method Name:     removeAssignment
     * Description:     Removes an Assignment from grades based on its index
     * Parameters:      index: The index of the assignment to be removed
     * Pre-Condition:   The object is created.
     * Post-Condition:  The assignment is removed from the grades ArrayList
     *                      or the index is invalid and then an 
     *                      IllegalArgumentException is thrown
     ***********************************************************************/
    public void removeAssignment(int index) throws IllegalArgumentException{
        /*Checks to see if the index is invalid*/
        if((index < 0) || (index > grades.size()))
            throw new IllegalArgumentException("Invalid Index");
        
        grades.remove(index);//removes the Assignment if the index is valid

    }

    /************************************************************************
     * Method Name:     getName
     * Description:     accessor for the name attribute
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the attribute is passed
     ***********************************************************************/
    public String getName() { return name; }

    /************************************************************************
     * Method Name:     getDistMod
     * Description:     accessor for the distMod attribute
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the attribute is passed
     ***********************************************************************/
    public double getDistMod() { return distMod; }

    /************************************************************************
     * Method Name:     getNumDrop
     * Description:     accessor for the numDrop attribute
     * Parameters:      none
     * Pre-Condition:   The object is created.
     * Post-Condition:  The value of the attribute is passed
     ***********************************************************************/
    public int getNumDrop() { return numDrop; }

    /************************************************************************
     * Method Name:     getAssignmemt
     * Description:     returns an Assignment at the index passed
     * Parameters:      index: the index of the Assignment
     * Pre-Condition:   The object is created.
     * Post-Condition:  The refrence of the desired Assignment is passed, or
     *                      or if the index is invalid an 
     *                      IllegalArgumentException is thrown.
     ***********************************************************************/
    public Assignment getAssignment(int index)  throws IllegalArgumentException{
        /*checks the validity of index*/
        if((index < 0) || (index > grades.size()))
            throw new IllegalArgumentException("Invalid Index");

        return grades.get(index);//returns the refrence of the desired Assignment
    }

    /************************************************************************
     * Method Name:     getAssignmemt
     * Description:     Searches grades for the desired Assignment based on
     *                      its name then returns the refrence to it
     * Parameters:      assignmentName: the name of the desired Assignment
     * Pre-Condition:   The object is created.
     * Post-Condition:  The refrence of the desired Assignment is passed, or
     *                      an Assignment is not found with a name then
     *                      an IllegalArgumentException is thrown
     ***********************************************************************/
    public Assignment getAssignment (String assignmentName) throws IllegalArgumentException {
        int index = getIndex(assignmentName);//stores -1 if Assignment wasn't found, otherwise stores index

        /*-1 signifies the Assignment wasn't found and therefor the assignmentName does not contain a 
        name of an Assignment*/
        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", assignmentName));

        return grades.get(index);//returns the refrence of the desired Assignment
    }

    /************************************************************************
     * Method Name:     getCategoryGrade
     * Description:     Calculates the grade of the Category, but does not
     *                  apply the distMod.
     * Parameters:      none
     * Pre-Condition:   The object is created
     * Post-Condition:  The grade for the Category is calculated
     **********************************************************************/
    public double getCategoryGrade()
    {
        double gradesToDrop[] = new double[getNumDrop()];   //Array to hold the scores of the assignments that will be dropped
        double score = 0;                                   //running total of the grades
        int maxI;                                           //Used to hold the max index of the gradesToDrop array
        int numGradesCounted = grades.size() - getNumDrop();//the number of grades counted in the grade calculations

        /*Used to assume that the first getNumDrop() grades are the lowest*/
        for(int i = 0; i < gradesToDrop.length; i++)
        {
            gradesToDrop[i] = grades.get(i).getScore();     //Used to assign the first getNumDrop() scores into the array
            score += grades.get(i).getScore();              //in case these grades are not counted they are added to the running total
        }

        /*Goes through the remaining scores in grades finding the scores to drop and incrementing the running total*/
        for(int i = gradesToDrop.length; i < grades.size(); i++)
        {
            score += grades.get(i).getScore();              //adds the current Assignment's to the running total

            /*If there are grades to be drop then */
            if(getNumDrop() > 0) {
                maxI = 0;                                   //resets maxI to zero to be used assume the first element is the max
                /*finds the index of the element of gradesToDrop that contains the greatest value*/
                for (int j = 1; j < gradesToDrop.length; j++)
                    /*if the element at the current index of grades to drop is greater than the element at the current
                    maxI, then maxI is set to the current index*/
                    if (gradesToDrop[maxI] < gradesToDrop[j])
                        maxI = j;
                /*If the current score is less than the max element of the gradesToDropArray then set the
                gradesToDrop[maxI] to the current score*/
                if ((grades.get(i).getScore() < gradesToDrop[maxI]))
                    gradesToDrop[maxI] = grades.get(i).getScore();
            }
        }

        /*If the number of Assignments to be dropped and the number of Assignments in the grades Arraylist,
        then the grades will not be dropped. Grades will only be dropped if the number Assignmnets  exceeds
        the number of grades to be dropped*/
        if(numGradesCounted > 0) {
            /*Goes through the gradesToDrop and subtracts them from score to not count in the grade calculation*/
            for (int i = 0; i < gradesToDrop.length; i++)
                score -= gradesToDrop[i];
        }
        else
            numGradesCounted = grades.size();//resets the numGradesCounted to include all grades since they will all be counted

        return (score / numGradesCounted);//calculates the average score
    }

    /************************************************************************
     * Method Name:     getIndex
     * Description:     Either finds an Assignment in grades with a
     *                      name attribute matching assignmentName and 
     *                      returns its index or if the Assignment is not
     *                      found returns a -1.
     * Parameters:      assignmentName: The name of the desired Assignment
     * Pre-Condition:   The object is created
     * Post-Condition:  Either the Assignment is found and its index 
     *                      returned, or the assignment was not found and
     *                      -1 is returned.
     **********************************************************************/
    private int getIndex(String assignmentName) {
        /*iterates through the grades ArrayList*/
        for(int index = 0; index < grades.size(); index++)
        {
            /*checks if the Assignment at the current index's name attribute matches
              assignment name*/
            if(grades.get(index).getName().equals(assignmentName))
            {
                return index;//Asignment was found with a matching name
            }
        }
        return -1;//Assignment wasn't found with a matching name
    }



}
