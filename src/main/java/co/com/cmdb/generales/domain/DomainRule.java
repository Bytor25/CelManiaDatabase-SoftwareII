package co.com.cmdb.generales.domain;

public interface DomainRule<T> {
	void execute(T data);
}
