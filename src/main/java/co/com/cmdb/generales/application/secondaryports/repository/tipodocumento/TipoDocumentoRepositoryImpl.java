package co.com.cmdb.generales.application.secondaryports.repository.tipodocumento;

import java.util.ArrayList;
import java.util.List;

import co.com.cmdb.generales.application.secondaryports.entity.TipoDocumentoEntity;
import co.com.cmdb.generales.crosscutting.exceptions.DataCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class TipoDocumentoRepositoryImpl implements TipoDocumentoRepositoryCustom {
	
	private EntityManager entityManager;
	
	public TipoDocumentoRepositoryImpl(final EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}

	@Override
	public List<TipoDocumentoEntity> selectByFilter(TipoDocumentoEntity filter) {
	
		try {
			
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(TipoDocumentoEntity.class);
			var result = query.from(TipoDocumentoEntity.class);
		
			var predicates = new ArrayList<Predicate>();
			
			if(!ObjectHelper.isNull(filter)) {
				
				if(!NumericHelper.isNullOrEmpty(filter.getIdentificador())) {
					predicates.add(criteriaBuilder.equal(result.get("identificador"), filter.getIdentificador()));
					
				}
				
				if(!TextHelper.isEmptyApplyingTrim(filter.getNombre())) {
					predicates.add(criteriaBuilder.equal(result.get("nombre"), filter.getNombre()));
				
				}
				
			}
			
		query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));	
		
		
		return entityManager.createQuery(query).getResultList();
		
		
			
			
		} catch (final Exception exception) {
			
			throw new DataCmdbException("Error", "Error", exception);
			
		}
	}
	
	

}
