/*******************************************
* Class Name:Student
* Author:Super Team
* Description:This class allows the user to 
              create a name that the app 
              will reference the user by. 
              The class also has the methods 
              for adding and removing
              courses.
*******************************************/
import java.io.IOException;
import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Course> courseList;

    //Default Constructor
    public Student() {
        this.name= "";
        this.courseList = new ArrayList<Course>(0);
    }

    //Mutators
    /*******************************************
    * Method Name: setName
    * Description: This method sets the name of
                   the course.
    * Parameters: String
    *******************************************/
    public void setName(String name) throws IOException
    {
        this.name = name;
    }

    //Add remove courses
    
    /*******************************************
    * Method Name: addCourse
    * Description: This method creates a new
                   course and checks to make
                   sure the course name is not
                   set to Null. It also 
                   informs the user if the
                   course was not added.
    * Parameters: Course
    *******************************************/
    public void addCourse(Course newCourse) throws IllegalArgumentException {
        boolean worked = false;

        if(newCourse == null)
            throw new IllegalArgumentException("The New Category must not be Null");

        worked = courseList.add(newCourse);

        if (worked == false)
            throw new IllegalArgumentException("The New Category wasn't added successful.");
    }
    
    /*******************************************
    * Method Name: removeCourse
    * Description: This method removes a course
                   using the name of the course
                   to specify which one to
                   remove.
    * Parameters: String
    *******************************************/
    public void removeCourse(String courseName) throws IllegalArgumentException {
        int index = getIndex(courseName);

        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", courseName));

        courseList.remove(index);

    }
    
    /*******************************************
    * Method Name: removeCourse
    * Description: This method removes a course
                   using the index of the
                   course to specify which one
                   to remove. 
    * Parameters: int
    *******************************************/
    public void removeCourse(int index) throws IllegalArgumentException{
        if((index < 0) || (index > courseList.size()))
            throw new IllegalArgumentException("Invalid Index");

        courseList.remove(index);

    }

    //Acessesors
    
    /*******************************************
    * Method Name: getName
    * Description: This method returns the name
                   of the student.
    * Parameters: None
    *******************************************/
    public String getName()
    {
        return name;
    }
    
    /*******************************************
    * Method Name: getCourse
    * Description: This method returns the
                   course using the index.
                   If the index input is invalid
                   it will inform the user.
    * Parameters: int
    *******************************************/
    public Course getCourse(int index)  throws IllegalArgumentException{
        if((index < 0) || (index > courseList.size()))
            throw new IllegalArgumentException("Invalid Index");

        return courseList.get(index);
    }
    
    /*******************************************
    * Method Name: getCourse 
    * Description: This method returns the
                   course using the course name.
                   If the name input is invalid
                   it will inform the user.
    * Parameters: String
    *******************************************/
    public Course getCourse (String courseName) throws IllegalArgumentException {
        int index = getIndex(courseName);

        if(index == -1)
            throw new IllegalArgumentException(String.format("%s is not in the list", courseName));

        return courseList.get(index);
    }
    
    /*******************************************
    * Method Name: getIndex
    * Description: This method returns the index
                   of the course using the
                   course name
    * Parameters: String
    *******************************************/
    private int getIndex(String courseName) {
        for(int index = 0; index < courseList.size(); index++)
            if(courseList.get(index).getName().equals(courseName))
                return index;
        return -1;
    }
}
