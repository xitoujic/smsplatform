package smsplatform.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBdUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see smsplatform.dao.TBdUser
 * @author MyEclipse Persistence Tools
 */

public class TBdUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TBdUserDAO.class);
	// property constants
	public static final String _FUSER_NAME = "FUserName";
	public static final String _FUSER_FULL_NAME = "FUserFullName";
	public static final String _FPASSWORD = "FPassword";
	public static final String _FPHONE_NUMBER = "FPhoneNumber";
	public static final String _FSEX = "FSex";
	public static final String _FROLE = "FRole";
	public static final String _FCOMPANY_TYPE = "FCompanyType";
	public static final String _FCHECK_TYPE = "FCheckType";
	public static final String _FSIGNATURE = "FSignature";
	public static final String _FSIGNATURE_FLAG = "FSignatureFlag";
	public static final String _FURGENT = "FUrgent";
	public static final String _FUPDATE_STATUS = "FUpdateStatus";
	public static final String _FRIGHT = "FRight";
	public static final String _FDEDUCT_SCALE = "FDeductScale";
	public static final String _FEMAIL = "FEmail";

	public void save(TBdUser transientInstance) {
		log.debug("saving TBdUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBdUser persistentInstance) {
		log.debug("deleting TBdUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBdUser findById(java.lang.Long id) {
		log.debug("getting TBdUser instance with id: " + id);
		try {
			TBdUser instance = (TBdUser) getSession().get(
					"smsplatform.dao.TBdUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBdUser instance) {
		log.debug("finding TBdUser instance by example");
		try {
			List results = getSession().createCriteria(
					"smsplatform.dao.TBdUser").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TBdUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TBdUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFUserName(Object FUserName) {
		return findByProperty(_FUSER_NAME, FUserName);
	}

	public List findByFUserFullName(Object FUserFullName) {
		return findByProperty(_FUSER_FULL_NAME, FUserFullName);
	}

	public List findByFPassword(Object FPassword) {
		return findByProperty(_FPASSWORD, FPassword);
	}

	public List findByFPhoneNumber(Object FPhoneNumber) {
		return findByProperty(_FPHONE_NUMBER, FPhoneNumber);
	}

	public List findByFSex(Object FSex) {
		return findByProperty(_FSEX, FSex);
	}

	public List findByFRole(Object FRole) {
		return findByProperty(_FROLE, FRole);
	}

	public List findByFCompanyType(Object FCompanyType) {
		return findByProperty(_FCOMPANY_TYPE, FCompanyType);
	}

	public List findByFCheckType(Object FCheckType) {
		return findByProperty(_FCHECK_TYPE, FCheckType);
	}

	public List findByFSignature(Object FSignature) {
		return findByProperty(_FSIGNATURE, FSignature);
	}

	public List findByFSignatureFlag(Object FSignatureFlag) {
		return findByProperty(_FSIGNATURE_FLAG, FSignatureFlag);
	}

	public List findByFUrgent(Object FUrgent) {
		return findByProperty(_FURGENT, FUrgent);
	}

	public List findByFUpdateStatus(Object FUpdateStatus) {
		return findByProperty(_FUPDATE_STATUS, FUpdateStatus);
	}

	public List findByFRight(Object FRight) {
		return findByProperty(_FRIGHT, FRight);
	}

	public List findByFDeductScale(Object FDeductScale) {
		return findByProperty(_FDEDUCT_SCALE, FDeductScale);
	}

	public List findByFEmail(Object FEmail) {
		return findByProperty(_FEMAIL, FEmail);
	}

	public List findAll() {
		log.debug("finding all TBdUser instances");
		try {
			String queryString = "from TBdUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBdUser merge(TBdUser detachedInstance) {
		log.debug("merging TBdUser instance");
		try {
			TBdUser result = (TBdUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBdUser instance) {
		log.debug("attaching dirty TBdUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBdUser instance) {
		log.debug("attaching clean TBdUser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}