package edu.infsci2560.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Objects;

@Embeddable
public class RatingPk implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Long recipeid;

    @Column(insertable = false, updatable = false,nullable = false)
    private Long userid;

    public RatingPk() {
    }

    /**
     * Fully initialize a Rating Pk
     *
     * @param recipe          the recipe
     * @param userid    the user identifier.
     */
    public RatingPk(Long recipeid, Long userid) {
        this.recipeid = recipeid;
        this.userid = userid;   
    }
    @Override
    public String toString() {
                return "[ recipeId =" + this.recipeid + ", userId=" + this.userid +" ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public Long getRecipeId() {
        return recipeid;
    }

    public Long getUserId() {
        return userid;
    }
    


}
