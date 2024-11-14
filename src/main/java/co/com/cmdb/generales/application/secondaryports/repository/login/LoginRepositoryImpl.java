package co.com.cmdb.generales.application.secondaryports.repository.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Repository
public class LoginRepositoryImpl implements LoginRepositoryCustom{

	private EntityManager entityManager;
	
	public LoginRepositoryImpl(final EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}
	@Override
	public List<LoginEntity> selectByFilter(LoginEntity filter) {
		
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(LoginEntity.class);
			var result = query.from(LoginEntity.class);
			
			var predicates = new ArrayList<>();
			
			if(!ObjectHelper.isNull(filter)) {
				if(!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
					
				}
				
				if(!TextHelper.isNull(filter.getUsuario())) {
					predicates.add(criteriaBuilder.equal(result.get("usuario"), filter.getUsuario()));
						
				}
				
				if(!NumericHelper.isNullOrEmpty(filter.getPassword())) {
					predicates.add(criteriaBuilder.equal(result.get("password"), filter.getPassword()));
				}
				
				if(!BooleanHelper.isNull(filter.isEstado())) {
					predicates.add(criteriaBuilder.equal(result.get("estado"), filter.isEstado()));
				}
			}
			
			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			
			return entityManager.createQuery(query).getResultList();
		}catch(Exception exception) {
			throw new DataCmdbException("Error", "Error", exception);
		}
	}

}
