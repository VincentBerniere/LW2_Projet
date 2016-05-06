package univ.rest.config;

import com.mongodb.*;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import univ.rest.model.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vincent on 28/04/2016.
 */
public class MongoDBJDBC {
    public static STBLiteList getMongoSTBList() {
        STBLiteList stbs = new STBLiteList();

        try {

            MongoClientURI uri  = new MongoClientURI("mongodb://VincentBerniere:stbgil@ds021691.mlab.com:21691/stbs");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB(uri.getDatabase());
            System.out.println("Connect to database successfully");

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            DBCursor cursor = coll.find();
            int k = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: " + k);
                DBObject dbo = cursor.next();
                System.out.println(dbo);

                String titre = (String) dbo.get("titreDuProjet").toString();
                double version = (double) dbo.get("version");
                String date = (String) dbo.get("date");
                String descript = (String) dbo.get("description");

                ObjectId idSTB = (ObjectId)dbo.get( "_id" );
                STBLite stb = new STBLite(idSTB.toString(), titre, version, date, descript);
                stbs.getSTBs().add(stb);

                //System.out.println(cursor.next());
                k++;
            }

        } catch (Exception e) {
            System.out.println(e);
            return stbs;
        }

        return stbs;
    }

    public static STB getMongoSTBList(String idS) {
        STB stb = null;

        try {

            MongoClientURI uri  = new MongoClientURI("mongodb://VincentBerniere:stbgil@ds021691.mlab.com:21691/stbs");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB(uri.getDatabase());
            System.out.println("Connect to database successfully");

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            DBCursor cursor = coll.find();
            int k = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: " + k);
                DBObject dbo = cursor.next();
                ObjectId idSTB = (ObjectId)dbo.get( "_id" );

                if (idS.equals(idSTB.toString())) {
                    String titre = (String) dbo.get("titreDuProjet").toString();
                    double version = (double) dbo.get("version");
                    String date = (String) dbo.get("date");
                    String descript = (String) dbo.get("description");

                    // On récupère le Client
                    BasicDBObject clientDb = (BasicDBObject) dbo.get("client");
                    Client client = new Client(clientDb.getString("entite"), clientDb.getString("contact"), clientDb.getInt("codePostal"));

                    // On récupère la liste des équipes
                    ArrayList<Equipe> equipes = new ArrayList<Equipe>();
                    BasicDBList list = (BasicDBList) dbo.get("equipe");
                    for (int i = 0; i < list.size(); i++) {
                        BasicDBObject obj = (BasicDBObject) list.get(i);
                        boolean gender = obj.getBoolean("gender");
                        String nom = obj.getString("nom");
                        String prenom = obj.getString("prenom");

                        Equipe equipe = new Equipe(gender, nom, prenom);

                        equipes.add(equipe);
                    }

                    // On récupère la liste des fonctionnalites
                    ArrayList<Fonctionnalite> fonctionnalites = new ArrayList<Fonctionnalite>();
                    list = (BasicDBList) dbo.get("fonctionnalite");
                    for (int i = 0; i < list.size(); i++) {
                        BasicDBObject obj = (BasicDBObject) list.get(i);
                        String description = obj.getString("description");
                        String commentaire = obj.getString("commentaire");

                        // On récupère la liste des exigences d'une fonctionnalite
                        ArrayList<ExigenceFonctionnelle> exigences = new ArrayList<ExigenceFonctionnelle>();
                        BasicDBList list2 = (BasicDBList) obj.get("exigence");
                        for (int j = 0; j < list2.size(); j++) {
                            BasicDBObject obj2 = (BasicDBObject) list2.get(j);
                            String id = obj2.getString("identifiant");
                            String desc = obj2.getString("description");
                            int priorite = obj2.getInt("priorite");
                            ExigenceFonctionnelle exigenceFonctionnelle = new ExigenceFonctionnelle(id, desc, priorite);

                            exigences.add(exigenceFonctionnelle);
                        }

                        Fonctionnalite f = new Fonctionnalite(description, commentaire, exigences);

                        fonctionnalites.add(f);
                    }
                    stb = new STB(idSTB.toString(), titre, version, date, descript, client, equipes, fonctionnalites);

                    //System.out.println(cursor.next());
                }
                k++;
            }
        }catch(Exception e){
            System.out.println(e);
            return stb;
        }
        return stb;
    }

    public static int getMongoSTBListSize() {
        int k = 1;

        try {

            MongoClientURI uri  = new MongoClientURI("mongodb://VincentBerniere:stbgil@ds021691.mlab.com:21691/stbs");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB(uri.getDatabase());
            System.out.println("Connect to database successfully");

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            DBCursor cursor = coll.find();

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: " + k);
                DBObject dbo = cursor.next();
                k++;
            }

        }catch(Exception e){
            System.out.println(e);
            return -1;
        }
        return k-1;
    }

    public static boolean insertMongoSTB(STB stb) {
        try {
            MongoClientURI uri  = new MongoClientURI("mongodb://VincentBerniere:stbgil@ds021691.mlab.com:21691/stbs");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB(uri.getDatabase());
            System.out.println("Connect to database successfully");

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            BasicDBObject doc = new BasicDBObject().
                    append("titreDuProjet", stb.getTitre()).
                    append("version", stb.getVersion()).
                    append("date", stb.getDate()).
                    append("description", stb.getDescription());

            BasicDBObject client = new BasicDBObject().
                    append("entite", stb.getClient().getEntite()).
                    append("contact", stb.getClient().getContact()).
                    append("codePostal", stb.getClient().getCodePostal());
            doc.append("client", client);

            BasicDBList equipes = new BasicDBList();
            for (Equipe e : stb.getEquipe()) {
                BasicDBObject eq = new BasicDBObject()
                        .append("gender", e.isGender())
                        .append("nom", e.getNom())
                        .append("prenom", e.getPrenom());
                equipes.add(eq);
            }
            doc.append("equipe", equipes);

            BasicDBList fcts = new BasicDBList();
            for (Fonctionnalite f : stb.getFonctionnalite()) {
                BasicDBObject fonctionnalite = new BasicDBObject()
                        .append("description", f.getDescription())
                        .append("commentaire", f.getCommentaire());


                BasicDBList exigences = new BasicDBList();
                for (ExigenceFonctionnelle exigence : f.getExigenceFonctionnelle()) {
                    BasicDBObject exigenceDB = new BasicDBObject()
                            .append("identifiant", exigence.getIdentifiant())
                            .append("description", exigence.getDescription())
                            .append("priorite", exigence.getPriorite());

                    exigences.add(exigenceDB);
                }
                fonctionnalite.append("exigence", exigences);

                fcts.add(fonctionnalite);
            }
            doc.append("fonctionnalite", fcts);

            coll.insert(doc);
            ObjectId idSTB = (ObjectId)doc.get( "_id" );
            stb.setId(idSTB.toString());
            System.out.println("Document inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
