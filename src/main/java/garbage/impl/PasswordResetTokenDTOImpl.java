package garbage.impl;

import com.unesasoft.persistance.dao.PasswordResetTokenDTO;
import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.persistance.dto.VerificationTokenDTO;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * Created by Slavyanin on 17.12.2015.
 */
//@Repository
public class PasswordResetTokenDTOImpl extends SimpleJpaRepository<VerificationTokenDTO, Long> implements PasswordResetTokenDTO {
    private final JpaEntityInformation<VerificationTokenDTO, ?> entityInformation;
    private final EntityManager entityManager;
    private final PersistenceProvider provider;

    public PasswordResetTokenDTOImpl(JpaEntityInformation<VerificationTokenDTO, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    public PasswordResetTokenDTOImpl(Class<VerificationTokenDTO> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    @Override
    public VerificationTokenDTO findByToken(String token) {
        return null;
    }

    @Override
    public VerificationTokenDTO findByUser(UserDTO user) {
        return null;
    }
}
