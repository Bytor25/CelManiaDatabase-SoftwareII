package co.com.cmdb.generales.application.usecase;

public interface UseCaseWithReturn <D,R>{
    R execute(D domain);
}
