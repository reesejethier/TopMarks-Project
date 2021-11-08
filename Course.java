/*******************************************************************************
* Class Name:Course
* Author: Super Team
* Description: This class allows the user to set the passing and desired grades 
               for a course. It also allows the user to create or delete 
               categories for a given course. The user uses the name setter to
               specify the name of the category.
******************************************************************************/
import java.util.ArrayList;

public class Course {
    
    private String name;
    private double passingGrade, desiredGrade;
    private ArrayList<Category> categories;

    //Default Constructor
    public Course() {
        this.name= "";
        this.passingGrade = 0;
        this.desiredGrade = 0;
        this.categories = new ArrayList<Category>(0);
    }

    //Constructor
    
    /*******************************************
    * Method Name: Course
    * Description:This is the constructor for
                  the class. It checks to make
                  sure the passing grade is not
                  equal to zero and the desired
                  grade is no less than the pas-
                  sing grade.
    * Parameters: String, ArrayList, double
    *******************************************/
    public Course (String name, ArrayList<Category> grades, double passingGrade, double desiredGrade) throws IllegalArgumentException {
        if(passingGrade < 0.0)
            throw new IllegalArgumentException("Passing grade cannot be equal to zero.");
        if(desiredGrade < passingGrade)
            throw new IllegalArgumentException("Desired grade cannot be less than passing grade.");

        this.name = name;
        this.categories = new ArrayList<Category>(0);
        this.passingGrade = passingGrade;
        this.desiredGrade = desiredGrade;
    }


    //The Mutators
    /*******************************************
    * Method Name: setName
    * Description: This sets the name for a
                   given category.
    * Parameters: String
    *******************************************/
    public void setName(String name) throws IllegalArgumentException
    {
        this.name = name;
    }

    /*******************************************
    * Method Name: setPassingGrade
    * Description: This sets the passing grade
                   for the course.
    * Parameters: double
    *******************************************/
    public void setPassingGrade(double passingGrade)throws IllegalArgumentException
    {
        if(passingGrade <= 0)
        {
            throw new IllegalArgumentException("Passing Grade cannot be less than or equal to zero.");
        }
        this.passingGrade = passingGrade;
    }
    
    /*******************************************
    * Method Name: setDesiredGrade
    * Description: This sets the desired grade
                   for the course.
    * Parameters: double
    *******************************************/
    public void setDesiredGrade(double desiredGrade)throws IllegalArgumentException
    {
        if(desiredGrade < passingGrade)
        {
            throw new IllegalArgumentException("Your desired grade cannot be less than the passing grade.");
        }
        this.desiredGrade = desiredGrade;
    }


    //Add and remove Categories
    
    /*******************************************
    * Method Name: addCategory
    * Description: This adds a category and
                   applies it to a course. It
                   also makes sure the name is
                   not set to null or informs
                   the user if the category 
                   failed to create.
    * Parameters: Category
    *******************************************/
    public void addCategory(Category newCategory) throws NullPointerException, IllegalArgumentException {
        boolean worked = false;

        if(newCategory == null)
            throw new NullPointerException("The New Category must not be Null");

        worked = categories.add(newCategory);

        if (worked == false)
            throw new IllegalArgumentException("The New Category wasn't added successful.");
    }
    /*******************************************
    * Method Name: removeCategory
    * Description: This removes a category from
                   course. It uses the name
                   of the category to select
                   it for deletion.                   
    * Parameters: String
    *******************************************/
    public void removeCategory(String categoryName) throws IllegalArgumentException {
        int index = getIndex(categoryName);

        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", categoryName));

        categories.remove(index);

    }
    /*******************************************
    * Method Name: removeCategory
    * Description: This removes a category from
                   course. It uses the index
                   of the category to select
                   it for deletion.                   
    * Parameters: int
    *******************************************/
    public void removeCategory(int index) throws IllegalArgumentException{
        if((index < 0) || (index > categories.size()))
            throw new IllegalArgumentException("Invalid Index");

        categories.remove(index);

    }

    //The Accessors
    /*******************************************
    * Method Name: getName
    * Description: This returns the name of the
                   course.
    * Parameters: None
    *******************************************/
    public String getName()
    {
        return name;
    }
    /*******************************************
    * Method Name: getName
    * Description:This returns the passing 
                  grade of the course.
    * Parameters: None
    *******************************************/
    public double getPassingGrade()
    {
        return passingGrade;
    }
    /*******************************************
    * Method Name: getName
    * Description: This returns the desired 
                   grade of the course.
    * Parameters: None
    *******************************************/
    public double getDesiredGrade()
    {
        return desiredGrade;
    }


    //Get Category
    /*******************************************
    * Method Name: getCategory
    * Description:This returns the category 
                  using the index.
    * Parameters: int
    *******************************************/
    public Category getCategory(int index)  throws IllegalArgumentException{
        if((index < 0) || (index > categories.size()))
            throw new IllegalArgumentException("Invalid Index");

        return categories.get(index);
    }
    
    /*******************************************
    * Method Name: getCategory
    * Description:This returns the category 
                  using the category name.
    * Parameters: String
    *******************************************/
    public Category getCategory (String categoryName) throws IllegalArgumentException {
        int index = getIndex(categoryName);

        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", categoryName));

        return categories.get(index);
    }

    
    /*******************************************
    * Method Name: getCourseGrade
    * Description: This returns the over all 
                   course grade.
    * Parameters: None
    *******************************************/
    public double getCourseGrade()
    {
        double grade = 0;
        for(int i = 0; i<categories.size(); i++)
        {
            grade += categories.get(i).getCategoryGrade() * categories.get(i).getDistMod();
        }
        return grade/categories.size();
    }

    //Get index of category
    
    /*******************************************
    * Method Name: getIndex
    * Description:This method gets the index by
                  iterating through a category
                  using the category name as
                  reference.
    * Parameters: String
    *******************************************/
    private int getIndex(String categoryName) {
        for(int index = 0; index < categories.size(); index++)
            if(categories.get(index).getName().equals(categoryName))
                return index;
        return -1;
    }
}
