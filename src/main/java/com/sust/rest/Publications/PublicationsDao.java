package com.sust.rest.Publications;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sust.rest.Publications.*;

/*singleton class*/

public class PublicationsDao {
	static PublicationsDao instance = new PublicationsDao();
	
	public static PublicationsDao getInstance() {
        return instance;
	}
	
	//store data in a hashmap
	HashMap<Integer, Publications> publicationsHashMap = new HashMap<Integer, Publications>();
	int lastId = 13;
	
	//create an object
	private PublicationsDao() {
		 int key = lastId;
         Publications publications = new Publications(key, "title", "subject", "author");
         publicationsHashMap.put(key, publications);
    }
	
   public Publications get(int key){
         return (Publications)publicationsHashMap.get(key);
   		}
	
	public List<Publications> getAll(){
        List<Publications> publicationsList = new ArrayList<Publications>();
        for (Map.Entry<Integer, Publications> entry : publicationsHashMap.entrySet()) { 
        	System.out.println("inside publications list");
        	publicationsList.add(entry.getValue());
        }
        return publicationsList;
	}
  

	public Integer addPublications(Publications publications) {
           int nextKey = getNextKey();           
           publications.setId(nextKey);
           publicationsHashMap.put(nextKey, publications);
           return nextKey;
     }
	
	public Integer updatePublications(Publications publications) {
		   int key = publications.getId();
           publicationsHashMap.put(key, publications);
           int nextKey = getNextKey(); 
           return nextKey;
		
	}
	
	private int getNextKey() {
	       return ++lastId;
	}
			
 	public Integer deletePublications(Publications publications) {
			 int nextKey = lastId;   
	         publicationsHashMap.remove(nextKey, publications);
	         return nextKey;
		}
	
}
