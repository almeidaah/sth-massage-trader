package br.com.companyname.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;

@Document
@Data
public class Massage implements Serializable {

    private static final long serialVersionUID = -1928015274485228566L;

    public enum Professional{
        DIEGO,
        SAMA,
        ANA,
        OUTRO;
    }

    @Id
    private String id;

    private String detail;

    private Professional professional;

    @NotNull
    @Size(min = 5, max = 5)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    private Login login;

    /**
     * Verify massage for exchange(visible in exchange table)
     */
    private Boolean visible;

    /**
     * On massageform, set if massage is for donation(not exchangable)
     */
    private Boolean donateMassage;



}
