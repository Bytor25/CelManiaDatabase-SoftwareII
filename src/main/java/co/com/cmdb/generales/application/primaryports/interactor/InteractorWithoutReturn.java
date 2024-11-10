package co.com.cmdb.generales.application.primaryports.interactor;

public interface InteractorWithoutReturn<T>{
    void execute(T data);
}