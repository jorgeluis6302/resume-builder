package com.resume.model;

public class ContactInfo {
    private String email;
    private String phoneNumber;
    private Socials socials;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Socials getSocials() {
        return socials;
    }

    public void setSocials(Socials socials) {
        this.socials = socials;
    }
}
