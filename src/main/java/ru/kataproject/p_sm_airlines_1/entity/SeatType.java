package ru.kataproject.p_sm_airlines_1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.SeatCategory;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat_type")
public class SeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private SeatCategory category;

    @Column(name = "has_window")
    private Boolean hasWindow;

    @Column(name = "has_addit_place_for_legs")
    private Boolean hasAdditPlaceForLegs;

    @Column(name = "has_tv")
    private Boolean hasTv;

    @Column(name = "is_aisle")
    private Boolean isAisle;
}
