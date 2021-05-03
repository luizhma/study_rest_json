package luiz_hma.study_rest_json.repository;

import luiz_hma.study_rest_json.model.bean.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {

}
