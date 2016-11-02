/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import databases.Sql_sentences;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import students.Student_Attributes;

/**
 *
 * @author Ismael
 */
public class Student_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Student_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'><font color='red'>PLEASE SELECT A STUDENT  FROM THE DROPDOWN</font></h1>");
            out.println("<h1 align='center'>Error controlled by the developer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ResultSet resultsql = null; //Variable ResulSet
        Sql_sentences sql = new Sql_sentences(); //Object of Sql_sentences for acces at his methods
        
        ArrayList<Student_Attributes> sal = new ArrayList(); //ArrayList to save the query executed
        
        int selection = 0; //int variable to save the student selected by the user
        selection = Integer.parseInt(request.getParameter("codeSelect"));
        
        if (selection != 0) { //if selection is a student
            try (PrintWriter out = response.getWriter()) { //Print html
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Jdbc_Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table align=center width=500 border=1>");
                out.println("<h1 align='center'>Student Query</h1>");
                out.println("<tr><td><b>Student Name</b></td><td><b>Tutoria</b></td><td><b>Subject<b/></td></tr>");

                resultsql = sql.SearchStudent(selection);  //execute the query according to the selected file
                while (resultsql.next()) { //save all the required data in to the ArrayList
                    Student_Attributes salobj = new Student_Attributes(resultsql.getString(1), resultsql.getString(2), resultsql.getString(3));
                    sal.add(salobj);
                }

                for (int i = 0; i < sal.size(); i++) { //print in to a table the required datos of the selected sutudent
                    out.println("<tr><td>" + sal.get(i).getStudentName() + "</td><td>" + sal.get(i).getTutoria() + "</td><td>" + sal.get(i).getSubject() + "</td></tr>");
                }
                
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {// if selection is not a student ("choose a student")
            processRequest(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
