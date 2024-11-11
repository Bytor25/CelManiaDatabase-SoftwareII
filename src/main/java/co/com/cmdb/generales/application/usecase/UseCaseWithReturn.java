package co.com.cmdb.generales.application.usecase;

public interface UseCaseWithReturn <R, D>{
	
    R execute(D data);
}
