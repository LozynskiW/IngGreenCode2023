package ing.atmservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ATMModelDto {

    @JsonProperty("region")
    private int region;
    @JsonProperty("atmId")
    private int atmId;

    public static ATMModelDto fromModel(ATMModel atm) {

        return new ATMModelDto(atm.getRegion(), atm.getAtmId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATMModelDto that)) return false;

        if (region != that.region) return false;
        return atmId == that.atmId;
    }

    @Override
    public int hashCode() {
        int result = region;
        result = 31 * result + atmId;
        return result;
    }
}
