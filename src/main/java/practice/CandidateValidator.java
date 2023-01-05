package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIOD_IN_UKR = 10;
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[PERIOD_START_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[PERIOD_END_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodInUkr >= VALID_PERIOD_IN_UKR;
    }
}
