/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Assignment Two
 *
 * @author ivanchong 24/3/2023 input Student input File Name: student.csv input
 * Marks File Name: marks.csv Output file: sortedList.csv
 */
public class clientClass {

    /*
    studentInfo() will print out student information, course and tutor's name
     */
    public static void studentInfo() {

        // display Student Information,StudentID,Course,Tutor
        System.out.println("Student Name : IVAN CHONG JIA HAO\n"
                + "Student Number : CT0362330\n"
                + "PT-MUR BIT(CS&F&CS)-44\n"
                + "Tutor Name: CHONG SIEW CHEONG  ");

    }

    /*
    getList() will read and add in student data into array list
     */
    public static void getList(ArrayList<studentClass> list) {

        //Method to get information from the CSV file and add to list from studentClass and subClasses.
        Scanner reader = null;
        try {
            // open of file
            reader = new Scanner(new File("Student.csv"));

           

            while (reader.hasNext()) {

                String oneLine = reader.nextLine();
                String[] extractData = oneLine.split(",");

                char check = extractData[0].charAt(0);
                if (check == 'R' || check == 'r') {
                    // create instance for r 
                    long studentIdent = Long.parseLong(extractData[3]);
                    studentClass assignRClass = new studentResearchClass(extractData[1], extractData[2], studentIdent);

                    list.add(assignRClass);

                } else if (check == 'C' || check == 'c') {
                    // create new instance 
                    long studentIdent = Long.parseLong(extractData[3]);
                    studentClass assignCclass = new studentCourseClass(extractData[1], extractData[2], studentIdent);

                    list.add(assignCclass);

                }

               

            }

        } catch (FileNotFoundException err) {

            System.out.println(err);

        } finally {
            if (reader != null) {
                reader.close();
            }

        }
    }

