package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data

public class ProfileList {
    private List<Profile> profiles;
    public ProfileList() {
        profiles = new ArrayList<>();
    }

}
