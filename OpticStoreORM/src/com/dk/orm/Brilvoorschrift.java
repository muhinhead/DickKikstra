// Generated by com.xlend.orm.tools.dbgen.DbGenerator.class at Sat Jun 18 16:10:48 CEST 2016
// generated file: do not modify
package com.dk.orm;

import com.dk.orm.dbobject.DbObject;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.orm.dbobject.Triggers;
import java.sql.*;
import java.util.ArrayList;

public class Brilvoorschrift extends DbObject  {
    private static Triggers activeTriggers = null;
    private Integer brilvoorschriftId = null;
    private Integer klantId = null;
    private Double odSph = null;
    private Double odCyl = null;
    private Integer odAs = null;
    private Double odAdd = null;
    private Double odNabil = null;
    private Integer odPr = null;
    private Integer odBasis = null;
    private Double odVis = null;
    private String odPddn = null;
    private Integer odLh = null;
    private Integer odHa = null;
    private Integer odIod = null;
    private Double osSph = null;
    private Double osCyl = null;
    private Integer osAs = null;
    private Double osAdd = null;
    private Double osNabil = null;
    private Integer osPr = null;
    private Integer osBasis = null;
    private Double osVis = null;
    private String osPddn = null;
    private Integer osLh = null;
    private Integer osHa = null;
    private Integer osIod = null;
    private String oogmetingDoor = null;
    private Date datumRefractie = null;
    private String anamnese = null;

    public Brilvoorschrift(Connection connection) {
        super(connection, "brilvoorschrift", "brilvoorschrift_id");
        setColumnNames(new String[]{"brilvoorschrift_id", "klant_id", "od_sph", "od_cyl", "od_as", "od_add", "od_nabil", "od_pr", "od_basis", "od_vis", "od_pddn", "od_lh", "od_ha", "od_iod", "os_sph", "os_cyl", "os_as", "os_add", "os_nabil", "os_pr", "os_basis", "os_vis", "os_pddn", "os_lh", "os_ha", "os_iod", "oogmeting_door", "datum_refractie", "anamnese"});
    }

    public Brilvoorschrift(Connection connection, Integer brilvoorschriftId, Integer klantId, Double odSph, Double odCyl, Integer odAs, Double odAdd, Double odNabil, Integer odPr, Integer odBasis, Double odVis, String odPddn, Integer odLh, Integer odHa, Integer odIod, Double osSph, Double osCyl, Integer osAs, Double osAdd, Double osNabil, Integer osPr, Integer osBasis, Double osVis, String osPddn, Integer osLh, Integer osHa, Integer osIod, String oogmetingDoor, Date datumRefractie, String anamnese) {
        super(connection, "brilvoorschrift", "brilvoorschrift_id");
        setNew(brilvoorschriftId.intValue() <= 0);
//        if (brilvoorschriftId.intValue() != 0) {
            this.brilvoorschriftId = brilvoorschriftId;
//        }
        this.klantId = klantId;
        this.odSph = odSph;
        this.odCyl = odCyl;
        this.odAs = odAs;
        this.odAdd = odAdd;
        this.odNabil = odNabil;
        this.odPr = odPr;
        this.odBasis = odBasis;
        this.odVis = odVis;
        this.odPddn = odPddn;
        this.odLh = odLh;
        this.odHa = odHa;
        this.odIod = odIod;
        this.osSph = osSph;
        this.osCyl = osCyl;
        this.osAs = osAs;
        this.osAdd = osAdd;
        this.osNabil = osNabil;
        this.osPr = osPr;
        this.osBasis = osBasis;
        this.osVis = osVis;
        this.osPddn = osPddn;
        this.osLh = osLh;
        this.osHa = osHa;
        this.osIod = osIod;
        this.oogmetingDoor = oogmetingDoor;
        this.datumRefractie = datumRefractie;
        this.anamnese = anamnese;
    }

