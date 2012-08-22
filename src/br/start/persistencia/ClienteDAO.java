package br.start.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.start.beans.Cliente;
import br.start.util.HibernateUtil;

public class ClienteDAO {
	
	public void salvar(Cliente cliente){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cliente);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Cliente.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}

}
