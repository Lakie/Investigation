package garbage.impl;

import com.unesasoft.persistance.dao.PasswordResetTokenRepository;
import com.unesasoft.persistance.dto.PasswordResetTokenDTO;
import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * Created by Slavyanin on 17.12.2015.
 */
//@Repository
public class PasswordResetTokenRepositoryImpl extends SimpleJpaRepository<PasswordResetTokenDTO, Long> implements PasswordResetTokenRepository {
    private final JpaEntityInformation<PasswordResetTokenDTO, ?> entityInformation;
    private final EntityManager entityManager;
    private final PersistenceProvider provider;

    public PasswordResetTokenRepositoryImpl(JpaEntityInformation<PasswordResetTokenDTO, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    public PasswordResetTokenRepositoryImpl(Class<PasswordResetTokenDTO> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    @Override
    public PasswordResetTokenDTO findByToken(String token) {
        return null;
    }

    @Override
    public PasswordResetTokenDTO findByUser(UserDTO user) {
        return null;
    }
}
