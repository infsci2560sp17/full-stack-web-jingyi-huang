package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userid;
    protected String username;
    protected String city;

    protected User() {}

    public User(Long userid, String username, String city) {
        this.userid = userid;
        this.username = username;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username='%s', city='%s']", getId(), getUserName(), getCity());
    }

    /**
     * @return the userid
     */
    public Long getId() {
        return userid;
    }

    /**
     * @param userid the id to set
     */
    public void setId(Long userid) {
        this.userid = userid;
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

}
