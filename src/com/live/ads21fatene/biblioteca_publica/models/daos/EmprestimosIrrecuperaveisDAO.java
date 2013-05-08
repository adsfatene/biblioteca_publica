package com.live.ads21fatene.biblioteca_publica.models.daos;

import com.live.ads21fatene.biblioteca_publica.models.EmprestimoIrrecuperavel;
import java.util.List;

/**
 *
 * @author Clairton
 */
public class EmprestimosIrrecuperaveisDAO {

    private final Conexao conexao;

    public EmprestimosIrrecuperaveisDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    public List<EmprestimoIrrecuperavel> pesquisarPorTodosOsDadosNaoNulos(EmprestimoIrrecuperavel materialIrrecuperavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
