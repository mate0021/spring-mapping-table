package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.AuthorNameKey;
import rnd.mate00.springmappingtable.entity.AuthorWithCompositeKey;

@Repository
public interface AuthorCompositeRepository extends JpaRepository<AuthorWithCompositeKey, AuthorNameKey> {
}
