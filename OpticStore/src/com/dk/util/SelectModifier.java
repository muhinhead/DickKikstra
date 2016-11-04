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
import javafx.scene.control.RadioButton;
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
        if (!klantIDfield.getText().trim().isEmpty()) {
            sb.append("klant_id = " + klantIDfield.getText());
            isThere = true;
        }
        if (!aanhefField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(aanhef) like '" + aanhefField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!voorlettersField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(voorletters) like '" + voorlettersField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!tussenvoegselField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(tussenvoegsel) like '" + tussenvoegselField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!achternaamField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(achternaam) like '" + achternaamField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!adresField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(adres) like '" + adresField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!huisnummerField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(huisnummer) like '" + huisnummerField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!postcodeField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(postcode) like '" + postcodeField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!plaatsField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(plaats) like '" + plaatsField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!landField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(land) like '" + landField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!gebortedatumField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("to_char(geboortedatum,'"
                    + OpticStore.dateFormat.toPattern().trim().toUpperCase() + "') like '"
                    + gebortedatumField.getText() + "%'");
            isThere = true;
        }
        if (!telefonField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(telefoon) like '" + telefonField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!mobileField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(mobiel) like '" + mobileField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!emailField.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(email) like '" + emailField.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (isThere) {
            sb.append(OpticStore.KLANTLIST.substring(orderByPos));
            return sb.toString();
        } else {
            return OpticStore.KLANTLIST;
        }
    }

    private static boolean isEmpty(ComboBox cb) {
        return (cb.getValue() == null || cb.getValue().toString().trim().isEmpty() || cb.getValue().toString().equals("--elke--"));
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
            TextField srcDiameter1Input, TextField srcDiameter2Input,
            RadioButton srcRndsJa, RadioButton srcRndsNee,
            TextField srcPrijs1GlasInput, TextField srcPrijs2GlasInput) {
        int orderByPos = OpticStore.VERKOOPLIST.toLowerCase().indexOf(" order by");
        StringBuilder sb = new StringBuilder();
        if (orderByPos > 0) {
            OpticStore.VERKOOPLIST.substring(0, orderByPos);
        } else {
            sb.append(OpticStore.VERKOOPLIST);
        }
        sb.append(" where ");

        boolean isThere = false;
        if (!srcDate1Input.getText().trim().isEmpty()) {
            sb.append("verkoopdatum >= to_date('" + srcDate1Input.getText() + "','"
                    + OpticStore.dateFormat.toPattern().trim().toUpperCase() + "') ");
            isThere = true;
        }
        if (!srcDate2Input.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("verkoopdatum <= to_date('" + srcDate2Input.getText() + "','"
                    + OpticStore.dateFormat.toPattern().trim().toUpperCase() + "') ");
            isThere = true;
        }
        if (!srcMerkCombo.getEditor().getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(montuur_merk) like '" + srcMerkCombo.getEditor().getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcModelCombo.getEditor().getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(montuur_model) like '" + srcModelCombo.getEditor().getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcKleurCombo.getEditor().getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(montuur_kleur) like '" + srcKleurCombo.getEditor().getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcMaatInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(montuur_maat) like '" + srcMaatInput.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcPrijs1MontuurInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_prijs >= " + srcPrijs1MontuurInput.getText());
            isThere = true;
        }
        if (!srcPrijs2MontuurInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_prijs <= " + srcPrijs2MontuurInput.getText());
            isThere = true;
        }
        if (!isEmpty(srcMontuurTypeCombo)) {
            sb.append(isThere ? " and " : "");
            sb.append("montuur_type = '" + srcMontuurTypeCombo.getValue().toString() + "'");
            isThere = true;
        }
        if (!isEmpty(srcMateriallCombo)) {
            sb.append(isThere ? " and " : "");
            sb.append("materiaal = '" + srcMateriallCombo.getValue().toString() + "'");
            isThere = true;
        }
        if (!isEmpty(srcDiversenCombo)) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(diverse) like '" + srcDiversenCombo.getEditor().getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcIdMontuurInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("UPPER(id_montuur) like '" + srcIdMontuurInput.getText().trim().toUpperCase() + "%'");
            isThere = true;
        }
        if (!srcLeverancierCombo.getEditor().getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            String leverancier = srcLeverancierCombo.getEditor().getText();
            sb.append("(UPPER(r_leverancier) like '" + leverancier.trim().toUpperCase() + "%' or UPPER(l_leverancier) like '" + leverancier.trim().toUpperCase() + "%')");
            isThere = true;
        }
        if (!isEmpty(srcTypeGlasCombo)) {
            sb.append(isThere ? " and " : "");
            String typeglas = srcTypeGlasCombo.getEditor().getText();
            sb.append("(UPPER(r_type_glas) like '" + typeglas.trim().toUpperCase() + "%' or UPPER(l_type_glas) like '" + typeglas.trim().toUpperCase() + "%')");
            isThere = true;
        }
        if (!isEmpty(srcCoatingCombo)) {
            sb.append(isThere ? " and " : "");
            String coating = srcCoatingCombo.getEditor().getText();
            sb.append("(UPPER(r_coating) like '" + coating.trim().toUpperCase() + "%' or UPPER(l_coating) like '" + coating.trim().toUpperCase() + "%')");
            isThere = true;
        }
        if (!isEmpty(srcKleurCombo)) {
            sb.append(isThere ? " and " : "");
            String kleurglass = srcKleurCombo.getEditor().getText();
            sb.append("(UPPER(r_kleur_glazen) like '" + kleurglass.trim().toUpperCase() + "%' or UPPER(l_kleur_glazen) like '" + kleurglass.trim().toUpperCase() + "%')");
            isThere = true;
        }
        if (!srcDiameter1Input.getText().trim().isEmpty() && !srcDiameter2Input.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("((r_diameter between " + srcDiameter1Input.getText().replace(",", ".")
                    + " and " + srcDiameter2Input.getText().replace(",", ".") + ")");
            sb.append(" or ");
            sb.append("(l_diameter between " + srcDiameter1Input.getText().replace(",", ".")
                    + " and " + srcDiameter2Input.getText().replace(",", ".") + "))");
            isThere = true;
        } else if (!srcDiameter1Input.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_diameter >= " + srcDiameter1Input.getText().replace(",", ".")
                    + " or l_diameter >= " + srcDiameter1Input.getText().replace(",", ".") + ")");
            isThere = true;
        } else if (!srcDiameter2Input.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_diameter <= " + srcDiameter2Input.getText().replace(",", ".")
                    + " or l_diameter <= " + srcDiameter2Input.getText().replace(",", ".") + ")");
            isThere = true;
        }
        if (srcRndsJa.isSelected()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_randscherp=1 or l_randscherp=1)");
            isThere = true;
        } else if (srcRndsNee.isSelected()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_randscherp=0 and l_randscherp=0)");
            isThere = true;
        }
        if (!srcPrijs1GlasInput.getText().trim().isEmpty() && !srcPrijs2GlasInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_prijs_glas between " + srcPrijs1GlasInput.getText() + " and " + srcPrijs2GlasInput.getText() + ")"
                    + " or (l_prijs_glas between " + srcPrijs1GlasInput.getText() + " and " + srcPrijs2GlasInput.getText() + ")");
            isThere = true;
        } else if (!srcPrijs1GlasInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_prijs_glas>=" + srcPrijs1GlasInput.getText() + " or l_prijs_glas>=" + srcPrijs1GlasInput.getText() + ")");
            isThere = true;
        } else if (!srcPrijs2GlasInput.getText().trim().isEmpty()) {
            sb.append(isThere ? " and " : "");
            sb.append("(r_prijs_glas<=" + srcPrijs2GlasInput.getText() + " or l_prijs_glas<=" + srcPrijs2GlasInput.getText() + ")");
            isThere = true;
        }
        if (isThere) {
            if (orderByPos > 0) {
                sb.append(OpticStore.KLANTLIST.substring(orderByPos));
            }
            System.out.println("!!:" + sb.toString());
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

    public static Verkoop
            getLastVerkoop(Integer klantId) throws RemoteException {
        DbObject[] recs = OpticStore.getExchanger().getDbObjects(
                Verkoop.class, "klant_id=" + klantId, "verkoopdatum desc");
        if (recs.length > 0) {
            return (Verkoop) recs[0];
        }
        return (Verkoop) null;
    }
}
