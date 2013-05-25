package com.live.adsfatene.biblioteca_publica.models.util;

import com.live.adsfatene.biblioteca_publica.models.Statu;
import com.live.adsfatene.biblioteca_publica.models.daos.SetCommand;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MJ
 */
public class EstoqueComboBox {

    private final List<Statu> status;
    private final MaterialComboBox materialComboBox;

    public EstoqueComboBox() {
        status = new LinkedList<>();
        materialComboBox = new MaterialComboBox();
    }

    public List<Statu> getStatus() {
        return status;
    }

    public MaterialComboBox getMaterialComboBox() {
        return materialComboBox;
    }   
}