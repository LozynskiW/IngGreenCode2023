package ing.onlinegame.schemas;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("prototype")
public class Players {
/**
Represents request - placeholder for all clans to be later placed in groups
 */
    @Min(1)
    @Max(1000)
    @Getter
    @Setter
    private int groupCount;

    @Max(20000)
    @Getter
    private LinkedList<Clan> clans;

    public void addClanToList(Clan clan) {

        this.clans.add(clan);
    }

    public void addClansToList(Clan ... clans) {

        for (Clan clan : clans) this.addClanToList(clan);

    }

}
