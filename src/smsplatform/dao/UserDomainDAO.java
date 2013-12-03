package smsplatform.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smsplatform.dao.impl.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for UserDomain entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see smsplatform.dao.UserDomain
  * @author MyEclipse Persistence Tools 
 */

public class UserDomainDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserDomainDAO.class);
		//property constants
	public static final String USER_NAME = "userName";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String TYPE = "type";



    
    public void save(UserDomain transientInstance) {
        log.debug("saving UserDomain instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserDomain persistentInstance) {
        log.debug("deleting UserDomain instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserDomain findById( java.lang.Integer id) {
        log.debug("getting UserDomain instance with id: " + id);
        try {
            UserDomain instance = (UserDomain) getSession()
                    .get("smsplatform.dao.UserDomain", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserDomain instance) {
        log.debug("finding UserDomain instance by example");
        try {
            List results = getSession()
                    .createCriteria("smsplatform.dao.UserDomain")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserDomain instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserDomain as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserName(Object userName
	) {
		return findByProperty(USER_NAME, userName
		);
	}
	
	public List findByEmail(Object email
	) {
		return findByProperty(EMAIL, email
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	

	public List findAll() {
		log.debug("finding all UserDomain instances");
		try {
			String queryString = "from UserDomain";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserDomain merge(UserDomain detachedInstance) {
        log.debug("merging UserDomain instance");
        try {
            UserDomain result = (UserDomain) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserDomain instance) {
        log.debug("attaching dirty UserDomain instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserDomain instance) {
        log.debug("attaching clean UserDomain instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}