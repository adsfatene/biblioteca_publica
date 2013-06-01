pesquisarPorTodosOsDadosNaoNulos1;
SELECT * FROM estoques_view 
    WHERE estoque_material_codigo NOT IN 
    (
        SELECT emprestimo_estoque_material_codigo FROM emprestimos_view 
        WHERE emprestimo_estoque_material_formato_nome IN ('Impresso')
        AND emprestimo_data_hora_devolucao_efetiva IS NULL
    )
    AND estoque_statu IS NOT NULL;

pesquisarPorTodosOsDadosNaoNulos2;
    ORDER BY estoque_material_dado_material_titulo, estoque_material_dado_material_descricao;

pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormatoStatu;
SELECT * FROM estoques_combobox_view;