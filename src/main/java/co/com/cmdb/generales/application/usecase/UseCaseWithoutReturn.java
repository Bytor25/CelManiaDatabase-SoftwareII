package co.com.cmdb.generales.application.usecase;

public interface UseCaseWithoutReturn<D>{
    void execute(D domain);
}
