// Generated by com.xlend.orm.tools.dbgen.DbGenerator.class at Wed Jun 29 19:43:18 CEST 2016
// generated file: do not modify
package com.dk.orm;

import com.dk.orm.dbobject.DbObject;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.orm.dbobject.Triggers;
import java.sql.*;
import java.util.ArrayList;

public class Verkoop extends DbObject  {
    private static Triggers activeTriggers = null;
    private Integer verkoopId = null;
    private Integer klantId = null;
    private String rLeverancier = null;
    private String lReverancier = null;
    private String rTypeGlas = null;
    private String lTypeGlas = null;
    private String rCoating = null;
    private String lCoating = null;
    private String rKleurGlazen = null;
    private String lKleurGlazen = null;
    private Integer rDiameter = null;
    private Integer lDiameter = null;
    private Double rPrijsGlas = null;
    private Double lPrijsGlas = null;
    private Double rBtw = null;
    private Double lBtw = null;
    private String montuurMerk = null;
    private String montuurModel = null;
    private String montuurKleur = null;
    private String montuurMaat = null;
    private Double montuurPrijs = null;
    private Double montuurBtw = null;
    private String soortGlas = null;
    private String montuurType = null;
    private String materiaal = null;
    private Double korting = null;
    private Double totaal = null;
    private Double totalBtw = null;
    private Date verkoopdatum = null;
    private String diverse = null;
    private String idMontuur = null;

    public Verkoop(Connection connection) {
        super(connection, "verkoop", "verkoop_id");
        setColumnNames(new String[]{"verkoop_id", "klant_id", "r_leverancier", "l_reverancier", "r_type_glas", "l_type_glas", "r_coating", "l_coating", "r_kleur_glazen", "l_kleur_glazen", "r_diameter", "l_diameter", "r_prijs_glas", "l_prijs_glas", "r_btw", "l_btw", "montuur_merk", "montuur_model", "montuur_kleur", "montuur_maat", "montuur_prijs", "montuur_btw", "soort_glas", "montuur_type", "materiaal", "korting", "totaal", "total_btw", "verkoopdatum", "diverse", "id_montuur"});
    }

    public Verkoop(Connection connection, Integer verkoopId, Integer klantId, String rLeverancier, String lReverancier, String rTypeGlas, String lTypeGlas, String rCoating, String lCoating, String rKleurGlazen, String lKleurGlazen, Integer rDiameter, Integer lDiameter, Double rPrijsGlas, Double lPrijsGlas, Double rBtw, Double lBtw, String montuurMerk, String montuurModel, String montuurKleur, String montuurMaat, Double montuurPrijs, Double montuurBtw, String soortGlas, String montuurType, String materiaal, Double korting, Double totaal, Double totalBtw, Date verkoopdatum, String diverse, String idMontuur) {
        super(connection, "verkoop", "verkoop_id");
        setNew(verkoopId.intValue() <= 0);
//        if (verkoopId.intValue() != 0) {
            this.verkoopId = verkoopId;
//        }
        this.klantId = klantId;
        this.rLeverancier = rLeverancier;
        this.lReverancier = lReverancier;
        this.rTypeGlas = rTypeGlas;
        this.lTypeGlas = lTypeGlas;
        this.rCoating = rCoating;
        this.lCoating = lCoating;
        this.rKleurGlazen = rKleurGlazen;
        this.lKleurGlazen = lKleurGlazen;
        this.rDiameter = rDiameter;
        this.lDiameter = lDiameter;
        this.rPrijsGlas = rPrijsGlas;
        this.lPrijsGlas = lPrijsGlas;
        this.rBtw = rBtw;
        this.lBtw = lBtw;
        this.montuurMerk = montuurMerk;
        this.montuurModel = montuurModel;
        this.montuurKleur = montuurKleur;
        this.montuurMaat = montuurMaat;
        this.montuurPrijs = montuurPrijs;
        this.montuurBtw = montuurBtw;
        this.soortGlas = soortGlas;
        this.montuurType = montuurType;
        this.materiaal = materiaal;
        this.korting = korting;
        this.totaal = totaal;
        this.totalBtw = totalBtw;
        this.verkoopdatum = verkoopdatum;
        this.diverse = diverse;
        this.idMontuur = idMontuur;
    }

