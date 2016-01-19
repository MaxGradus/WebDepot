package com.maxdegree.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeId", nullable = false)
    private Long placeId;

    @Column(name = "placeName", nullable = false)
    private String placeName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;


    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}


//final Long MONTH = 2592000000L;
//Long today = new Date().getTime() + MONTH;
//Date date  = new Date(today);

