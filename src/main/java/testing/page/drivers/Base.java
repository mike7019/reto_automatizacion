package testing.page.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {


    public void consultarBaseDeDatos(String cabecera) throws SQLException {
        Connection conn = null;
        try {
            // Aquí se realiza la conexión con la base de datos.
            String url = null;
            String user = null;
            String password = null;
            assert false;
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Seleccionamos todas las columnas excepto las que contienen el valor "<ignore>"
            ResultSet rs = stmt.executeQuery("SELECT * FROM tabla WHERE NOT columna = '<ignore>'");

            // Recorremos todas las columnas de la tabla
            while (rs.next()) {
                // Verificamos si el valor "<ignore>" está presente y lo negamos
                if (!rs.getString(cabecera).equals("<ignore>")) {
                    // Ejecutamos una acción específica según la cabecera de la columna
                    switch (cabecera) {
                        case "columna1":
                            // Acción para la columna 1
                            break;
                        case "columna2":
                            // Acción para la columna 2
                            break;
                        case "columna3":
                            // Acción para la columna 3
                            break;
                        // Y así sucesivamente para cada columna que necesites procesar
                    }
                }
            }

            // Cerramos todas las conexiones abiertas
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            assert false;
            conn.close();  // Multiple streams were opened. Only the last is closed.
        }
    }

}
