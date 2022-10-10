package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * seat number in cabin, like A6, C8...
     */
    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    /**
     * basic coast
     */
    @Column(name = "fare", nullable = false)
    private Integer fare;

    /**
     * aircraft in which this seat
     */
//    @OneToOne(fetch = FetchType.LAZY)
//    private Aircraft aircraft;

    @Column(name = "is_registered")
    private Boolean isRegistered;

    @Column(name = "is_sold")
    private Boolean isSold;

}
