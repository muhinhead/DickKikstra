/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk.orm;

import com.dk.orm.dbobject.DbObject;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.orm.dbobject.TriggerAdapter;
import java.sql.SQLException;

/**
 *
 * @author nick
 */
public class VerkoopTrigger extends TriggerAdapter {

    private static final double NDS = 21.0;

    @Override
    public void beforeInsert(DbObject dbObject) throws SQLException {
        try {
            Verkoop vb = (Verkoop) dbObject;
            calcBTW(vb);
        } catch (ForeignKeyViolationException ex) {
        }
    }

    @Override
    public void beforeUpdate(DbObject dbObject) throws SQLException {
        try {
            Verkoop vb = (Verkoop) dbObject;
            calcBTW(vb);
        } catch (ForeignKeyViolationException ex) {
        }
    }

    private Double getBTW(Double val) {
        if (val == null) {
            return null;
        }
        return new Double(Math.round(100.0 * (val.doubleValue() / (100.0 + NDS)) * NDS) / 100.0);
    }

    private void calcBTW(Verkoop vk) throws SQLException, ForeignKeyViolationException {
        vk.setLBtw(getBTW(vk.getLPrijsGlas()));
        vk.setRBtw(getBTW(vk.getRPrijsGlas()));
        vk.setMontuurBtw(getBTW(vk.getMontuurPrijs()));
        vk.setDiverseBtw(getBTW(vk.getDiversePrijs()));
    }
}
