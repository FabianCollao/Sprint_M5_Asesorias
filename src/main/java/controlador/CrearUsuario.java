package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TipoUsuario;
import model.Usuario;
import utils.ValidarDatos;
import implementacion.UsuarioDaoImpl;
import interfaces.IUsuarioDAO;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuarioDAO = new UsuarioDaoImpl();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Se obtiene la sesion actual
				HttpSession session = request.getSession();
				//validacion de usuario logeado
			    if (session != null && session.getAttribute("usuario") != null) {
					getServletContext().getRequestDispatcher("/views/crear-usuario.jsp").forward(request, response);
			    } else {
			    	//redireccionando al login
			    	response.sendRedirect(request.getContextPath() + "/Login");
			    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nombre = request.getParameter("nombre");
			String contrasena = request.getParameter("contraseña");
			String tipo = request.getParameter("tipo");

			// Validaciones de campos del formulario
			boolean todoOk = (ValidarDatos.esObligatorio(nombre) && ValidarDatos.esObligatorio(contrasena)
					&& ValidarDatos.esObligatorio(tipo));

			if (todoOk) {
				Usuario usuario = new Usuario(nombre, contrasena, TipoUsuario.parse(tipo));
				usuarioDAO.crearUsuario(usuario);
				request.setAttribute("mensaje", "Usuario creado correctamente");

				// Redireccionar a web de exito
				getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error en AgregarUsuario Servlet: " + e);
		}
	}

}