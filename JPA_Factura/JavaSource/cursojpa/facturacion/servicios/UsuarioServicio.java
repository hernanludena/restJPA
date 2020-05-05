package cursojpa.facturacion.servicios;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Usuario;

@Stateless
public class UsuarioServicio {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Busca el usuario que coincida con el usuario y password que recibe como
	 * parámetro
	 * 
	 * @param usuario
	 *            Usuario con datos para la búsqueda
	 * @return Usuario encontrado, si no encuentra lanza una exception NotResultException (retorna null)
	 */
	
	//Examen 6
	//Cuál es el tipo de transacción por defecto en un EJB?  ES REQUIRED	 
	/*En este tipo de busqueda, no es necesario que se cree una transaccion,
	ya que no se esta realizando operaciones CRUD(insert,delete,update sobre la base;sino solo una consulta; 
	de esta forma mejoramos el rendimiento de la aplicaion, al no crear transacciones sobre las consultas.*/
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario buscar(Usuario usuario){
        //No nos serviria el find
              //usar getSingleResult si no hay nada en la base devuelve Excepcion, se debe capturar la Excepcion
              //Si no encuentra lanza una excepcion NotResulException entre un Try y Catch
              try {
                     Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario =:p1 and u.clave =:p2");

                     query.setParameter("p1", usuario.getUsuario());
                     query.setParameter("p2", usuario.getClave());

                     return (Usuario) query.getSingleResult();
                     
              } catch (NoResultException e) {
                     // TODO: handle exception
                     return null;
              }
              

              
       }

}
