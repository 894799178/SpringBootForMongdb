package com.test.demo.model;

public class DamageData {
    private Integer id;

    private String typeId;

    private String pointX;

    private String pointY;

    private String damageNumber;

    private String isCrit;

    private String beingAttackedName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getPointX() {
        return pointX;
    }

    public void setPointX(String pointX) {
        this.pointX = pointX == null ? null : pointX.trim();
    }

    public String getPointY() {
        return pointY;
    }

    public void setPointY(String pointY) {
        this.pointY = pointY == null ? null : pointY.trim();
    }

    public String getDamageNumber() {
        return damageNumber;
    }

    public void setDamageNumber(String damageNumber) {
        this.damageNumber = damageNumber == null ? null : damageNumber.trim();
    }

    public String getIsCrit() {
        return isCrit;
    }

    public void setIsCrit(String isCrit) {
        this.isCrit = isCrit == null ? null : isCrit.trim();
    }

    public String getBeingAttackedName() {
        return beingAttackedName;
    }

    public void setBeingAttackedName(String beingAttackedName) {
        this.beingAttackedName = beingAttackedName == null ? null : beingAttackedName.trim();
    }

    @Override
    public String toString() {
        return "DamageData{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", pointX='" + pointX + '\'' +
                ", pointY='" + pointY + '\'' +
                ", damageNumber='" + damageNumber + '\'' +
                ", isCrit='" + isCrit + '\'' +
                ", beingAttackedName='" + beingAttackedName + '\'' +
                '}';
    }
}