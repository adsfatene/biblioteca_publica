pesquisarPorTodosOsDadosNaoNulos1;
SELECT * FROM estoques_view 
    WHERE 
    (estoque_material_formato_nome NOT IN ('Impresso') AND estoque_statu NOT IN ('Emprestado'))
    AND estoque_statu IN ('Novo', 'Usado', 'Restaurado');

pesquisarPorTodosOsDadosNaoNulos2;
    ORDER BY estoque_material_dado_material_titulo, estoque_material_dado_material_descricao;

pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormatoStatu;
SELECT * FROM estoques_combobox_view;