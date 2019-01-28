package com.test.demo.model;

public class DamageBean extends BaseModel{
    /**
     * 伤害的数值
     */
    private String damageNumber;
    /**
     * 是否暴击
     */
    private String isCrit;
    /**
     *  被攻击单位的名字
     */
    private String beingAttackedName;
    /**
     * 攻击力
     */
    private String atk;
    /**
     * 当前血量
     */
    private String hp;

    public String getDamageNumber() {
        return damageNumber;
    }

    public void setDamageNumber(String damageNumber) {
        this.damageNumber = damageNumber;
    }

    public String getIsCrit() {
        return isCrit;
    }

    public void setIsCrit(String isCrit) {
        this.isCrit = isCrit;
    }

    public String getBeingAttackedName() {
        return beingAttackedName;
    }

    public void setBeingAttackedName(String beingAttackedName) {
        this.beingAttackedName = beingAttackedName;
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }



    public DamageBean() {
    }

    public DamageBean(String damageNumber, String isCrit, String beingAttackedName) {
        this.damageNumber = damageNumber;
        this.isCrit = isCrit;
        this.beingAttackedName = beingAttackedName;
    }
    @Override
    public String toString() {
        return "DamageBean{" +
                "damageNumber='" + damageNumber + '\'' +
                ", isCrit='" + isCrit + '\'' +
                ", beingAttackedName='" + beingAttackedName + '\'' +
                ", atk='" + atk + '\'' +
                ", hp='" + hp + '\'' +
                '}';
    }
}
