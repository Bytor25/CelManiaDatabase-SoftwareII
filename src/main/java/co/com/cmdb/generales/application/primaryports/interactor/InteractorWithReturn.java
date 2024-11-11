package co.com.cmdb.generales.application.primaryports.interactor;

public interface InteractorWithReturn <T, R> {
	
    R execute(T data);
    
}
