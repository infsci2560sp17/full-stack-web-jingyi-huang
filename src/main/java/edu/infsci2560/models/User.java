package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String username;
    private String city;
    private String email;
    private String password;

    public User() {}

    public User(Long userId,String username, String password, String email, String city) {
        this.id = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username='%s', password='%s', email='%s', city='%s']", getId(), getUserName(), getPassword(),getEmail(), getCity());
    }

    /**
     * @return the userId
     */
    public Long getId() {
        return id;
    }

    /**
     * @param userId the id to set
     */
    public void setId(Long userId) {
        this.id = userId;
    }

    /**
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * @param username
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

}
