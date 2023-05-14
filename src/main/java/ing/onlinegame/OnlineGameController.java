package ing.onlinegame;

import ing.onlinegame.schemas.Clan;
import ing.onlinegame.schemas.Group;
import ing.onlinegame.schemas.Order;
import ing.onlinegame.schemas.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/onlinegame")
class OnlineGameController {

    private final OnlineGameService onlineGameService;

    @Autowired
    public OnlineGameController(OnlineGameService onlineGameService) {
        this.onlineGameService = onlineGameService;
    }

    @PostMapping(path = "/calculate")
    public List<List<Clan>> getOrder(@RequestBody Players players) {

        Order order = onlineGameService.organizeOrder(players);

        return order.getClansListsFromGroups();
    }
}
