package Model.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.entities.Compte;
import Model.entities.Personnel;
import Model.entities.Tache;

public class EtatManager {
	public void addPersonnel(Personnel pr) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		int id = (Integer) session.save(pr);
		Compte cpt = new Compte(pr.getNom_pers(), pr.getNom_pers() + ""
				+ pr.getPrenom_pers());
		cpt.setId(id);
		session.save(cpt);
		tx.commit();
		session.close();

	}

	public List<Personnel> getAllPersonnel() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Personnel> listePersonnel = (ArrayList) session.createQuery(
				"from Personnel").list();
		tx.commit();
		session.close();

		return listePersonnel;

	}

	public void addTache(String nom, String d1, String d2, int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		Personnel pr = (Personnel) session.load(Personnel.class, id);
		Tache t = new Tache(nom, d1, d2, pr);
		session.save(t);
		tx.commit();
		session.close();
	}

	public List<Tache> getTacheByetat(String etat) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		List<Tache> tache = (ArrayList) session
				.createQuery(
						" FROM Tache t join fetch  t.pr WHERE t.id_tache IN(SELECT id_tache FROM Tache WHERE etat='"
								+ etat + "')").list();
		tx.commit();
		session.close();

		return tache;
	}

	public List<Personnel> getlogin(String login, String pass) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		List<Integer> id = (ArrayList) session.createQuery(
				"select id from Compte where login='" + login
						+ "'and password='" + pass + "'").list();
		List<Personnel> p = new ArrayList<Personnel>();
		if (id.size() != 0) {
			p = (ArrayList<Personnel>) session.createQuery(
					"from Personnel where id_pers='" + id.get(0) + "'").list();

		}
		tx.commit();
		session.close();

		return p;

	}

	public List<Tache> getTacheByetatPersonnel(String etat, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		List<Tache> tache = (ArrayList) session
				.createQuery(
						" FROM Tache t join fetch  t.pr WHERE t.id_tache IN(SELECT id_tache FROM Tache WHERE etat='"
								+ etat + "') and t.pr.id_pers='" + id + "'")
				.list();

		tx.commit();
		session.close();

		return tache;
	}

	public void updateEtatTache(int id_tache, String etat) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		Tache t = (Tache) session.load(Tache.class, id_tache);
		t.setEtat(etat);
		session.update(t);
		tx.commit();
		session.close();
	}

}
