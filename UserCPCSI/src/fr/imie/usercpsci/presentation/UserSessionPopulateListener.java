package fr.imie.usercpsci.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.imie.usercpsci.model.Faction;
import fr.imie.usercpsci.model.UserData;

/**
 * Application Lifecycle Listener implementation class UserSessionPopulate
 *
 */
@WebListener
public class UserSessionPopulateListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserSessionPopulateListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  { 
         UserData userData1 = new UserData();
         userData1.setNom("Kent");
         userData1.setPrenom("Clark");
         userData1.setPassw("superman");
         userData1.setFaction(Faction.gentil);
         UserData userData2 = new UserData();
         userData2.setNom("Wayne");
         userData2.setPrenom("Bruce");
         userData2.setPassw("batman");
         userData2.setFaction(Faction.gentil);
         UserData userData3 = new UserData();
         userData3.setNom("Parker");
         userData3.setPrenom("Peter");
         userData3.setPassw("spiderman");
         userData3.setFaction(Faction.gentil);
         UserData userData4 = new UserData();
         userData4.setNom("Dent");
         userData4.setPrenom("Harvey");
         userData4.setPassw("doubleface");
         userData4.setFaction(Faction.mechant);
         List<UserData> users = new ArrayList<UserData>();
         
         users.add(userData1);
         users.add(userData2);
         users.add(userData3);
         users.add(userData4);
      
         httpSessionEvent.getSession().setAttribute("users", users);
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
