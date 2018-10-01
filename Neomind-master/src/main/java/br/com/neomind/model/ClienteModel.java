package br.com.neomind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteModel {

@Id
@Column(name = "id")
int id;

@Column (name="name")
String name;

@Column (name="cnpj")
String cnpj;

@Column (name="email")
String email;

@Column (name="comment")
String comment;

public int getId() {
 return id; }

 public void setId(int id) {
 this.id = id; }

 public String getName() {
 return name; }

 public void setName(String name) {
 this.name = name; }
 
 public String getCnpj(){
	 return cnpj;}
 
 public void setCnpj(String cnpj) {
	 this.cnpj = cnpj;}
 
 public String getEmail() {
	return email; }
 
 public void setEmail(String email) {
	 this.email = email;}

 public String getComment() {
	 return comment;}
 
 public void setComment(String comment) {
	 this.comment = comment;}
	 

}
