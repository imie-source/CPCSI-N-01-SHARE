/**
 * 
 */
package fr.imie.usercpcsi.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.usercpcsi.presentation.model.Faction;
import fr.imie.usercpcsi.presentation.model.UserData;

/**
 * @author imie
 *
 */
@Named("instance")
public class UserService implements UserServiceInterface {

	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<UserData> getAllUser(){
		System.out.println("alimentation data");
		
		List<UserData> retour = new ArrayList<UserData>();
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
     
		return users;
	}


}
