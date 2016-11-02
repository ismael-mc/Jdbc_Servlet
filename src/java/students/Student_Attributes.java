/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

/**
 *
 * @author Ismael
 */
public class Student_Attributes {
    private String studentName; //to save the student name
    private String tutoria; //to save de "tutoria" of the student
    private String subject; //to save the subjecto of the student

    //Constructor o
    public Student_Attributes(String studentName, String tutoria, String subject) {
        this.studentName = studentName;
        this.tutoria = tutoria;
        this.subject = subject;
    }

    //Getter to obtain the value of the variables
    public String getStudentName() {
        return studentName;
    }

    public String getTutoria() {
        return tutoria;
    }

    public String getSubject() {
        return subject;
    }

}
