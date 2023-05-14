package ing.onlinegame.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Comparator;

@AllArgsConstructor
@Component
@Scope("prototype")
public class Clan implements Serializable {
    /**
    Representation of clans
     */

    @Min(1)
    @Max(1000)
    @Getter
    @JsonProperty("numberOfPlayers")
    private final int numberOfPlayers;
    @Min(1)
    @Max(1000000)
    @Getter
    @JsonProperty("points")
    private final int points;

    public static class ClansByPointsComparator implements Comparator<Clan> {

        @Override
        public int compare(Clan c1, Clan c2) {
            return Integer.compare(c2.getPoints(), c1.getPoints());
        }
    }

    public static class ClansByNumberOfPlayersComparator implements Comparator<Clan> {

        @Override
        public int compare(Clan c1, Clan c2) {
            if (c1.getPoints() == c2.getPoints()) return Integer.compare(c1.getNumberOfPlayers(), c2.getNumberOfPlayers());
            else return 0;
        }
    }

    @Override
    public String toString() {
        return "Clan{" +
                "numberOfPlayers=" + numberOfPlayers +
                ", points=" + points +
                '}';
    }
}
