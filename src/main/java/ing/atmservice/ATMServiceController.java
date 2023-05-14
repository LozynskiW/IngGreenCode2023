package ing.atmservice;

import ing.atmservice.model.ATMModel;
import ing.atmservice.model.ATMModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/atms")
public class ATMServiceController {


    private final ATMServiceService atmServiceService;

    @Autowired
    public ATMServiceController(ATMServiceService atmServiceService) {
        this.atmServiceService = atmServiceService;
    }

    @PostMapping("calculateOrder")
    public Set<ATMModelDto> calculateOrder(@RequestBody ATMModel...atmModels) {

        return atmServiceService.sortAndReturn(atmModels);

    }
}
