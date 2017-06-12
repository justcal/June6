//Resource 
package com.sust.rest.Publications;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Publications {
	
	private int id;
	String publication_Title;
	String publication_Subject;
	String publication_Author;
	
	public Publications() {}
	
	public Publications(int id, String publication_Title, String publication_Subject, String publication_Author) {
		super();
		this.id = id;
		this.publication_Title = publication_Title;
		this.publication_Subject = publication_Subject;
		this.publication_Author = publication_Author;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return publication_Title;
	}
	
	public void setTitle(String publication_Title) {
		this.publication_Title = publication_Title;
	}

	public String getSubject() {
		return publication_Subject;
	}
	
	public void setSubject(String publication_Subject) {
		this.publication_Subject = publication_Subject;
	}
	
	public String getAuthor() {
		return publication_Author;
	}
	
	public void setAuthor(String publication_Author) {
		this.publication_Author = publication_Author;
	}
	
	@Override
	public String toString() {
		return "credentials [id=" + id + ", Title=" + publication_Title + ", Subject=" + publication_Subject + ", Author=" + publication_Author + "]";
	}

}