
package edu.infsci2560.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


@Entity
public class Rating {

    @EmbeddedId
    private RatingPk pk;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    /**
     * Create a rating for a recipe
     *
     * @param pk         primiary key of a recipe and userid.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the user
     */
    public Rating(RatingPk pk, Integer score, String comment) {
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }

    public Rating() {
    }

    @Override
    public String toString() {
                return "[ pk=" + this.pk + ", score=" + this.score + ", comment=" +this.comment+" ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public RatingPk getPk() {
        return pk;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setPk(RatingPk pk) {
        this.pk = pk;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
