package com.live.ads21fatene.biblioteca_publica.models.daos;

import com.live.ads21fatene.biblioteca_publica.models.Cidadao;
import java.util.List;

/**
 *
 * @author Clairton
 */
public class CidadaosDAO {
    private Conexao conexao;

    public CidadaosDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    public List<Cidadao> pesquisarPorTodosOsDadosNaoNulos(Cidadao cidadao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cidadao buscarPeloCodigo(Integer codigo) {
        Cidadao cidadao = new Cidadao();
        cidadao.setCodigo(codigo);
        List<Cidadao> cidadaos = pesquisarPorTodosOsDadosNaoNulos(cidadao);
        cidadao = cidadaos.remove(0);
        return cidadao;
    }

    public Boolean atualizarPorTodosOsDados(Cidadao cidadao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean cadastarNovo(Cidadao cidadao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
