package smsplatform.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smsplatform.dao.impl.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for TBdMessagesendgroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see smsplatform.dao.TBdMessagesendgroup
  * @author MyEclipse Persistence Tools 
 */

public class TBdMessagesendgroupDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TBdMessagesendgroupDAO.class);
		//property constants
	public static final String _FGROUP_TYPE = "FGroupType";
	public static final String _FSUBMIT_TYPE = "FSubmitType";
	public static final String _FGROUP_SEND_STATUS = "FGroupSendStatus";
	public static final String _FGROUP_PHONE_NUM = "FGroupPhoneNum";
	public static final String _FGROUP_CONTENT = "FGroupContent";



    
    public void save(TBdMessagesendgroup transientInstance) {
        log.debug("saving TBdMessagesendgroup instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TBdMessagesendgroup persistentInstance) {
        log.debug("deleting TBdMessagesendgroup instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TBdMessagesendgroup findById( java.lang.Long id) {
        log.debug("getting TBdMessagesendgroup instance with id: " + id);
        try {
            TBdMessagesendgroup instance = (TBdMessagesendgroup) getSession()
                    .get("smsplatform.dao.TBdMessagesendgroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TBdMessagesendgroup instance) {
        log.debug("finding TBdMessagesendgroup instance by example");
        try {
            List results = getSession()
                    .createCriteria("smsplatform.dao.TBdMessagesendgroup")
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
      log.debug("finding TBdMessagesendgroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TBdMessagesendgroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFGroupType(Object FGroupType
	) {
		return findByProperty(_FGROUP_TYPE, FGroupType
		);
	}
	
	public List findByFSubmitType(Object FSubmitType
	) {
		return findByProperty(_FSUBMIT_TYPE, FSubmitType
		);
	}
	
	public List findByFGroupSendStatus(Object FGroupSendStatus
	) {
		return findByProperty(_FGROUP_SEND_STATUS, FGroupSendStatus
		);
	}
	
	public List findByFGroupPhoneNum(Object FGroupPhoneNum
	) {
		return findByProperty(_FGROUP_PHONE_NUM, FGroupPhoneNum
		);
	}
	
	public List findByFGroupContent(Object FGroupContent
	) {
		return findByProperty(_FGROUP_CONTENT, FGroupContent
		);
	}
	

	public List findAll() {
		log.debug("finding all TBdMessagesendgroup instances");
		try {
			String queryString = "from TBdMessagesendgroup";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TBdMessagesendgroup merge(TBdMessagesendgroup detachedInstance) {
        log.debug("merging TBdMessagesendgroup instance");
        try {
            TBdMessagesendgroup result = (TBdMessagesendgroup) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TBdMessagesendgroup instance) {
        log.debug("attaching dirty TBdMessagesendgroup instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TBdMessagesendgroup instance) {
        log.debug("attaching clean TBdMessagesendgroup instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}