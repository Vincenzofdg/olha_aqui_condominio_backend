package com.br.vkcoders.olhaaquicondominio.models;

import com.br.vkcoders.olhaaquicondominio.records.LawRecord;
import com.br.vkcoders.olhaaquicondominio.utils.CustomId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "law")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LawModel {

    @Id
    @Column(nullable = false, updatable = false, unique = true, length = 50)
    private String id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 250)
    private String description;

    @Column(nullable = false, length = 100)
    private String link;

    @Column(nullable = false, length = 50)
    private String source;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public LawModel(LawRecord payload) {
        this.id = CustomId.generateId();
        this.title = payload.title();
        this.description = payload.description();
        this.link = payload.link();
        this.source = payload.source();
    }
}
