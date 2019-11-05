package org.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver"); // cogemos el conector
			System.out.println("conector correcto");
			String url="jdbc:mysql://localhost:3306/primera";// ruta de nuestra base de datos
			String user="root";
			String password="";
			Connection conn = DriverManager.getConnection(url, user, password); //hacemos la conexion a nuestra base de datos
			System.out.println("la conexión es: " + conn.toString());
			String consulta = "select * from clientes"; // creamos una consulta a la base de datos
			Statement st = conn.createStatement(); // necesitamos un Statement para recoger la consulta ejecutada
			ResultSet resultado = st.executeQuery(consulta);// el ResultSet recoge el Statement creado al ejecutar la consulta
			System.out.println("El ResultSet es: " + resultado);
			while(resultado.next()) { // pintamos con un bucle y mientras sea True pinta la columna elegida
				System.out.println(resultado.getString("nombre"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
