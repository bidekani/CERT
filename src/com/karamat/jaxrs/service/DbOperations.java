package com.karamat.jaxrs.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.karamat.jaxrs.model.CertExt;
import com.karamat.jaxrs.model.Certificate;
import com.karamat.jaxrs.model.Response;

public class DbOperations<T> {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    public static final Logger logger = Logger.getLogger(DbOperations.class);

    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static <E> Response<E> createRecord(E p) {
        int count = 1;
        logger.error("Inserting into databse");
        logger.info("Inserting into databse");
        Response<E> response = new Response<>();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(p);
            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
            response.setStatus(true);
            response.setMessage("Successfully Created Records In The Database!");
            response.setData(p);
            return response;

        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
            response.setStatus(false);
            response.setMessage("Record can not be created! \n " + sqlException.toString());
            response.setData(p);
            return response;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> List<E> displayRecords(E p) {
        List<E> listData = new ArrayList<E>();
        String className = p.getClass().getName();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            listData = sessionObj.createQuery("FROM " + className).list();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return listData;
    }

    public static void updateRecord(int id) {
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            CertExt stuObj = (CertExt) sessionObj.get(CertExt.class, id);
            sessionObj.getTransaction().commit();
            logger.info("\nRecord  With Id?= " + id + " Is Successfully Updated In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public static <E> Response<E> deleteRecord(Integer id, E classType) {
        Response<E> response = new Response<>();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            E dataObj = findRecordById(id, classType );

            sessionObj.delete(dataObj);
            sessionObj.getTransaction().commit();
            logger.info("\nRecord With Id?= " + id + " Is Successfully Deleted From The Database!\n");
            response.setStatus(true);
            response.setMessage("Successfully Deleted");
            response.setData(dataObj);
            return response;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
            response.setStatus(true);
            response.setMessage("Delete Error" + sqlException.toString());
            return response;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> E findRecordById(Integer id, E classType) {
        logger.info("\n.......Searching ........\n" + id);
        E findDataObj = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            findDataObj =  (E) sessionObj.load(classType.getClass(), id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        System.out.println("find Result" + findDataObj);
        return findDataObj;
    }

    public static <E> void deleteAllRecords(E classType) {
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String className = classType.getClass().getName();
            Query queryObj = sessionObj.createQuery("DELETE FROM " + className);
            queryObj.executeUpdate();

            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> List<E> filterRecords(E p ) throws Exception {
        List<E> listData = new ArrayList<E>();
        String className = p.getClass().getSimpleName();
        String hqlCritiria = creatFilterCondition((Certificate) p, Certificate.class);

        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            String queyStr = "  FROM " + className + "  where  " + hqlCritiria   ;
            logger.info(queyStr);
            listData = sessionObj.createQuery(queyStr).list();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return listData;
    }

    static <T> String creatFilterCondition(Certificate classData, Class<T> classType) throws Exception {
        Field[] fields = classType.getDeclaredFields();
        Class<?> c = Class.forName(classData.getClass().getName());
        Method method;
        Object obj = c.newInstance();
        String condition = " ";

        for (Field field : fields) {
            String fieldName = field.getName();
            method = c.getDeclaredMethod(makeGetter(fieldName));

            if(method.invoke(classData)!=null){
                condition += "  "+fieldName + "=" + method.invoke(classData) + "  and ";
            }

        }
        //remove the Last and
        return condition.substring(0, condition.length()-4);
        }

    private static String makeGetter(String fieldName) {
        return "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }
}
