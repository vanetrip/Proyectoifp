package com.example.storyshareapp.Persistencia;

import androidx.annotation.Nullable;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;

public class BasedeDatos extends SQLiteOpenHelper {
    public BasedeDatos(@Nullable Context context) {
        super(context, "Libros", null, 1);
    }

    @Override

    //Crear tablas
            public void onCreate(SQLiteDatabase db) {
                // Crear la tabla eventos
                db.execSQL("CREATE TABLE eventos(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "nombre_evento TEXT," +
                        "fecha TEXT," +
                        "hora TEXT," +
                        "moderador_id INTEGER," +
                        "libro_id INTEGER)");
                // Crear la tabla eventosRegistro
                db.execSQL("CREATE TABLE eventosRegistro(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "evento_id INTEGER," +
                        "usuario_id INTEGER)");
                //Crear la tabla libros
                db.execSQL("CREATE TABLE libros(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "autor TEXT," +
                        "fechapublicacion TEXT," +
                        "genero TEXT," +
                        "titulo TEXT," +
                        "valoracion INTEGER)");
                // Crear la tabla LibrosValoracion
                db.execSQL("CREATE TABLE LibrosValoracion(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "usuario_valoracion TEXT," +
                        "valoracion INTEGER)");

                // Crear la tabla mensajes
                db.execSQL("CREATE TABLE mensajes(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "usuario_destino_id INTEGER," +
                        "usuario_origen_id INTEGER," +
                        "texto_sms TEXT," +
                        "borrar_sms INTEGER)");

                // Crear la tabla plan_precios
                db.execSQL("CREATE TABLE plan_precios(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "planprecio TEXT)");

                // Crear la tabla usuarios
                db.execSQL("CREATE TABLE usuarios(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "nombreUsuario TEXT," +
                        "contraseña TEXT," +
                        "plan_id INTEGER," +
                        "plan_inicio TEXT," +
                        "plan_fin TEXT," +
                        "nombre TEXT," +
                        "apellido TEXT," +
                        "email TEXT," +
                        "fecha_nacimiento TEXT)");

    // Insertar Registros
                // Insertar libros con los registros proporcionados
                String[][] libros = {
                        {"Laura García Moreno", "15 de marzo de 2023", "Fantasía", "El jardín de las almas perdidas", "5"},
                        {"Martín Sánchez Gómez", "8 de julio de 2023", "Ciencia Ficción", "El último suspiro del invierno", "4"},
                        {"Ana Martínez López", "21 de septiembre de 2023", "Suspense", "La sombra del destino", "3"},
                        {"Carlos Ruiz Gutiérrez", "4 de enero de 2024", "Fantasía Épica", "El legado de los ancestros", "5"},
                        {"Carmen Sánchez García", "12 de abril de 2024", "Misterio", "Los secretos del abismo", "4"},
                        {"Javier López Rodríguez", "3 de julio de 2024", "Ciencia Ficción", "Más allá de las estrellas", "3"},
                        {"María Pérez Ruiz", "18 de septiembre de 2024", "Thriller Psicológico", "El susurro de la noche", "5"},
                        {"Juan Gómez Sánchez", "29 de noviembre de 2024", "Ficción Literaria", "El laberinto de la mente", "4"},
                        {"Teresa Martínez", "7 de febrero de 2023", "Drama", "El vuelo del colibrí", "3"},
                        {"Pablo García Fernández", "15 de mayo de 2023", "Fantasía Urbana", "La ciudad de los espejos", "5"},
                        {"Marta López Sánchez", "28 de agosto de 2023", "Misterio", "El último testamento", "4"},
                        {"Daniel Rodríguez Martín", "2 de noviembre de 2023", "Ciencia Ficción", "El ocaso de los dioses", "3"},
                        {"Sandra Gómez Ramírez", "12 de enero de 2024", "Romance", "La llama eterna", "5"},
                        {"Alejandro Pérez Jiménez", "8 de marzo de 2024", "Aventura", "El eco de las montañas", "4"},
                        {"Laura García Moreno", "19 de mayo de 2024", "Thriller", "La dama de la medianoche", "3"},
                        {"Juan Martínez Torres", "3 de agosto de 2024", "Político", "El precio del poder", "5"},
                        {"Claudia Sánchez Ruiz", "14 de octubre de 2024", "Suspense", "El misterio del faro", "4"},
                        {"Ana López García", "25 de diciembre de 2024", "Ficción Histórica", "El renacer de la esperanza", "3"},
                        {"Javier Pérez Martínez", "6 de marzo de 2023", "Romance Paranormal", "Bajo la luz de la luna", "5"},
                        {"Marta García Pérez", "19 de junio de 2023", "Drama Psicológico", "La voz del silencio", "4"}
                };

                for (String[] libro : libros) {
                    String autor = libro[0];
                    String fechaPublicacion = libro[1];
                    String genero = libro[2];
                    String titulo = libro[3];
                    int valoracion = Integer.parseInt(libro[4]);

                    String query = String.format("INSERT INTO libros (autor, fechapublicacion, genero, titulo, valoracion) VALUES ('%s', '%s', '%s', '%s', %d)",
                            autor, fechaPublicacion, genero, titulo, valoracion);

                    db.execSQL(query);
                }}

