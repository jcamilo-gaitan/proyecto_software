package com.proyecto.entrega2.entity;

public enum possibleGenres {
    ACCION, AVENTURA, RPG, ESTRATEGIA, CARRERAS, SHOOTER, DEPORTES, LUCHA, ARCADE, PUZZLE, SIMULACION, VISUAL_NOVEL, TERROR, MUNDO_ABIERTO, SANDBOX, PARTY, REALIDAD_VIRTUAL, METROIDVANIA;

    public String getDisplayName() {
        return this.name().replace("_", " ");
    }
    }
