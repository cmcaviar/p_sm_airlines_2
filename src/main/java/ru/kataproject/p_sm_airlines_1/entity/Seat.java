package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Row letter of seat like A, B, C, F, etc
     */
    @Column(name = "seat_row", nullable = false)
    private String seatRow;

    /**
     * just seat number, without letter; seat in row
     */
    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "fare", nullable = false)
    private Long fare;

//    @OneToOne(fetch = FetchType.LAZY) //TODO uncomment after creating aircraft entity
//    private Aircraft aircraft;

    @Column(name = "is_registered", nullable = false)
    private Boolean isRegistered;

    @Column(name = "is_sold", nullable = false)
    private Boolean isSold;

}
