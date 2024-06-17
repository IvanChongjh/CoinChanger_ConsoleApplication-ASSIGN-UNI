/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

/**
 * unitResearch is a sub class that extends from unitClass
 *
 * @author ivanchong
 */
public class unitResearchClass extends unitClass {

    private double proposalMarks;
    private char enrollment;
    private double finalDissertionMarks;
    private double overAllMarks;
    private String finalGrade;

    /**
     * Constructors with values such as enrolment, proposal mark ,
     * finalDissertion
     *
     * @param enrollment
     * @param proposalMarks
     * @param finalDissertionMarks
     */
    public unitResearchClass(char enrollment, double proposalMarks, double finalDissertionMarks) {
        this.enrollment = enrollment;
        this.proposalMarks = proposalMarks;
        this.finalDissertionMarks = finalDissertionMarks;

    }

    /**
     * method to set the value if it is in range when user decides to key into
     * array. Mutator
     *
     * @param marks
     * @return
     */
    public double researchProposal(double marks) {
        if (marks > 0 && marks < 100) {
            proposalMarks = marks;
        }
        return proposalMarks;
    }

    /**
     * method to set the values if the user decides to manually key into the
     * array Mutator to set finalDissertion marks
     *
     * @param marks
     * @return
     */
    public double finalDissertionMarks(double marks) {
        if (marks > 0 && marks < 100) {
            finalDissertionMarks = marks;
        }
        return finalDissertionMarks;
    }

    /**
     * assessor to get the research overAllMarks from the current Object Values
     * overAllMarks is calculated based on a formal of finalDissertion weight
     * 60% ProposalMarks 40% of overall Marks roudOff is to round off marks to
     * nearest two decimal place.
     *
     * @return
     */
    public double researchOverAllMarks() {
        overAllMarks = finalDissertionMarks * 0.6 + proposalMarks * 0.4;
        double roundOff = Math.round(overAllMarks * 100) / 100;
        return roundOff;
    }

    /**
     * assessor to get the finalGrade based on the formula the program uses
     * finalDissertion marks of 60 % weight and proposal of 40% weight the super
     * calls a method from parent class finalGrade and categorise the Grades
     *
     * @return
     */
    public String getfinalGrade() {
        overAllMarks = finalDissertionMarks * 0.6 + proposalMarks * 0.4;
        finalGrade = super.finalGrade(overAllMarks);
        return finalGrade;
    }

}
