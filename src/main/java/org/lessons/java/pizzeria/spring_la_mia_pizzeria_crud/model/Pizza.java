package org.lessons.java.pizzeria.spring_la_mia_pizzeria_crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    private String descrizione;

    @NotBlank(message = "Devi mettere un URL per l'immagine")
    @Column(nullable = false)
    private String urlFoto;

    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di 0")
    @Column(nullable = false)
    private double prezzo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

}
