package tests;

import dao.DaoException;
import dao.DaoFactory;
import dao.DaoFactoryJpa;
import dao.JpaDeplacementDao;
import dao.JpaUsagerDao;
import java.math.BigDecimal;
import java.util.Date;
import metier.Deplacement;
import metier.Usager;

/**
 *
 * @author adrien
 */
public class Test1 {

    public static void main(String [] args) throws DaoException{

         Usager usager1 = new Usager("thibaut.dufour@outlook.com", "thibaut");
         Usager usager2 = new Usager("adrien.philippaux@gmail.com", "adrien");
         Usager usager3 = new Usager("adrien.philippaux@gmail.com", "toto");
         Usager usager4 = new Usager("toto@gmail.com", "toto");

         Deplacement dep1 = new Deplacement(new Date(), "VOI", 54.2, true);
         Deplacement dep2 = new Deplacement(new Date(), "TRA", 474.79, false);
         Deplacement dep3 = new Deplacement(new Date(), "VEL", 4.0, true);
         Deplacement dep4 = new Deplacement(new Date(), "NUL", 0.0, true);
         
         DaoFactoryJpa factory = (DaoFactoryJpa) DaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA);
         JpaUsagerDao jud = factory.getUsagerDao();
         JpaDeplacementDao jdd = factory.getDeplacementDao();
         
         jud.deleteAll();
         jdd.deleteAll();
         
         if(usager1.addDeplacement(dep1))
             System.out.println("Deplacement 1 ajouté à l'usager 1");
         else
             System.out.println("Probleme lors de l'ajout du deplacement 1 à l'usager 1");
         
         if(usager1.addDeplacement(dep2))
            System.out.println("Deplacement 2 ajouté à l'usager 1");
         else
             System.out.println("Probleme lors de l'ajout du deplacement 2 à l'usager 1");
         
         if(usager2.addDeplacement(dep2)) // should fail
             System.out.println("Deplacement 2 ajouté à l'usager 2");
         else
             System.out.println("Probleme lors de l'ajout du deplacement 2 à l'usager 2");
         
        if(usager3.addDeplacement(dep4))
             System.out.println("Deplacement 4 ajouté à l'usager 3");
         else
             System.out.println("Probleme lors de l'ajout du deplacement 4 à l'usager 3");
         
        jud.create(usager1);
        jud.create(usager2);
        jud.create(usager3); // should fail
        jud.create(usager4);

    
      /** AFFICHAGE USAGERS **/ 
       System.out.println("Affichage de tous les usagers");
        for(Usager u : jud.findAll()){
            System.out.println(u);
        }
        
        System.out.println("Suppression de l' usager 4");
        jud.delete(usager4);
        
        System.out.println("Update de l' usager 1");
        usager1.setPassword("yenapaslaisselacaseide");
        jud.update(usager1);
        
         /** AFFICHAGE déplacements **/ 
       System.out.println("Affichage de tous les déplacements");
        for(Deplacement d : jdd.findAll()){
            System.out.println(d);
        }
        
        System.out.println("Affichage des déplacements de l'usager 1");
        for(Deplacement d : usager1.getListeDeplacement()){
            System.out.println(d);
        }

        System.out.println("Affichage de tous les déplacements");
        for(Deplacement d : jdd.findAll()){
            System.out.println(d);
        }
        
        System.out.println("Suppression du déplacement 4");
        jdd.delete(dep4);
        
        System.out.println("Update du déplacement 3");
        dep3.setMode("PIE");
        jdd.update(dep3);
        
        System.out.println("Affichage de tous les déplacements");
        for(Deplacement d : jdd.findAll()){
            System.out.println(d);
        }
        
    }
}
