package com.proyecto.entrega2.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameLibraryID implements Serializable {
    private Long gameId;
    private Long userId;

    @Override
    public int hashCode(){
        return Objects.hash(gameId,userId);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        GameLibraryID other = (GameLibraryID) obj;
        return this.gameId.equals(other.gameId) && this.userId.equals(other.userId);
    }
}
