package com.example.storyshareapp.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BasedeDatos {

    // Datos de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/Storyshare";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "admin";

    // Instancias de las clases
    ComentarioForo comentarioForo = new ComentarioForo();
    Evento evento = new Evento();
    Foro foro = new Foro();
    Libro libro = new Libro();
    LibroUsuario libroUsuario = new LibroUsuario();
    PlanPrecio planPrecio = new PlanPrecio();
    Usuario usuario = new Usuario();

    // Constructor
    public BasedeDatos() {}

    // Método para establecer la conexión a la base de datos
    private Connection conectar() {
        Connection conexion = null;
        try {
            // Registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    private void desconectar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // USUARIOS


    // Método para verificar si existe un usuario con el nombre de usuario y contraseña proporcionados
    public static boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        boolean credencialesCorrectas = false;
        BasedeDatos bd= new BasedeDatos();
        Connection conexion = bd.conectar();
        try {
            String consulta = "SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            ResultSet resultado = statement.executeQuery();
            // Si hay al menos un resultado, las credenciales son correctas
            credencialesCorrectas = resultado.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.desconectar(conexion);
        }
        return credencialesCorrectas;
    }

    // Método para buscar un registro por su ID en la tabla Usuarios
    public Usuario buscarUsuarioPorId(int id) {
        Usuario usuario = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Usuarios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nombre_usuario"),
                        resultado.getString("contraseña"),
                        resultado.getInt("plan_id"),
                        resultado.getDate("plan_inicio"),
                        resultado.getDate("plan_fin"),
                        resultado.getString("email"),
                        resultado.getInt("edad"),
                        resultado.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return usuario;
    }

    // Método para buscar todos los registros de la tabla Usuarios
    public ArrayList<Usuario> buscarTodosLosUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Usuarios";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                Usuario usuario = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nombre_usuario"),
                        resultado.getString("contraseña"),
                        resultado.getInt("plan_id"),
                        resultado.getDate("plan_inicio"),
                        resultado.getDate("plan_fin"),
                        resultado.getString("email"),
                        resultado.getInt("edad"),
                        resultado.getString("nombre")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return usuarios;
    }

    // Método para insertar un nuevo usuario en la tabla Usuarios
    public boolean insertarUsuario(Usuario usuario) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO Usuarios (nombre_usuario, contraseña, plan_id, plan_inicio, plan_fin, email, fecha_nacimiento, nombre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getContraseña());
            statement.setInt(3, usuario.getPlanId());
            statement.setDate(4, usuario.getPlanInicio());
            statement.setDate(5, usuario.getPlanFin());
            statement.setString(8, usuario.getEmail());
            statement.setInt(9, usuario.getFechaNacimiento());
            statement.setString(10, usuario.getNombre());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un usuario por su ID de la tabla Usuarios
    public boolean eliminarUsuarioPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM Usuarios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // COMENTARIOS DEL FORO

    // Método para buscar un comentario por su ID en la tabla ComentariosForo
    public ComentarioForo buscarComentarioPorId(int id) {
        ComentarioForo comentario = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM ComentariosForo WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                comentario = new ComentarioForo(
                        resultado.getInt("id"),
                        resultado.getInt("id_foro"),
                        resultado.getInt("id_usuario"),
                        resultado.getString("comentario"),
                        resultado.getDate("fecha"),
                        resultado.getTime("hora")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return comentario;
    }

    // Método para buscar todos los comentarios de un foro en particular en la tabla ComentariosForo
    public ArrayList<ComentarioForo> buscarComentariosPorForo(int idForo) {
        ArrayList<ComentarioForo> comentarios = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM ComentariosForo WHERE id_foro = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idForo);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                ComentarioForo comentario = new ComentarioForo(
                        resultado.getInt("id"),
                        resultado.getInt("id_foro"),
                        resultado.getInt("id_usuario"),
                        resultado.getString("comentario"),
                        resultado.getDate("fecha"),
                        resultado.getTime("hora")
                );
                comentarios.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return comentarios;
    }

    // Método para insertar un nuevo comentario en la tabla ComentariosForo
    public boolean insertarComentario(ComentarioForo comentario) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO ComentariosForo (id_foro, id_usuario, comentario, fecha, hora) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, comentario.getIdForo());
            statement.setInt(2, comentario.getIdUsuario());
            statement.setString(3, comentario.getComentario());
            statement.setDate(4, comentario.getFecha());
            statement.setTime(5, comentario.getHora());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un comentario por su ID de la tabla ComentariosForo
    public boolean eliminarComentarioPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM ComentariosForo WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // EVENTOS

    // Método para buscar un evento por su ID en la tabla Eventos
    public Evento buscarEventoPorId(int id) {
        Evento evento = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Eventos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                evento = new Evento(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDate("fecha"),
                        resultado.getTime("hora"),
                        resultado.getInt("moderador_id"),
                        resultado.getInt("libro_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return evento;
    }

    // Método para buscar todos los eventos en la tabla Eventos
    public ArrayList<Evento> buscarTodosLosEventos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Eventos";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                Evento evento = new Evento(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDate("fecha"),
                        resultado.getTime("hora"),
                        resultado.getInt("moderador_id"),
                        resultado.getInt("libro_id")
                );
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return eventos;
    }

    // Método para insertar un nuevo evento en la tabla Eventos
    public boolean insertarEvento(Evento evento) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO Eventos (nombre, fecha, hora, moderador_id, libro_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, evento.getNombreEvento());
            statement.setDate(2, evento.getFecha());
            statement.setTime(3, evento.getHora());
            statement.setInt(4, evento.getModeradorId());
            statement.setInt(5, evento.getLibroId());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un evento por su ID de la tabla Eventos
    public boolean eliminarEventoPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM Eventos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // FOROS

    // Método para buscar un foro por su ID en la tabla Foros
    public Foro buscarForoPorId(int id) {
        Foro foro = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Foros WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                foro = new Foro(
                        resultado.getInt("id"),
                        resultado.getString("titulo"),
                        resultado.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return foro;
    }

    // Método para buscar todos los foros en la tabla Foros
    public ArrayList<Foro> buscarTodosLosForos() {
        ArrayList<Foro> foros = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Foros";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                Foro foro = new Foro(
                        resultado.getInt("id"),
                        resultado.getString("titulo"),
                        resultado.getString("descripcion")
                );
                foros.add(foro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return foros;
    }

    // Método para insertar un nuevo foro en la tabla Foros
    public boolean insertarForo(Foro foro) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO Foros (titulo, descripcion) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, foro.getTitulo());
            statement.setString(2, foro.getDescripcion());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un foro por su ID de la tabla Foros
    public boolean eliminarForoPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM Foros WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // LIBROS

    // Método para buscar un libro por su ID en la tabla Libros
    public Libro buscarLibroPorId(int id) {
        Libro libro = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Libros WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                libro = new Libro(
                        resultado.getInt("id"),
                        resultado.getString("genero"),
                        resultado.getString("titulo"),
                        resultado.getString("autor"),
                        resultado.getDate("fecha_publicacion"),
                        resultado.getInt("valoracion_media"),
                        resultado.getString("portada")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return libro;
    }

    // Método para buscar todos los libros en la tabla Libros
    public ArrayList<Libro> buscarTodosLosLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM Libros";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                Libro libro = new Libro(
                        resultado.getInt("id"),
                        resultado.getString("genero"),
                        resultado.getString("titulo"),
                        resultado.getString("autor"),
                        resultado.getDate("fecha_publicacion"),
                        resultado.getInt("valoracion_media"),
                        resultado.getString("portada")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return libros;
    }

    // Método para insertar un nuevo libro en la tabla Libros
    public boolean insertarLibro(Libro libro) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO Libros (genero, titulo, autor, fecha_publicacion, valoracion_media, portada) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, libro.getGenero());
            statement.setString(2, libro.getTitulo());
            statement.setString(3, libro.getAutor());
            statement.setDate(4, libro.getFechaPublicacion());
            statement.setInt(5, libro.getValoracion());
            statement.setString(6, libro.getPortada());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un libro por su ID de la tabla Libros
    public boolean eliminarLibroPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM Libros WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // LIBROSUSUARIOS

    // Método para buscar un registro por su ID en la tabla LibrosUsuarios
    public LibroUsuario buscarLibroUsuarioPorId(int id) {
        LibroUsuario libroUsuario = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM LibrosUsuarios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                libroUsuario = new LibroUsuario(
                        resultado.getInt("id"),
                        resultado.getInt("usuario_id"),
                        resultado.getInt("libro_id"),
                        resultado.getDate("fecha_lectura"),
                        resultado.getInt("valoracion"),
                        resultado.getString("comentario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return libroUsuario;
    }

    // Método para buscar todos los registros de la tabla LibrosUsuarios
    public ArrayList<LibroUsuario> buscarTodosLosLibrosUsuarios() {
        ArrayList<LibroUsuario> librosUsuarios = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM LibrosUsuarios";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                LibroUsuario libroUsuario = new LibroUsuario(
                        resultado.getInt("id"),
                        resultado.getInt("usuario_id"),
                        resultado.getInt("libro_id"),
                        resultado.getDate("fecha_lectura"),
                        resultado.getInt("valoracion"),
                        resultado.getString("comentario")
                );
                librosUsuarios.add(libroUsuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return librosUsuarios;
    }

    // Método para insertar un nuevo registro en la tabla LibrosUsuarios
    public boolean insertarLibroUsuario(LibroUsuario libroUsuario) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO LibrosUsuarios (usuario_id, libro_id, fecha_lectura, valoracion, comentario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, libroUsuario.getUsuarioId());
            statement.setInt(2, libroUsuario.getLibroId());
            statement.setDate(3, libroUsuario.getFechaLectura());
            statement.setInt(4, libroUsuario.getValoracion());
            statement.setString(5, libroUsuario.getComentario());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un registro por su ID de la tabla LibrosUsuarios
    public boolean eliminarLibroUsuarioPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM LibrosUsuarios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // PLANPRECIOS

    // Método para buscar un plan de precio por su ID en la tabla PlanPrecios
    public PlanPrecio buscarPlanPrecioPorId(int id) {
        PlanPrecio planPrecio = null;
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM PlanPrecios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                planPrecio = new PlanPrecio(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return planPrecio;
    }

    // Método para buscar todos los planes de precio en la tabla PlanPrecios
    public ArrayList<PlanPrecio> buscarTodosLosPlanPrecios() {
        ArrayList<PlanPrecio> planPrecios = new ArrayList<>();
        Connection conexion = conectar();
        try {
            String consulta = "SELECT * FROM PlanPrecios";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                PlanPrecio planPrecio = new PlanPrecio(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio")
                );
                planPrecios.add(planPrecio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar(conexion);
        }
        return planPrecios;
    }

    // Método para insertar un nuevo plan de precio en la tabla PlanPrecios
    public boolean insertarPlanPrecio(PlanPrecio planPrecio) {
        Connection conexion = conectar();
        try {
            String consulta = "INSERT INTO PlanPrecios (nombre, precio) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, planPrecio.getNombre());
            statement.setDouble(2, planPrecio.getPrecio());
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }

    // Método para eliminar un plan de precio por su ID de la tabla PlanPrecios
    public boolean eliminarPlanPrecioPorId(int id) {
        Connection conexion = conectar();
        try {
            String consulta = "DELETE FROM PlanPrecios WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            int filasEliminadas = statement.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            desconectar(conexion);
        }
    }
   }
