
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
    private RatingPk ratingPk;


    private int score;


    private String comment;

    /**
     * Create a rating for a recipe
     *
     * @param ratingPk         primiary key of a recipe and userid.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the user
     */
    public Rating(RatingPk ratingPk, int score, String comment) {
        this.ratingPk = ratingPk;
        this.score = score;
        this.comment = comment;
    }

    public Rating() {
    }

    @Override
    public String toString() {
                return "[ pk=" + this.ratingPk + ", score=" + this.score + ", comment=" +this.comment+" ]";
    }



    public RatingPk getRatingPk() {
        return ratingPk;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setRatingPk(RatingPk ratingPk) {
        this.ratingPk = ratingPk;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
