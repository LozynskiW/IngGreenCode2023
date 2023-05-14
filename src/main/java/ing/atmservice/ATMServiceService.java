package ing.atmservice;

import ing.atmservice.comparators.ATMModelPriorityComparator;
import ing.atmservice.comparators.ATMModelRegionComparator;
import ing.atmservice.model.ATMModel;
import ing.atmservice.model.ATMModelDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ATMServiceService {

    private final List<ATMModel> modelList = new ArrayList<>();

    public Set<ATMModelDto> sortAndReturn(ATMModel... atmModels) {

        modelList.addAll(Arrays.asList(atmModels));

        List<ATMModel> modelListSorted = modelList.stream()
                .sorted(new ATMModelPriorityComparator())
                .sorted(new ATMModelRegionComparator())
                .collect(Collectors.toCollection(ArrayList::new));

        return modelListSorted.stream()
                .map(ATMModelDto::fromModel)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
