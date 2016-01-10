package garbage.impl;

import com.unesasoft.persistance.dao.PrivilegeRepository;
import com.unesasoft.persistance.dto.PrivilegeDTO;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Slavyanin on 17.12.2015.
 */
//@Repository
public class PrivilegeRepositoryImpl extends SimpleJpaRepository<PrivilegeDTO, Long> implements PrivilegeRepository {
    private final JpaEntityInformation<PrivilegeDTO, ?> entityInformation;
    private final EntityManager entityManager;
    private final PersistenceProvider provider;

    public PrivilegeRepositoryImpl(JpaEntityInformation<PrivilegeDTO, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    public PrivilegeRepositoryImpl(Class<PrivilegeDTO> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    @Override
    public PrivilegeDTO findByName(String name) {
        Query query = entityManager.createQuery("from PrivilegeDTO where name=:name");
        query.setParameter("name",name);
        return (PrivilegeDTO) query.getSingleResult();
    }
}