    public DbObject loadOnId(int id) throws SQLException, ForeignKeyViolationException {
        Brilvoorschrift brilvoorschrift = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stmt = "SELECT brilvoorschrift_id,klant_id,od_sph,od_cyl,od_as,od_add,od_nabil,od_pr,od_basis,od_vis,od_pddn,od_lh,od_ha,od_iod,os_sph,os_cyl,os_as,os_add,os_nabil,os_pr,os_basis,os_vis,os_pddn,os_lh,os_ha,os_iod,oogmeting_door,datum_refractie,anamnese FROM brilvoorschrift WHERE brilvoorschrift_id=" + id;
        try {
            ps = getConnection().prepareStatement(stmt);
            rs = ps.executeQuery();
            if (rs.next()) {
                brilvoorschrift = new Brilvoorschrift(getConnection());
                brilvoorschrift.setBrilvoorschriftId(new Integer(rs.getInt(1)));
                brilvoorschrift.setKlantId(new Integer(rs.getInt(2)));
                brilvoorschrift.setOdSph(rs.getDouble(3));
                brilvoorschrift.setOdCyl(rs.getDouble(4));
                brilvoorschrift.setOdAs(new Integer(rs.getInt(5)));
                brilvoorschrift.setOdAdd(rs.getDouble(6));
                brilvoorschrift.setOdNabil(rs.getDouble(7));
                brilvoorschrift.setOdPr(new Integer(rs.getInt(8)));
                brilvoorschrift.setOdBasis(new Integer(rs.getInt(9)));
                brilvoorschrift.setOdVis(rs.getDouble(10));
                brilvoorschrift.setOdPddn(rs.getString(11));
                brilvoorschrift.setOdLh(new Integer(rs.getInt(12)));
                brilvoorschrift.setOdHa(new Integer(rs.getInt(13)));
                brilvoorschrift.setOdIod(new Integer(rs.getInt(14)));
                brilvoorschrift.setOsSph(rs.getDouble(15));
                brilvoorschrift.setOsCyl(rs.getDouble(16));
                brilvoorschrift.setOsAs(new Integer(rs.getInt(17)));
                brilvoorschrift.setOsAdd(rs.getDouble(18));
                brilvoorschrift.setOsNabil(rs.getDouble(19));
                brilvoorschrift.setOsPr(new Integer(rs.getInt(20)));
                brilvoorschrift.setOsBasis(new Integer(rs.getInt(21)));
                brilvoorschrift.setOsVis(rs.getDouble(22));
                brilvoorschrift.setOsPddn(rs.getString(23));
                brilvoorschrift.setOsLh(new Integer(rs.getInt(24)));
                brilvoorschrift.setOsHa(new Integer(rs.getInt(25)));
                brilvoorschrift.setOsIod(new Integer(rs.getInt(26)));
                brilvoorschrift.setOogmetingDoor(rs.getString(27));
                brilvoorschrift.setDatumRefractie(rs.getDate(28));
                brilvoorschrift.setAnamnese(rs.getString(29));
                brilvoorschrift.setNew(false);
            }
        } finally {
            try {
                if (rs != null) rs.close();
            } finally {
                if (ps != null) ps.close();
            }
        }
        return brilvoorschrift;
    }

