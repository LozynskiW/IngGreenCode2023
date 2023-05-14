package ing.onlinegame.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

    @Getter
    @JsonProperty
    private final List<Clan> clansList = new ArrayList<>();

    public void addClanToList(Clan clan) {

        this.clansList.add(clan);
    }

    public void addClansToList(Clan ... clans) {

        for (Clan clan : clans) {

            this.addClanToList(clan);
        }

    }

    public void clearAllClans() {
        this.clansList.clear();
    }

    public int getNumberOfGroupMembers() {
        return this.clansList.stream()
                .reduce(0,
                        (accumulator, clan) -> accumulator + clan.getNumberOfPlayers(),
                        Integer::sum);
    }

    @Override
    public String toString() {
        return "Group{" +
                "clansList=" + clansList +
                '}';
    }
}
