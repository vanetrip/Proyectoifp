package com.example.storyshareapp.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class BasedeDatos extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "Storyshare.db";

    // Constructor
    public BasedeDatos(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas
        db.execSQL("CREATE TABLE Usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_usuario TEXT," +
                "contraseña TEXT," +
                "plan_id INTEGER," +
                "plan_inicio DATE," +
                "plan_fin DATE," +
                "nombreCompleto TEXT," +
                "email TEXT," +
                "edad INTEGER)"
        );

        // Crear la tabla PlanPrecios
        db.execSQL("CREATE TABLE PlanPrecios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_plan TEXT," +
                "precio FLOAT)"
        );

        // Crear la tabla Libros_Usuario
        db.execSQL("CREATE TABLE LibrosUsuario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "libro_id INTEGER," +
                "usuario_id INTEGER," +
                "valoracion INTEGER," +
                "favorito BOOLEAN," +
                "comentarios TEXT)"
        );

        // Crear la tabla Libros
        db.execSQL("CREATE TABLE Libros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "genero TEXT," +
                "titulo TEXT," +
                "autor TEXT," +
                "fecha_publicacion DATE," +
                "valoracion_media INTEGER," +
                "portada TEXT)"
        );

        // Crear la tabla Eventos
        db.execSQL("CREATE TABLE Eventos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "fecha DATE," +
                "hora TIME," +
                "moderador_id INTEGER," +
                "libro_id INTEGER)"
        );

        // Crear la tabla Temas
        db.execSQL("CREATE TABLE Foros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "creador_id INTEGER," +
                "id_libro INTEGER," +
                "fecha_creacion DATE)"
        );

        // Crear la tabla ComentariosForo
        db.execSQL("CREATE TABLE ComentariosForo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_foro INTEGER," +
                "id_usuario INTEGER," +
                "comentario TEXT," +
                "fecha DATE," +
                "hora TIME)"
        );

        // Inserción de libros
        db.execSQL("INSERT INTO Libros (genero, titulo, autor, fecha_publicacion, valoracion_media, portada) VALUES " +
                "('Fantasía', 'El Señor de los Anillos', 'J.R.R. Tolkien', '1954-07-29', 4, 'https://m.media-amazon.com/images/I/81DjOU3MIvL._SL1500_.jpg'), " +
                "('Ciencia Ficción', '1984', 'George Orwell', '1949-06-08', 4, 'https://m.media-amazon.com/images/I/71sOSrd+JxL._SL1500_.jpg'), " +
                "('Misterio', 'El Código Da Vinci', 'Dan Brown', '2003-03-18', 4, 'https://m.media-amazon.com/images/I/81flVY5AzaL._SL1500_.jpg'), " +
                "('Romance', 'Orgullo y Prejuicio', 'Jane Austen', '1813-01-28', 5, 'https://m.media-amazon.com/images/I/91F-tGwtyFL._SL1500_.jpg'), " +
                "('Aventura', 'La Isla del Tesoro', 'Robert Louis Stevenson', '1883-11-14', 4, 'https://m.media-amazon.com/images/I/71Xe94-ddFL._SL1125_.jpg'), " +
                "('Terror', 'It', 'Stephen King', '1986-09-15', 4, 'https://m.media-amazon.com/images/I/61pveRMfvcL._SL1500_.jpg'), " +
                "('Ciencia Ficción', 'Dune', 'Frank Herbert', '1965-06-01', 4, 'https://m.media-amazon.com/images/I/81A1Mn-x49L._SL1500_.jpg'), " +
                "('Fantasía', 'Harry Potter y la Piedra Filosofal', 'J.K. Rowling', '1997-06-26', 5, 'https://m.media-amazon.com/images/I/81DIK77B0PL._SL1500_.jpg'), " +
                "('Drama', 'Cien Años de Soledad', 'Gabriel García Márquez', '1967-05-30', 5, 'https://m.media-amazon.com/images/I/A1lNJP8sC6L._SL1500_.jpg'), " +
                "('Romance', 'Romeo y Julieta', 'William Shakespeare', '1597-01-20', 5, 'https://m.media-amazon.com/images/I/81qJ-ARZhsL._SL1500_.jpg'), " +
                "('Thriller', 'El Silencio de los Corderos', 'Thomas Harris', '1988-05-05', 4, 'https://m.media-amazon.com/images/I/81maxs5mO7L._SL1500_.jpg'), " +
                "('Fantasía', 'Las Crónicas de Narnia: El León, la Bruja y el Armario', 'C.S. Lewis', '1988-05-05', 4, 'https://m.media-amazon.com/images/I/81mSMwtCE7L._SL1500_.jpg'), " +
                "('Romance', 'Crepúsculo', 'Stephenie Meyer', '2005-10-05', 4, 'https://m.media-amazon.com/images/I/618bMH3QLOL._SL1500_.jpg'), " +
                "('Terror', 'Drácula', 'Bram Stoker', '1897-05-26', 4, 'https://m.media-amazon.com/images/I/71hhPWoeNBS._SL1000_.jpg'), " +
                "('Misterio', 'Sherlock Holmes: Estudio en Escarlata', 'Arthur Conan Doyle', '1887-11-01', 4, 'https://m.media-amazon.com/images/I/7167Blq5N-L._SL1500_.jpg'), " +
                "('Ciencia Ficción', 'Guía del Autoestopista Galáctico', 'Douglas Adams', '1979-10-12', 4, 'https://m.media-amazon.com/images/I/81DGy-chD1L._SL1500_.jpg'), " +
                "('Fantasía', 'El Hobbit', 'J.R.R. Tolkien', '1937-09-21', 4, 'https://m.media-amazon.com/images/I/914VEoNzIPL._SL1500_.jpg'), " +
                "('Romance', 'Anna Karenina', 'Lev Tolstói', '1877-03-01', 4, 'https://m.media-amazon.com/images/I/71wLs1YK8yL._SL1000_.jpg'), " +
                "('Ciencia Ficción', 'Fundación', 'Isaac Asimov', '1951-06-01', 4, 'https://m.media-amazon.com/images/I/811QjmMJxuL._SL1500_.jpg'), " +
                "('Aventura', 'La vuelta al mundo en 80 días', 'Julio Verne', '1873-01-30', 4, 'https://m.media-amazon.com/images/I/A16vPjDrebS._SL1500_.jpg')"
        );

        // Inserción del usuario Maria
        db.execSQL("INSERT INTO Usuarios (nombre_usuario, contraseña, plan_id, plan_inicio, plan_fin, nombreCompleto, email, edad) VALUES " +
                "('maria', 'maria123', 1, '2024-05-01', '2025-05-01', 'Maria Molina', 'maria@example.com', 29)"
        );

        // Inserción de eventos
        db.execSQL("INSERT INTO Eventos (nombre, fecha, hora, moderador_id, libro_id) VALUES " +
                "('Evento de Fantasía', '2024-06-15', '18:00', 1, 1), " +
                "('Ciencia Ficción: Dune', '2024-07-20', '20:00', 1, 7), " +
                "('Encuentro de Misterio', '2024-08-10', '17:00', 1, 3), " +
                "('Terror Nocturno', '2024-10-31', '22:00', 1, 13), " +
                "('Clásicos de la Literatura', '2024-12-05', '19:00', 1, 9)"
        );

        // Insertar foros
        db.execSQL("INSERT INTO Foros (nombre, creador_id, id_libro, fecha_creacion) VALUES " +
                "('Foro de Dune 1', 2, 7, '2024-06-25'), " +
                "('Foro de Romeo y Julieta 1', 3, 10, '2024-07-01'), " +
                "('Foro de Crepúsculo 1', 4, 12, '2024-07-05'), " +
                "('Foro de Drácula 1', 5, 14, '2024-07-10'), " +
                "('Foro de Sherlock Holmes 1', 1, 15, '2024-07-15'), " +
                "('Foro de Dune 2', 2, 7, '2024-06-25'), " +
                "('Foro de Romeo y Julieta 2', 3, 10, '2024-07-02'), " +
                "('Foro de Crepúsculo 2', 4, 12, '2024-07-06'), " +
                "('Foro de Drácula 2', 5, 14, '2024-07-11'), " +
                "('Foro de Sherlock Holmes 2', 1, 15, '2024-07-17'), " +
                "('Foro de El Señor de los Anillos', 2, 1, '2024-06-25'), " +
                "('Foro de 1984', 3, 2, '2024-07-01'), " +
                "('Foro de Orgullo y Prejuicio', 4, 4, '2024-07-08'), " +
                "('Foro de La Isla del Tesoro', 5, 5, '2024-07-13'), " +
                "('Foro de Harry Potter y la Piedra Filosofal', 1, 8, '2024-07-18'), " +
                "('Foro de El Hobbit', 2, 18, '2024-06-27'), " +
                "('Foro de Anna Karenina', 3, 19, '2024-07-03'), " +
                "('Foro de Fundación', 4, 20, '2024-07-02'), " +
                "('Foro de La vuelta al mundo en 80 días', 5, 21, '2024-07-04'), " +
                "('Foro de El Señor de los Anillos 2', 2, 1, '2024-06-27'), " +
                "('Foro de Dune 3', 2, 7, '2024-06-28'), " +
                "('Foro de Romeo y Julieta 3', 3, 10, '2024-07-02'), " +
                "('Foro de Crepúsculo 3', 4, 12, '2024-07-07'), " +
                "('Foro de Drácula 3', 5, 14, '2024-07-17'), " +
                "('Foro de Sherlock Holmes 3', 1, 15, '2024-07-16')");

        db.execSQL("INSERT INTO ComentariosForo (id_foro, id_usuario, comentario, fecha, hora) VALUES " +
                "(1, 1, '¡Qué interesante discusión!', '2024-05-01', '09:30'), " +
                "(1, 2, 'Estoy de acuerdo contigo.', '2024-05-02', '10:15'), " +
                "(1, 3, '¿Alguien ha leído el libro?', '2024-05-03', '11:45'), " +
                "(1, 4, 'No he tenido la oportunidad de leerlo aún.', '2024-05-04', '13:20'), " +
                "(1, 5, 'Me encantaría unirme a esta discusión.', '2024-05-05', '15:00'), " +
                "(2, 1, '¿Qué opinan sobre el personaje principal?', '2024-05-06', '09:30'), " +
                "(2, 2, 'Creo que es un personaje bien desarrollado.', '2024-05-07', '10:15'), " +
                "(2, 3, 'Su evolución a lo largo de la historia es impresionante.', '2024-05-08', '11:45'), " +
                "(2, 4, 'Estoy de acuerdo contigo, es uno de mis personajes favoritos.', '2024-05-09', '13:20'), " +
                "(2, 5, 'Me encanta cómo el autor lo retrató.', '2024-05-10', '15:00'), " +
                "(3, 1, '¿Alguien tiene teorías sobre el final?', '2024-05-11', '09:30'), " +
                "(3, 2, 'Creo que el final fue sorprendente pero satisfactorio.', '2024-05-12', '10:15'), " +
                "(3, 3, 'Yo también quedé impresionado.', '2024-05-13', '11:45'), " +
                "(3, 4, 'Pero creo que podría haber sido un poco más abierto.', '2024-05-14', '13:20'), " +
                "(3, 5, 'Estoy de acuerdo, dejó algunas incógnitas sin resolver.', '2024-05-15', '15:00'), " +
                "(4, 1, '¿Cuál fue su parte favorita?', '2024-05-16', '09:30'), " +
                "(4, 2, 'Definitivamente la escena de acción en el capítulo cinco.', '2024-05-17', '10:15'), " +
                "(4, 3, 'Esa parte fue emocionante, pero prefiero los momentos más emotivos.', '2024-05-18', '11:45'), " +
                "(4, 5, '¡Me encantaría debatir sobre eso!', '2024-05-20', '15:00'), " +
                "(5, 1, '¿Alguien ha notado los simbolismos en la obra?', '2024-05-21', '09:30'), " +
                "(5, 2, 'Sí, hay muchos detalles sutiles que merecen atención.', '2024-05-22', '10:15'), " +
                "(5, 3, 'Estoy de acuerdo, el autor tiene un estilo único.', '2024-05-23', '11:45'), " +
                "(5, 5, 'Definitivamente, es uno de los aspectos más interesantes de la obra.', '2024-05-25', '15:00')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes manejar la actualización de la base de datos si cambias la versión
    }

    // Método para verificar credenciales
    public static boolean verificarCredenciales(SQLiteDatabase db, String nombreUsuario, String contraseña) {
        Cursor cursor = db.rawQuery("SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contraseña = ?", new String[]{nombreUsuario, contraseña});
        boolean credencialesCorrectas = cursor.getCount() > 0;
        cursor.close();
        return credencialesCorrectas;
    }

    public static int obtenerId(SQLiteDatabase db, String nombreUsuario) {
        int userId = -1; // Valor por defecto si no se encuentra el usuario
        Cursor cursor = db.rawQuery("SELECT id FROM Usuarios WHERE nombre_usuario = ?", new String[]{nombreUsuario});
        if (cursor.moveToFirst()) {
            userId = cursor.getInt(0); // Obtiene el valor de la primera columna (en este caso, la columna "id")
        }
        cursor.close();
        return userId;
    }

    // Método para insertar un usuario
    public int insertarUsuario(final Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre_usuario", usuario.getNombreUsuario());
        values.put("contraseña", usuario.getContraseña());
        values.put("plan_id", usuario.getPlanId());
        values.put("plan_inicio", usuario.getPlanInicio().getTime()); // Convertir Date a milisegundos
        values.put("plan_fin", usuario.getPlanFin().getTime()); // Convertir Date a milisegundos
        values.put("nombreCompleto", usuario.getNombre());
        values.put("email", usuario.getEmail());
        values.put("edad", usuario.getEdad());
        int id = (int) db.insert("Usuarios", null, values);
        db.close(); // Cerrar la conexión
        return id;
    }

    public void updateUsuario(int idUsuario, String nuevoUsername, String nuevaContraseña, String nuevoNombreCompleto, int nuevaEdad) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (nuevoUsername != null && !nuevoUsername.isEmpty()) {
            values.put("nombre_usuario", nuevoUsername);
        }
        if (nuevaContraseña != null && !nuevaContraseña.isEmpty()) {
            values.put("contraseña", nuevaContraseña);
        }
        if (nuevoNombreCompleto != null && !nuevoNombreCompleto.isEmpty()) {
            values.put("nombreCompleto", nuevoNombreCompleto);
        }
        if (nuevaEdad > 0) {
            values.put("edad", nuevaEdad);
        }

        db.update("Usuarios", values, "id=?", new String[]{String.valueOf(idUsuario)});
        db.close();
    }

    public void borrarUsuario(int idUsuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Usuarios", "id=?", new String[]{String.valueOf(idUsuario)});
        db.close();
    }

    public Usuario obtenerUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Usuarios WHERE id = ?", new String[]{String.valueOf(id)});
        if (cursor != null) {
            cursor.moveToFirst();
            // Parseo de las fechas
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date planInicio = null;
            Date planFin = null;
            try {
                planInicio = dateFormat.parse(cursor.getString(cursor.getColumnIndexOrThrow("plan_inicio")));
                planFin = dateFormat.parse(cursor.getString(cursor.getColumnIndexOrThrow("plan_fin")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Usuario usuario = new Usuario(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombre_usuario")),
                    cursor.getString(cursor.getColumnIndexOrThrow("contraseña")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("plan_id")),
                    planInicio,
                    planFin,
                    cursor.getString(cursor.getColumnIndexOrThrow("email")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("edad")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombreCompleto"))
            );
            cursor.close();
            return usuario;
        }
        return null;
    }

    public void eliminarBaseDeDatos() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS PlanPrecios");
        db.execSQL("DROP TABLE IF EXISTS LibrosUsuario");
        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL("DROP TABLE IF EXISTS Eventos");
        db.execSQL("DROP TABLE IF EXISTS Foros");
        db.execSQL("DROP TABLE IF EXISTS ComentariosForo");
        onCreate(db); // Volver a crear la base de datos después de eliminarla
    }

    public List<Integer> obtenerIdForosPopulares() {
        List<Integer> idForosPopulares = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id_foro, COUNT(id_foro) AS count FROM ComentariosForo GROUP BY id_foro ORDER BY count DESC LIMIT 3", null);
        if (cursor.moveToFirst()) {
            do {
                int idForo = cursor.getInt(0);
                idForosPopulares.add(idForo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return idForosPopulares;
    }

    public int obtenerIdLibroPorIdForo(int idForo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id_libro FROM Foros WHERE id = ?", new String[]{String.valueOf(idForo)});
        int idLibro = -1; // Valor por defecto si no se encuentra
        if (cursor.moveToFirst()) {
            idLibro = cursor.getInt(0);
        }
        cursor.close();
        return idLibro;
    }

    public Libro obtenerLibro(int idLibro) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Libros WHERE id = ?", new String[]{String.valueOf(idLibro)});
        Libro libro = null;
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            String genero = cursor.getString(1);
            String titulo = cursor.getString(2);
            String autor = cursor.getString(3);
            String fechaPublicacionString = cursor.getString(4);
            int valoracion = cursor.getInt(5);
            String portada = cursor.getString(6);

            libro = new Libro(id, titulo, autor, genero, fechaPublicacionString, valoracion, portada);
        }
        cursor.close();
        return libro;
    }

    public List<Integer> obtenerLibrosMasRecientes() {
        List<Integer> librosMasRecientes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT libro_id FROM Eventos ORDER BY fecha DESC LIMIT 3", null);
        if (cursor.moveToFirst()) {
            do {
                int libroId = cursor.getInt(5);
                librosMasRecientes.add(libroId);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return librosMasRecientes;
    }

    public List<Integer> obtenerForosMasRecientes() {
        List<Integer> librosMasRecientes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id_libro FROM Foros ORDER BY fecha_creacion DESC LIMIT 3", null);
        if (cursor.moveToFirst()) {
            do {
                int libroId = cursor.getInt(3);
                librosMasRecientes.add(libroId);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return librosMasRecientes;
    }

    public List<Libro> obtenerLibrosEnOrdenAlfabetico() {
        List<Libro> libros = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Libros ORDER BY titulo ASC", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String genero = cursor.getString(1);
                String titulo = cursor.getString(2);
                String autor = cursor.getString(3);
                String fechaPublicacionString = cursor.getString(4);
                int valoracion = cursor.getInt(5);
                String portada = cursor.getString(6);
                Libro libro = new Libro(id, titulo, autor, genero, fechaPublicacionString, valoracion, portada);
                libros.add(libro);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return libros;
    }

    public List<Integer> obtenerLibrosFavoritosPorUsuario(int usuarioId) {
        List<Integer> librosFavoritos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT libro_id FROM LibrosUsuario WHERE usuario_id = ? AND favorito = 1", new String[]{String.valueOf(usuarioId)});
        if (cursor.moveToFirst()) {
            do {
                int libroId = cursor.getInt(1);
                librosFavoritos.add(libroId);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return librosFavoritos;
    }

    public List<Libro> obtenerLibrosPorIds(List<Integer> ids) {
        List<Libro> libros = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String idsStr = ids.toString().replace("[", "").replace("]", ""); // Convierte la lista de IDs a una cadena separada por comas
        Cursor cursor = db.rawQuery("SELECT * FROM Libros WHERE id IN (" + idsStr + ")", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String genero = cursor.getString(1);
                String titulo = cursor.getString(2);
                String autor = cursor.getString(3);
                String fechaPublicacionString = cursor.getString(4);
                int valoracion = cursor.getInt(5);
                String portada = cursor.getString(6);
                Libro libro = new Libro(id, titulo, autor, genero, fechaPublicacionString, valoracion, portada);
                libros.add(libro);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return libros;
    }
    public long insertarEvento(Evento evento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", evento.getNombreEvento());
        values.put("fecha", String.valueOf(evento.getFecha()));
        values.put("hora", String.valueOf(evento.getHora()));
        values.put("moderador_id", evento.getModeradorId());
        values.put("libro_id", evento.getLibroId());
        long id = db.insert("Eventos", null, values);
        db.close();
        return id;
    }
    public long insertarTema(Foro foro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", foro.getNombre());
        values.put("creador_id", foro.getCreadorId());
        values.put("id_libro", foro.getIdLibro());
        values.put("Fecha", String.valueOf(foro.getFechaCreacion()));

        long id = db.insert("Foros", null, values);
        db.close();
        return id;
    }
                   
    public List<Integer> obtenerIdeventosMasRecientes() {
        List<Integer> eventosMasRecientes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, COUNT(id) AS COUNT FROM Eventos GROUP BY id ORDER BY fecha DESC LIMIT 3", null);
        if (cursor.moveToFirst()) {
            do {
                eventosMasRecientes.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return eventosMasRecientes;
    }

    public int obtenerIdLibroPorIdevento(int idEvento) {
        int idLibro = -1; // Default value if no ID is found
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT libro_id FROM Eventos WHERE id = ?", new String[]{String.valueOf(idEvento)});
        if (cursor != null && cursor.moveToFirst()) {
            idLibro = cursor.getInt(0);
            cursor.close();
        }
        return idLibro;
    }

    public List<Integer> obtenerIdForosrecientes() {
        List<Integer> idForosrecientes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, COUNT(id) AS COUNT FROM Foros GROUP BY id ORDER BY fecha_creacion DESC LIMIT 3", null);
        if (cursor.moveToFirst()) {
            do {
                int idForo = cursor.getInt(0);
                idForosrecientes.add(idForo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return idForosrecientes;
    }

    public List<Integer> buscarIdLibrosPorTitulo(String texto) {
        List<Integer> idLibros = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM Libros WHERE titulo LIKE ? ORDER BY fecha_publicacion DESC", new String[]{"%" + texto + "%"});
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idLibro = cursor.getInt(0);
                idLibros.add(idLibro);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return idLibros;
    }

    public int buscarIdLibroPorTitulo(String texto) {
        int idLibro = -1; // Valor predeterminado en caso de que no se encuentre ningún resultado
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM Libros WHERE titulo LIKE ? ORDER BY fecha_publicacion DESC LIMIT 1", new String[]{"%" + texto + "%"});
        if (cursor != null && cursor.moveToFirst()) {
            idLibro = cursor.getInt(0);
            cursor.close();
        }
        return idLibro;
    }

    public int obtenerIdEventoMasProximo(int idLibro) {
        int idEvento = -1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id FROM Eventos WHERE libro_id = ? AND fecha >= DATE('now') ORDER BY fecha ASC LIMIT 1", new String[]{String.valueOf(idLibro)});
        if (cursor != null && cursor.moveToFirst()) {
            idEvento = cursor.getInt(0);
            cursor.close();
        }
        return idEvento;
    }

    public Evento obtenerEvento(int idEvento) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Eventos WHERE id = ?", new String[]{String.valueOf(idEvento)});
        Evento evento = null;
        if (cursor != null && cursor.moveToFirst()) {
            String nombre = cursor.getString(1);
            String fechaString = cursor.getString(2);
            String horaString = cursor.getString(3);
            int moderadorId = cursor.getInt(4);
            int libroId = cursor.getInt(5);

            // Convertir las cadenas de fecha y hora a objetos Date y Time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            Date fecha = null;
            Time hora = null;
            try {
                fecha = dateFormat.parse(fechaString);
                hora = new Time(timeFormat.parse(horaString).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Crear el objeto Evento
            evento = new Evento(idEvento, nombre, fecha, hora, moderadorId, libroId);

            cursor.close();
        }
        return evento;
    }

    public boolean libroFavorito(int usuarioId, int libroId) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean favorito = false;
        Cursor cursor = db.rawQuery("SELECT favorito FROM LibrosUsuario WHERE usuario_id = ? AND libro_id = ?", new String[]{String.valueOf(usuarioId), String.valueOf(libroId)});
        if (cursor.moveToFirst()) {
            favorito = cursor.getInt(0) > 0;
        }
        cursor.close();
        db.close();
        return favorito;
    }

    public void agregarFavorito(int idUsuario, int idLibro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("favorito", true);
        int rowsUpdated = db.update("LibrosUsuario", values, "usuario_id = ? AND libro_id = ?", new String[]{String.valueOf(idUsuario), String.valueOf(idLibro)});
        if (rowsUpdated == 0) {
            values.put("usuario_id", idUsuario);
            values.put("libro_id", idLibro);
            db.insert("LibrosUsuario", null, values);
        }
    }

    public void eliminarFavorito(int idUsuario, int idLibro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("favorito", false);
        db.update("LibrosUsuario", values, "usuario_id = ? AND libro_id = ?", new String[]{String.valueOf(idUsuario), String.valueOf(idLibro)});
    }

    public List<Integer> obtenerLibrosFavoritos(int usuarioId) {
        List<Integer> librosIds = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT libro_id FROM LibrosUsuario WHERE usuario_id = ? AND favorito = ?";
        String[] selectionArgs = {String.valueOf(usuarioId), "1"};
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()) {
            do {
                int libroId = cursor.getInt(0);
                librosIds.add(libroId);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return librosIds;
    }

    public List<Evento> obtenerEventosOrdenadosPorFecha() {
        List<Evento> eventos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Eventos ORDER BY fecha ASC";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nombreEvento = cursor.getString(1);
                String fechaString = cursor.getString(2);
                String horaString = cursor.getString(3);
                int moderadorId = cursor.getInt(4);
                int libroId = cursor.getInt(5);

                // Convertir las cadenas de fecha y hora a objetos Date y Time
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                Date fecha = null;
                Time hora = null;
                try {
                    fecha = dateFormat.parse(fechaString);
                    hora = new Time(timeFormat.parse(horaString).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Crear el objeto Evento
                Evento evento = new Evento(id, nombreEvento, fecha, hora, moderadorId, libroId);
                eventos.add(evento);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eventos;
    }

    public Evento buscarEventoPorNombre(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Eventos WHERE nombre = ?", new String[]{nombre});
        Evento evento = null;
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            String nombreEvento = cursor.getString(1);
            long fechaMillis = cursor.getLong(2);
            Date fecha = new Date(fechaMillis);
            long horaMillis = cursor.getLong(3);
            Time hora = new Time(horaMillis);
            int moderadorId = cursor.getInt(4);
            int libroId = cursor.getInt(5);

            evento = new Evento(id, nombreEvento, fecha, hora, moderadorId, libroId);
        }
        cursor.close();
        return evento;
    }
}
