package com.hridoykrisna.Lazeez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "customer")
public class Customer extends BaseModel {
    private String name;
    //    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String city;
    private String zip_code;
    private long total_order;

    public Customer(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.password = generatedPassword;
    }
}
