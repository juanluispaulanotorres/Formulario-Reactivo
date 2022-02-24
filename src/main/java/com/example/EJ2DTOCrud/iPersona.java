package com.example.EJ2DTOCrud;

import java.util.List;
import java.util.Optional;

public interface iPersona {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
    List<PersonaOutputDTO>  listaPersonas();
    PersonaOutputDTO idPersona(int id) throws Exception;
    /*List<PersonaOutputDTO> usuarioPersona(String usuario);*/
    /*void modificaPersona(int id, Persona persona) ;*/
    /*int getId();
    String getUsuario();
    void setUsuario(String usuario);
    String getPassword();
    void setPassword(String password);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getCompany_email();
    void setCompany_email(String company_email);
    String getPersonal_email();
    void setPersonal_email(String personal_email);
    String getCity();
    void setCity(String city);
    boolean getActive();
    void setActive(boolean active);
    Date getCreated_date();
    void setCreated_date(Date created_date);
    String getImagen_url();
    void setImagen_url(String imagen_url);
    Date getTermination_date();
    void setTermination_date(Date termination_date);*/
}
