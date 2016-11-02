/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk.util;

import com.dk.OpticStore;
import com.dk.orm.Verkoop;
import com.dk.orm.dbobject.DbObject;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Nick
 */
public class SelectModifier {

    public static String modifyKlantCondition(
            TextField klantIDfield,
            TextField aanhefField,
            TextField voorlettersField,
            TextField tussenvoegselField,
            TextField achternaamField,
            TextField adresField,
            TextField huisnummerField,
            TextField postcodeField,
            TextField plaatsField,
            TextField landField,
            TextField gebortedatumField,
            TextField telefonField,
            TextField mobileField,
            TextField emailField
    ) {
        int orderByPos = OpticStore.KLANTLIST.toLowerCase().indexOf(" order by");
        StringBuilder sb = new StringBuilder(OpticStore.KLANTLIST.substring(0,
                orderByPos) + " where ");
        boolean isThere = false;
        if (!klantIDfield.getText().isEmpty()) {
            sb.append("klant_id = " + klantIDfield.getText());
            isThere = true;
        }
        if (!aanhefField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(aanhef) like '" + aanhefField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!voorlettersField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(voorletters) like '" + voorlettersField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!tussenvoegselField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(tussenvoegsel) like '" + tussenvoegselField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!achternaamField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(achternaam) like '" + achternaamField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!adresField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(adres) like '" + adresField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!huisnummerField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(huisnummer) like '" + huisnummerField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!postcodeField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(postcode) like '" + postcodeField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!plaatsField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(plaats) like '" + plaatsField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!landField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(land) like '" + landField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!gebortedatumField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("to_char(geboortedatum,'"
                    + OpticStore.dateFormat.toPattern().toUpperCase() + "') like '"
                    + gebortedatumField.getText() + "%'");
            isThere = true;
        }
        if (!telefonField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(telefoon) like '" + telefonField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!mobileField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(mobiel) like '" + mobileField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (!emailField.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(email) like '" + emailField.getText().toUpperCase() + "%'");
            isThere = true;
        }
        if (isThere) {
            sb.append(OpticStore.KLANTLIST.substring(orderByPos));
            return sb.toString();
        } else {
            return OpticStore.KLANTLIST;
        }
    }

    public static String modifyVerkoopCondition(TextField srcDate1Input,
            TextField srcDate2Input, ComboBox srcMerkCombo,
            ComboBox srcModelCombo, ComboBox srcKleurCombo,
            TextField srcMaatInput,
            TextField srcPrijs1MontuurInput, TextField srcPrijs2MontuurInput,
            ComboBox srcMontuurTypeCombo, ComboBox srcMateriallCombo,
            ComboBox srcDiversenCombo, TextField srcIdMontuurInput,
            ComboBox srcLeverancierCombo, ComboBox srcTypeGlasCombo,
            ComboBox srcCoatingCombo, ComboBox srcKleurGlasCombo,
            TextField srcDiameter1Input, TextField srcDiameter2Input) {
        int orderByPos = OpticStore.VERKOOPLIST.toLowerCase().indexOf(" order by");
        StringBuilder sb = new StringBuilder(
                OpticStore.VERKOOPLIST.substring(0, orderByPos > 0 ? orderByPos : 2048) + " where ");
        boolean isThere = false;
        if (!srcDate1Input.getText().isEmpty()) {
            sb.append("verkoopdatum >= to_date('" + srcDate1Input.getText() + "','"
                    + OpticStore.dateFormat.toPattern().toUpperCase() + "') ");
            isThere = true;
        }
        if (!srcDate2Input.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("verkoopdatum <= to_date('" + srcDate2Input.getText() + "','"
                    + OpticStore.dateFormat.toPattern().toUpperCase() + "') ");
            isThere = true;
        }
        if (!srcMerkCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_merk like '" + srcMerkCombo.getEditor().getText() + "%'");
        }
        if (!srcModelCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_model like '" + srcModelCombo.getEditor().getText() + "%'");
        }
        if (!srcKleurCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_kleur like '" + srcKleurCombo.getEditor().getText() + "%'");
        }
        if (!srcMaatInput.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_maat like '" + srcMaatInput.getText() + "%'");
        }
        if (!srcPrijs1MontuurInput.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_prijs >= " + srcPrijs1MontuurInput.getText());
        }
        if (!srcPrijs2MontuurInput.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_prijs <= " + srcPrijs2MontuurInput.getText());
        }
        if (!srcMontuurTypeCombo.getValue().toString().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_type = '" + srcMontuurTypeCombo.getValue().toString() + "'");
        }
        if (!srcMateriallCombo.getValue().toString().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("material = '" + srcMateriallCombo.getValue().toString() + "'");
        }
        if (!srcDiversenCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("diverse like '" + srcDiversenCombo.getEditor().getText() + "%'");
        }
        if (!srcIdMontuurInput.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("id_montuur like '" + srcIdMontuurInput.getText() + "%'");
        }
        if (!srcLeverancierCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            String leverancier = srcLeverancierCombo.getEditor().getText();
            sb.append("(r_leverancier like '" + leverancier + "%' or l_leverancier like '" + leverancier + "%')");
        }
        if (!srcTypeGlasCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            String typeglas = srcTypeGlasCombo.getEditor().getText();
            sb.append("(r_type_glas like '" + typeglas + "%' or l_type_glas like '" + typeglas + "%')");
        }
        if (!srcCoatingCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            String coating = srcCoatingCombo.getEditor().getText();
            sb.append("(r_coating like '" + coating + "%' or l_coating like '" + coating + "%')");
        }
        if (!srcKleurCombo.getEditor().getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            String kleurglass = srcKleurCombo.getEditor().getText();
            sb.append("(r_kleur_glazen like '" + kleurglass + "%' or l_kleur_glazen like '" + kleurglass + "%')");
        }
        if (!srcDiameter1Input.getText().isEmpty() && !srcDiameter2Input.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("((r_diameter between " + srcDiameter1Input.getText().replace(",", ".")
                    + " and " + srcDiameter2Input.getText().replace(",", ".") + ")");
            sb.append(" or ");
            sb.append("(l_diameter between " + srcDiameter1Input.getText().replace(",", ".")
                    + " and " + srcDiameter2Input.getText().replace(",", ".") + "))");
        } else if (!srcDiameter1Input.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_diameter >= " + srcDiameter1Input.getText().replace(",", ".")
                    + "l_diameter >= " + srcDiameter1Input.getText().replace(",", ".") + ")");
        }
        if (!srcDiameter2Input.getText().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_diameter <= " + srcDiameter2Input.getText().replace(",", ".")
                    + "l_diameter <= " + srcDiameter2Input.getText().replace(",", ".") + ")");
        }
        if (isThere) {
            if (orderByPos > 0) {
                sb.append(OpticStore.KLANTLIST.substring(orderByPos));
            }
            return sb.toString();
        } else {
            return OpticStore.VERKOOPLIST;
        }
    }

    public static String getCurListEmails(Vector[] body, int col) {
        StringBuilder sb = new StringBuilder();
        Set set = new HashSet();
        //Vector[] body = klantGrid.getTableBody();
        Vector lines = body[1];
        for (int i = 0; i < lines.size(); i++) {
            Vector line = (Vector) lines.get(i);
            set.add(line.get(col));
        }
        for (Object o : set) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(o.toString());
        }
        return sb.toString();
    }

    public static String getAgeRangeEmails(TextField vanDeInput, TextField totDeInput) {
        StringBuilder condition = new StringBuilder();
        if (vanDeInput.getText() != null && vanDeInput.getText().length() > 0) {
            condition.append("months_between(now(),geboortedatum)/12 >= " + vanDeInput.getText());
        }
        if (totDeInput.getText() != null && totDeInput.getText().length() > 0) {
            if (condition.length() > 0) {
                condition.append(" and ");
            }
            condition.append("months_between(now(),geboortedatum)/12 <= " + totDeInput.getText());
        }
        if (condition.length() > 0) {
            condition.insert(0, "select distinct email from klant where ");
        }
        try {
            return SelectModifier.getCurListEmails(
                    OpticStore.getExchanger().getTableBody(condition.toString()), 0);
        } catch (RemoteException ex) {
            OpticStore.log(ex.getLocalizedMessage());
        }
        return "";
    }

    public static Verkoop getLastVerkoop(Integer klantId) throws RemoteException {
        DbObject[] recs = OpticStore.getExchanger().getDbObjects(
                Verkoop.class, "klant_id=" + klantId, "verkoopdatum desc");
        if (recs.length > 0) {
            return (Verkoop) recs[0];
        }
        return (Verkoop) null;
    }
}
