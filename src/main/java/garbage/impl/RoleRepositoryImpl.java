package garbage.impl;

import com.unesasoft.persistance.dao.RoleRepository;
import com.unesasoft.persistance.dto.RoleDTO;
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
public class RoleRepositoryImpl extends SimpleJpaRepository<RoleDTO, Long> implements RoleRepository {
    private final JpaEntityInformation<RoleDTO, ?> entityInformation;
    private final EntityManager entityManager;
    private final PersistenceProvider provider;

    public RoleRepositoryImpl(JpaEntityInformation<RoleDTO, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    public RoleRepositoryImpl(Class<RoleDTO> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
        this.entityManager = entityManager;
        this.provider = PersistenceProvider.fromEntityManager(entityManager);
    }

    @Override
    public RoleDTO findByName(String name) {
        Query query = entityManager.createQuery("from RoleDTO where name=:name");
        query.setParameter("name", name);
        return (RoleDTO) query.getSingleResult();
    }
}
