package com.example.EJ2DTOCrud;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_persona;
    @NonNull
    @Column(name = "usuario")
    private String usuario;
    @NonNull
    @Column(name = "password")
    private String password;
    @NonNull
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @NonNull
    @Column(name = "company_email")
    private String company_email;
    @NonNull
    @Column(name = "personal_email")
    private String personal_email;
    @NonNull
    @Column(name = "city")
    private String city;
    @NonNull
    @Column(name = "active")
    private boolean active;
    @NonNull
    @Column(name = "created_date")
    private Date created_date;
    @Column(name = "imagen_url")
    private String imagen_url;
    @Column(name = "termination_date")
    private Date termination_date;

    public Persona(PersonaInputDTO personaDTO) {
        if (personaDTO == null)
            return;

        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
    }
}
