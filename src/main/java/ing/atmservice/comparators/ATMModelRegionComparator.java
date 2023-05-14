package ing.atmservice.comparators;

import ing.atmservice.model.ATMModel;

import java.util.Comparator;

public class ATMModelRegionComparator implements Comparator<ATMModel> {

    @Override
    public int compare(ATMModel o1, ATMModel o2) {
        return o1.getRegion() - o2.getRegion();
    }
}
