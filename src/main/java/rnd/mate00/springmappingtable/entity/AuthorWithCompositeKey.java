package rnd.mate00.springmappingtable.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "author_composite")
public class AuthorWithCompositeKey {

    @EmbeddedId
    private AuthorNameKey authorNameKey;

    private String country;

    public AuthorWithCompositeKey() {
    }

    public AuthorWithCompositeKey(AuthorNameKey authorNameKey, String country) {
        this.authorNameKey = authorNameKey;
        this.country = country;
    }

    public AuthorNameKey getAuthorNameKey() {
        return authorNameKey;
    }

    public void setAuthorNameKey(AuthorNameKey authorNameKey) {
        this.authorNameKey = authorNameKey;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorWithCompositeKey author = (AuthorWithCompositeKey) o;
        return Objects.equals(authorNameKey, author.authorNameKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorNameKey);
    }

    @Override
    public String toString() {
        return "AuthorWithCompositeKey{" +
                "authorNameKey=" + authorNameKey +
                ", country='" + country + '\'' +
                '}';
    }
}
