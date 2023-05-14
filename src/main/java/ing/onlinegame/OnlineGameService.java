package ing.onlinegame;

import ing.onlinegame.schemas.Clan;
import ing.onlinegame.schemas.Group;
import ing.onlinegame.schemas.Order;
import ing.onlinegame.schemas.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OnlineGameService {

    private final Order order;

    @Autowired
    public OnlineGameService(Order order) {
        this.order = order;
    }

    public Order organizeOrder(Players players) {

        if (players.getClans().size() == 0) return new Order();

        List<Clan> sortedClans = this.sortClansByPointsAndNumber(players);
        int index = 0;
        Group currentGroup = new Group();

        while (sortedClans.size() > 0) {



            if ((currentGroup.getNumberOfGroupMembers() == players.getGroupCount()) || (index == sortedClans.size())) {

                this.order.addGroupToList(currentGroup);
                currentGroup = new Group();
                index=0;
            }

            if (currentGroup.getNumberOfGroupMembers() + sortedClans.get(index).getNumberOfPlayers() <= players.getGroupCount()) {

                currentGroup.addClanToList(sortedClans.get(index));
                sortedClans.remove(index);
                index=0;
            } else {

                index++;
            }
        }

        return this.order;

    }


    private List<Clan> sortClansByPointsAndNumber(Players players) {

        List<Clan> clansList = players.getClans();

        clansList.sort(new Clan.ClansByPointsComparator());
        clansList.sort(new Clan.ClansByNumberOfPlayersComparator());

        return clansList;
    }

}
