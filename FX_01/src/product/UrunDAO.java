package product;

import com.mongodb.*;
import com.sun.javafx.collections.ObservableListWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrunDAO {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    private static MongoClient mongoClient;

    public static void main(String[] args) {
        UrunDAO dao  = new UrunDAO();
        List<DBObject> list=dao.getData();
        System.out.println(">>"+list.toString());
        // 42 Mongo-Java
    }

    public static  void MongoConnect(){
        try {
            mongoClient = new MongoClient(HOST,PORT);
            DB db = mongoClient.getDB( "sirket" );
            System.out.println(" MongoDB Baglantisi Basarili");
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        finally {
            System.out.println("MongoDB Baglantisi Kesiliyor...");
            mongoClient.close();
        }

    }
    public void insertUrun(Urun urun){

        try {
            mongoClient = new MongoClient(HOST,PORT);
            DB db = mongoClient.getDB( "sirket" );
            DBCollection coll = db.getCollection("urun");
            System.out.println("MongoDB Baglantisi Yapildi..");

            DBObject doc = new BasicDBObject("urunNo",urun.getUrunNo())
                    .append("urunAd", urun.getUrunAd())
                    .append("urunCins", urun.getUrunCins())
                    .append("fiyat", urun.getUrunFiyat())
            .append("miktar", urun.getUrunMiktar());;
            coll.insert(doc);

            System.out.println("MongoDB Ekleme Basarili. ");
        }
        catch (Exception e){
            System.out.println("MongoDB Baglantisi Yapilmadi Bağlantiyi Kontrol Et!!!..");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        finally {
            System.out.println("MongoDB Baglantisi Kesildi..");
            mongoClient.close();
        }
    }

    public void deleteUrun(int  no){
        try{
            mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("sirket");
            DBCollection coll = db.getCollection("urun");

            DBObject query = new BasicDBObject("urunNo",no);
            DBObject doc = coll.findAndRemove(query);
            coll.remove(doc);
            System.out.println("urun veritabaninda silindi");

        } catch (Exception e){
            System.out.println("MongoDB Baglantisi Yapilmadi Bağlantiyi Kontrol Et!!!..");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        finally {
            System.out.println("MongoDB Baglantisi Kesildi..");
            mongoClient.close();
        }

    }

    public List<DBObject> getData(){
        List<DBObject> obj_list = new ArrayList<DBObject>();

        try {
            mongoClient = new MongoClient(HOST,PORT);
            DB db = mongoClient.getDB( "sirket" );
            DBCollection coll = db.getCollection("urun");
            DBCursor cursor = coll.find();
            try {
                int i=0;
                while(cursor.hasNext()) {
                    DBObject object = cursor.next();
                    obj_list.add(object);
                    System.out.println(i+": "+object);
                    i++;
                }
            }
            finally {
                cursor.close();
            }

            System.out.println("MongoDB Ekleme Basarili. ");
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        finally {
            System.out.println("MongoDB Baglantisi Kesiliyor...");
            mongoClient.close();
        }
        return obj_list;

    }

}
