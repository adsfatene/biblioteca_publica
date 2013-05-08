package com.live.ads21fatene.biblioteca_publica.models.daos;

import com.live.ads21fatene.biblioteca_publica.models.Estoque;
import com.live.ads21fatene.biblioteca_publica.models.EmprestimoIrrecuperavel;
import com.live.ads21fatene.biblioteca_publica.models.Material;
import java.util.List;

public class EstoquesDAO {
    private Conexao conexao;

    public EstoquesDAO(Conexao conexao) {
        this.conexao = conexao;
    }    

    public Boolean estocarNovo(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean aumentar(Estoque estoque, Integer volumeAdicional) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean moverVolumeDeMaterialEstocadoParaEstoquesIrrecuperavel(EmprestimoIrrecuperavel estoqueIrrecuperavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Estoque> pesquisarPorTodosOsDadosNaoNulos(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
