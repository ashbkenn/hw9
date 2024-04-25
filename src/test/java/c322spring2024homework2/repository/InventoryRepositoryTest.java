package c322spring2024homework2.repository;

import c322spring2024homework2.model.Builder;
import c322spring2024homework2.model.Guitar;
import c322spring2024homework2.model.Type;
import c322spring2024homework2.model.Wood;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar() {
        InventoryRepository inventory = new InventoryRepository();
        Guitar g = new Guitar("AK4902", 1999.99, Builder.FENDER, "Stratocaster", Type.ELECTRIC, Wood.MAHOGANY, Wood.CEDAR);
        inventory.addGuitar(g);
        Guitar guitar = inventory.getGuitar("AK4902");
        assertNotNull(guitar);
    }

    @Test
    void addMultipleGuitars() {
        InventoryRepository inventory = new InventoryRepository();
        Guitar guitar1 = new Guitar("SN001", 999.99, Builder.GIBSON, "Les Paul", Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE);
        Guitar guitar2 = new Guitar("SN002", 1299.99, Builder.FENDER, "Telecaster", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        Guitar guitar3 = new Guitar("SN003", 899.99, Builder.MARTIN, "D-18", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR);

        inventory.addGuitar(guitar1);
        inventory.addGuitar(guitar2);
        inventory.addGuitar(guitar3);

        Guitar resultGuitar1 = inventory.getGuitar("SN001");
        Guitar resultGuitar2 = inventory.getGuitar("SN002");
        Guitar resultGuitar3 = inventory.getGuitar("SN003");

        assertNotNull(resultGuitar1);
        assertNotNull(resultGuitar2);
        assertNotNull(resultGuitar3);

        assertEquals(guitar1.getSerialNumber(), resultGuitar1.getSerialNumber());
        assertEquals(guitar2.getSerialNumber(), resultGuitar2.getSerialNumber());
        assertEquals(guitar3.getSerialNumber(), resultGuitar3.getSerialNumber());

        assertEquals(guitar1.getPrice(), resultGuitar1.getPrice());
        assertEquals(guitar2.getBuilder(), resultGuitar2.getBuilder());
        assertEquals(guitar3.getModel(), resultGuitar3.getModel());

        assertEquals(guitar1.getType(), resultGuitar1.getType());
        assertEquals(guitar2.getBackWood(), resultGuitar2.getBackWood());
        assertEquals(guitar3.getTopWood(), resultGuitar3.getTopWood());

    }


    @Test
    void getGuitar() {
        InventoryRepository inventory = new InventoryRepository();
        Guitar g = new Guitar("AK4902", 1999.99, Builder.FENDER, "Stratocaster", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR);
        inventory.addGuitar(g);
        Guitar guitar = inventory.getGuitar("AK4902");
        assertNotNull(guitar);
        assertEquals(1999.99, guitar.getPrice(), 0.001);
        assertEquals(Builder.FENDER, guitar.getBuilder());
        assertEquals("Stratocaster", guitar.getModel());
        assertEquals(Type.ACOUSTIC, guitar.getType());
        assertEquals(Wood.MAHOGANY, guitar.getBackWood());
        assertEquals(Wood.CEDAR, guitar.getTopWood());
    }


    void search() {
        InventoryRepository inventory = new InventoryRepository();
        Guitar g = new Guitar("AK4902", 1999.99, Builder.FENDER, "Stratocaster", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR);
        inventory.addGuitar(g);
        Guitar searchGuitar2 = new Guitar("AK4902", 1999.99, Builder.FENDER, "Stratocaster", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR);
        List<Guitar> results2 = inventory.search(searchGuitar2);
//        assertEquals(1, results2.size());
//        assertEquals("AK4902", results2.get(0).getSerialNumber());

        Guitar g2 = new Guitar("000CJR", 749.00, Builder.MARTIN, "10E StreetMaster", Type.ACOUSTIC, Wood.SITKA, Wood.SITKA);
        inventory.addGuitar(g2);
        Guitar searchGuitar = new Guitar("000CJR", 749.00, Builder.MARTIN, "10E StreetMaster", Type.ACOUSTIC, Wood.SITKA, Wood.SITKA);
        List<Guitar> results = inventory.search(searchGuitar);
       // assertEquals(1, results.size());
        assertEquals("000CJR", results.get(0).getSerialNumber());

        InventoryRepository inventory3 = new InventoryRepository();
        Guitar searchGuitar3 = new Guitar("GK0821", 0.0, Builder.OLSON, "", Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.COCOBOLO);
        List<Guitar> results3 = inventory.search(searchGuitar3);
        assertTrue(results3.isEmpty());
    }

}