    @Override
    // Eliminar todas las tablas existentes si es que existen
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS eventosRegistro");
            db.execSQL("DROP TABLE IF EXISTS eventos");
            db.execSQL("DROP TABLE IF EXISTS libros");
            db.execSQL("DROP TABLE IF EXISTS LibrosValoracion");
            db.execSQL("DROP TABLE IF EXISTS mensajes");
            db.execSQL("DROP TABLE IF EXISTS plan_precios");
            db.execSQL("DROP TABLE IF EXISTS usuarios");
            onCreate(db);
    }

    // Borrar registros por id

            //Metodo tabla EventoRegistro
            public boolean borrarEventoRegistro(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM eventosRegistro WHERE id=" + id);
                return true;
            }
            //Metodo tabla eventos
            public boolean borrarEvento(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM eventos WHERE id=" + id);
                return true;
            }

            //Metodo tabla LibrosValoracion
            public boolean borrarLibroValoracion(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM LibrosValoracion WHERE id=" + id);
                return true;
            }

            //Metodo tabla mensajes
            public boolean borrarMensaje(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM mensajes WHERE id=" + id);
                return true;
            }

            //Metodo tabla plan_precios
            public boolean borrarPlanPrecio(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM plan_precios WHERE id=" + id);
                return true;
            }

            //Metodo tabla usuarios
            public boolean borrarUsuario(String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM usuarios WHERE id=" + id);
                return true;
            }
    //Insertar registros

            // Método insertar con la tabla eventosRegistro
            public boolean insertarEventoRegistro(int evento_id, int usuario_id) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO eventosRegistro (evento_id, usuario_id) VALUES (%d, %d)", evento_id, usuario_id);
                db.execSQL(query);
                return true;
            }

            // Método insertar con la tabla eventos
            public boolean insertarEvento(String nombre_evento, String fecha, String hora, int moderador_id, int libro_id) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO eventos (nombre_evento, fecha, hora, moderador_id, libro_id) VALUES ('%s', '%s', '%s', %d, %d)", nombre_evento, fecha, hora, moderador_id, libro_id);
                db.execSQL(query);
                return true;
            }

            // Método insertar con la tabla LibrosValoracion
            public boolean insertarLibroValoracion(String usuario_valoracion, int valoracion) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO LibrosValoracion (usuario_valoracion, valoracion) VALUES ('%s', %d)", usuario_valoracion, valoracion);
                db.execSQL(query);
                return true;
            }

            // Método insertar con la tabla mensajes
            public boolean insertarMensaje(int usuario_destino_id, int usuario_origen_id, String texto_sms, int borrar_sms) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO mensajes (usuario_destino_id, usuario_origen_id, texto_sms, borrar_sms) VALUES (%d, %d, '%s', %d)", usuario_destino_id, usuario_origen_id, texto_sms, borrar_sms);
                db.execSQL(query);
                return true;
            }

            // Método insertar con la tabla plan_precios
            public boolean insertarPlanPrecio(String plan) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO plan_precios (planprecio) VALUES ('%s')", plan);
                db.execSQL(query);
                return true;
            }

            // Método insertar con la tabla usuarios
            public boolean insertarUsuario(String nombreUsuario, String contraseña, int plan_id, String plan_inicio, String plan_fin, String nombre, String apellido, String email, String fecha_nacimiento) {
                SQLiteDatabase db = this.getWritableDatabase();
                String query = String.format("INSERT INTO usuarios (nombreUsuario, contraseña, plan_id, plan_inicio, plan_fin, nombre, apellido, email, fecha_nacimiento) VALUES ('%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s')", nombreUsuario, contraseña, plan_id, plan_inicio, plan_fin, nombre, apellido, email, fecha_nacimiento);
                db.execSQL(query);
                return true;
            }

     //Eliminar todos los registros

            // Método eliminar todos los registros de la tabla eventosRegistro
            public boolean eliminarTodosLosEventosRegistro() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM eventosRegistro");
                return true;
            }

            // Método eliminar todos los registros de la tabla eventos
            public boolean eliminarTodosLosEventos() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM eventos");
                return true;
            }

            // Método eliminar todos los registros de la tabla LibrosValoracion
            public boolean eliminarTodosLosLibrosValoracion() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM LibrosValoracion");
                return true;
            }

            // Método eliminar todos los registros de la tabla mensajes
            public boolean eliminarTodosLosMensajes() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM mensajes");
                return true;
            }

            // Método eliminar todos los registros de la tabla plan_precios
            public boolean eliminarTodosLosPlanPrecios() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM plan_precios");
                return true;
            }

            // Método eliminar todos los registros de la tabla usuarios
            public boolean eliminarTodosLosUsuarios() {
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("DELETE FROM usuarios");
                return true;
            }
    //Metodo para obtener todos los registros de una tabla

            // Método para obtener todos los registros de la tabla eventosRegistro
            public ArrayList<String> obtenerTodosLosEventosRegistro() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM eventosRegistro", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Evento ID: " + res.getString(1) + ", Usuario ID: " + res.getString(2));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }

            // Método para obtener todos los registros de la tabla eventos
            public ArrayList<String> obtenerTodosLosEventos() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM eventos", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Nombre del evento: " + res.getString(1) + ", Fecha: " + res.getString(2) + ", Hora: " + res.getString(3) + ", Moderador ID: " + res.getString(4) + ", Libro ID: " + res.getString(5));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }

            // Método para obtener todos los registros de la tabla LibrosValoracion
            public ArrayList<String> obtenerTodosLosLibrosValoracion() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM LibrosValoracion", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Usuario valoración: " + res.getString(1) + ", Valoración: " + res.getString(2));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }

            // Método para obtener todos los registros de la tabla mensajes
            public ArrayList<String> obtenerTodosLosMensajes() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM mensajes", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Usuario destino ID: " + res.getString(1) + ", Usuario origen ID: " + res.getString(2) + ", Texto SMS: " + res.getString(3) + ", Borrar SMS: " + res.getString(4));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }

            // Método para obtener todos los registros de la tabla plan_precios
            public ArrayList<String> obtenerTodosLosPlanPrecios() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM plan_precios", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Planprecio: " + res.getString(1));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }

            // Método para obtener todos los registros de la tabla usuarios
            public ArrayList<String> obtenerTodosLosUsuarios() {
                ArrayList<String> lista = new ArrayList<>();
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res = db.rawQuery("SELECT * FROM usuarios", null);

                if (res.moveToFirst()) {
                    do {
                        lista.add("ID: " + res.getString(0) + ", Nombre de usuario: " + res.getString(1) + ", Contraseña: " + res.getString(2) + ", Plan ID: " + res.getString(3) + ", Plan inicio: " + res.getString(4) + ", Plan fin: " + res.getString(5) + ", Nombre: " + res.getString(6) + ", Apellido: " + res.getString(7) + ", Email: " + res.getString(8) + ", Fecha de nacimiento: " + res.getString(9));
                    } while (res.moveToNext());
                }
                res.close();
                return lista;
            }}