    protected void insert() throws SQLException, ForeignKeyViolationException {
         if (getTriggers() != null) {
             getTriggers().beforeInsert(this);
         }
         PreparedStatement ps = null;
         String stmt =
                "INSERT INTO brilvoorschrift ("+(getBrilvoorschriftId().intValue()!=0?"brilvoorschrift_id,":"")+"klant_id,od_sph,od_cyl,od_as,od_add,od_nabil,od_pr,od_basis,od_vis,od_pddn,od_lh,od_ha,od_iod,os_sph,os_cyl,os_as,os_add,os_nabil,os_pr,os_basis,os_vis,os_pddn,os_lh,os_ha,os_iod,oogmeting_door,datum_refractie,anamnese) values("+(getBrilvoorschriftId().intValue()!=0?"?,":"")+"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
             ps = getConnection().prepareStatement(stmt);
             int n = 0;
             if (getBrilvoorschriftId().intValue()!=0) {
                 ps.setObject(++n, getBrilvoorschriftId());
             }
             ps.setObject(++n, getKlantId());
             ps.setObject(++n, getOdSph());
             ps.setObject(++n, getOdCyl());
             ps.setObject(++n, getOdAs());
             ps.setObject(++n, getOdAdd());
             ps.setObject(++n, getOdNabil());
             ps.setObject(++n, getOdPr());
             ps.setObject(++n, getOdBasis());
             ps.setObject(++n, getOdVis());
             ps.setObject(++n, getOdPddn());
             ps.setObject(++n, getOdLh());
             ps.setObject(++n, getOdHa());
             ps.setObject(++n, getOdIod());
             ps.setObject(++n, getOsSph());
             ps.setObject(++n, getOsCyl());
             ps.setObject(++n, getOsAs());
             ps.setObject(++n, getOsAdd());
             ps.setObject(++n, getOsNabil());
             ps.setObject(++n, getOsPr());
             ps.setObject(++n, getOsBasis());
             ps.setObject(++n, getOsVis());
             ps.setObject(++n, getOsPddn());
             ps.setObject(++n, getOsLh());
             ps.setObject(++n, getOsHa());
             ps.setObject(++n, getOsIod());
             ps.setObject(++n, getOogmetingDoor());
             ps.setObject(++n, getDatumRefractie());
             ps.setObject(++n, getAnamnese());
             ps.execute();
         } finally {
             if (ps != null) ps.close();
         }
         ResultSet rs = null;
         if (getBrilvoorschriftId().intValue()==0) {
             stmt = "SELECT max(brilvoorschrift_id) FROM brilvoorschrift";
             try {
                 ps = getConnection().prepareStatement(stmt);
                 rs = ps.executeQuery();
                 if (rs.next()) {
                     setBrilvoorschriftId(new Integer(rs.getInt(1)));
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
                    "UPDATE brilvoorschrift " +
                    "SET klant_id = ?, od_sph = ?, od_cyl = ?, od_as = ?, od_add = ?, od_nabil = ?, od_pr = ?, od_basis = ?, od_vis = ?, od_pddn = ?, od_lh = ?, od_ha = ?, od_iod = ?, os_sph = ?, os_cyl = ?, os_as = ?, os_add = ?, os_nabil = ?, os_pr = ?, os_basis = ?, os_vis = ?, os_pddn = ?, os_lh = ?, os_ha = ?, os_iod = ?, oogmeting_door = ?, datum_refractie = ?, anamnese = ?" + 
                    " WHERE brilvoorschrift_id = " + getBrilvoorschriftId();
            try {
                ps = getConnection().prepareStatement(stmt);
                ps.setObject(1, getKlantId());
                ps.setObject(2, getOdSph());
                ps.setObject(3, getOdCyl());
                ps.setObject(4, getOdAs());
                ps.setObject(5, getOdAdd());
                ps.setObject(6, getOdNabil());
                ps.setObject(7, getOdPr());
                ps.setObject(8, getOdBasis());
                ps.setObject(9, getOdVis());
                ps.setObject(10, getOdPddn());
                ps.setObject(11, getOdLh());
                ps.setObject(12, getOdHa());
                ps.setObject(13, getOdIod());
                ps.setObject(14, getOsSph());
                ps.setObject(15, getOsCyl());
                ps.setObject(16, getOsAs());
                ps.setObject(17, getOsAdd());
                ps.setObject(18, getOsNabil());
                ps.setObject(19, getOsPr());
                ps.setObject(20, getOsBasis());
                ps.setObject(21, getOsVis());
                ps.setObject(22, getOsPddn());
                ps.setObject(23, getOsLh());
                ps.setObject(24, getOsHa());
                ps.setObject(25, getOsIod());
                ps.setObject(26, getOogmetingDoor());
                ps.setObject(27, getDatumRefractie());
                ps.setObject(28, getAnamnese());
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
                "DELETE FROM brilvoorschrift " +
                "WHERE brilvoorschrift_id = " + getBrilvoorschriftId();
        try {
            ps = getConnection().prepareStatement(stmt);
            ps.execute();
        } finally {
            if (ps != null) ps.close();
        }
        setBrilvoorschriftId(new Integer(-getBrilvoorschriftId().intValue()));
        if (getTriggers() != null) {
            getTriggers().afterDelete(this);
        }
    }

    public boolean isDeleted() {
        return (getBrilvoorschriftId().intValue() < 0);
    }

    public static DbObject[] load(Connection con,String whereCondition,String orderCondition) throws SQLException {
        ArrayList lst = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stmt = "SELECT brilvoorschrift_id,klant_id,od_sph,od_cyl,od_as,od_add,od_nabil,od_pr,od_basis,od_vis,od_pddn,od_lh,od_ha,od_iod,os_sph,os_cyl,os_as,os_add,os_nabil,os_pr,os_basis,os_vis,os_pddn,os_lh,os_ha,os_iod,oogmeting_door,datum_refractie,anamnese FROM brilvoorschrift " +
                ((whereCondition != null && whereCondition.length() > 0) ?
                " WHERE " + whereCondition : "") +
                ((orderCondition != null && orderCondition.length() > 0) ?
                " ORDER BY " + orderCondition : "");
        try {
            ps = con.prepareStatement(stmt);
            rs = ps.executeQuery();
            while (rs.next()) {
                DbObject dbObj;
                lst.add(dbObj=new Brilvoorschrift(con,new Integer(rs.getInt(1)),new Integer(rs.getInt(2)),rs.getDouble(3),rs.getDouble(4),new Integer(rs.getInt(5)),rs.getDouble(6),rs.getDouble(7),new Integer(rs.getInt(8)),new Integer(rs.getInt(9)),rs.getDouble(10),rs.getString(11),new Integer(rs.getInt(12)),new Integer(rs.getInt(13)),new Integer(rs.getInt(14)),rs.getDouble(15),rs.getDouble(16),new Integer(rs.getInt(17)),rs.getDouble(18),rs.getDouble(19),new Integer(rs.getInt(20)),new Integer(rs.getInt(21)),rs.getDouble(22),rs.getString(23),new Integer(rs.getInt(24)),new Integer(rs.getInt(25)),new Integer(rs.getInt(26)),rs.getString(27),rs.getDate(28),rs.getString(29)));
                dbObj.setNew(false);
            }
        } finally {
            try {
                if (rs != null) rs.close();
            } finally {
                if (ps != null) ps.close();
            }
        }
        Brilvoorschrift[] objects = new Brilvoorschrift[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            Brilvoorschrift brilvoorschrift = (Brilvoorschrift) lst.get(i);
            objects[i] = brilvoorschrift;
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
        String stmt = "SELECT brilvoorschrift_id FROM brilvoorschrift " +
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
    //    return getBrilvoorschriftId() + getDelimiter();
    //}

    public Integer getPK_ID() {
        return brilvoorschriftId;
    }

    public void setPK_ID(Integer id) throws ForeignKeyViolationException {
        boolean prevIsNew = isNew();
        setBrilvoorschriftId(id);
        setNew(prevIsNew);
    }

    public Integer getBrilvoorschriftId() {
        return brilvoorschriftId;
    }

    public void setBrilvoorschriftId(Integer brilvoorschriftId) throws ForeignKeyViolationException {
        setWasChanged(this.brilvoorschriftId != null && this.brilvoorschriftId != brilvoorschriftId);
        this.brilvoorschriftId = brilvoorschriftId;
        setNew(brilvoorschriftId.intValue() == 0);
    }

    public Integer getKlantId() {
        return klantId;
    }

    public void setKlantId(Integer klantId) throws SQLException, ForeignKeyViolationException {
        if (klantId!=null && !Klant.exists(getConnection(),"klant_id = " + klantId)) {
            throw new ForeignKeyViolationException("Can't set klant_id, foreign key violation: brilvoorschrift_klant_fk");
        }
        setWasChanged(this.klantId != null && !this.klantId.equals(klantId));
        this.klantId = klantId;
    }

    public Double getOdSph() {
        return odSph;
    }

    public void setOdSph(Double odSph) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odSph != null && !this.odSph.equals(odSph));
        this.odSph = odSph;
    }

    public Double getOdCyl() {
        return odCyl;
    }

    public void setOdCyl(Double odCyl) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odCyl != null && !this.odCyl.equals(odCyl));
        this.odCyl = odCyl;
    }

    public Integer getOdAs() {
        return odAs;
    }

    public void setOdAs(Integer odAs) throws SQLException, ForeignKeyViolationException {
        if (null != odAs)
            odAs = odAs == 0 ? null : odAs;
        setWasChanged(this.odAs != null && !this.odAs.equals(odAs));
        this.odAs = odAs;
    }

    public Double getOdAdd() {
        return odAdd;
    }

    public void setOdAdd(Double odAdd) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odAdd != null && !this.odAdd.equals(odAdd));
        this.odAdd = odAdd;
    }

    public Double getOdNabil() {
        return odNabil;
    }

    public void setOdNabil(Double odNabil) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odNabil != null && !this.odNabil.equals(odNabil));
        this.odNabil = odNabil;
    }

    public Integer getOdPr() {
        return odPr;
    }

    public void setOdPr(Integer odPr) throws SQLException, ForeignKeyViolationException {
        if (null != odPr)
            odPr = odPr == 0 ? null : odPr;
        setWasChanged(this.odPr != null && !this.odPr.equals(odPr));
        this.odPr = odPr;
    }

    public Integer getOdBasis() {
        return odBasis;
    }

    public void setOdBasis(Integer odBasis) throws SQLException, ForeignKeyViolationException {
        if (null != odBasis)
            odBasis = odBasis == 0 ? null : odBasis;
        setWasChanged(this.odBasis != null && !this.odBasis.equals(odBasis));
        this.odBasis = odBasis;
    }

    public Double getOdVis() {
        return odVis;
    }

    public void setOdVis(Double odVis) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odVis != null && !this.odVis.equals(odVis));
        this.odVis = odVis;
    }

    public String getOdPddn() {
        return odPddn;
    }

    public void setOdPddn(String odPddn) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.odPddn != null && !this.odPddn.equals(odPddn));
        this.odPddn = odPddn;
    }

    public Integer getOdLh() {
        return odLh;
    }

    public void setOdLh(Integer odLh) throws SQLException, ForeignKeyViolationException {
        if (null != odLh)
            odLh = odLh == 0 ? null : odLh;
        setWasChanged(this.odLh != null && !this.odLh.equals(odLh));
        this.odLh = odLh;
    }

    public Integer getOdHa() {
        return odHa;
    }

    public void setOdHa(Integer odHa) throws SQLException, ForeignKeyViolationException {
        if (null != odHa)
            odHa = odHa == 0 ? null : odHa;
        setWasChanged(this.odHa != null && !this.odHa.equals(odHa));
        this.odHa = odHa;
    }

    public Integer getOdIod() {
        return odIod;
    }

    public void setOdIod(Integer odIod) throws SQLException, ForeignKeyViolationException {
        if (null != odIod)
            odIod = odIod == 0 ? null : odIod;
        setWasChanged(this.odIod != null && !this.odIod.equals(odIod));
        this.odIod = odIod;
    }

    public Double getOsSph() {
        return osSph;
    }

    public void setOsSph(Double osSph) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osSph != null && !this.osSph.equals(osSph));
        this.osSph = osSph;
    }

    public Double getOsCyl() {
        return osCyl;
    }

    public void setOsCyl(Double osCyl) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osCyl != null && !this.osCyl.equals(osCyl));
        this.osCyl = osCyl;
    }

    public Integer getOsAs() {
        return osAs;
    }

    public void setOsAs(Integer osAs) throws SQLException, ForeignKeyViolationException {
        if (null != osAs)
            osAs = osAs == 0 ? null : osAs;
        setWasChanged(this.osAs != null && !this.osAs.equals(osAs));
        this.osAs = osAs;
    }

    public Double getOsAdd() {
        return osAdd;
    }

    public void setOsAdd(Double osAdd) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osAdd != null && !this.osAdd.equals(osAdd));
        this.osAdd = osAdd;
    }

    public Double getOsNabil() {
        return osNabil;
    }

    public void setOsNabil(Double osNabil) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osNabil != null && !this.osNabil.equals(osNabil));
        this.osNabil = osNabil;
    }

    public Integer getOsPr() {
        return osPr;
    }

    public void setOsPr(Integer osPr) throws SQLException, ForeignKeyViolationException {
        if (null != osPr)
            osPr = osPr == 0 ? null : osPr;
        setWasChanged(this.osPr != null && !this.osPr.equals(osPr));
        this.osPr = osPr;
    }

    public Integer getOsBasis() {
        return osBasis;
    }

    public void setOsBasis(Integer osBasis) throws SQLException, ForeignKeyViolationException {
        if (null != osBasis)
            osBasis = osBasis == 0 ? null : osBasis;
        setWasChanged(this.osBasis != null && !this.osBasis.equals(osBasis));
        this.osBasis = osBasis;
    }

    public Double getOsVis() {
        return osVis;
    }

    public void setOsVis(Double osVis) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osVis != null && !this.osVis.equals(osVis));
        this.osVis = osVis;
    }

    public String getOsPddn() {
        return osPddn;
    }

    public void setOsPddn(String osPddn) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.osPddn != null && !this.osPddn.equals(osPddn));
        this.osPddn = osPddn;
    }

    public Integer getOsLh() {
        return osLh;
    }

    public void setOsLh(Integer osLh) throws SQLException, ForeignKeyViolationException {
        if (null != osLh)
            osLh = osLh == 0 ? null : osLh;
        setWasChanged(this.osLh != null && !this.osLh.equals(osLh));
        this.osLh = osLh;
    }

    public Integer getOsHa() {
        return osHa;
    }

    public void setOsHa(Integer osHa) throws SQLException, ForeignKeyViolationException {
        if (null != osHa)
            osHa = osHa == 0 ? null : osHa;
        setWasChanged(this.osHa != null && !this.osHa.equals(osHa));
        this.osHa = osHa;
    }

    public Integer getOsIod() {
        return osIod;
    }

    public void setOsIod(Integer osIod) throws SQLException, ForeignKeyViolationException {
        if (null != osIod)
            osIod = osIod == 0 ? null : osIod;
        setWasChanged(this.osIod != null && !this.osIod.equals(osIod));
        this.osIod = osIod;
    }

    public String getOogmetingDoor() {
        return oogmetingDoor;
    }

    public void setOogmetingDoor(String oogmetingDoor) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.oogmetingDoor != null && !this.oogmetingDoor.equals(oogmetingDoor));
        this.oogmetingDoor = oogmetingDoor;
    }

    public Date getDatumRefractie() {
        return datumRefractie;
    }

    public void setDatumRefractie(Date datumRefractie) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.datumRefractie != null && !this.datumRefractie.equals(datumRefractie));
        this.datumRefractie = datumRefractie;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) throws SQLException, ForeignKeyViolationException {
        setWasChanged(this.anamnese != null && !this.anamnese.equals(anamnese));
        this.anamnese = anamnese;
    }
    public Object[] getAsRow() {
        Object[] columnValues = new Object[29];
        columnValues[0] = getBrilvoorschriftId();
        columnValues[1] = getKlantId();
        columnValues[2] = getOdSph();
        columnValues[3] = getOdCyl();
        columnValues[4] = getOdAs();
        columnValues[5] = getOdAdd();
        columnValues[6] = getOdNabil();
        columnValues[7] = getOdPr();
        columnValues[8] = getOdBasis();
        columnValues[9] = getOdVis();
        columnValues[10] = getOdPddn();
        columnValues[11] = getOdLh();
        columnValues[12] = getOdHa();
        columnValues[13] = getOdIod();
        columnValues[14] = getOsSph();
        columnValues[15] = getOsCyl();
        columnValues[16] = getOsAs();
        columnValues[17] = getOsAdd();
        columnValues[18] = getOsNabil();
        columnValues[19] = getOsPr();
        columnValues[20] = getOsBasis();
        columnValues[21] = getOsVis();
        columnValues[22] = getOsPddn();
        columnValues[23] = getOsLh();
        columnValues[24] = getOsHa();
        columnValues[25] = getOsIod();
        columnValues[26] = getOogmetingDoor();
        columnValues[27] = getDatumRefractie();
        columnValues[28] = getAnamnese();
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
            setBrilvoorschriftId(Integer.parseInt(flds[0]));
        } catch(NumberFormatException ne) {
            setBrilvoorschriftId(null);
        }
        try {
            setKlantId(Integer.parseInt(flds[1]));
        } catch(NumberFormatException ne) {
            setKlantId(null);
        }
        try {
            setOdSph(Double.parseDouble(flds[2]));
        } catch(NumberFormatException ne) {
            setOdSph(null);
        }
        try {
            setOdCyl(Double.parseDouble(flds[3]));
        } catch(NumberFormatException ne) {
            setOdCyl(null);
        }
        try {
            setOdAs(Integer.parseInt(flds[4]));
        } catch(NumberFormatException ne) {
            setOdAs(null);
        }
        try {
            setOdAdd(Double.parseDouble(flds[5]));
        } catch(NumberFormatException ne) {
            setOdAdd(null);
        }
        try {
            setOdNabil(Double.parseDouble(flds[6]));
        } catch(NumberFormatException ne) {
            setOdNabil(null);
        }
        try {
            setOdPr(Integer.parseInt(flds[7]));
        } catch(NumberFormatException ne) {
            setOdPr(null);
        }
        try {
            setOdBasis(Integer.parseInt(flds[8]));
        } catch(NumberFormatException ne) {
            setOdBasis(null);
        }
        try {
            setOdVis(Double.parseDouble(flds[9]));
        } catch(NumberFormatException ne) {
            setOdVis(null);
        }
        setOdPddn(flds[10]);
        try {
            setOdLh(Integer.parseInt(flds[11]));
        } catch(NumberFormatException ne) {
            setOdLh(null);
        }
        try {
            setOdHa(Integer.parseInt(flds[12]));
        } catch(NumberFormatException ne) {
            setOdHa(null);
        }
        try {
            setOdIod(Integer.parseInt(flds[13]));
        } catch(NumberFormatException ne) {
            setOdIod(null);
        }
        try {
            setOsSph(Double.parseDouble(flds[14]));
        } catch(NumberFormatException ne) {
            setOsSph(null);
        }
        try {
            setOsCyl(Double.parseDouble(flds[15]));
        } catch(NumberFormatException ne) {
            setOsCyl(null);
        }
        try {
            setOsAs(Integer.parseInt(flds[16]));
        } catch(NumberFormatException ne) {
            setOsAs(null);
        }
        try {
            setOsAdd(Double.parseDouble(flds[17]));
        } catch(NumberFormatException ne) {
            setOsAdd(null);
        }
        try {
            setOsNabil(Double.parseDouble(flds[18]));
        } catch(NumberFormatException ne) {
            setOsNabil(null);
        }
        try {
            setOsPr(Integer.parseInt(flds[19]));
        } catch(NumberFormatException ne) {
            setOsPr(null);
        }
        try {
            setOsBasis(Integer.parseInt(flds[20]));
        } catch(NumberFormatException ne) {
            setOsBasis(null);
        }
        try {
            setOsVis(Double.parseDouble(flds[21]));
        } catch(NumberFormatException ne) {
            setOsVis(null);
        }
        setOsPddn(flds[22]);
        try {
            setOsLh(Integer.parseInt(flds[23]));
        } catch(NumberFormatException ne) {
            setOsLh(null);
        }
        try {
            setOsHa(Integer.parseInt(flds[24]));
        } catch(NumberFormatException ne) {
            setOsHa(null);
        }
        try {
            setOsIod(Integer.parseInt(flds[25]));
        } catch(NumberFormatException ne) {
            setOsIod(null);
        }
        setOogmetingDoor(flds[26]);
        setDatumRefractie(toDate(flds[27]));
        setAnamnese(flds[28]);
    }
}