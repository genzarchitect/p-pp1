package com.stackroute.groundservice.model;

public class Ground {
    private String groundName;
    private int groundId;
    private String groundAddress;
    private String groundEquipments;
    private String groundImage;
    private String groundOwnerEmail;
    private double pricePerSlot;
    private String status;
    private String categories;

    public Ground() {
    }

    public Ground(String groundName, int groundId, String groundAddress, String groundEquipments, String groundImage, String groundOwnerEmail, double pricePerSlot, String status, String categories) {
        this.groundName = groundName;
        this.groundId = groundId;
        this.groundAddress = groundAddress;
        this.groundEquipments = groundEquipments;
        this.groundImage = groundImage;
        this.groundOwnerEmail = groundOwnerEmail;
        this.pricePerSlot = pricePerSlot;
        this.status = status;
        this.categories = categories;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public int getGroundId() {
        return groundId;
    }

    public void setGroundId(int groundId) {
        this.groundId = groundId;
    }

    public String getGroundAddress() {
        return groundAddress;
    }

    public void setGroundAddress(String groundAddress) {
        this.groundAddress = groundAddress;
    }

    public String getGroundEquipments() {
        return groundEquipments;
    }

    public void setGroundEquipments(String groundEquipments) {
        this.groundEquipments = groundEquipments;
    }

    public String getGroundImage() {
        return groundImage;
    }

    public void setGroundImage(String groundImage) {
        this.groundImage = groundImage;
    }

    public String getGroundOwnerEmail() {
        return groundOwnerEmail;
    }

    public void setGroundOwnerEmail(String groundOwnerEmail) {
        this.groundOwnerEmail = groundOwnerEmail;
    }

    public double getPricePerSlot() {
        return pricePerSlot;
    }

    public void setPricePerSlot(double pricePerSlot) {
        this.pricePerSlot = pricePerSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Ground{" +
                "groundName='" + groundName + '\'' +
                ", groundId=" + groundId +
                ", groundAddress='" + groundAddress + '\'' +
                ", groundEquipments='" + groundEquipments + '\'' +
                ", groundImage='" + groundImage + '\'' +
                ", groundOwnerEmail='" + groundOwnerEmail + '\'' +
                ", pricePerSlot=" + pricePerSlot +
                ", status='" + status + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }
}
