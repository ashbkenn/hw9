package c322spring2024homework2.repository;

import c322spring2024homework2.model.GuitarTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarsRepository
        extends CrudRepository<GuitarTable, String>
, QueryByExampleExecutor<GuitarTable> {
}
