/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ismael
 */
public class Sql_sentences extends Connection_DataBases {

    ResultSet resultsql = null;

    public ResultSet StudentList() { //Select to the alumne table for print the student in to the dropdown
        try {
            Statement st = getSt(); //connect to the databases
            resultsql = st.executeQuery("select * from alumne order by nom asc"); //query
            return resultsql;
        } catch (Exception e) {
            System.out.println("-----ERROR----- CONNECTION NOT STABLISHED");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet SearchStudent(int codi) { //select to print the subjects and "tutorias" from the student
        try {
            Statement st = getSt();
            resultsql = st.executeQuery("Select al.nom, tu.nom, ass.nom from alumne al, assignatura ass,tutoria tu,tutoriaalumne tual "
                    + "where al.codi=tual.codiAlumne and tu.codi=tual.codiTutoria and tu.codiAssignatura=ass.codi and al.codi=" + codi);
            return resultsql;
        } catch (Exception e) {
            System.out.println("-----ERROR----- CONNECTION NOT STABLISHED");
            e.printStackTrace();
        }
        return null;
    }

}
