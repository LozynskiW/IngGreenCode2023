package ing.atmservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class ATMModel{

    @JsonProperty("region")
    private int region;
    @JsonProperty("atmId")
    private int atmId;
    @JsonProperty("requestType")
    private PriorityEnum priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ATMModel atmModel)) return false;

        if (region != atmModel.region) return false;
        return atmId == atmModel.atmId;
    }

    @Override
    public int hashCode() {
        int result = region;
        result = 31 * result + atmId;
        return result;
    }

    @Override
    public String toString() {
        return "ATMModel{" +
                "region=" + region +
                ", atmId=" + atmId +
                ", priority=" + priority +
                '}';
    }
}
