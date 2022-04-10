package com.example.restuser.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudioId implements Serializable {
    enum StudioName {
        A,
        B,
        C
    }
    private StudioName name;
    private int seats;
}
