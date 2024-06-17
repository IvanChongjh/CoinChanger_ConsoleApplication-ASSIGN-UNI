/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 * parent class of unitCourseClass and Research Class
 *
 * @author ivanchong
 */
public class unitClass {

    public char enrollmentType;
    public String finalGrade;
    public double overAllMarks;

    /**
     * Constructor with enrolment Value and Final grade
     *
     * @param enrollmentType
     * @param finalGrade
     */
    public void unitClass(char enrollmentType, String finalGrade) {
        this.enrollmentType = enrollmentType;
        this.finalGrade = finalGrade;
    }

    /**
     * formula to find the grade value 'N' for fail, 'P' for Pass, 'C' for
     * Credit , 'D' for Distinction, 'HD' for High Distinction
     *
     * @param overAllMarks
     * @return String
     */
    public String finalGrade(double overAllMarks) {
        if (overAllMarks > 0 && overAllMarks < 50) {
            finalGrade = "N";
        } else if (overAllMarks > 50 && overAllMarks < 60) {
            finalGrade = "P";
        } else if (overAllMarks >= 60 && overAllMarks < 70) {
            finalGrade = "C";
        } else if (overAllMarks >= 70 && overAllMarks < 80) {
            finalGrade = "D";
        } else if (overAllMarks >= 80) {
            finalGrade = "HD";
        }

        return finalGrade;
    }

    /**
     * Default finalGrade Report
     *
     * @return
     */
    public String finalGradeReport() {
        return "N/A not applicable";
    }

}