    public DbObject loadOnId(int id) throws SQLException, ForeignKeyViolationException {
        Verkoop verkoop = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stmt = "SELECT verkoop_id,klant_id,r_leverancier,l_reverancier,r_type_glas,l_type_glas,r_coating,l_coating,r_kleur_glazen,l_kleur_glazen,r_diameter,l_diameter,r_prijs_glas,l_prijs_glas,r_btw,l_btw,montuur_merk,montuur_model,montuur_kleur,montuur_maat,montuur_prijs,montuur_btw,soort_glas,montuur_type,materiaal,korting,totaal,total_btw,verkoopdatum,diverse,id_montuur FROM verkoop WHERE verkoop_id=" + id;
        try {
            ps = getConnection().prepareStatement(stmt);
            rs = ps.executeQuery();
            if (rs.next()) {
                verkoop = new Verkoop(getConnection());
                verkoop.setVerkoopId(new Integer(rs.getInt(1)));
                verkoop.setKlantId(new Integer(rs.getInt(2)));
                verkoop.setRLeverancier(rs.getString(3));
                verkoop.setLReverancier(rs.getString(4));
                verkoop.setRTypeGlas(rs.getString(5));
                verkoop.setLTypeGlas(rs.getString(6));
                verkoop.setRCoating(rs.getString(7));
                verkoop.setLCoating(rs.getString(8));
                verkoop.setRKleurGlazen(rs.getString(9));
                verkoop.setLKleurGlazen(rs.getString(10));
                verkoop.setRDiameter(new Integer(rs.getInt(11)));
                verkoop.setLDiameter(new Integer(rs.getInt(12)));
                verkoop.setRPrijsGlas(rs.getDouble(13));
                verkoop.setLPrijsGlas(rs.getDouble(14));
                verkoop.setRBtw(rs.getDouble(15));
                verkoop.setLBtw(rs.getDouble(16));
                verkoop.setMontuurMerk(rs.getString(17));
                verkoop.setMontuurModel(rs.getString(18));
                verkoop.setMontuurKleur(rs.getString(19));
                verkoop.setMontuurMaat(rs.getString(20));
                verkoop.setMontuurPrijs(rs.getDouble(21));
                verkoop.setMontuurBtw(rs.getDouble(22));
                verkoop.setSoortGlas(rs.getString(23));
                verkoop.setMontuurType(rs.getString(24));
                verkoop.setMateriaal(rs.getString(25));
                verkoop.setKorting(rs.getDouble(26));
                verkoop.setTotaal(rs.getDouble(27));
                verkoop.setTotalBtw(rs.getDouble(28));
                verkoop.setVerkoopdatum(rs.getDate(29));
                verkoop.setDiverse(rs.getString(30));
                verkoop.setIdMontuur(rs.getString(31));
                verkoop.setNew(false);
            }
        } finally {
            try {
                if (rs != null) rs.close();
            } finally {
                if (ps != null) ps.close();
            }
        }
        return verkoop;
    }

