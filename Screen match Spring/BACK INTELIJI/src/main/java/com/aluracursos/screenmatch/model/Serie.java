package com.aluracursos.screenmatch.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
@Entity //se está iportando que lo que hay aqui quiero que sea una tabla
@Table (name = "series") //como se va llamar mi tabla en mi postgree
public class Serie {
    @Id //Se indica que habrá un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se pide que se generé solo el ID
    private Long id;
    @Column(unique = true)//Se tiene que que declarar antes del aributo que quiero que no se repita
    private String titulo;
    private Integer totalTemporadas;
    private Double evaluacion;
    private String poster;
    @Enumerated(EnumType.STRING) //le estoy diciendo que tengo un enum es decir una lista, se debe declarar antes de la lista
    private Categoria genero;
    private String actores;
    private String sinopsis;
    //@Transient //Le estoy diciendo que existe una lista de episodios pero que de momento no la voy a utilizar y que no la pele
    @OneToMany(mappedBy = "serie" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    public Serie(){}

    public Serie (DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalTemporadas = datosSerie.totalTemporadas();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.poster = datosSerie.poster();
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
        this.sinopsis = datosSerie.sinopsis();
        //Ejemplo para consulta chatGPT
        //this.sinopsis = ConsultaChatGPT.obtenerTraduccion(datosSerie.sinopsis());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return  "genero= " + genero +
                "titulo= '" + titulo + '\'' +
                ", totalTemporadas= " + totalTemporadas +
                ", evaluacion= " + evaluacion +
                ", poster= '" + poster + '\'' +
                ", actores= '" + actores + '\'' +
                ", sinopsis= '" + sinopsis + '\''  +
                ", episodios= '" + episodios + '\'';
    }

}

