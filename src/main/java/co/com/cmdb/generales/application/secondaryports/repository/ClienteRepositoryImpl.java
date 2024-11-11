package co.com.cmdb.generales.application.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.LongHelper;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryCustom {
	
	private EntityManager entityManager;
	
	public ClienteRepositoryImpl(final EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}

	@Override
	public List<ClienteEntity> selectByFilter(ClienteEntity filter) {
		
		try {
			
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(ClienteEntity.class);
			var result = query.from(ClienteEntity.class);
			
			var predicates = new ArrayList<>();
			
			if(ObjectHelper.isNull(filter)) {
				
				if(!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
					
				}
				
				if(ObjectHelper.isNull(filter.getTipoDocumento()) && !NumericHelper.isNull(filter.getTipoDocumento().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("TipoDocumento"), filter.getTipoDocumento()));
					
				}
				
				if(!TextHelper.isNull(filter.getNombre())) {
					predicates.add(criteriaBuilder.equal(result.get("Nombre"), filter.getNombre()));
						
				}
		
				
				if(!TextHelper.isNull(filter.getApellidos())) {
					predicates.add(criteriaBuilder.equal(result.get("Apellidos"), filter.getApellidos()));
					
				}
				
				if(!TextHelper.isNull(filter.getCorreo())) {
					predicates.add(criteriaBuilder.equal(result.get("Correo"), filter.getCorreo()));
						
				}
				
				if(!LongHelper.isNull(filter.getTelefono())) {
					predicates.add(criteriaBuilder.equal(result.get("Telefono"), filter.getTelefono()));
					
				}
				
			}
			
			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			
			return entityManager.createQuery(query).getResultList();
			
		} catch (Exception exception) {
			
			throw new DataCmdbException("Error", "Error", exception);
			
		}
		
		
	
		
	}

}
