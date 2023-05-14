package ing.onlinegame.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Order {

    @JsonProperty()
    private final List<Group> groupsList = new ArrayList<>();

    public void addGroupToList(Group group) {

        this.groupsList.add(group);
    }

    public List<Group> getGroupsOrder() {

        return this.groupsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "groupsList=" + groupsList +
                '}';
    }

    public List<List<Clan>> getClansListsFromGroups() {

        return this.groupsList.stream().map(Group::getClansList).collect(Collectors.toList());
    }
}