    /*
    setMarksToList() will read and add data file that holds marks information and add into existing array list
    additional checks is that the program will read which enroltype R OR C and then check the student ID with marks to add marks
    this will allow user to sort list before adding the marks.
     */
    public static void setMarksToList(ArrayList<studentClass> list) {

        //add marks information into existing list from file name entered by user.
        Scanner s = new Scanner(System.in);
        System.out.println("Enter File Name To Import:");
        String inFileName2 = s.nextLine();

        Scanner readerForMarksList = null;
        try {
            // read from file from inFileName 2 
            readerForMarksList = new Scanner(new File(inFileName2));

            // check if file has data
            while (readerForMarksList.hasNext()) {

                String oneLine = readerForMarksList.nextLine();
                String[] extractData = oneLine.split(",");

                char check = extractData[0].charAt(0);
                if (check == 'R' || check == 'r') {

                    double convertGrade = Double.parseDouble(extractData[3]);
                    double convertGradee = Double.parseDouble(extractData[4]);
                    long studentID = Long.parseLong(extractData[2]);

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).compareStudentID(studentID)) {

                            unitResearchClass urc = new unitResearchClass(check, convertGrade, convertGradee);

                            if (list.get(i) instanceof studentResearchClass) {
                                studentResearchClass add = (studentResearchClass) list.get(i);
                                add.setOverAllMarks(urc.researchOverAllMarks());

                                add.setFinalGrade(urc.getfinalGrade());

                            }
                        }
                    }
                } else if (check == 'C' || check == 'c') {
                    long studentID = Long.parseLong(extractData[2]);
                    double assignmentOne = Double.parseDouble(extractData[3]);
                    double assignmentTwo = Double.parseDouble(extractData[4]);
                    double examMarks = Double.parseDouble(extractData[5]);
                    char year = extractData[1].charAt(3);
                    for (int x = 0; x < list.size(); x++) {
                        if (list.get(x).compareStudentID(studentID)) {
                            unitCourseClass ucc = new unitCourseClass(check, extractData[1], year, assignmentOne, assignmentTwo, examMarks);
                            if (list.get(x) instanceof studentCourseClass) {

                                studentCourseClass add = (studentCourseClass) list.get(x);

                                add.setOverAllMarks(ucc.courseOverAllMarks());

                                add.setFinalGrade(ucc.getfinalGrade());

                            }
                        }
                    }
                }

            }

        } catch (FileNotFoundException err) {

            System.out.println(err);

        } finally {
            if (readerForMarksList != null) {
                readerForMarksList.close();
            }

        }
    }

    /*
    getMenuList() will output the menu
     */
    public static void getMenuList() {
        // print menu
        System.out.println("Press 1 Quit");
        System.out.println("Press 2 Add Marks Information For Course Work Student And Research Student To List");
        System.out.println("Press 3 Provide Student ID To Proceed With Removal Of Information From List");
        System.out.println("Press 4 Output All Information In List");
        System.out.println("Press 5 Find The Number Of Course Work Students Score Above Average Overall Marks And "
                + "Below Average Overall Marks");
        System.out.println("Press 6 Provide StudentID For Student Information");
        System.out.println("Press 7 Sort Information In List In Ascending order Of Students Identification Number(IDs)");
        System.out.println("Press 8 Export Sorted List Into A CSV file");

    }

    /*
    sortStudentID() will sort the list based on studentID in accending order
     */
    public static void sortStudentID(ArrayList<studentClass> list) {
        // sort list in accending order 
        studentClass tempData = null;

        for (int x = 0; x < list.size(); x++) {

            for (int i = 0; i < list.size(); i++) {

                if (list.get(x).getStudentID() < list.get(i).getStudentID()) {

                    tempData = list.get(x);

                    list.set(x, list.get(i));
                    list.set(i, tempData);

                }

            }
        }
    }

    /*
    findStudentInfo() will find user entered student id and display information
     */
    public static void findStudentInfo(ArrayList<studentClass> list) {
        // scan list form entered student id
        System.out.println("Enter StudentID :");
        Scanner kboard = new Scanner(System.in);
        long student = kboard.nextLong();
        boolean checker = false;
        for (int i = 0; i < list.size(); i++) {
              if (list.get(i).compareStudentID(student)){
                  System.out.println(list.get(i).reportGrade());
                  checker = true;
              }

        }
        if (checker == false) {
            System.out.println("Unable to locate Student ID :" + student);
        }
    }

    /*
    findNumStuOverAll() will find the number of student who scored above overall average marks and below average marks
     */
    public static void findNumStuOverAll(ArrayList<studentClass> list) {
        // find number of student  above and below the average overall marks
        double totalOverAllMarks = 0;
        int numCourseClassStudent = 0;
        double averageOverAllMarks = 0;
        int belowAverageCount = 0;
        int aboveAverageCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof studentCourseClass) {
                studentCourseClass x = (studentCourseClass) list.get(i);

                totalOverAllMarks += x.getOverallMarks();

                numCourseClassStudent++;

            }
        }

        averageOverAllMarks = totalOverAllMarks / numCourseClassStudent;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof studentCourseClass) {
                studentCourseClass x = (studentCourseClass) list.get(i);
                if (x.getOverallMarks() > averageOverAllMarks) {
                    belowAverageCount++;
                }
                if (x.getOverallMarks() < averageOverAllMarks) {
                    aboveAverageCount++;
                }
            }

        }

        System.out.println("Students Scored Above Overall Average Marks :" + aboveAverageCount
                + "\nStudents Scored Below Average Overall Marks :" + belowAverageCount);
    }

    /*
     printList() will print the list to display 
     */
    public static void printList(ArrayList<studentClass> list) {
        // print all information in array list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).reportGrade());
        }

    }

    /*
    removeStudentFromList() when user enter student id, program will remove student's information
     */
    public static void removeStudentFromList(ArrayList<studentClass> list) {
        // user enter student id, remove student from list , prompt user for confirmation
        System.out.println("Enter Student ID for removal of information: ");
        Scanner s = new Scanner(System.in);
        long studentIDRemoval = s.nextLong();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareStudentID(studentIDRemoval)) {
                System.out.println("Remove Student ID:" + studentIDRemoval + " Name: "
                        + list.get(i).getName() + " " + list.get(i).getSurname() + " from list");
                System.out.println("Press Y/N");
                char option = s.next().toLowerCase().charAt(0);

                if (option == 'y') {
                    list.remove(i);
                    System.out.println("Deleted");
                    break;
                }
               
                else if (option == 'n') {
                    System.out.println("Delete Fail");
                    break;
                    
                } else System.out.println( "invalid choice ");
                break;
                   

            }else if (i == list.size()-1){
                    System.out.println("Invalid student ID :" + studentIDRemoval);
                break;
            }
        }

    }

    /*
    exportSortedList() will output list to a new file "sortedList.csv"
     */
    public static void exportSortedList(ArrayList<studentClass> list) {
        // output list to a new file called sortedList.txt
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("sortedList.csv");
                for (int i = 0; i < list.size(); i++) {
            writer.println(list.get(i).reportGrade());
        }
        } catch (FileNotFoundException err) {

            System.out.println(err);

        } finally {

            if (writer != null) {
                writer.close();
            }

        }

    }

    /*
    main will declare arraylist and checker and switch case for different senerios
    checker is to check if menu list selection of number 7 have been trigger before number 8 could be executed
     */
    public static void main(String[] argv) {

        ArrayList<studentClass> list = new ArrayList<>();

        studentInfo();
        getList(list);
        boolean checker = false;

        // switchCase for user to choose between 0 - 8 
        while (true) {
            getMenuList();
            Scanner kboard = new Scanner(System.in);
            int userInput = kboard.nextInt();
            if (userInput < 0 || userInput > 8 || userInput == 1) {
                break;
            } else {
                switch (userInput) {
                    case 1:
                        break;
                    case 2:
                        setMarksToList(list);

                        break;

                    case 3:
                        removeStudentFromList(list);

                        break;

                    case 4:

                        printList(list);

                        break;
                    case 5:

                        findNumStuOverAll(list);
                        break;
                    case 6:
                        findStudentInfo(list);
                        break;
                    case 7:

                        sortStudentID(list);
                        //checker to check if 7 have been applied 
                        checker = true;
                        break;

                    case 8:
                        // check if case 7 has been applied before proceeding
                        if (checker == true) {
                            exportSortedList(list);
                        }

                        break;

                }
            }

        }

    }
}
