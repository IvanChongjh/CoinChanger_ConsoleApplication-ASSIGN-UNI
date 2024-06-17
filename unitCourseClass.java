/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 * unitCourseClass extends from parent class "unitClass"
 *
 * @author ivanchong
 */
public class unitCourseClass extends unitClass {

    private String unitID;
    private char levelUnit;
    private double assignmentOneMark, assignmentTwoMark, examMarks;
    private double overAllMarks;
    private String finalGrade;
    private char enroll;

    /**
     * Constructors with enrolment, UnitID, LevelUnit, assignment 1 Marks,
     * Assignment 2 Marks , ExamMarks
     *
     * @param enroll
     * @param unitID
     * @param levelUnit
     * @param assignmentOneMark
     * @param assignmentTwoMark
     * @param examMarks
     */
    public unitCourseClass(char enroll, String unitID, char levelUnit, double assignmentOneMark, double assignmentTwoMark, double examMarks) {
        this.assignmentOneMark = assignmentOneMark;
        this.assignmentTwoMark = assignmentTwoMark;
        this.enroll = enroll;
        this.unitID = unitID;
        this.levelUnit = levelUnit;
    }

    /**
     * mutator to set value to assignment one
     *
     * @param marks
     * @return assignment One Marks
     */
    public double setAssignmentOne(double marks) {
        if (marks > 0 || marks < 100) {
            assignmentOneMark = marks;
        }
        return assignmentOneMark;
    }

    /**
     * mutator to set value to assignment two
     *
     * @param marks
     * @return
     */
    public double setAssignmentTwo(double marks) {
        if (marks > 0 || marks < 100) {
            assignmentOneMark = marks;
        }
        return assignmentOneMark;
    }

    /**
     * assessor to set courseOverAllMarks
     *
     * @return
     */
    public double courseOverAllMarks() {
        overAllMarks = (assignmentOneMark + assignmentTwoMark / 2) * 0.6 + examMarks * 0.4;
        double roundOff = Math.round(overAllMarks * 100) / 100;
        return roundOff;
    }

    /**
     * assessors to get final Grade finalGrade formula was retrieved from parent
     * class unitClass
     *
     * @return
     */
    public String getfinalGrade() {

        overAllMarks = (assignmentOneMark + assignmentTwoMark / 2) * 0.6 + examMarks * 0.4;
        finalGrade = super.finalGrade(overAllMarks);

        return finalGrade;
    }

    /**
     * Converts values to string for checking
     *
     * @return
     */
    public String toString() {
        return overAllMarks + "Marks" + " Final Grade : " + finalGrade;
    }

}
