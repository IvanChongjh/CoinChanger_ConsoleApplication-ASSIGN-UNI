/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 *
 * @author ivanchong
 *
 * instance variable name,surname,studentID
 */
public class studentClass {

    private String name;
    private String surname;
    private long studentID;

    /**
     * default() constructor initialised with name,surname and studentID
     */
    public studentClass() {
        name = "blank";
        surname = "blank";
        studentID = 0;
    }

    /**
     * constructors studentClass() objects are declared with
     * name,surname,studentID
     *
     * @param name
     * @param surname
     * @param studentID
     */
    public studentClass(String name, String surname, long studentID) {
        this.name = name;
        this.surname = surname;
        this.studentID = studentID;

    }

    /**
     * getStudentID() assessor to get object surname
     *
     * @return studenID
     */
    public long getStudentID() {
        return studentID;
    }

    /**
     * getName() assessor to get object name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getSurname() assessor to get object surname
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setStudentID () Mutators to set Student ID of object
     *
     * @param studentID set object studentID
     */
    public void setStudentID(long studentID) {
        this.studentID = studentID;

    }

    /**
     * setName() mutator to set Name of object
     *
     * @param name set object name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setSurname() mutator to set surname of object
     *
     * @param surname set object surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * reportGrade() holds grade report in this case no grades can be found in
     * studentClass.
     *
     * @return string
     */
    public String reportGrade() {
        return "There is no grade here";
    }

    /**
     * compareStudedID() compares both student ID in Long declaration, if both
     * is the same logic "true", if not "false".
     *
     * @param studentID compare object
     * @return true or false
     */
    public boolean compareStudentID(long studentID) {
        return (this.studentID == studentID);
    }

    /**
     * converts all variable into string
     *
     * @return name, surname, studentID
     */
    public String toString() {
        return name + surname + studentID;
    }

}
