package br.com.samuel.repository;
 
import java.io.Serializable;
 
import javax.persistence.Query;
 
import br.com.samuel.model.UsuarioModel;
import br.com.samuel.repository.entity.UsuarioEntity;
import br.com.samuel.uteis.Uteis;
 
 
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PAR�METROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USU�RIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
}