package Modelo;

public class Conexion {

	private ConexionMySQL mysql;
	private String sqlQuery;

	public Conexion() {
		this.mysql = new ConexionMySQL();
	}

	public void conectar() {

		/* Conectar a mysql server */

		mysql.conectar();
	}

	public void crearTablaCliente() {

		/* Crear base de datos Clientes */

		mysql.createDB("VideoClub");

		/* Crear tabla cliente */

		sqlQuery = "CREATE TABLE cliente (" + "ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "Nombre VARCHAR(100) DEFAULT NULL ," + "Apellido VARCHAR(100) DEFAULT NULL,"
				+ "Dirección VARCHAR(100) DEFAULT NULL," + "DNI INT(11) DEFAULT NULL," + "Fecha date DEFAULT NULL);";

		mysql.insertQuery("Clientes", sqlQuery);

	}

	public void crearTablaVideo() {

		/* Crear tabla videos */

		sqlQuery = "CREATE TABLE videos(" + "ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "Title VARCHAR(100) DEFAULT NULL ," + "Director VARCHAR(100) DEFAULT NULL,"
				+ "ID_cli INT(11) DEFAULT NULL,"
				+ "CONSTRAINT videos_fk FOREIGN KEY (ID_cli) REFERENCES cliente(ID) ON DELETE CASCADE ON UPDATE CASCADE);";

		mysql.insertQuery("Clientes", sqlQuery);
	}

	
	 /* Insertar registros en la tabla cliente */
	
	public void insertarRegistrosClientes() {
		
		sqlQuery = "INSERT INTO cliente(Nombre, Apellido, Dirección, DNI, Fecha) VALUE"
				+ "(\"Manolo\",\"Garcia\",\"Calle Francia Nº4\",\"39324562\",\"1994/09/05\"),"
				+ "(\"Maria\",\"Ramirez\",\"Calle Argentera Nº7\",\"39247289\",\"1989/08/15\"),"
				+ "(\"Juan\",\"Garcia\",\"Calle Larios Nº1\",\"39183471\",\"1995/11/25\"),"
				+ "(\"Belen\",\"Gutierrez\",\"Calle Palacios Nº32\",\"39183948\",\"1990/05/17\"),"
				+ "(\"Azucena\",\"Monte\",\"Calle Nueve Nº10\",\"39192398\",\"1998/11/12\");";
		mysql.insertQuery("Clientes", sqlQuery);
	}
	
	

	 /* Insertar registros en la tabla videos */

	public void insertarRegistrosVideos() {
		
		sqlQuery = "INSERT INTO videos (Title, Director,ID_cli) VALUE" 
		+ "(\"Cocina\",\"Arguiñano\",2),"
		+ "(\"Deportes\",\"Dani Parejo\",1),"
		+ "(\"Viajes\",\"Jesus Calleja\",3),"
		+ "(\"Cine\",\"Almodovar\",4),"
		+ "(\"Juegos\",\"Sergio\",5);";
		mysql.insertQuery("Clientes", sqlQuery);
	}

}
