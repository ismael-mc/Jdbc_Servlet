/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ismael
 */
public class Connection_DataBases {

    private static Connection con;
    private static String databases = "colegio"; //Databases name
    private static String usuario = "root"; //user
    private static String clave = ""; //password

    private static Connection obtenerConexion() throws SQLException { //to connect to the databases
        if (con != null) {
            return con;
        }
        MysqlDataSource ms = new MysqlDataSource();
        ms.setDatabaseName(databases);
        ms.setUser(usuario);
        ms.setPassword(clave);

        con = ms.getConnection();
        return con;
    }

    public static Statement getSt() throws SQLException { //Method to connect to the databases
        Connection conn = obtenerConexion();
        return conn.createStatement();
    }
}
