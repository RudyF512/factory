package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Module;



public interface ModuleRepository extends JpaRepository<Module, Long> {

}
