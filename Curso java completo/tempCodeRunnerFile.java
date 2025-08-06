       Class.forName("org.sqlite.JDBC"); // Carga la clase del driver JDBC para SQLite
             // Conectar a la base de datos; se creará "miBaseDatos.db" si no existe
             conexion = DriverManager.getConnection("jdbc:sqlite:miBaseDatos.db");
             System.out.println("✅ Conexión exitosa a la base de datos.");