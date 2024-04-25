package c322spring2024homework2.repository;

import c322spring2024homework2.model.Guitar;
import c322spring2024homework2.model.Builder;
import c322spring2024homework2.model.Type;
import c322spring2024homework2.model.Wood;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class InventoryRepository {
    private List<Guitar> guitars;

    public InventoryRepository() {
        guitars = new ArrayList<>();
    }

    public Guitar addGuitar(Guitar guitar) {
        guitars.add(guitar);
        writeGuitar(guitar);
        return guitar;
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> match = new ArrayList<>();

        for(Guitar guitar : guitars) {
            if (searchGuitar.getSerialNumber() != null && !searchGuitar.getSerialNumber().isEmpty() && !guitar.getSerialNumber().equals(searchGuitar.getSerialNumber())) {
                continue;
            }
            if (searchGuitar.getPrice() != 0.0 && searchGuitar.getPrice() != guitar.getPrice()) {
                continue;
            }
            if (searchGuitar.getBuilder() != null && guitar.getBuilder() != searchGuitar.getBuilder()) {
                continue;
            }
            if (searchGuitar.getModel() != null && !searchGuitar.getModel().isEmpty() && !guitar.getModel().equals(searchGuitar.getModel())) {
                continue;
            }
            if (searchGuitar.getType() != null && guitar.getType() != searchGuitar.getType()) {
                continue;
            }
            if (searchGuitar.getBackWood() != null && guitar.getBackWood() != searchGuitar.getBackWood()) {
                continue;
            }
            if (searchGuitar.getTopWood() != null && guitar.getTopWood() != searchGuitar.getTopWood()) {
                continue;
            }
            match.add(guitar);
        }

        return match;
    }

    private void writeGuitar(Guitar guitar) {
        try (FileWriter writer = new FileWriter("guitars_database.txt", true)) {
            writer.write(guitar.getSerialNumber() + "," +
                    guitar.getPrice() + "," +
                    guitar.getBuilder() + "," +
                    guitar.getModel() + "," +
                    guitar.getType() + "," +
                    guitar.getBackWood() + "," +
                    guitar.getTopWood() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
