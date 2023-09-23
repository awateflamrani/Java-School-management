package ensat.dca.model;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    private String idEtu;
    private String nom;
    private String prenom;
    private String sexe;
    private String filiere;


}