    protected void insert() throws SQLException, ForeignKeyViolationException {
         if (getTriggers() != null) {
             getTriggers().beforeInsert(this);
         }
         PreparedStatement ps = null;
         String stmt =
                "INSERT INTO verkoop ("+(getVerkoopId().intValue()!=0?"verkoop_id,":"")+"klant_id,r_leverancier,l_reverancier,r_type_glas,l_type_glas,r_coating,l_coating,r_kleur_glazen,l_kleur_glazen,r_diameter,l_diameter,r_prijs_glas,l_prijs_glas,r_btw,l_btw,montuur_merk,montuur_model,montuur_kleur,montuur_maat,montuur_prijs,montuur_btw,soort_glas,montuur_type,materiaal,korting,totaal,total_btw,verkoopdatum,diverse,id_montuur) values("+(getVerkoopId().intValue()!=0?"?,":"")+"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
             ps = getConnection().prepareStatement(stmt);
             int n = 0;
             if (getVerkoopId().intValue()!=0) {
                 ps.setObject(++n, getVerkoopId());
             }
             ps.setObject(++n, getKlantId());
             ps.setObject(++n, getRLeverancier());
             ps.setObject(++n, getLReverancier());
             ps.setObject(++n, getRTypeGlas());
             ps.setObject(++n, getLTypeGlas());
             ps.setObject(++n, getRCoating());
             ps.setObject(++n, getLCoating());
             ps.setObject(++n, getRKleurGlazen());
             ps.setObject(++n, getLKleurGlazen());
             ps.setObject(++n, getRDiameter());
             ps.setObject(++n, getLDiameter());
             ps.setObject(++n, getRPrijsGlas());
             ps.setObject(++n, getLPrijsGlas());
             ps.setObject(++n, getRBtw());
             ps.setObject(++n, getLBtw());
             ps.setObject(++n, getMontuurMerk());
             ps.setObject(++n, getMontuurModel());
             ps.setObject(++n, getMontuurKleur());
             ps.setObject(++n, getMontuurMaat());
             ps.setObject(++n, getMontuurPrijs());
             ps.setObject(++n, getMontuurBtw());
             ps.setObject(++n, getSoortGlas());
             ps.setObject(++n, getMontuurType());
             ps.setObject(++n, getMateriaal());
             ps.setObject(++n, getKorting());
             ps.setObject(++n, getTotaal());
             ps.setObject(++n, getTotalBtw());
             ps.setObject(++n, getVerkoopdatum());
             ps.setObject(++n, getDiverse());
             ps.setObject(++n, getIdMontuur());
             ps.execute();
         } finally {
             if (ps != null) ps.close();
         }
         ResultSet rs = null;
         if (getVerkoopId().intValue()==0) {
             stmt = "SELECT max(verkoop_id) FROM verkoop";
             try {
                 ps = getConnection().prepareStatement(stmt);
                 rs = ps.executeQuery();
                 if (rs.next()) {
                     setVerkoopId(new Integer(rs.getInt(1)));
                 }
             } finally {
                 try {
                     if (rs != null) rs.close();
                 } finally {
                     if (ps != null) ps.close();
                 }
             }
         }
         setNew(false);
         setWasChanged(false);
         if (getTriggers() != null) {
             getTriggers().afterInsert(this);
         }
    }

    public void save() throws SQLException, ForeignKeyViolationException {
        if (isNew()) {
            insert();
        } else {
            if (getTriggers() != null) {
                getTriggers().beforeUpdate(this);
            }
            PreparedStatement ps = null;
            String stmt =
                    "UPDATE verkoop " +
                    "SET klant_id = ?, r_leverancier = ?, l_reverancier = ?, r_type_glas = ?, l_type_glas = ?, r_coating = ?, l_coating = ?, r_kleur_glazen = ?, l_kleur_glazen = ?, r_diameter = ?, l_diameter = ?, r_prijs_glas = ?, l_prijs_glas = ?, r_btw = ?, l_btw = ?, montuur_merk = ?, montuur_model = ?, montuur_kleur = ?, montuur_maat = ?, montuur_prijs = ?, montuur_btw = ?, soort_glas = ?, montuur_type = ?, materiaal = ?, korting = ?, totaal = ?, total_btw = ?, verkoopdatum = ?, diverse = ?, id_montuur = ?" + 
                    " WHERE verkoop_id = " + getVerkoopId();
            try {
                ps = getConnection().prepareStatement(stmt);
                ps.setObject(1, getKlantId());
                ps.setObject(2, getRLeverancier());
                ps.setObject(3, getLReverancier());
                ps.setObject(4, getRTypeGlas());
                ps.setObject(5, getLTypeGlas());
                ps.setObject(6, getRCoating());
                ps.setObject(7, getLCoating());
                ps.setObject(8, getRKleurGlazen());
                ps.setObject(9, getLKleurGlazen());
                ps.setObject(10, getRDiameter());
                ps.setObject(11, getLDiameter());
                ps.setObject(12, getRPrijsGlas());
                ps.setObject(13, getLPrijsGlas());
                ps.setObject(14, getRBtw());
                ps.setObject(15, getLBtw());
                ps.setObject(16, getMontuurMerk());
                ps.setObject(17, getMontuurModel());
                ps.setObject(18, getMontuurKleur());
                ps.setObject(19, getMontuurMaat());
                ps.setObject(20, getMontuurPrijs());
                ps.setObject(21, getMontuurBtw());
                ps.setObject(22, getSoortGlas());
                ps.setObject(23, getMontuurType());
                ps.setObject(24, getMateriaal());
                ps.setObject(25, getKorting());
                ps.setObject(26, getTotaal());
                ps.setObject(27, getTotalBtw());
                ps.setObject(28, getVerkoopdatum());
                ps.setObject(29, getDiverse());
                ps.setObject(30, getIdMontuur());
                ps.execute();
            } finally {
                if (ps != null) ps.close();
            }
            setWasChanged(false);
            if (getTriggers() != null) {
                getTriggers().afterUpdate(this);
            }
        }
    }

    public void delete() throws SQLException, ForeignKeyViolationException {
        if (getTriggers() != null) {
            getTriggers().beforeDelete(this);
        }
        PreparedStatement ps = null;
        String stmt =
                "DELETE FROM verkoop " +
                "WHERE verkoop_id = " + getVerkoopId();
        try {
            ps = getConnection().prepareStatement(stmt);
            ps.execute();
        } finally {
            if (ps != null) ps.close();
        }
        setVerkoopId(new Integer(-getVerkoopId().intValue()));
        if (getTriggers() != null) {
            getTriggers().afterDelete(this);
        }
    }

    public boolean isDeleted() {
        return (getVerkoopId().intValue() < 0);
    }

    public static DbObject[] load(Connection con,String whereCondition,String orderCondition) throws SQLException {
        ArrayList lst = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stmt = "SELECT verkoop_id,klant_id,r_leverancier,l_reverancier,r_type_glas,l_type_glas,r_coating,l_coating,r_kleur_glazen,l_kleur_glazen,r_diameter,l_diameter,r_prijs_glas,l_prijs_glas,r_btw,l_btw,montuur_merk,montuur_model,montuur_kleur,montuur_maat,montuur_prijs,montuur_btw,soort_glas,montuur_type,materiaal,korting,totaal,total_btw,verkoopdatum,diverse,id_montuur FROM verkoop " +
                ((whereCondition != null && whereCondition.length() > 0) ?
                " WHERE " + whereCondition : "") +
                ((orderCondition != null && orderCondition.length() > 0) ?
                " ORDER BY " + orderCondition : "");
        try {
            ps = con.prepareStatement(stmt);
            rs = ps.executeQuery();
            while (rs.next()) {
                DbObject dbObj;
                lst.add(dbObj=new Verkoop(con,new Integer(rs.getInt(1)),new Integer(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),new Integer(rs.getInt(11)),new Integer(rs.getInt(12)),rs.getDouble(13),rs.getDouble(14),rs.getDouble(15),rs.getDouble(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getDouble(21),rs.getDouble(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getDouble(26),rs.getDouble(27),rs.getDouble(28),rs.getDate(29),rs.getString(30),rs.getString(31)));
                dbObj.setNew(false);
            }
        } finally {
            try {
                if (rs != null) rs.close();
            } finally {
                if (ps != null) ps.close();
            }
        }
        Verkoop[] objects = new Verkoop[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            Verkoop verkoop = (Verkoop) lst.get(i);
            objects[i] = verkoop;
        }
        return objects;
    }

    public static boolean exists(Connection con, String whereCondition) throws SQLException {
        if (con == null) {
            return true;
        }
        boolean ok = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stmt = "SELECT verkoop_id FROM verkoop " +
                ((whereCondition != null && whereCondition.length() > 0) ?
                "WHERE " + whereCondition : "");
        try {
            ps = con.prepareStatement(stmt);
            rs = ps.executeQuery();
            ok = rs.next();
        } finally {
            try {
                if (rs != null) rs.close();
            } finally {
                if (ps != null) ps.close();
            }
        }
        return ok;
    }

    //public String toString() {
    //    return getVerkoopId() + getDelimiter();
    //}

    public Integer getPK_ID() {
        return verkoopId;
    }

    public void setPK_ID(Integer id) throws ForeignKeyViolationException {
        boolean prevIsNew = isNew();
        setVerkoopId(id);
        setNew(prevIsNew);
    }

    public Integer getVerkoopId() {
        return verkoopId;
    }

    public void setVerkoopId(Integer verkoopId) throws ForeignKeyViolationException {
        setWasChanged(this.verkoopId != null && this.verkoopId != verkoopId);
        this.verkoopId = verkoopId;
        setNew(verkoopId.intValue() == 0);
    }

    public Integer getKlantId() {
        return klantId;
    }

    public void setKlantId(Integer klantId) throws SQLException, ForeignKeyViolationException {
        if (klantId!=null && !Klant.exists(getConnection(),"klant_id = " + klantId)) {
            throw new ForeignKeyViolationException("Can't set klant_id, foreign key violation: verkoop_klant_fk");
        }
        setWasChanged(this.klantId != null && !this.klantId.equals(klantId));
        this.klantId = klantId;
    }

    public String getRLeverancier() {
        return rLeverancier;
    }

    public void setRLeverancier(String rLeverancier) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rLeverancier != null && !this.rLeverancier.equals(rLeverancier));
        this.rLeverancier = rLeverancier;
    }

    public String getLReverancier() {
        return lReverancier;
    }

    public void setLReverancier(String lReverancier) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lReverancier != null && !this.lReverancier.equals(lReverancier));
        this.lReverancier = lReverancier;
    }

    public String getRTypeGlas() {
        return rTypeGlas;
    }

    public void setRTypeGlas(String rTypeGlas) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rTypeGlas != null && !this.rTypeGlas.equals(rTypeGlas));
        this.rTypeGlas = rTypeGlas;
    }

    public String getLTypeGlas() {
        return lTypeGlas;
    }

    public void setLTypeGlas(String lTypeGlas) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lTypeGlas != null && !this.lTypeGlas.equals(lTypeGlas));
        this.lTypeGlas = lTypeGlas;
    }

    public String getRCoating() {
        return rCoating;
    }

    public void setRCoating(String rCoating) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rCoating != null && !this.rCoating.equals(rCoating));
        this.rCoating = rCoating;
    }

    public String getLCoating() {
        return lCoating;
    }

    public void setLCoating(String lCoating) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lCoating != null && !this.lCoating.equals(lCoating));
        this.lCoating = lCoating;
    }

    public String getRKleurGlazen() {
        return rKleurGlazen;
    }

    public void setRKleurGlazen(String rKleurGlazen) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rKleurGlazen != null && !this.rKleurGlazen.equals(rKleurGlazen));
        this.rKleurGlazen = rKleurGlazen;
    }

    public String getLKleurGlazen() {
        return lKleurGlazen;
    }

    public void setLKleurGlazen(String lKleurGlazen) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lKleurGlazen != null && !this.lKleurGlazen.equals(lKleurGlazen));
        this.lKleurGlazen = lKleurGlazen;
    }

    public Integer getRDiameter() {
        return rDiameter;
    }

    public void setRDiameter(Integer rDiameter) throws SQLException, ForeignKeyViolationException {
        if (null != rDiameter)
            rDiameter = rDiameter == 0 ? null : rDiameter;
        setWasChanged(this.rDiameter != null && !this.rDiameter.equals(rDiameter));
        this.rDiameter = rDiameter;
    }

    public Integer getLDiameter() {
        return lDiameter;
    }

    public void setLDiameter(Integer lDiameter) throws SQLException, ForeignKeyViolationException {
        if (null != lDiameter)
            lDiameter = lDiameter == 0 ? null : lDiameter;
        setWasChanged(this.lDiameter != null && !this.lDiameter.equals(lDiameter));
        this.lDiameter = lDiameter;
    }

    public Double getRPrijsGlas() {
        return rPrijsGlas;
    }

    public void setRPrijsGlas(Double rPrijsGlas) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rPrijsGlas != null && !this.rPrijsGlas.equals(rPrijsGlas));
        this.rPrijsGlas = rPrijsGlas;
    }

    public Double getLPrijsGlas() {
        return lPrijsGlas;
    }

    public void setLPrijsGlas(Double lPrijsGlas) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lPrijsGlas != null && !this.lPrijsGlas.equals(lPrijsGlas));
        this.lPrijsGlas = lPrijsGlas;
    }

    public Double getRBtw() {
        return rBtw;
    }

    public void setRBtw(Double rBtw) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.rBtw != null && !this.rBtw.equals(rBtw));
        this.rBtw = rBtw;
    }

    public Double getLBtw() {
        return lBtw;
    }

    public void setLBtw(Double lBtw) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.lBtw != null && !this.lBtw.equals(lBtw));
        this.lBtw = lBtw;
    }

    public String getMontuurMerk() {
        return montuurMerk;
    }

    public void setMontuurMerk(String montuurMerk) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurMerk != null && !this.montuurMerk.equals(montuurMerk));
        this.montuurMerk = montuurMerk;
    }

    public String getMontuurModel() {
        return montuurModel;
    }

    public void setMontuurModel(String montuurModel) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurModel != null && !this.montuurModel.equals(montuurModel));
        this.montuurModel = montuurModel;
    }

    public String getMontuurKleur() {
        return montuurKleur;
    }

    public void setMontuurKleur(String montuurKleur) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurKleur != null && !this.montuurKleur.equals(montuurKleur));
        this.montuurKleur = montuurKleur;
    }

    public String getMontuurMaat() {
        return montuurMaat;
    }

    public void setMontuurMaat(String montuurMaat) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurMaat != null && !this.montuurMaat.equals(montuurMaat));
        this.montuurMaat = montuurMaat;
    }

    public Double getMontuurPrijs() {
        return montuurPrijs;
    }

    public void setMontuurPrijs(Double montuurPrijs) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurPrijs != null && !this.montuurPrijs.equals(montuurPrijs));
        this.montuurPrijs = montuurPrijs;
    }

    public Double getMontuurBtw() {
        return montuurBtw;
    }

    public void setMontuurBtw(Double montuurBtw) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurBtw != null && !this.montuurBtw.equals(montuurBtw));
        this.montuurBtw = montuurBtw;
    }

    public String getSoortGlas() {
        return soortGlas;
    }

    public void setSoortGlas(String soortGlas) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.soortGlas != null && !this.soortGlas.equals(soortGlas));
        this.soortGlas = soortGlas;
    }

    public String getMontuurType() {
        return montuurType;
    }

    public void setMontuurType(String montuurType) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.montuurType != null && !this.montuurType.equals(montuurType));
        this.montuurType = montuurType;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.materiaal != null && !this.materiaal.equals(materiaal));
        this.materiaal = materiaal;
    }

    public Double getKorting() {
        return korting;
    }

    public void setKorting(Double korting) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.korting != null && !this.korting.equals(korting));
        this.korting = korting;
    }

    public Double getTotaal() {
        return totaal;
    }

    public void setTotaal(Double totaal) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.totaal != null && !this.totaal.equals(totaal));
        this.totaal = totaal;
    }

    public Double getTotalBtw() {
        return totalBtw;
    }

    public void setTotalBtw(Double totalBtw) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.totalBtw != null && !this.totalBtw.equals(totalBtw));
        this.totalBtw = totalBtw;
    }

    public Date getVerkoopdatum() {
        return verkoopdatum;
    }

    public void setVerkoopdatum(Date verkoopdatum) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.verkoopdatum != null && !this.verkoopdatum.equals(verkoopdatum));
        this.verkoopdatum = verkoopdatum;
    }

    public String getDiverse() {
        return diverse;
    }

    public void setDiverse(String diverse) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.diverse != null && !this.diverse.equals(diverse));
        this.diverse = diverse;
    }

    public String getIdMontuur() {
        return idMontuur;
    }

    public void setIdMontuur(String idMontuur) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.idMontuur != null && !this.idMontuur.equals(idMontuur));
        this.idMontuur = idMontuur;
    }
    public Object[] getAsRow() {
        Object[] columnValues = new Object[31];
        columnValues[0] = getVerkoopId();
        columnValues[1] = getKlantId();
        columnValues[2] = getRLeverancier();
        columnValues[3] = getLReverancier();
        columnValues[4] = getRTypeGlas();
        columnValues[5] = getLTypeGlas();
        columnValues[6] = getRCoating();
        columnValues[7] = getLCoating();
        columnValues[8] = getRKleurGlazen();
        columnValues[9] = getLKleurGlazen();
        columnValues[10] = getRDiameter();
        columnValues[11] = getLDiameter();
        columnValues[12] = getRPrijsGlas();
        columnValues[13] = getLPrijsGlas();
        columnValues[14] = getRBtw();
        columnValues[15] = getLBtw();
        columnValues[16] = getMontuurMerk();
        columnValues[17] = getMontuurModel();
        columnValues[18] = getMontuurKleur();
        columnValues[19] = getMontuurMaat();
        columnValues[20] = getMontuurPrijs();
        columnValues[21] = getMontuurBtw();
        columnValues[22] = getSoortGlas();
        columnValues[23] = getMontuurType();
        columnValues[24] = getMateriaal();
        columnValues[25] = getKorting();
        columnValues[26] = getTotaal();
        columnValues[27] = getTotalBtw();
        columnValues[28] = getVerkoopdatum();
        columnValues[29] = getDiverse();
        columnValues[30] = getIdMontuur();
        return columnValues;
    }

    public static void setTriggers(Triggers triggers) {
        activeTriggers = triggers;
    }

    public static Triggers getTriggers() {
        return activeTriggers;
    }

    //for SOAP exhange
    @Override
    public void fillFromString(String row) throws ForeignKeyViolationException, SQLException {
        String[] flds = splitStr(row, delimiter);
        try {
            setVerkoopId(Integer.parseInt(flds[0]));
        } catch(NumberFormatException ne) {
            setVerkoopId(null);
        }
        try {
            setKlantId(Integer.parseInt(flds[1]));
        } catch(NumberFormatException ne) {
            setKlantId(null);
        }
        setRLeverancier(flds[2]);
        setLReverancier(flds[3]);
        setRTypeGlas(flds[4]);
        setLTypeGlas(flds[5]);
        setRCoating(flds[6]);
        setLCoating(flds[7]);
        setRKleurGlazen(flds[8]);
        setLKleurGlazen(flds[9]);
        try {
            setRDiameter(Integer.parseInt(flds[10]));
        } catch(NumberFormatException ne) {
            setRDiameter(null);
        }
        try {
            setLDiameter(Integer.parseInt(flds[11]));
        } catch(NumberFormatException ne) {
            setLDiameter(null);
        }
        try {
            setRPrijsGlas(Double.parseDouble(flds[12]));
        } catch(NumberFormatException ne) {
            setRPrijsGlas(null);
        }
        try {
            setLPrijsGlas(Double.parseDouble(flds[13]));
        } catch(NumberFormatException ne) {
            setLPrijsGlas(null);
        }
        try {
            setRBtw(Double.parseDouble(flds[14]));
        } catch(NumberFormatException ne) {
            setRBtw(null);
        }
        try {
            setLBtw(Double.parseDouble(flds[15]));
        } catch(NumberFormatException ne) {
            setLBtw(null);
        }
        setMontuurMerk(flds[16]);
        setMontuurModel(flds[17]);
        setMontuurKleur(flds[18]);
        setMontuurMaat(flds[19]);
        try {
            setMontuurPrijs(Double.parseDouble(flds[20]));
        } catch(NumberFormatException ne) {
            setMontuurPrijs(null);
        }
        try {
            setMontuurBtw(Double.parseDouble(flds[21]));
        } catch(NumberFormatException ne) {
            setMontuurBtw(null);
        }
        setSoortGlas(flds[22]);
        setMontuurType(flds[23]);
        setMateriaal(flds[24]);
        try {
            setKorting(Double.parseDouble(flds[25]));
        } catch(NumberFormatException ne) {
            setKorting(null);
        }
        try {
            setTotaal(Double.parseDouble(flds[26]));
        } catch(NumberFormatException ne) {
            setTotaal(null);
        }
        try {
            setTotalBtw(Double.parseDouble(flds[27]));
        } catch(NumberFormatException ne) {
            setTotalBtw(null);
        }
        setVerkoopdatum(toDate(flds[28]));
        setDiverse(flds[29]);
        setIdMontuur(flds[30]);
    }
}
