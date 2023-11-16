package cadastroee.controller;

import cadastroee.model.Produto;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Maiara
 */
@Local
public interface ProdutoFacadeLocal {
    void create(Produto var1);

    void edit(Produto var1);

    void remove(Produto var1);

    Produto find(Object var1);

    List<Produto> findAll();

    List<Produto> findRange(int[] var1);

    int count();
}

