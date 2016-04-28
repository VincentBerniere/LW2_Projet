package univ.rest.config;

import com.mongodb.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import univ.rest.model.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vincent on 28/04/2016.
 */
public class MongoDBJDBC {
    public static STBList getMongoSTBList() {
        STBList stbs = new STBList();

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "ds021691.mlab.com" , 21691 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "stbs" );
            System.out.println("Connect to database successfully");

            char[] password = "stbgil".toCharArray();
            boolean auth = db.authenticate("VincentBerniere", password);
            System.out.println("Authentication: "+auth);

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            DBCursor cursor = coll.find();
            int k = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: "+k);
                DBObject dbo = cursor.next();
                System.out.println(dbo);

                String titre = (String)dbo.get("titreDuProjet").toString();
                double version = (double)dbo.get("version");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                Date date = format.parse(dbo.get("date").toString());
                date = new Date();
                String descript = (String)dbo.get("description");
                /*
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
                    list = (BasicDBList) dbo.get("exigenceFonctionnelle");
                    for (int j = 0; j < list.size(); j++) {
                        BasicDBObject obj2 = (BasicDBObject) list.get(i);
                        String id = obj2.getString("identifiant");
                        String desc = obj2.getString("description");
                        int priorite = obj2.getInt("priorite");

                        ExigenceFonctionnelle exigenceFonctionnelle = new ExigenceFonctionnelle(id, desc, priorite);

                        exigences.add(exigenceFonctionnelle);
                    }

                    Fonctionnalite f = new Fonctionnalite(description, commentaire, exigences);

                    fonctionnalites.add(f);
                }*/

                //STB stb = new STB(k, titre, version, date, descript, client, equipes, fonctionnalites);
                STB stb = new STB(k, titre, version, date, descript, null, null, null);
                stbs.getSTBs().add(stb);

                //System.out.println(cursor.next());
                k++;
            }

        }catch(Exception e){
            stbs = new STBList();
            STB stb = new STB();
            stb.setDescription(e.toString());
            stbs.getSTBs().add(stb);
            return stbs;
        }

        return stbs;
    }

    public static STB getMongoSTBList(int idS) {
        STB stb = null;

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "ds021691.mlab.com" , 21691 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "stbs" );
            System.out.println("Connect to database successfully");

            char[] password = "stbgil".toCharArray();
            boolean auth = db.authenticate("VincentBerniere", password);
            System.out.println("Authentication: "+auth);

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            DBCursor cursor = coll.find();
            int k = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: "+k);
                DBObject dbo = cursor.next();

                if (idS == k) {
                    String titre = (String)dbo.get("titreDuProjet");
                    double version = (double)dbo.get("version");
                    Date date = new Date(dbo.get("date").toString());
                    String descript = (String)dbo.get("description");

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
                        list = (BasicDBList) dbo.get("exigenceFonctionnelle");
                        for (int j = 0; j < list.size(); j++) {
                            BasicDBObject obj2 = (BasicDBObject) list.get(i);
                            String id = obj2.getString("identifiant");
                            String desc = obj2.getString("description");
                            int priorite = obj2.getInt("priorite");

                            ExigenceFonctionnelle exigenceFonctionnelle = new ExigenceFonctionnelle(id, desc, priorite);

                            exigences.add(exigenceFonctionnelle);
                        }

                        Fonctionnalite f = new Fonctionnalite(description, commentaire, exigences);

                        fonctionnalites.add(f);
                    }

                    stb = new STB(k, titre, version, date, descript, client, equipes, fonctionnalites);
                }
                k++;
                //System.out.println(cursor.next());
            }

        }catch(Exception e){
            stb = new STB();
            stb.setDescription(e.toString());
            return stb;
        }
        return stb;
    }

    public static String insertMongoSTB(STB stb) {
        try{
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "ds021691.mlab.com" , 21691 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "stbs" );
            System.out.println("Connect to database successfully");

            char[] password = "stbgil".toCharArray();
            boolean auth = db.authenticate("VincentBerniere", password);
            System.out.println("Authentication: "+auth);

            DBCollection coll = db.getCollection("stb");
            System.out.println("Collection stb selected successfully");

            BasicDBObject doc = new BasicDBObject().
                    append("titreDuProjet", stb.getTitre()).
                    append("version", stb.getVersion()).
                    append("date", stb.getDate().toString()).
                    append("description", stb.getDescription());

            BasicDBObject client = new BasicDBObject().
                    append("entite", stb.getClient().getEntite()).
                    append("contact", stb.getClient().getContact()).
                    append("codePostal", stb.getClient().getCodePostal());
            doc.append("client", client);

            BasicDBList equipes = new BasicDBList();
            for (Equipe e:stb.getEquipe()) {
                BasicDBObject eq = new BasicDBObject()
                        .append("gender", e.isGender())
                        .append("nom",e.getNom())
                        .append("prenom", e.getPrenom());
                equipes.add(eq);
            }
            doc.append("equipe", equipes);

            BasicDBList fcts = new BasicDBList();
            for (Fonctionnalite f:stb.getFonctionnalite()) {
                BasicDBObject fonctionnalite = new BasicDBObject()
                        .append("description", f.getDescription())
                        .append("commentaire", f.getCommentaire());


                BasicDBList exigences = new BasicDBList();
                for (ExigenceFonctionnelle exigence:f.getExigenceFonctionnelle()) {
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
            System.out.println("Document inserted successfully");
        }catch(Exception e){
            return e.toString();
        }
        return "";
    }
}
