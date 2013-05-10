package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import java.util.List;

/**
 *
 * @author Clairton
 */
public class EmprestimosDAO {

    private Conexao conexao;

    public EmprestimosDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    public List<Emprestimo> pesquisarPorTodosOsDadosNaoNulos(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Emprestimo buscarPeloCodigo(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean cadastarNovo(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean atualizarDadosDeDevolucao(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
