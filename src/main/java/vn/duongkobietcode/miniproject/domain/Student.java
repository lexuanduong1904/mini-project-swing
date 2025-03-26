/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.duongkobietcode.miniproject.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private int id;
    private String name;
    private Date birthDate;
    private boolean gender;
    private String phoneNumber;
    private String address;
    private boolean status;

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name;
    }
}
