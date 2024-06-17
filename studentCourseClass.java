/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 * StudentCourseClass() is a subClass of studentClass
 *
 * @author ivanchong
 */
public class studentCourseClass extends studentClass {

    private String unitID;
    private String finalGrade;
    private double overAllMarks;
    private final char enrolType = 'C';

    /**
     * constructor object that uses parent class values name, surname,studentID
     *
     * @param nname
     * @param ssurname
     * @param sstudentID
     */
    public studentCourseClass(String nname, String ssurname, long sstudentID) {
        super(nname, ssurname, sstudentID);

    }

    /**
     * overloading of constructor but with values of
     * unitID,overAllMarks,FinalGrade
     *
     * @param unitID
     * @param overAllMarks
     * @param finalGrade
     */

    public studentCourseClass(String unitID, double overAllMarks, String finalGrade) {

        this.unitID = unitID;
        this.overAllMarks = overAllMarks;
        this.finalGrade = finalGrade;
    }

    /**
     * mutators set unitID;
     *
     * @param unitID
     * @return unit ID
     */

    public String setUnitID(String unitID) {
        return this.unitID = unitID;
    }

    /**
     * assessor get unitID;
     *
     * @return unit id
     */
    public String getUnitID() {
        return unitID;
    }

    /**
     * mutator get OverallMarks
     *
     * @return over all marks
     */
    public double getOverallMarks() {
        return overAllMarks;
    }

    /**
     * assessor get Overall Marks
     *
     * @param overAllMarks
     * @return
     */
    public double setOverAllMarks(double overAllMarks) {
        return this.overAllMarks = overAllMarks;
    }

    /**
     * assessor get finalGrade
     *
     * @return final grade
     */
    public String getFinalGrade() {
        return finalGrade;
    }

    /**
     * mutator set final grade
     *
     * @param finalGrade
     * @return final grade
     */
    public String setFinalGrade(String finalGrade) {
        return this.finalGrade = finalGrade;
    }

    /**
     * get enrolment type
     *
     * @return
     */
    public char getEnrolType() {
        return enrolType;
    }

    @Override
    public String reportGrade() {
        return enrolType + "," + super.getName() + "," + super.getSurname() + "," + super.getStudentID() + "," + overAllMarks + "," + finalGrade;
    }

}
