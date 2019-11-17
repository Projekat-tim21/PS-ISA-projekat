package rs.ac.uns.ftn.informatika.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import rs.ac.uns.ftn.informatika.jpa.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}