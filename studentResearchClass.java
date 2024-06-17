/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 * child class of studentClass
 *
 * @author ivanchong
 */
public class studentResearchClass extends studentClass {

    private String finalGrade;
    private double overAllMarks;
    private final char enrolType = 'R';

    /**
     * Constructor with name,surname,studentID from parent class "studentClass"
     *
     * @param sname
     * @param ssurname
     * @param sstudentID
     */
    public studentResearchClass(String sname, String ssurname, long sstudentID) {

        super(sname, ssurname, sstudentID);

    }

    /**
     * method overLoading with different parameter over all marks and final
     * grade
     *
     * @param overAllMarks
     * @param finalGrade
     */
    public studentResearchClass(double overAllMarks, String finalGrade) {

        this.overAllMarks = overAllMarks;
        this.finalGrade = finalGrade;
    }

    /**
     * setOverAllMarks() mutator set overall marks
     *
     * @param overAllMark
     */

    public void setOverAllMarks(double overAllMark) {
        this.overAllMarks = overAllMark;

    }

    /**
     * setFinalGrade() mutator set final grade
     *
     * @param finalGrade
     */
    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    /**
     * getOverallMarks() assessor get overall marks
     *
     * @return
     */
    public double getOverallMarks() {
        return overAllMarks;
    }

    /**
     * getFinalGrade() assessor get final grade
     *
     * @return
     */
    public String getFinalGrade() {
        return finalGrade;
    }

    /**
     * getEnrolType() assessor get enrol Type 'R' or 'C' R for Research, C for
     * Course
     *
     * @return char value
     */
    public char getEnrolType() {
        return enrolType;
    }

    /**
     * reportGrade() converts all variable and share parent values to string to
     * display
     *
     * @return
     */
    public String reportGrade() {
        return enrolType + "," + super.getName() + "," + super.getSurname() + "," + super.getStudentID() + "," + overAllMarks + "," + finalGrade;
    }

}
