package com.sust.rest.Publications;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.json.*;

import com.sust.rest.Publications.*;


	@Path("/publications")
	public class PublicationsResource {
		PublicationsDao dao = PublicationsDao.getInstance();
		

		public PublicationsResource() {
		}	
	
		@GET
		@Path("/basic")
		@Produces("application/json")
		public List<Publications> getPublications() {
			return dao.getAll();
		}
	
		@GET
		@Path("/json")
		@Produces("application/json")
	    public List<Publications> getPublicationsJson(){
			return getPublications();
		}

		@GET
		@Path("/text")
		@Produces("application/text")
	    public String getPublicationsText(){
			return getPublications().toString();
		}


		@GET
		@Path("/{id}")
		@Produces("application/xml")
		public Publications getPublications(@PathParam(value = "key") int key) throws ResourceException {
			if(dao.get(key) == null) {
			 throw new ResourceException("incorrect url ");
			}
			else
			return dao.get(key);		
		    }
		
		
		@Path("/new")
		@Consumes("application/json")
		@Produces("application/json")
		@POST
		public String addPublications(Publications publ) throws ResourceException  {
			if(dao.addPublications(publ) == null) {
				throw new ResourceException("could not add new data");
			}
			else
		return "OK";
		}
		
	
		//post new row(json array) from user input value
		@Path("/createnew")
		@Consumes("application/json")
		@Produces("application/json")
		@POST
		public Response createNameInJSON(
				@FormParam("id") int id,
				@FormParam("title") String title, 
				@FormParam("subject") String subject,
				@FormParam("author") String author) throws ResourceException{
			
			Publications var = new Publications(id,title,subject,author);
			if(addPublications(var) == null) {
				throw new ResourceException("could not add new publication");
			}
			else
			return Response.status(200)
					.entity("id : " + id + "," + " title : " + title + " , " + " subject is : " + subject + "author is : " + author )
					.build();			
			}	
		
		
		
		@Path("")
		@Consumes("application/json")
		@Produces("application/json")
		@POST
		public String updatePublications(Publications publ) {
		dao.updatePublications(publ);
		return "OK";
		}		
	
		//put - use to update existing row (json array) of data 
		@Path("/updateExisting")
		@PUT
		public Response updatePublicationInJSON(
				@FormParam("id") int id,
				@FormParam("title") String title, 
				@FormParam("subject") String subject,
				@FormParam("author") String author){
			
			Publications var = new Publications(id,title,subject,author);
			updatePublications(var);
			return Response.status(200)
					.entity("id : " + id + "," + " title : " + title + " , " + " subject is : " + subject + "author is : " + author )
					.build();
		}
		
		
		//delete a row
//		@Path("/delete")
//		@DELETE
//		public Response deletePublicationInJSON(
//				@FormParam("id") int id,
//				@FormParam("title") String title, 
//				@FormParam("subject") String subject,
//				@FormParam("author") String author){
//			
//			Publications var = new Publications(id,title,subject,author);
//			
//			deletePublications(var);
//			
//			return Response.status(200)
//					.entity("id : " + id + "," + " title : " + title + " , " + " subject is : " + subject + "author is : " + author )
//					.build();
//		}
		
		
		

}
	