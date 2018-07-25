package it.codegen.rnd.assetTracking;

import it.codegen.rnd.assetTracking.db.Util.HibernateUtil;
import it.codegen.rnd.assetTracking.dbModels.Asset;
import it.codegen.rnd.assetTracking.dbModels.AssetCatagory;
import it.codegen.rnd.assetTracking.dbModels.Employee;
import it.codegen.rnd.assetTracking.dbModels.Location;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class dbCheck {
    public static void main(String[] args) {

        Location location = new Location();
        location.setId(1);

        Employee rashmin = new Employee();
        rashmin.setId(2);

        AssetCatagory assetCatagory = new AssetCatagory();
        assetCatagory.setId(1);

        Asset asset1 = new Asset();
        asset1.setName("CPU");
        asset1.setStatus(true);
        asset1.setAquiredDate(new Date());
        asset1.setAssetCatagory(assetCatagory);
        asset1.setLocation(location);
        asset1.setEmployee(rashmin);


        Asset asset2 = new Asset();
        asset2.setId(1);

        Session ses = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();

        HibernateUtil.getSessionAnnotationFactory().close();
    }

    public static void insertAssetToDB(String assetName , Boolean status, Date aquired,  String catagory , String owner , String location , Session session){
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
        transaction.begin();

        Query query1 = session.createQuery("from AssetCatagory as A where A.name=:name");
        query1.setString("name",catagory);
        AssetCatagory as1 = (AssetCatagory)query1.uniqueResult();

        Query query2 = session.createQuery("from Employee as E where E.name=:name");
        query2.setString("name",owner);
        Employee e1 = (Employee)query2.uniqueResult();

        Query query3 = session.createQuery("from Location L where L.name=:name");
        query3.setString("name",location);
        Location l1 = (Location) query3.uniqueResult();

        Asset asset1 = new Asset();
        asset1.setName(assetName);
        asset1.setStatus(status);
        asset1.setAquiredDate(aquired);
        asset1.setAssetCatagory(as1);
        asset1.setLocation(l1);
        asset1.setEmployee(e1);

        session.persist(asset1);
        transaction.commit();}

        catch(HibernateException h)
        {

            if(transaction!=null)
            {
                transaction.rollback();
            }

            throw h;
        }
    }




}
