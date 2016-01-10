package garbage.impl;

/**
 * Created by Slavyanin on 17.12.2015.
 */
//@Repository
public class UserRepositoryImpl{
    //} extends SimpleJpaRepository<UserDTO, Long> implements UserRepository {
//    private final JpaEntityInformation<UserDTO, ?> entityInformation;
//    private final EntityManager entityManager;
//    private final PersistenceProvider provider;
//
//    public UserRepositoryImpl(JpaEntityInformation<UserDTO, ?> entityInformation, EntityManager entityManager) {
//        super(entityInformation, entityManager);
//        this.entityInformation = entityInformation;
//        this.entityManager = entityManager;
//        this.provider = PersistenceProvider.fromEntityManager(entityManager);
//    }
//
//    public UserRepositoryImpl(Class<UserDTO> domainClass, EntityManager entityManager) {
//        super(domainClass, entityManager);
//        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
//        this.entityManager = entityManager;
//        this.provider = PersistenceProvider.fromEntityManager(entityManager);
//    }
//
//    @Override
//    public UserDTO findByEmail(String email) {
//        Query query = entityManager.createQuery("from UserDTO where email=:emai");
//        query.setParameter("email",email);
//        return (UserDTO) query.getSingleResult();
//    }


}
