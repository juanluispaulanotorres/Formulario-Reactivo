package com.example.EJ2DTOCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements iPersona{

    @Autowired
    PersonaRepositorio personaRepositorio;

    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if (personaInputDTO.getUsuario() == null) {
            throw new Exception("Usuario no puede ser nulo");

        } else if (personaInputDTO.getUsuario().length() > 10) {
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");

        } else {
            Persona persona = new Persona(personaInputDTO);
            personaRepositorio.save(persona);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);

            return personaOutputDTO;
        }
    }

    @Override
    public List<Persona> listaPersonas() {
        List<Persona> lista;
        lista = personaRepositorio.findAll();
        return lista;
    }

    @Override
    public Optional<Persona> idPersona(int id) {
        return personaRepositorio.findById(id);
    }



    /*@Override
    public int getId() {
        return persona.getId_persona();
    }

    @Override
    public String getUsuario() {
        return persona.getUsuario();
    }

    @Override
    public void setUsuario(String usuario) {
        persona.setUsuario(usuario);
    }

    @Override
    public String getPassword() {
        return persona.getPassword();
    }

    @Override
    public void setPassword(String password) {
        persona.setPassword(password);
    }

    @Override
    public String getName() {
        return persona.getName();
    }

    @Override
    public void setName(String name) {
        persona.setName(name);
    }

    @Override
    public String getSurname() {
        return persona.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        persona.setSurname(surname);
    }

    @Override
    public String getCompany_email() {
        return persona.getCompany_email();
    }

    @Override
    public void setCompany_email(String company_email) {
        persona.setCompany_email(company_email);
    }

    @Override
    public String getPersonal_email() {
        return persona.getPersonal_email();
    }

    @Override
    public void setPersonal_email(String personal_email) {
        persona.setPersonal_email(personal_email);
    }

    @Override
    public String getCity() {
        return persona.getCity();
    }

    @Override
    public void setCity(String city) {
        persona.setCity(city);
    }

    @Override
    public boolean getActive() {
        return persona.isActive();
    }

    @Override
    public void setActive(boolean active) {
        persona.setActive(active);
    }

    @Override
    public Date getCreated_date() {
        return persona.getCreated_date();
    }

    @Override
    public void setCreated_date(Date created_date) {
        persona.setCreated_date(created_date);
    }

    @Override
    public String getImagen_url() {
        return persona.getImagen_url();
    }

    @Override
    public void setImagen_url(String imagen_url) {
        persona.setImagen_url(imagen_url);
    }

    @Override
    public Date getTermination_date() {
        return persona.getTermination_date();
    }

    @Override
    public void setTermination_date(Date termination_date) {
        persona.setTermination_date(termination_date);
    }*/
}
