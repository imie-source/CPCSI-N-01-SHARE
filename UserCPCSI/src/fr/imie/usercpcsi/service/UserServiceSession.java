/**
 * 
 */
package fr.imie.usercpcsi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.usercpcsi.presentation.model.Faction;
import fr.imie.usercpcsi.presentation.model.UserData;

/**
 * @author imie
 *
 */
@Named("session")
@SessionScoped
public class UserServiceSession implements UserServiceInterface,Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6932877048494992121L;
	
	private List<UserData> userList = null;
	
	/**
	 * 
	 */
	public UserServiceSession() {
		        
	}
	
	@Override
	public List<UserData> getAllUser(){
		if(userList==null){
			System.out.println("alimentation data");
			
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
	        userList = new ArrayList<UserData>();
	        userList.add(userData1);
	        userList.add(userData2);
	        userList.add(userData3);
	        userList.add(userData4);

		}
		
		
		return userList;
	}
}
