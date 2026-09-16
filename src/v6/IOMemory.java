package v6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IOMemory implements Saving {
    private final List<Double> memory = new ArrayList<>();

    @Override
    public void save(double result) {
        memory.add(result);
        System.out.println("In-memory records: " + memory);
    }

    public List<Double> getMemory() {
        return Collections.unmodifiableList(memory);
    }
}
